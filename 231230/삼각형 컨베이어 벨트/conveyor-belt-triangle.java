import java.util.*;
import java.io.*;

public class Main {
    static int N, T;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        arr = new int[3][N];
        
        for(int i = 0 ; i < 3 ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }            
        }

        while(T --> 0) {
            rotate();
        }

        print();
    }

    private static void rotate() {
        int first = arr[0][N - 1];
        for(int i = N - 1 ; i >= 1 ; i--) {
            arr[0][i] = arr[0][i - 1];
        }
        
        int second = arr[1][N - 1];
        for(int i = N - 1 ; i >= 1 ; i--) {
            arr[1][i] = arr[1][i - 1];
        }

        int third = arr[2][N - 1];
        for(int i = N - 1 ; i >= 1 ; i--) {
            arr[2][i] = arr[2][i - 1];
        }

        arr[0][0] = third;
        arr[1][0] = first;
        arr[2][0] = second;
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();
        for(int[] i : arr) {
            for(int j : i) 
                sb.append(j + " ");
            sb.append("\n");
        }

        System.out.println(sb);
    }
}