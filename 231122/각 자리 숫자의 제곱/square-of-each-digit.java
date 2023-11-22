import java.util.*;
import java.io.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        System.out.println(getResult(N, 0));
    }

    private static int getResult(int num, int sum) {
        if(num == 0) {
            return sum;
        }
        return getResult(num / 10, sum + (int)Math.pow(num % 10, 2));
    }
}