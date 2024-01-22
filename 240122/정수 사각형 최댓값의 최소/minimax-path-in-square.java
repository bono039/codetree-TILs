import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N][N];
        dp[0][0] = arr[0][0];

        for(int i = 1 ; i < N ; i++) {
            dp[0][i] = Math.max(arr[0][i], dp[0][i - 1]);  // 맨 윗 줄
            dp[i][0] = Math.max(arr[i][0], dp[i - 1][0]);  // 맨 왼쪽 줄
        }

        for(int i = 1 ; i < N ; i++) {
            for(int j = 1 ; j < N ; j++) {
                dp[i][j] = Math.max(Math.min(dp[i - 1][j], dp[i][j - 1]), arr[i][j]);
            }
        }

        System.out.println(dp[N - 1][N - 1]);
    }
}