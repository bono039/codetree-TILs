import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static int n, m;
    static int[][] map;
    static int max = 0; // 손해보지 않으면서 채굴 가능한 최대 금 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());   // 금 1개 가격

        map = new int[n][n];
        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < m ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // K가 0이면 한 점에서만 채굴
        // 채굴에 드는 비용 : K * K + (K + 1) * (K + 1)
        for(int k = 0 ; k < n ; k++) {
            // 마름모 중심점 위치
            for(int i = 0 ; i < n ; i++) {
                for(int j = 0 ; j < n ; j++) {
                    int goldCnt = countGold(i, j, k);
                    int tmpPrice = (m * goldCnt) - (k * k + (k + 1) * (k + 1));

                    if(tmpPrice >= 0)
                        max = Math.max(max, goldCnt);

                }
            }
        }

        System.out.println(max);
    }

    private static int countGold(int x, int y, int len) {
        boolean[][] visited = new boolean[n][n];

        int cnt = 0;

        for(int k = 0 ; k <= len ; k++) {
            for(int d = 0 ; d < 4 ; d++) {
                int nx = x + dx[d] * k;
                int ny = y + dy[d] * k;

                if(inRange(nx, ny) && !visited[nx][ny] && map[nx][ny] == 1) {
                    cnt++;
                    visited[nx][ny] = true;
                }
            }
        }

        return cnt;
    }

    private static boolean inRange(int x, int y) {
        return (0 <= x && x < n && 0 <= y && y < n);
    }
}