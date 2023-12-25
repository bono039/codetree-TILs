import java.util.*;
import java.io.*;

public class Main {
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
        // [윗줄]
        // 윗줄 맨 오른쪽 값 따로 빼두기
        int leftTop = arr[0][N - 1];

        // 나머지 원소를 오른쪽으로 shift (오른쪽부터 채워넣음)
        for(int i = N - 1 ; i >= 1 ; i--) {
            arr[0][i] = arr[0][i - 1];
        }

        // [아랫줄]
        // 아랫줄 맨 왼쪽 값 따로 빼두기
        int leftDown = arr[1][0];

        for(int i = 0 ; i < N - 1 ; i++) {
            arr[1][i] = arr[1][i + 1];
        }

        arr[0][0] = leftDown;       // 맨 왼쪽 위 숫자 채우기
        arr[1][N - 1] = leftTop;    // 맨 오른쪽 아래 숫자 채우기
    }

    private static void print() {
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