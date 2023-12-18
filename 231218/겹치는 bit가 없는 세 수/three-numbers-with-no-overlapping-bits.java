import java.util.*;
import java.io.*;

public class Main {
    static int max = 0;

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 숫자 3개 고르기 (완탐)
        for(int i = 0 ; i < arr.length - 2 ; i++) {
            for(int j = i + 1 ; j < arr.length - 1 ; j++) {
                for(int k = j + 1 ; k < arr.length ; k++) {
                    if(chkBitOverlap(arr[i], arr[j], arr[k]) && (getSum(arr[i], arr[j], arr[k]) > max)) {
                        max = getSum(arr[i], arr[j], arr[k]);
                    }
                }
            }
        }
        System.out.println(max);
    }

    // bit가 서로 겹치지 않음 = & 연산하고 결과가 0일 때
    private static boolean chkBitOverlap(int a, int b, int c) {
        return ((a & b) == 0 && (a & c) == 0 && (b & c) == 0);
    }

    private static int getSum(int a, int b, int c) {
        return a + b + c;
    }
}