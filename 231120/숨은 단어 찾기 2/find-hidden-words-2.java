import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0, 1, 1, 1};   // 동쪽 남쪽 동남 남서
    static int[] dy = {1, 0, 1, -1};

    static int N, M, cnt;
    static char[][] words;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        words = new char[N][M];

        for(int i = 0 ; i < N ; i++) {
            char[] ch = br.readLine().toCharArray();
            for(int j = 0 ; j < M ; j++) {
                words[i][j] = ch[j];
            }
        }

        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < M ; j++) {
                if(words[i][j] == 'L') {
                    for(int d = 0 ; d < 4 ; d++) {
                        int nx = i;
                        int ny = j;
                        boolean isLee = true;
                        int tmpCnt = 1;

                        // 증가하는 방향 탐색
                        while(true) {
                            nx += dx[d];
                            ny += dy[d];

                            if(inRange(nx, ny) && words[nx][ny] == 'E') tmpCnt++;
                            else    break;
                        }

                        // 반대 방향 탐색
                        nx = i;
                        ny = j;
                        while(true) {
                            nx -= dx[d];
                            ny -= dy[d];

                            if(inRange(nx, ny) && words[nx][ny] == 'E') tmpCnt++;
                            else break;
                        }

                        if(tmpCnt >= 3) {
                            cnt++;
                        }
                    }
                }
            }
        }

        System.out.println(cnt);
    }

    private static boolean inRange(int x, int y) {
        return (0 <= x && x < N && 0 <= y && y < M);
    }
}