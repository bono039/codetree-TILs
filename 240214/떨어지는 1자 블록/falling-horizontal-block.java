import java.util.*;
import java.io.*;

public class Main {
    static int n,m,k;
    static int[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());   // 격자 크기
        m = Integer.parseInt(st.nextToken());   // 블록 크기
        k = Integer.parseInt(st.nextToken());   // 블록 떨어질 위치

        grid = new int[n+1][n+1];

        for(int i = 1 ; i <= n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1 ; j <= n ; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int row = 1;
        while(true) {
            if(allZero(row)) {
                row++;
            }
            else {
                putBlocks(row-1);   // 바로 윗 줄에 블록들 두기
                break;
            }
        }

        print();
    }

    private static boolean allZero(int row) {
        for(int col = k ; col < k + m && col <= n ; col++) {
            if(grid[row][col] != 0)
                return false;
        }

        return true;
    }

    private static void putBlocks(int row) {
        for(int col = k ; col < k + m && col <= n ; col++) {
            grid[row][col] = 1;
        }
    }


    private static void print() {
        StringBuilder sb = new StringBuilder();
        for(int i = 1 ; i <= n ; i++) {
            for(int j = 1 ; j <= n ; j++)
                sb.append(grid[i][j]).append(" ");
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}