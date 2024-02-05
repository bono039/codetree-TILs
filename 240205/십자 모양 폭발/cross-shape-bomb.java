import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static int n, r, c, size;
    static int[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];

        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < n ; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;
        size = grid[r][c];

        // 1) 터뜨리기
        pop();

        // 2) 중력 적용하기
        // 아래에서 위로 올라오면서 채우기
        int[][] tmp = new int[n][n];
        for(int col = 0 ; col < n ; col++) {
            int tmpRow = n - 1;
            for(int row = n - 1 ; row >= 0 ; row--) {
                if(grid[row][col] != 0) {
                    tmp[tmpRow][col] = grid[row][col];
                    tmpRow--;
                }
            }
        }

        // 3) 원본 배열로 다시 copy하기
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                grid[i][j] = tmp[i][j];
            }
        }

        // 결과 출력하기
        print();
    }

    // 십자 모양의 크기, 선택된 숫자에 비례하여 커지기
    private static void pop() {
        for(int dir = 0 ; dir < 4 ; dir++) {
            for(int i = 0 ; i < size ; i++) {
                int nr = r + dx[dir] * i;
                int nc = c + dy[dir] * i;

                if(nr < 0 || nr >= n || nc < 0 || nc >= n)  continue;
                grid[nr][nc] = 0;
            }
        }
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++)
                sb.append(grid[i][j]).append(" ");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}