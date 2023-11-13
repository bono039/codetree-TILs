import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());   // 이 높이로 나오게
        int T = Integer.parseInt(st.nextToken());   // 최소 몇 번 이상

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] diff = new int[N];
        for(int i = 0 ; i < diff.length ; i++) {
            diff[i] = Math.abs(H - arr[i]);
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i <= diff.length - T ; i++) {
            int tmp = 0;
            for(int j = i ; j < i + T ; j++) {
                tmp += diff[j];
            }
            min = Math.min(min, tmp);
        }

        System.out.println(min);
        
    }
}