import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] arr;

    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = arr[0];
        for(int i = 1 ; i < N ; i++) {
            if(sum + arr[i] >= 0) {
                sum += arr[i];
            }
            else {
                sum = arr[i];
            }
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}