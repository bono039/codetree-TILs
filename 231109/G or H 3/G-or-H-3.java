import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[] arr = new char[N + 1];
        int min = 100_000;
        int max = 1;

        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int pos = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);

            arr[pos] = c;
            min = Math.min(min, pos);
            max = Math.max(max, pos);
        }

        int score = 0;
        for(int i = 0 ; i < arr.length - K + 1 ; i++) {
            int tmp = 0;
            for(int j = i ; j <= i + K ; j++) {
                if(arr[i] == 'G') {
                    tmp += 1;
                }
                else {
                    tmp += 2;
                }
            }
            score = Math.max(score, tmp);
        }
        System.out.println(score);
    }
}