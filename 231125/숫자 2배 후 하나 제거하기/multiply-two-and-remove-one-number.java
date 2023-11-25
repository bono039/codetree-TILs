import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int minDiff = Integer.MAX_VALUE;
        for(int i = 0 ; i < N ; i++) {
            arr[i] *= 2;    // 하나의 숫자 선택해 2배

            for(int j = 0 ; j < N ; j++) {
                int[] remainder = new int[N - 1];   // 하나의 숫자 선택해 제거한 배열
                int cnt = 0;
                for(int k = 0 ; k < N ; k++) {
                    if(k != j) {
                        remainder[cnt++] = arr[k];
                    }
                }

                int sumDiff = 0;    // 인접한 숫자간의 차의 합
                for(int k = 0 ; k < N - 2 ; k++) {
                    sumDiff += Math.abs(remainder[k + 1] - remainder[k]);
                }

                minDiff = Math.min(minDiff, sumDiff);
            }

            arr[i] /= 2;
        }

        System.out.println(minDiff);
    }
}