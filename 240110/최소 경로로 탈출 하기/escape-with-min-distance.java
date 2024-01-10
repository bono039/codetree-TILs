import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int N, M;
    static int[][] grid;
    static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][M];
        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < M ; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new int[N][M];
        bfs(0, 0);

        System.out.println(visited[N - 1][M - 1] == 0 ? -1 : visited[N - 1][M - 1] - 1);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {x, y});

        visited[x][y] = 1;

        while(!q.isEmpty()) {
            int[] now = q.poll();

            for(int d = 0 ; d < 4 ; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if(canGo(nx, ny)) {
                    visited[nx][ny] = visited[now[0]][now[1]] + 1;
                    q.add(new int[] {nx ,ny});
                }
            }
        }
    }

    private static boolean canGo(int x, int y) {
        return inRange(x, y) && grid[x][y] == 1 && visited[x][y] == 0;
    }

    private static boolean inRange(int x, int y) {
        return (0 <= x && x < N && 0 <= y && y < M);
    }
}