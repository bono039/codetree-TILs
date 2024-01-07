import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {1, 0};   // 아래, 오른쪽
    static int[] dy = {0, 1};

    static int N, M;
    static int[][] grid;
    static boolean[][] visited;

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

        visited = new boolean[N][M];
        dfs(0, 0);

        System.out.println(visited[N - 1][M - 1] ? 1 : 0);
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for(int d = 0 ; d < 2 ; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(canGo(nx, ny)) {
                visited[nx][ny] = true;
                dfs(nx, ny);
            }
        }
    }

    private static boolean canGo(int x, int y) {
        if(!inRange(x, y) || visited[x][y])  return false;
        if(grid[x][y] == 0) return false;
        return true;
    }

    private static boolean inRange(int x, int y) {
        return (0 <= x && x < N && 0 <= y && y < M);
    }
}