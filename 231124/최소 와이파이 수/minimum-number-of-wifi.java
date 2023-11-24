import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = Integer.MAX_VALUE;

        for(int i = M ; i < arr.length - M ; i++) {
            int tmp = 0;
            for(int j = i - M ; j <= i + M ; j++) {
                if(arr[j] == 1)
                    tmp++;
            }
            cnt = Math.min(cnt, tmp);
        }
        System.out.println(cnt);
    }
}