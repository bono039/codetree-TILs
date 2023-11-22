import java.util.*;
import java.io.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        System.out.println(fibb(N));
    }

    private static int fibb(int num) {
        if(num == 1 || num == 2) {
            return 1;
        }

        return fibb(num - 1) + fibb(num - 2);
    }
}