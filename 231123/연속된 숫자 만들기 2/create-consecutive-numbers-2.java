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
        if((a + 1 == b) && (b + 1 == c)) {
            answer = 0;
        }
        else if(a + 2 == b || b + 2 == c) {
            answer = 1;
        }
        else {
            answer = 2;
        }

        System.out.println(answer);
    }
}