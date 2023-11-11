import java.util.*;
import java.io.*;

public class Main {
    static int[] arr = new int[6];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0 ; i < 6 ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 0 ; i < 6 ; i++) {
            for(int j = i + 1 ; j < 6 ; j++) {
                for(int k = j + 1 ; k < 6 ; k++) {
                    ans = Math.min(ans, getDiff(i, j, k));
                }
            }
        }

        System.out.println(ans);
    }

    private static int getDiff(int x, int y, int z) {
        int sum1 = arr[x] + arr[y] + arr[z];
        int sum2 = 0;

        for(int i = 0 ; i < 6 ; i++) {
            if(i != x && i != y && i != z) {
                sum2 += arr[i];
            }
        }

        return Math.abs(sum2 - sum1);
    }
}