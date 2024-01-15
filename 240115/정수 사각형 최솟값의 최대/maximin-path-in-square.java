import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[N][N];
        dp[0][0] = arr[0][0];

        for(int i = 1 ; i < N ; i++) {
            dp[i][0] = Math.min(dp[i - 1][0], arr[i][0]);
            dp[0][i] = Math.min(dp[0][i - 1], arr[0][i]);
        }

        for(int i = 1 ; i < N ; i++) {
            for(int j = 1 ; j < N ; j++) {
                dp[i][j] = Math.min(Math.max(dp[i - 1][j], dp[i][j - 1]), arr[i][j]);
            }
        }

        System.out.println(dp[N - 1][N - 1]);
    }
}