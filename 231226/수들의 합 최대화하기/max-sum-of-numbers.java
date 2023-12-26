import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[] visited;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N];
        solve(0, 0);

        System.out.println(max);
    }

    private static void solve(int row, int sum) {
        if(row == N) {
            max = Math.max(max, sum);
            return;
        }

        // 현재 행에 대해 색칠할 열 선택
        for(int j = 0 ; j < N ; j++) {
            if(!visited[j]) {
                visited[j] = true;
                solve(row + 1, sum + map[row][j]);
                visited[j] = false;
            }
        }
    }
}