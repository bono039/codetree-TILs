import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;

        for(int i = 1 ; i < N ; i++) {
            for(int j = 0 ; j < i ; j++) {
                if(dp[j] == Integer.MIN_VALUE)	continue;

                if(j + arr[j] >= i) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int answer = 0;
        for(int i = 0 ; i < N ; i++) {
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);        
    }
}