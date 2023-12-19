import java.util.*;
import java.io.*;

public class Main {
    static int N, M, K;
    static int[] nums;
    static int[] pieces;

    static int answer;    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());   // 턴 수
        M = Integer.parseInt(st.nextToken());   // 윷놀이 판 상태
        K = Integer.parseInt(st.nextToken());   // 말 수

        nums = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        pieces = new int[K];
        for(int i = 0 ; i < K ; i++) {
            pieces[i] = 1;
        }

        findMax(0);

        System.out.println(answer);
    }

    // 말 K개 中 N개 뽑는 순열 (백트래킹)
    private static void findMax(int cnt) {
        // 말을 직접 n번 움직이지 않아도 최대가 될 수 있으므로 항상 답 갱신
        answer = Math.max(answer, calc());

        if(cnt == N) {
            calc();
            return;
        }

        for(int i = 0 ; i < K ; i++) {
            // 움직여서 더 이상 이득이 안 된다면, 더 이상 움직이지 않음
            if(pieces[i] >= M)  continue;

            pieces[i] += nums[cnt];
            findMax(cnt + 1);
            pieces[i] -= nums[cnt];
        }
    }

    // 점수 계산 메소드
    private static int calc() {
        int score = 0;
        for(int i = 0 ; i < K ; i++) {
            score += (pieces[i] >= M ? 1 : 0);
        }

        return score;
    }
}