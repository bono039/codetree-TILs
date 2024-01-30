import java.util.*;
import java.io.*;

public class Main {
    static int n,k,u,d;
    static int[][] map;

    // dfs용
    static int[][] cities;
    static List<Integer> list = new ArrayList<>();  // 뽑은 값 저장

    // bfs용
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] visited;

    static int max = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());   // 격자 크기
        k = Integer.parseInt(st.nextToken());   // 고를 도시 수
        u = Integer.parseInt(st.nextToken());   // 두 도시 간 높이차 : u 이상 d 이하
        d = Integer.parseInt(st.nextToken());

        map = new int[n+1][n+1];
        cities = new int[n*n + 1][2];

        int idx = 1;
        for(int i = 1 ; i <= n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1 ; j <= n ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                cities[idx][0] = i;
                cities[idx][1] = j;

                idx++;
            }
        }

        visited = new boolean[n+1][n+1];
        comb(1, 0);

        System.out.println(max);
    }

    private static void comb(int idx, int depth) {
        if(depth == k) {
            initialize();

            for(int i = 0 ; i < list.size() ; i++) {
                int num = list.get(i);
                int x = cities[num][0];
                int y = cities[num][1];

                bfs(x, y);
            }

            max = Math.max(max, getCnt());            
            return;
        }

        for(int i = idx ; i <= n * n ; i++) {
            list.add(i);
            comb(i + 1, depth + 1);
            list.remove(list.size() - 1);
        }
    }

    private static void bfs(int x, int y) {
        visited[x][y] = true;

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {x, y});

        while(!q.isEmpty()) {
            int[] now = q.poll();

            for(int dir = 0 ; dir < 4 ; dir++) {
                int nx = now[0] + dx[dir];
                int ny = now[1] + dy[dir];

                if(!inRange(nx,ny) || visited[nx][ny])  continue;

                int diff = Math.abs(map[nx][ny] - map[now[0]][now[1]]);
                if(u <= diff && diff <= d) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

    private static int getCnt() {
        int cnt = 0;

        for(int i = 1 ; i <= n ; i++) {
            for(int j = 1 ; j <= n ; j++) {
                if(visited[i][j])
                    cnt++;
            }
        }

        return cnt;
    }

    private static void initialize() {
        for(int i = 1 ; i <= n ; i++) {
            for(int j = 1 ; j <= n ; j++) {
                visited[i][j] = false;
            }
        }
    }

    private static boolean inRange(int x, int y) {
        return (1 <= x && x <= n && 1 <= y && y <= n);
    }    
}