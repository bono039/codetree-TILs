import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int N, K, M;

    static int[][] grid;
    static List<int[]> rocks = new ArrayList<>();   // 돌 위치 기록 리스트
    static List<int[]> chosenRocks = new ArrayList<>();

    static int max = 0;     // 방문 가능한 칸 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());   // 격자 크기
        K = Integer.parseInt(st.nextToken());   // 시작점 수
        M = Integer.parseInt(st.nextToken());   // 치워야 할 돌 개수

        grid = new int[N+1][N+1];
        for(int i = 1 ; i <= N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1 ; j <= N ; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());

                if(grid[i][j] == 1) {
                    rocks.add(new int[] {i, j});
                }
            }
        }

        while(K --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken()); 

            grid[r][c] = 2; // 시작점 기록           
        }

        combination(0);
        System.out.println(max);
    }

    private static void combination(int depth) {
        if(depth == M) {
            max = Math.max(max, bfs());
            return;
        }

        for(int i = 0 ; i < rocks.size() ; i++) {
            chosenRocks.add(rocks.get(i));
            combination(depth + 1);
            chosenRocks.remove(chosenRocks.size() - 1);
        }
    }

    private static int bfs() {
        Queue<int[]> q = new ArrayDeque<>();

        int[][] newGrid = new int[N+1][N+1];
        for(int i = 1 ; i <= N ; i++) {
            for(int j = 1 ; j <= N ; j++) {
                newGrid[i][j] = grid[i][j];

                if(newGrid[i][j] == 2) {    // 시작점 큐에 삽입
                    q.add(new int[] {i, j});
                }
            }
        }

        // 돌 치우기
        for(int i = 0 ; i < chosenRocks.size() ; i++) {
            newGrid[chosenRocks.get(i)[0]][chosenRocks.get(i)[1]] = 0;
        }

        while(!q.isEmpty()) {
            int[] now = q.poll();

            for(int d = 0 ; d < 4 ; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if(inRange(nx, ny) && newGrid[nx][ny] == 0) {
                    q.add(new int[]{nx, ny});
                    newGrid[nx][ny] = 2;
                }
            }
        }

        int cnt = 0;
        for(int i = 1 ; i <= N ; i++) {
            for(int j = 1 ; j <= N ; j++) {
                if(newGrid[i][j] == 2) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static boolean inRange(int x, int y) {
        return (1 <= x && x <= N && 1 <= y && y <= N);
    }
}