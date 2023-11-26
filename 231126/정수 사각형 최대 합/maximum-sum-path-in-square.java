import java.util.*;
import java.io.*;

public class Main {
    static final int MAX_N = 1_000_000;
    static int N;
    static int[][] arr;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1][N + 1];       
        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new long[N + 1][N + 1];
        initialize();

        for(int i = 1 ; i < N ; i++) {
            for(int j = 1 ; j < N ; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + arr[i][j];
            }
        }

        System.out.println(dp[N - 1][N - 1]);
    }

    private static void initialize() {
        dp[0][0] = arr[0][0];

        for(int i = 1 ; i <= N ; i++) {
            dp[0][i] = dp[0][i - 1] + arr[0][i];
            dp[i][0] = dp[i - 1][0] + arr[i][0];
        }
    }
}