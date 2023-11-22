import java.util.*;
import java.io.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        System.out.println(getCount(N, 0));
    }

    private static int getCount(int num, int cnt) {
        if(num == 1) {
            return cnt;
        }

        if(num % 2 == 0) {
            return getCount(num / 2, cnt + 1);
        }
        else {
            return getCount(num / 3, cnt + 1);
        }

    }
}