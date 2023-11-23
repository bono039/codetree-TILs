import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(result(N, 0));
    }

    private static int result(int num, int cnt) {
        if(num == 1) {
            return cnt;
        }

        if(num % 2 == 0) {
            return result(num / 2, cnt + 1);
        }
        return result(num * 3 + 1, cnt + 1);
    }
}