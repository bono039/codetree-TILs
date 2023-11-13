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
        
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i <= N - T ; i++) {   // 등호 조심!!
            int tmp = 0;
            for(int j = i ; j < i + T ; j++) {  // 길이가 T인 구간 전체 잡아보기
                tmp += Math.abs(H - arr[j]);
            }

            min = Math.min(min, tmp);   // 최솟값 갱신
        }

        System.out.println(min);
    }
}