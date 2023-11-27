import java.util.*;
import java.io.*;

public class Main {
    static final int MOD = 10_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        dp[1] = 1;
        dp[2] = 3;

        for(int i = 3 ; i <= N ; i++) {
            dp[i] = (dp[i - 1] * 2 - 1) % MOD;
        }

        System.out.println(dp[N]);
    }
}