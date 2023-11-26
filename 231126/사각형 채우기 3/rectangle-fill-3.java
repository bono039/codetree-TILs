import java.util.*;
import java.io.*;

public class Main {
    static final int mod = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[1001];
        dp[1] = 2;
        dp[2] = 7;
        for(int i = 3 ; i <= N ; i++) {
            dp[i] = (dp[i - 1] * 3 + 1) % mod;
        }

        System.out.println(dp[N]);
    }
}