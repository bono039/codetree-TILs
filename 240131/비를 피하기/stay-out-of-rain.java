import java.util.*;
import java.io.*;

public class Main {
    static int n,h,m;
    static int[][] arr, ans;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] visited;

    static List<int[]> peoplePos = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());   // 격자 크기
        h = Integer.parseInt(st.nextToken());   // 사람 수
        m = Integer.parseInt(st.nextToken());   // 비 피할 수 있는 공간 위치 m개

        arr = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < n ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if(arr[i][j] == 2) peoplePos.add(new int[] {i, j});
            }
        }
        
        ans = new int[n][n];

        for(int i = 0 ; i < h ; i++) {
            int[] person = peoplePos.get(i);
            init();
            bfs(person[0], person[1]);
        }

        // 0 : 이동 가능, 1 : 벽. 이동 X. 2 : 사람, 3 : 비 피할 수 있는 공간
        printAns();        
    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {x, y, 0});

        visited[x][y] = true;
        
        while(!q.isEmpty()) {
            int[] now = q.poll();

            for(int dir = 0 ; dir < 4 ; dir++) {
                int nx = now[0] + dx[dir];
                int ny = now[1] + dy[dir];

                if(canGo(nx, ny)) {
                    if(arr[nx][ny] == 3) {
                        ans[x][y] = now[2] + 1;
                        return;
                    }

                    visited[nx][ny] = true;
                    q.add(new int[] {nx, ny, now[2] + 1});
                }
            }
        }

        ans[x][y] = -1;
    }

    private static void printAns() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++)
                sb.append(ans[i][j] + " ");
            sb.append("\n");
        }
        
        System.out.println(sb);
    }

    private static void init() {
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                visited[i][j] = false;
            }
        }
    }

    private static boolean canGo(int x, int y) {
        return (inRange(x, y) && !visited[x][y] && arr[x][y] != 1);
    }

    private static boolean inRange(int x, int y) {
        return (0 <= x && x < n && 0 <= y && y < n);
    }
}