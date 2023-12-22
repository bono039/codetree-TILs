import java.util.*;
import java.io.*;

//
public class Main {
    static int[] dx = {0, -1,1,0,0};   // 상하좌우
    static int[] dy = {0, 0,0,-1,1};

    static int N, M;
    static int[][] board, origin;
    static int min = (int)1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N + 1][M + 1];
        origin = new int[N + 1][M + 1];

        for(int i = 1 ; i <= N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1 ; j <= M ; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int state = 0 ; state < (1 << M) ; state++) {

            // 보드 초기화
            for(int i = 1 ; i <= N ; i++) {
                for(int j = 1 ; j <= M ; j++) {
                    board[i][j] = origin[i][j];
                }
            }

            for(int y = 1 ; y <= M ; y++) {
                if(((state >> (y - 1)) & 1) == 1) {
                    int x = 1;

                    for(int dir = 0; dir < 5 ; dir++) {
                        int nx = x + dx[dir];
                        int ny = y + dy[dir];

                        if(!inRange(nx,ny)) continue;

                        board[nx][ny] = 1 - board[nx][ny];
                    }
                }
            }

            int num = 0;
            for(int y = 1 ; y <= M ; y++) {
                if(((state >> (y - 1)) & 1) == 1) 
                    num++;
            }

            int cnt = 0;
            for(int i = 2 ; i <= N ; i++) {
                for(int j = 1 ; j <= M ; j++) {
                    if(board[i - 1][j] == 0) {
                        num++;

                        for(int dir = 0 ; dir < 5 ; dir++) {
                            int nx = i + dx[dir];
                            int ny = j + dy[dir];

                            if(!inRange(nx,ny)) continue;

                            board[nx][ny] = 1 - board[nx][ny];
                        }
                    }
                }

                boolean fullFilled = true;
                for(int j = 1 ; j <= M ; j++)
                    if(board[N][j] == 0)    fullFilled = false;
                

                if(fullFilled)
                    min = Math.min(min, num);
            }         
        }

        System.out.println(min == (int)1e9 ? -1 : min);
    }

    private static boolean inRange(int x, int y) {
        return (1 <= x && x <= N && 1 <= y && y <= N);
    }
}