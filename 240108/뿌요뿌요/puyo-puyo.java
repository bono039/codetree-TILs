import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int N;

    static int[][] grid;
    static boolean[][] visited;

    static int block = 0;   // 터지는 블럭 수
    static int max = 0;     // 최대 블럭 크기

    static int currBlockNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];

        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][N];
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N ; j++) {
                if(!visited[i][j]) {
                    currBlockNum = 1;
                    dfs(i, j);

                    if(currBlockNum >= 4) {
                        block++;
                    }
                    max = Math.max(max, currBlockNum);
                }
            }
        }

        System.out.println(block + " " + max);
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for(int d = 0 ; d < 4 ; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(!inRange(nx, ny) || visited[nx][ny] || grid[nx][ny] != grid[x][y])    continue;
            
            currBlockNum++;
            dfs(nx, ny);
        }
    }

    private static boolean inRange(int x, int y) {
        return (0 <= x && x < N && 0 <= y && y < N);
    }
}