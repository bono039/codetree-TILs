import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0,1,-1,0};   // 오른쪽, 아래, 위 왼쪽
    static int[] dy = {1,0,0,-1};
    
    static int N, Q, len;
    static int[][] grid, nextGrid;
    static boolean[][] visited;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());   // 회전 가능 레벨
        Q = Integer.parseInt(st.nextToken());   // 회전 횟수

        len = (int)Math.pow(2, N);
        grid = new int[len][len];
        nextGrid = new int[len][len];

        for(int i = 0 ; i < len ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < len ; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        while(Q --> 0) {
            int lv = Integer.parseInt(st.nextToken());

            // 1. 레벨에 맞춰 회전시키기
            if(lv > 0)
                rotate(lv);

            // 2. 얼음 녹이기
            melt();
        }

        // [출력하기]     
        // 1. 남은 빙하 총량 -> 브루트포스
        int sum = 0;
        for(int i = 0 ; i < len ; i++) {
            for(int j = 0 ; j < len ; j++) {
                sum += grid[i][j];
            }
        }
        System.out.println(sum);

        // 2. 가장 큰 크기 갖는 얼음군집 크기 (없으면 0) -> BFS
        visited = new boolean[len][len];
        for(int i = 0 ; i < len ; i++) {
            for(int j = 0 ; j < len ; j++) {
                if(!visited[i][j] && grid[i][j] != 0) {
                    visited[i][j] = true;
                    max = Math.max(max, bfs(i, j));
                }
            }
        }
        System.out.println(max);
    }

    private static void rotate(int lv) {
        // 1. rotate 이후 상태 저장할 배열을 0으로 초기화
        initialize();

        int boxSize  = (int)Math.pow(2, lv);
        int halfSize = (int)Math.pow(2, lv-1);


        // 2. 4등분해 회전하기
        // 2-1) 왼쪽 위 모서리 위치 잡기
        for(int i = 0 ; i < len ; i += boxSize) {
            for(int j = 0 ; j < len ; j += boxSize) {
                // 2-2) 움직여야 하는 크기 격자와 왼쪽 위 모서리를 각각 잡아 알맞은 방향으로 이동시킴
                change(i,            j,            halfSize, 0);
                change(i,            j + halfSize, halfSize, 1);
                change(i + halfSize, j,            halfSize, 2);
                change(i + halfSize, j + halfSize, halfSize, 3);
            }
        }

        // 3. rotate 이후 결과를 grid 배열로 가져오기
        for(int i = 0 ; i < len ; i++) {
            for(int j = 0 ; j < len ; j++) {
                grid[i][j] = nextGrid[i][j];
            }
        }
    }

    //(sr, sc)에서 halfSize 크기의 격차를 dir 방향으로 이동시키는 메소드
    private static void change(int sr, int sc, int halfSize, int dir) {
        for(int i = sr ; i < sr + halfSize ; i++) {
            for(int j = sc ; j < sc + halfSize ; j++) {
                int nx = i + dx[dir] * halfSize;
                int ny = j + dy[dir] * halfSize;

                if(!inRange(nx, ny))    continue;
                nextGrid[nx][ny] = grid[i][j];
            }
        }
    }

    // 얼음 녹이는 메소드 (브루트포스)
    private static void melt() {
        // 1. 녹은 이후 상태 저장할 배열을 0으로 초기화
        initialize();

        // 2. 얼음 녹이기
        for(int i = 0 ; i < len ; i++) {
            for(int j = 0 ; j < len ; j++) {                
                if(grid[i][j] != 0 && aroundIceCnt(i, j) < 3)
                    nextGrid[i][j] = grid[i][j] - 1;
                else
                    nextGrid[i][j] = grid[i][j];
            }
        }

        // 3. 녹은 이후 결과를 grid 배열에 다시 저장하기
        for(int i = 0 ; i < len ; i++) {
            for(int j = 0 ; j < len ; j++) {
                grid[i][j] = nextGrid[i][j];
            }
        }
    }

    // 주변 얼음 개수 세는 메소드
    private static int aroundIceCnt(int x, int y) {
        int iceCnt = 0;

        for(int d = 0 ; d < 4 ; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(inRange(nx, ny) && grid[nx][ny] != 0)
                iceCnt++;
        }

        return iceCnt;
    }

    // 그룹 크기 반환하는 메소드 (BFS)
    private static int bfs(int x, int y) {
        int size = 0;

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {x, y});

        while(!q.isEmpty()) {
            int[] now = q.poll();
            size++;

            for(int d = 0 ; d < 4 ; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if(!inRange(nx, ny) || visited[nx][ny] || grid[nx][ny] == 0) continue;

                visited[nx][ny] = true;
                q.add(new int[] {nx, ny});
            }
        }

        return size;
    }

    private static void initialize() {
        for(int i = 0 ; i < len ; i++) {
            for(int j = 0; j < len ; j++) {
                nextGrid[i][j] = 0;
            }
        }
    }

    private static boolean inRange(int x, int y) {
        return (0 <= x && x < len && 0 <= y && y < len);
    }
}