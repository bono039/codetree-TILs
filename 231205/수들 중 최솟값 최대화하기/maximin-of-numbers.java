import java.util.*;
import java.io.*;

public class Main {
    static int N, answer;
    static int[][] grid;
    static boolean[] visited;

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];

        int idx = 0;
        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
  
        visited = new boolean[N];
        backtracking(0);
        System.out.println(answer);        
    }

    // 백트래킹 (조합)
    private static void backtracking(int depth) {
        if(depth == N) {
            answer = Math.max(answer, getMin());
            return;
        }

        for(int i = 0 ; i < grid.length ; i++) {
            if(visited[i])  continue;

            visited[i] = true;
            list.add(i);

            backtracking(depth + 1);

            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }

    // 색칠된 칸에 적힌 수들 중 최솟값 구하기
    private static int getMin() {
        int min = Integer.MAX_VALUE;

        for(int i = 0 ; i < list.size() ; i++) {
            min = Math.min(min, grid[i][list.get(i)]);
        }

        return min;
    }
}