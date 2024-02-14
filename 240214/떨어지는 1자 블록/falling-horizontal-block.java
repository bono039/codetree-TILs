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

        // 1. 최종적으로 멈추게 될 위치를 구한다.
        int targetRow = getTargetRow(); 
        
        // 2. 최종 위치에 전부 블록을 표시한다.
        putBlocks(targetRow);

        // 3. 출력한다.
        print();
    }
    
    private static int getTargetRow() {
        for(int row = 1 ; row <= n ; row++) {
            if(!allZero(row))
                return row - 1;
        }
        
        return n;
    }

    // 모두 0인지 확인하는 메서드
    private static boolean allZero(int row) {
        for(int col = k ; col < k + m ; col++) {
            if(grid[row][col] != 0)
                return false;
        }

        return true;
    }

    // 블럭 두는 메서드
    private static void putBlocks(int row) {
        for(int col = k ; col < k + m ; col++) {
            grid[row][col] = 1;
        }
    }

    // 출력 메서드
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