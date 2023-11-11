import java.util.*;
import java.io.*;

public class Main {
    static int[] arr = new int[6];
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0 ; i < 6 ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 2명씩 3팀
        for(int i = 0 ; i < 6 ; i++) {
            for(int j = i + 1 ; j < 6 ; j++) {
                min = Math.min(min, getDiff(i, j));                
            }
        }
        System.out.println(min);
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

        for(int i = 0 ; i < 6 ; i++) {
            for(int j = i + 1 ; j < 6 ; j++) {
                if(i == a || i == b || j == a || j == b)    continue;
                sum2 = (arr[i] + arr[j]);
                sum3 = total - sum1 - sum2;

                int[] arr = {sum1, sum2, sum3};
                Arrays.sort(arr);
                int diff = arr[2] - arr[0];
                tmpMin = Math.min(tmpMin, diff);
            }
        }

        return tmpMin;        
    }
}