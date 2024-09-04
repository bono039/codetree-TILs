import java.util.*;
import java.io.*;

public class Main {
    static int N,M,K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(K == 0) {
            System.out.println(getDP(0,0,N-1,M-1));
            return;
        }

        int[] pos = new int[2];
        int num = 1;
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < M ; j++) {
                if(num == K) {
                    pos[0] = i;
                    pos[1] = j;
                    break;
                }
                num++;
            }
        }

        System.out.println(getDP(0,0,pos[0], pos[1]) * getDP(pos[0], pos[1], N-1, M-1));
    }

    private static long getDP(int sx, int sy, int ex, int ey) {
        int r = ex-sx+1;
        int c = ey-sy+1;
        System.out.println("R > " +(r-1) + ", c > " + (c-1));

        // dp 초기화
        long[][] dp = new long[r][c];
        // 행
        for(int i = 0 ; i < r ; i++) {
            dp[i][0] = 1;
        }
        // 열
        for(int i = 0 ; i < c ; i++) {
            dp[0][i] = 1;
        }

        // dp 배열 채우기
        for(int i = 1 ; i < r ; i++) {
            for(int j = 1 ; j < c ; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[r-1][c-1];
    }
}