import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static int N, K, r, c;
    static int[][] grid;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        grid = new int[N+1][N+1];

        for(int i = 1 ; i <= N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++) {
                grid[i][j + 1] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        while(K-->0){
            if(!smallerNumberExists())
                break;

            visited = new boolean[N + 1][N + 1];
            bfs();
        }

        System.out.println(r + " " + c);
    }
    
    private static boolean smallerNumberExists() {
        for(int d = 0 ; d < 4 ; d++) {
            int nr = r + dx[d];
            int nc = c + dy[d];

            if(inRange(nr, nc) && grid[nr][nc] < grid[r][c])
                return true;
        }

        return false;
    }

    private static boolean inRange(int r, int c) {
        return (1 <= r && r <= N && 1 <= c && c <= N);
    }

    private static void bfs() {
        List<Node> list = new ArrayList<>();
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(r, c, grid[r][c]));

        int num = grid[r][c];

        while(!q.isEmpty()) {
            Node now = q.poll();

            for(int d = 0 ; d < 4 ; d++) {
                int nr = now.r + dx[d];
                int nc = now.c + dy[d];

                if(inRange(nr, nc) && !visited[nr][nc] && grid[nr][nc] < num) {
                    visited[nr][nc] = true;
                    q.add(new Node(nr, nc, grid[nr][nc]));
                    list.add(new Node(nr, nc, grid[nr][nc]));
                }
            }
        }

        Collections.sort(list);
        r = list.get(0).r;
        c = list.get(0).c;
    }
}

class Node implements Comparable<Node> {
    int r, c, val;

    public Node(int r, int c, int val) {
        this.r = r;
        this.c = c;
        this.val = val;
    }

    @Override
    public int compareTo(Node n) {
        if(this.val == n.val) {
            if(this.r == n.r) {
                return this.c - n.c;
            }
            return this.r - n.r;
        }
        return n.val - this.val;
    }
}