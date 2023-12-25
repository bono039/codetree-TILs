import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {};

    static int N, T;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // input
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        arr = new int[2][N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            arr[0][i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            arr[1][N - 1 - i] = Integer.parseInt(st.nextToken());
        }

        while(T --> 0) {
            rotate();
        }

        print();
    }

    private static void rotate() {
        // swap
        // 윗줄
        int leftTop = arr[0][N - 1];

        // 나머지 원소를 오른쪽으로 shift (왜 for문을 이렇게 감소식으로 하는지?)
        for(int i = N - 1 ; i >= 1 ; i--) {
            arr[0][i] = arr[0][i - 1];
        }

        // 아랫줄
        int leftDown = arr[1][0];
        for(int i = 0 ; i < N - 1 ; i++) {
            arr[1][i] = arr[1][i + 1];
        }

        arr[0][0] = leftDown;
        arr[1][N - 1] = leftTop;
    }

    private static void print() {
        // output
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < N ; i++) {
            sb.append(arr[0][i]).append(" ");
        }
        sb.append("\n");

        // 아랫줄 출력 거꾸로
        for(int i = N - 1 ; i >= 0 ; i--) {
            sb.append(arr[1][i]).append(" ");
        }

        System.out.println(sb);
    }
}