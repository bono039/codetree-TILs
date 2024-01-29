import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static int N, M;
    static int[][] map;
    static Queue<int[]> q = new ArrayDeque<>();
    static boolean[][] visited;

    static int time, size;    // 전부 녹는데 걸리는 시간, 마지막으로 녹은 빙하 크기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < M ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        do {
            time++;
            size = 0;

            bfs();  // 빙하에 둘러쌓여있지 않은 물의 위치를 전부 방문 표시
            melt(); // 녹이기
        } while(iceExists());

        System.out.println(time + " " + size);
    }

    private static void bfs() {
        initialize();   // 방문 배열 매번 초기화

        q.add(new int[] {0, 0});    // 항상 (0,0)에서 시작
        visited[0][0] = true;

        while(!q.isEmpty()) {
            int[] now = q.poll();

            for(int d = 0 ; d < 4 ; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if(canGo(nx, ny)) {
                    visited[nx][ny] = true;
                    q.add(new int[] {nx, ny});
                }
            }
        }
    }

    // 안전 영역에 빙하에 둘러쌓여 있지 않은 물이 있는 빙하 찾아 녹이는 메소드
    private static void melt() {
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < M ; j++) {
                if(map[i][j] == 1 && aroundWater(i, j)) {
                    map[i][j] = 0;
                    size++;
                }
            }
        }
    }

    private static boolean aroundWater(int x, int y) {
        for(int d = 0 ; d < 4 ; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(inRange(nx, ny) && visited[nx][ny])
                return true;
        }

        return false;
    }
    
    private static void initialize() {
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < M ; j++) {
                visited[i][j] = false;
            }
        }
    }

    private static boolean canGo(int x, int y) {
        return inRange(x, y) && map[x][y] == 0 && !visited[x][y];
    }

    private static boolean inRange(int x, int y) {
        return (0 <= x && x < N && 0 <= y && y < M);
    }

    private static boolean iceExists() {
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < M ; j++) {
                if(map[i][j] == 1)
                    return true;
            }
        }

        return false;
    }
}