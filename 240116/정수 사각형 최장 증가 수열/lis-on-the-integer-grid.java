import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1, 1,  0, 0};
    static int[] dy = { 0, 0, -1, 1};
    
    static int n;
    static int[][] grid, dp;
    
    static List<Cell> cells = new ArrayList<>();
    static int ans = 0;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        
        grid = new int[n][n];
        dp = new int[n][n];

        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 1);  // 초기 DP 값 모두 1로 초기화
        
            for(int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                cells.add(new Cell(grid[i][j], i, j));  // (값, 행, 열)
            }
        }
        Collections.sort(cells);    //  값 기준 오름차순 정렬⭐ 

        // 정수값이 작은 칸부터 보며 4방향에 대해 dp 값 갱신
        for(int i = 0; i < cells.size(); i++) {
            int x = cells.get(i).x;
            int y = cells.get(i).y;

            // 인접한 4개의 칸에 대해 갱신
            for(int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                
                if(inRange(nx, ny) && grid[nx][ny] > grid[x][y])
                    dp[nx][ny] = Math.max(dp[nx][ny], dp[x][y] + 1);
            }
        }

        // 전체 수들 중 최댓값 탐색
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                ans = Math.max(ans, dp[i][j]);

        System.out.print(ans);
    }
    
    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
}


class Cell implements Comparable<Cell> {
    int num, x, y;

    public Cell(int num, int x, int y) {
        this.num = num;
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Cell c) {
        return this.num - c.num;      // num 기준 오름차순 정렬
    }
}