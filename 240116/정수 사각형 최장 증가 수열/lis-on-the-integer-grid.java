import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int N;
    static int[][] grid, dp;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        grid = new int[N][N];
        dp = new int[N][N];

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));

        for(int i = 0 ; i < N ; i++) {
            Arrays.fill(dp[i], 1);

            st = new StringTokenizer(br.readLine(), " ");            
            for(int j = 0 ; j < N ; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                pq.offer(new int[] {i, j, grid[i][j]});
            }
        }        

        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            int x = now[0];
            int y = now[1];
            int num = now[2];

            for(int d = 0 ; d < 4 ; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if(!inRange(nx, ny))    continue;

                if(num < grid[nx][ny]) {
                    dp[nx][ny] = Math.max(dp[nx][ny], dp[x][y] + 1);
                }
            }

            answer = Math.max(answer, dp[x][y]);
        }

        System.out.println(answer);
    }

    private static boolean inRange(int x, int y) {
        return (0 <= x && x < N && 0 <= y && y < N);
    }
}