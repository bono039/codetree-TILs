import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 입력받기
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] B = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < M ; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(B); // 정렬하기

        int answer = 0;
        for(int i = 0 ; i <= N - M ; i++) { // 탐색할 A 배열 구간에서의 시작점
            int[] tmp = new int[M]; // 구간 내 값들을 담을 임시 배열
            int idx = 0;
            for(int j = i ; j < i + M ; j++) {  // 탐색할 A 배열 구간에서의 끝점
                tmp[idx++] = A[j];
            }

            // 정렬 후 두 배열의 값이 같다면, 아름다운 수열 수 + 1
            Arrays.sort(tmp);
            boolean isSame = true;
            for(int j = 0 ; j < M ; j++) {
                if(tmp[j] != B[j]) {
                    isSame = false;
                    break;
                }
            }

            if(isSame) answer++;
        }

        System.out.println(answer);
    }
}