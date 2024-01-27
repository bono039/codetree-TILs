import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};   // 우선순위 : 상하좌우
    static int[] dy = {0, 0, -1, 1};

    static int n, curX, curY;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        curX = Integer.parseInt(st.nextToken());
        curY = Integer.parseInt(st.nextToken());

        map = new int[n + 1][n + 1];
        for(int i = 1 ; i <= n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < n ; j++) {
                map[i][j + 1] = Integer.parseInt(st.nextToken());
            }
        }

        sb.append(map[curX][curY] + " ");

        while(true) {
            boolean exists = simulate();

            if(!exists) 
                break;
            
            sb.append(map[curX][curY] + " ");
        }

        System.out.println(sb);
    }

    private static boolean simulate() {
        for (int d = 0; d < 4; d++) {
            int nx = curX + dx[d];
            int ny = curY + dy[d];

            if (inRange(nx, ny) && map[nx][ny] > map[curX][curY]) {
                curX = nx;
                curY = ny;
                return true;
            }
        }

        return false;
    }

    private static boolean inRange(int x, int y) {
        return (1 <= x && x <= n && 1 <= y && y <= n);
    }
}