import java.util.*;
import java.io.*;

public class Main {
    static final int mod = 10_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[1001];
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;

        for(int i = 4 ; i <= N ; i++) {
            dp[i] = (dp[i - 2] + dp[i - 3]) % mod;
        }

        System.out.println(dp[N]);
    }
}