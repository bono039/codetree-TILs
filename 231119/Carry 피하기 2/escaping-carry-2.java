import java.util.*;
import java.io.*;

public class Main {
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0 ; i < N - 2 ; i++) {
            for(int j = i + 1 ; j < N - 1 ; j++) {
                for(int k = j + 1 ; k < N ; k++) {
                    if(isCarry(arr[i], arr[j], arr[k])) {
                        max = Math.max(max, arr[i] + arr[j] + arr[k]);
                    }
                }
            }
        }
        
        System.out.println((max == Integer.MIN_VALUE) ? -1 : max);
    }
    
    private static boolean isCarry(int a, int b, int c) {
        for(int i = 0 ; i < 5 ; i++) {
            if((a % 10 + b % 10 + c % 10) >= 10) {
                return false;
            }
            a /= 10;
            b /= 10;
            c /= 10;
        }
        return true;
    }
}