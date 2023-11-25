import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int answer = Integer.MIN_VALUE;

        for(int i = 1 ; i < C / A ; i++) {
            for(int j = 1 ; j < C / B ; j++) {
                int tmp = A * i + B * j;

                if(tmp <= C) {
                    answer = Math.max(answer, tmp);
                }
            }
        }

        System.out.println(answer);
    }
}