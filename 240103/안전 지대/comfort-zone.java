import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int N, M;
    static int[][] map;
    static boolean[][] visited;

    static int max = 0;
    static int min = 100;
    static int K;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
                min = Math.min(min, map[i][j]);
            }
        }

        K = max;

        for (int k = min ; k <= max; k++) {
            visited = new boolean[N][M];
            int cnt = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] > k && !visited[i][j]) {
                        visited[i][j] = true;
                        cnt++;
                        dfs(i, j, k);
                    }
                }
            }

            if(cnt >= ans) {
                ans = cnt;
                K = k;
            }
        }

        System.out.println(ans + " " + K);
    }

    private static void dfs(int x, int y, int v) {
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (!inRange(nx, ny) || visited[nx][ny] || map[nx][ny] <= v) continue;

            
            visited[nx][ny] = true;
            dfs(nx, ny, v);
        }
    }

    private static boolean inRange(int x, int y) {
        return (0 <= x && x < N && 0 <= y && y < M);
    }
}