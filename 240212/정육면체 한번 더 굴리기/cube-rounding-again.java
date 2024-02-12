import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0,1,0,-1};   // (시계 방향) 오른쪽 아래쪽 왼쪽 위쪽
    static int[] dy = {1,0,-1,0};

    static int n,m;
    static int[][] grid;
    static boolean[][] visited;

    static int[] dice = new int[] {1,2,3};
    static int x = 0, y = 0, dir = 0;
    static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][n];
        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine(), " "); 
            for(int j = 0 ; j < n ; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[n][n];

        while(m --> 0) {
            roll();
        }

        System.out.println(sum);
    }

    private static void roll() {
        // 1. 아랫면 확인해 방향 값 설정하기
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        // 격자판 벗어난 경우
        if(!inRange(nx, ny)) {
            dir = (dir + 2) % 4;

            nx = x + dx[dir];
            ny = y + dy[dir];
        }

        // 범위 내에 있는 경우
        x = nx;
        y = ny;
        sum += bfs(x, y);

        // 2. 주사위 놓인 상태 조정하기
        rotateDice(x, y);
    }

    private static void rotateDice(int nx, int ny) {
        int[] tmp = dice.clone();
        if(dir == 0) {
            dice = new int[]{7 - tmp[2], tmp[1], tmp[0]};
        }
        else if(dir == 1) {
            dice = new int[]{7 - tmp[1], tmp[0], tmp[2]};
        }
        else if(dir == 2) {
            dice = new int[] {tmp[2], tmp[1], 7 - tmp[0]};
        }
        else if(dir == 3) {
            dice = new int[] {tmp[1], 7 - tmp[0], tmp[2]};
        }

        // 주사위 바닥면 비교하기
        int bottom = 7 - dice[0];

        if(bottom > grid[x][y]) { // 시계 90도 회전
            dir = (dir + 1) % 4;
        }
        else if(bottom < grid[nx][ny]) {    // 반시계 90도 회전
            dir = (dir - 1 + 4) % 4;
        }
    }

    private static int bfs(int x, int y) {
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++)
                visited[i][j] = false;
        }
        visited[x][y] = true;

        int target = grid[x][y];
        int total = 0;

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {x, y});

        while(!q.isEmpty()) {
            int[] now = q.poll();
            total += target;

            for(int d = 0 ; d < 4 ; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if(inRange(nx, ny) && !visited[nx][ny] && grid[nx][ny] == target) {
                    visited[nx][ny] = true;
                    q.add(new int[] {nx, ny, total});
                }
            }
        }

        return total;
    }

    private static boolean inRange(int x, int y) {
        return (0 <= x && x < n && 0 <= y && y < n);
    }
}