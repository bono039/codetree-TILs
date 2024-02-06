import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] map;
    static int max = 0; // 손해보지 않으면서 채굴 가능한 최대 금 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());   // 금 1개 가격

        map = new int[n][n];
        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < m ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                for(int k = 0 ; k < n ; k++) {
                    int goldCnt = countGold(i,j,k);

                    if(goldCnt * m >= digCost(k)) {
                        max = Math.max(max, goldCnt);
                    }
                }                    
            }
        }

        System.out.println(max);
    }

    private static int countGold(int x, int y, int k) {
        int cnt = 0;

        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(Math.abs(x - i) + Math.abs(y - j) <= k) {
                    cnt += map[i][j];
                }
            }
        }

        return cnt;
    }

    private static int digCost(int k) {
        return k * k + (k + 1) * (k + 1);
    }
}