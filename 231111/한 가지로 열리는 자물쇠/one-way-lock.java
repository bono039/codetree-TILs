import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < arr.length ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        for(int i = 1 ; i <= N ; i++) {
            for(int j = 1 ; j <= N ; j++) {
                for(int k = 1 ; k <= N ; k++) {
                    int a = i;  // 첫 번째 자리
                    int b = j;
                    int c = k;  //  세 번째 자리

                    if(Math.abs(c - arr[2]) <= 2 || Math.abs(b - arr[1]) <= 2 || Math.abs(a - arr[0]) <= 2) {
                        cnt++;
                    }
                }
            }
        }
        
        System.out.println(cnt);
    }
}