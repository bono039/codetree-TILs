import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] grid = new int[201][201];
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            paint(x + 100, y + 100);
        }

        for(int i = 0 ; i < grid.length ; i++) {
            for(int j = 0 ; j < grid[i].length ; j++) {
                //System.out.print(grid[i][j] + " ");
                if(grid[i][j] != 0) {
                    cnt++;
                }
            }
            //System.out.println();
        }

        System.out.println(cnt);
    }

    private static void paint(int x, int y) {
        for(int i = x ; i < x + 8 ; i++) {
            for(int j = y ; j < y + 8 ; j++) {
                if(grid[i][j] == 0)
                    grid[i][j] = 1;
            }
        }
    }
}