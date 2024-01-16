import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        if(N == 2) {
            System.out.println(2);
            return;
        }
        if(N == 3) {
            System.out.println(5);
            return;
        }
        
        dp[2] = 2;
        dp[3] = 5;

        for(int i = 4 ; i <= N ; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println(dp[N]);
    }
}