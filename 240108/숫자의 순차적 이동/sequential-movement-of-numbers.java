import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};   // 8방향
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    static int N, M;
    static int[][] grid, tmpArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());   // 격자 크기
        M = Integer.parseInt(st.nextToken());   // 턴 수

        grid = new int[N][N];
        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(M --> 0) {
            for(int k = 1 ; k <= N * N ; k++) {
                for(int i = 0 ; i < N ; i++) {
                    for(int j = 0 ; j < N ; j++) {
                        if(grid[i][j] == k) {
                            change(i, j);
                        }
                    }
                }
            }
        }

        print();
    }

    private static void change(int x, int y) {
        int[] pos = new int[2]; // 가장 큰 숫자가 있는 칸의 위치
        int max = 0;

        for(int d = 0 ; d < 8 ; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(inRange(nx, ny) && grid[nx][ny] > max) {
                max = grid[nx][ny];
                pos = new int[] {nx, ny};
            }
        }

        // swap
        int tmp = grid[pos[0]][pos[1]];
        grid[pos[0]][pos[1]] = grid[x][y];
        grid[x][y] = tmp;

        return;
    }

    private static boolean inRange(int x, int y) {
        return (0 <= x && x < N && 0 <= y && y < N);
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();
        for(int[] i : grid) {
            for(int j : i)
                sb.append(j + " ");
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}