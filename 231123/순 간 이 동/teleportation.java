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
        int pos = A;


        if(((int)Math.abs(A - x) < (int)Math.abs(A - y))) {
            answer += (int)Math.abs(A - x);
            answer += (int)Math.abs(B - y);
        }
        else {
            answer += (int)Math.abs(A - y);
            answer += (int)Math.abs(B - x);
        }            
        
        answer = Math.min(answer, Math.abs(A - B));
        System.out.println(answer);
    }
}