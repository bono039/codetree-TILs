import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        int total = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
        }

        int diff = Integer.MAX_VALUE;
        for(int i = 0 ; i < N ; i++) {
            for(int j = i + 1 ; j < N ; j++) {  // 제외시킬 번호1
                for(int k = j + 1 ; k < N ; k++) {  // 제외시킬 번호2
                    if(Math.abs(S - (total - arr[j] - arr[k])) < diff) {
                        diff = Math.abs(S - (total - arr[j] - arr[k]));
                    }
                }
            }
        }

        System.out.println(diff);
    }
}