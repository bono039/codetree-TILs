import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] B = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < M ; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for(int i = 0 ; i <= N - M ; i++) {
            int tmp = 0;

            for(int j = i ; j < i + M ; j++) {
                for(int k = 0 ; k < M ; k++) {
                    if(A[j] == B[k]) {
                        tmp++;
                    }
                }
                if(tmp == M) answer++;
            }
        }
        System.out.println(answer);

        // 백트래킹 아니묘?
    }
}