import java.util.*;
import java.io.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int multiple = a * b * c;   // double형?
        System.out.println(sum(multiple));
    }

    private static int sum(int num) {
        if(num == 0) {
            return 0;
        }
        return sum(num / 10) + num % 10;
    }
}