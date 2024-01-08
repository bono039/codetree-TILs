import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int N, K;
    static int[][] grid;
    static int[][] visited;

    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        grid = new int[N + 1][N + 1];
        visited = new int[N + 1][N + 1];

        for(int i = 1 ; i <= N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1 ; j <= N ; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(K --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            ans += bfs(r, c);
        }

        System.out.println(ans);
    }

    private static int bfs(int x, int y) {
        if(visited[x][y] == 1) {
            return 0;
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {x, y});

        visited[x][y] = 1;

        int cnt = 1;

        while(!q.isEmpty()) {
            int[] now = q.poll();

            for(int d = 0 ; d < 4 ; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if(canGo(nx, ny)) {
                    visited[nx][ny] = 1;
                    cnt++;
                    q.add(new int[] {nx, ny});
                }
            }
        }

        return cnt;
    }

    private static boolean canGo(int x, int y) {
        if(!inRange(x, y))  return false;
        if(visited[x][y] == 1 || grid[x][y] == 1) return false;
        return true;
    }

    private static boolean inRange(int x, int y) {
        return (1 <= x && x <= N && 1 <= y && y <= N);
    }
}