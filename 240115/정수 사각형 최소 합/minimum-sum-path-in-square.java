import java.util.*;
import java.io.*;

public class Main {
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

        // 위쪽 줄 채우기
        for(int i = N - 2 ; i >= 0 ; i--) {
            dp[0][i] += dp[0][i + 1];
        }

        // 오른쪽 줄 채우기
        for(int i = 1 ; i < N ; i++) {
            dp[i][N - 1] += dp[i - 1][N - 1];
        }       

        for(int i = 1 ; i < N ; i++) {
            for(int j = N - 2 ; j >= 0 ; j--) {
                dp[i][j] += Math.min(dp[i - 1][j], dp[i][j + 1]);
            }
        }

        System.out.println(dp[N - 1][0]);
    }
}