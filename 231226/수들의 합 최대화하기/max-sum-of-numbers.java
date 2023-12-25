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

        // N개 고르기
        visited = new boolean[N * N];
        comb(0, 0);

        System.out.println(max);
    }

    // N개 조합 뽑는 메소드
    private static void comb(int curr, int sum) {
        if(curr == N) {
            max = Math.max(max, sum);
            return;
        }

        for(int j = 0 ; j < N ; j++) {
            if(!visited[j]) {
                visited[j] = true;
                comb(curr + 1, sum + map[curr][j]);
                visited[j] = false;
            }
        }
    }
}