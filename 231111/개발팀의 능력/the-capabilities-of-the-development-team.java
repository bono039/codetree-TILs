import java.util.*;
import java.io.*;

public class Main {
    static int[] arr = new int[5];
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0 ; i < 5 ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0 ; i < 5 ; i++) {  // 첫 번째 팀
            for(int j = i + 1 ; j < 5 ; j++) {
                min = Math.min(min, getDiff(i, j));
            }
        }
        
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    private static int getDiff(int a, int b) {
        int total = 0;
        for(int i : arr) {
            total += i;
        }

        int sum1 = arr[a] + arr[b];
        int sum2 = 0;
        int sum3 = 0;

        int tmpMin = Integer.MAX_VALUE;

        for(int i = 0 ; i < 5 ; i++) {  // 두 번째 팀 고르기
            for(int j = i + 1 ; j < 5 ; j++) {
                if(i == a || i == b || j == a || j == b)    continue;
                
                sum2 = arr[i] + arr[j];
                sum3 = total - sum1 - sum2;

                int[] tmp = {sum1, sum2, sum3};
                Arrays.sort(tmp);

                if(sum1 == sum2 || sum2 == sum3 || sum1 == sum3)    continue;
                tmpMin = Math.min(tmpMin, tmp[2] - tmp[0]);
            }
        }

        return tmpMin;
    }
}