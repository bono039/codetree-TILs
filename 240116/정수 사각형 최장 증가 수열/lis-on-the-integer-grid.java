import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int N;
    static int[][] grid, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        grid = new int[N][N];
        dp = new int[N][N];

        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = 1;
            }
        }        

        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N ; j++) {
                bfs(i, j);
            }
        }

        int max = 0;
        for(int[] i : dp) {
            for(int j : i) {
                max = Math.max(max, j);
            }
        }

        System.out.println(max);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {x, y});

        while(!q.isEmpty()) {
            int[] now = q.poll();

            for(int d = 0 ; d < 4 ; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if(!inRange(nx, ny) || grid[nx][ny] <= grid[now[0]][now[1]])    continue;

                dp[nx][ny] = Math.max(dp[nx][ny], dp[x][y] + 1);
            }
        }
    }

    private static boolean inRange(int x, int y) {
        return (0 <= x && x < N && 0 <= y && y < N);
    }
}