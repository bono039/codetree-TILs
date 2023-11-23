import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int answer = 0;

        // Case1) 숫자 3개가 연속한 경우
        if((a + 1 == b) && (b + 1 == c)) {
            answer = 0;
        }
        // Case2) 숫자 2개의 차이가 2인 경우
        else if(a + 2 == b || b + 2 == c) {
            answer = 1;
        }
        // Case3) 그렇지 않은 경우, 항상 2번에 걸쳐 연속하게 만들 수 있음
        else {
            answer = 2;
        }

        System.out.println(answer);
    }
}