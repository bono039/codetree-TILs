import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(result(N));
    }

    private static int result(int num) {
        if(num == 1) {
            return 2;
        }
        if(num == 2) {
            return 4;
        }

        return result(num - 1) * result(num - 2) % 100;
    }
}