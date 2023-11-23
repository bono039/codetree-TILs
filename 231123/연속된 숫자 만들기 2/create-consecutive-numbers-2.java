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
        while(true) {
            int diff1 = Math.abs(b - a);
            int diff2 = Math.abs(c - b);
            
            if((c - b) * (b - a) == 1) {
                break;
            }

            if(diff2 < diff1) {
                if(Math.abs(c - b) != 1) {
                    a = b;
                    b = c - 1;
                    answer++;
                }
                else {
                    a = b - 1;
                    answer++;
                }
            }
            else {
                if(Math.abs(b - a) != 1) {
                    c = b;
                    b = a + 1;
                    answer++;
                }
                else {
                    c = b + 1;
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}