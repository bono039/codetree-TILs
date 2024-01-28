import java.util.*;
import java.io.*;

public class Main {
    
    static int [] dy = {-1,1,0,0};
    static int [] dx = {0,0,-1,1};

    static int n, m, k;
    static int[][] map;
    static ArrayList<int[]> rockList = new ArrayList<>();   // 돌 리스트

    // dfs용
    static int[] res;  // 고른 돌 목록
    static boolean[][] v;

    static int[][] startPos;   // 시작점 위치

    static int max = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        res = new int[m];
        map = new int[n][n];
        startPos = new int[k][2];

        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < n ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 1){
                    rockList.add(new int[]{i , j});
                }
            }
        }

        for(int i = 0 ; i < k ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            startPos[i][0] = Integer.parseInt(st.nextToken()) - 1;
            startPos[i][1] = Integer.parseInt(st.nextToken()) - 1;
        }

        dfs(0, 0);
        System.out.print(max);
    }
    static void dfs(int cur, int depth){
        if(depth == m){
            // 돌 제거하기
            for(int r : res){
                int[] pos = rockList.get(r);
                map[pos[0]][pos[1]] = 0;
            }

            v = new boolean[n][n];
            int sum = 0;

            for(int[] pos : startPos){
                if(v[pos[0]][pos[1]]) continue;
                sum += bfs(pos[0], pos[1]);
            }

            max = Math.max(sum, max);

            // 원상복구하기
            for(int r : res){
                int[] pos = rockList.get(r);
                map[pos[0]][pos[1]] = 1;
            }

            return;
        }

        for(int i = cur ; i < rockList.size() ; i++) {
            res[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }

    static int bfs(int x, int y){
        Queue<int []> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});
        
        v[x][y] = true;
        int cnt = 1;

        while(!queue.isEmpty()){
            int [] now = queue.poll();

            for(int d = 0 ; d < 4 ; d++){
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if(OOB(nx, ny) || v[nx][ny] || map[nx][ny] == 1) continue;
                cnt++;
                v[nx][ny] = true;
                queue.add(new int[]{nx, ny});
            }
        }
        
        return cnt;
    }

    static boolean OOB(int y, int x){
        return y >= n || y < 0 || x >= n || x < 0;
    }
}