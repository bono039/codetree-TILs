import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {1, -1, 0, 0};    // 상하좌우
    static int[] dy = {0, 0, 1, -1};

    static int N, cnt;
    static int[][] map;
    static boolean[][] visited;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N ; j++) {
                if(!visited[i][j] && map[i][j] == 1) {
                    cnt = 0;
                    dfs(i, j);
                    pq.add(cnt);
                }
            }
        }

        sb.append(pq.size()).append("\n");
        while(!pq.isEmpty()) {
            sb.append(pq.poll()).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        cnt++;

        for(int d = 0 ; d < 4 ; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(inRange(nx, ny) && !visited[nx][ny] && map[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
    }

    private static boolean inRange(int x, int y) {
        return (0 <= x && x < N && 0 <= y && y < N);
    }
}