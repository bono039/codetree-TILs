import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] visited = new boolean[N];

        int cnt = 0;
        for(int i = arr.length - 1 - M ; i >= M ; i--) {
            int tmp = 0;
            if(arr[i] == 1 && !visited[i]) {
                for(int j = i - M ; j <= i + M ; j++) {
                    visited[j] = true;
                    if(arr[j] == 1) {
                        tmp++;
                    }
                }
            }

            if(tmp > 0) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}