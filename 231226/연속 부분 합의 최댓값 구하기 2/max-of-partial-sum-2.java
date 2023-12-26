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

        int sum = 0;
        for(int i = 0 ; i < N ; i++) {
            sum = Math.max(sum, 0) + arr[i];
            max = Math.max(sum, max);
        }

        System.out.println(max);
    }
}