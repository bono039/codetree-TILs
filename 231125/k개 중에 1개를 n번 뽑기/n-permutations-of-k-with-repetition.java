import java.util.*;
import java.io.*;

public class Main {
    static int K, N;
    static int[] arr, result;
    static StringBuilder sb = new StringBuilder();                        

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[K];
        for(int i = 0 ; i < arr.length ; i++) {
            arr[i] = i + 1;
        }
        result = new int[N];
        
        back(0);
        System.out.println(sb.toString());
    }

    private static void back(int depth) {
        if(depth == N) {
            for(int i : result) sb.append(i + " ");
            sb.append("\n");
            return;
        }

        for(int i = 0 ; i < K ; i++) {
            result[depth] = arr[i];
            back(depth + 1);
        }
    }

}