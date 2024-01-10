import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1, -2, -2, -1, 1, 2, 1, 2};
    static int[] dy = {-2, -1, 1, 2,-2, -1, 1, 2};

    static int N;
    static int[][] grid, visited;
    static int r1, c1, r2, c2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        grid = new int[N + 1][N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        if(r1 == r2 && c1 == c2) {
            System.out.println(0);
            return;
        }

        visited = new int[N + 1][N + 1];
        visited[r1][c1] = 1;
        bfs(r1, c1);

        System.out.println(visited[r2][c2] == 0 ? -1 : visited[r2][c2]);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {x, y});

        while(!q.isEmpty()) {
            int[] now = q.poll();

            for(int d = 0 ; d < 8 ; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if(canGo(nx, ny)) {
                    visited[nx][ny] = visited[now[0]][now[1]] + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

    private static boolean canGo(int x, int y) {
        return inRange(x, y) && visited[x][y] == 0;
    }

    private static boolean inRange(int x, int y) {
        return (1 <= x && x <= N && 1 <= y && y <= N);
    }
}