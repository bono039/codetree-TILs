import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static int n,k;
    static int[][] map, ans;

    static Queue<int[]> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < n ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 2)  q.add(new int[]{i, j});
            }
        }

        ans = new int[n][n];
        bfs();
        print();
    }

    private static void bfs() {
        while(!q.isEmpty()) {
            int[] now = q.poll();

            for(int dir = 0 ; dir < 4 ; dir++) {
                int nx = now[0] + dx[dir];
                int ny = now[1] + dy[dir];

                if(canGo(nx, ny)) {
                    q.add(new int[]{nx, ny});
                    ans[nx][ny] = ans[now[0]][now[1]] + 1;
                }
            }
        }
    }

    private static boolean canGo(int x, int y) {
        return (inRange(x, y) && map[x][y] == 1 && ans[x][y] == 0);
    }

    private static boolean inRange(int x, int y) {
        return (0 <= x && x < n && 0 <= y && y < n);
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(map[i][j] == 0) ans[i][j] = -1;
                if(map[i][j] == 1 && ans[i][j] == 0) ans[i][j] = -2;
                sb.append(ans[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}