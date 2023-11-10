import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());   // 바구니 수
        int K = Integer.parseInt(st.nextToken());   // +- K

        int[] arr = new int[101];

        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int candy = Integer.parseInt(st.nextToken());   // 사탕 개수
            int basket = Integer.parseInt(st.nextToken());  // 바구니 좌표

            arr[basket] += candy;
        }

        int max = 0;
        for(int i = K ; i <= 100 - K ; i++) {
            int tmp = 0;
            for(int j = i - K ; j <= i + K ; j++) {
                tmp += arr[j];
            }
            max = Math.max(max, tmp);
        }

        System.out.println(max);
    }
}