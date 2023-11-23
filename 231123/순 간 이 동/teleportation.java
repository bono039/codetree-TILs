import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int answer = 0;

        // Case 1) a -> x -> y -> b 순서로 이동
        if(((int)Math.abs(A - x) < (int)Math.abs(A - y))) {
            answer += (int)Math.abs(A - x);
            answer += (int)Math.abs(B - y);
        }
        // Case 2) a -> y -> x -> b 순서로 이동
        else {
            answer += (int)Math.abs(A - y);
            answer += (int)Math.abs(B - x);
        }            
        
        // Case 3) a -> b 바로 이동
        answer = Math.min(answer, Math.abs(A - B));
        System.out.println(answer);
    }
}