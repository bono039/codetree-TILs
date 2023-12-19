import java.util.*;
import java.io.*;

public class Main {
    static int N, M, K;
    static int[] turns, moveArr;
    static int[] arr;   // 순열 배열

    static int answer;    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());   // 턴 수
        M = Integer.parseInt(st.nextToken());   // 윷놀이 판 상태
        K = Integer.parseInt(st.nextToken());   // 말 수

        turns = new int[N ];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            turns[i] = Integer.parseInt(st.nextToken());
        }
        
        arr = new int[N];
        perm(0);

        System.out.println(answer);
    }

    // 말 K개 中 N개 뽑는 순열 (백트래킹)
    private static void perm(int cnt) {
        if(cnt == N) {
            calculate();
            return;
        }

        for(int i = 1 ; i <= K ; i++) {
            arr[cnt] = i;
            perm(cnt + 1);
        }
    }

    private static void calculate() {
        int score = 0;
        moveArr = new int[K + 1];

        for(int i = 0 ; i < N ; i++) {
            moveArr[arr[i]] += turns[i];
        }

        for(int i = 1 ; i <= K ; i++) {
            if(moveArr[i] >= M - 1) {
                score++;
            }
        }

        answer = Math.max(answer, score);
    }
}