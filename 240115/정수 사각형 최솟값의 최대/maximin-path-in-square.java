import java.util.*;
import java.io.*;

public class Main {
    static int min = -1;

    static int N;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        dp = new int[N][N];
        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1 ; i < N ; i++) {
            for(int j = 1 ; j < N ; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        System.out.println(Math.max(dp[N - 1][N - 2], dp[N - 2][N - 1]));
    }
}