import java.util.*;
import java.io.*;
// 매 초 마다의 위치 기록
public class Main {
    static final int MAX_N = 1_000;

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr1 = new int[MAX_N * MAX_N + 1];
        int time1 = 0;
        int dist1 = 0;

        int[] arr2 = new int[MAX_N * MAX_N + 1];
        int time2 = 0;
        int dist2 = 0;


        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int v = Integer.parseInt(st.nextToken());   // 속도
            int t = Integer.parseInt(st.nextToken());   // 시간

            for(int j = 0 ; j < t ; j++) {
                dist1 += v;
                arr1[++time1] = dist1;
            }
        }

        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            for(int j = 0 ; j < t ; j++) {
                dist2 += v;
                arr2[++time2] = dist2;
            }
        }

        int cnt = 0;
        int[] tmp = new int[time1 + 1];
        for(int i = 1 ; i <= time1 ; i++) {
            if(arr1[i] > arr2[i])       tmp[i] = 1;
            else if(arr1[i] < arr2[i])  tmp[i] = 2;
            else                        tmp[i] = 3;
        }

        for(int i = 0 ; i < tmp.length - 1 ; i++) {
            if(tmp[i] != tmp[i + 1]) {
                cnt++;
            }
        }
        System.out.println(cnt);
   }
}