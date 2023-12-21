import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for(int i = 0 ; i < N ; i++) {
            String[] str = br.readLine().split(" ");
            int m = Integer.parseInt(str[0]);   // 그룹에 속하는 사람 수

            for(int j = 1 ; j <= m ; j++) {
                int num = Integer.parseInt(str[j]);
                arr[i] ^= (1 << num);   // 수 새롭게 추가
            }
        }

        int cnt = 0;
        for(int i = 0 ; i < N - 1 ; i++) {
            for(int j = i + 1 ; j < N ; j++) {
                if(!isOverlap(arr[i], arr[j])) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
    
    private static boolean isOverlap(int a, int b) {
        return (a & b) == 0 ? false : true;
    }
}