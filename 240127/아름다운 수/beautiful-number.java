import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] arr;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        dfs(0);
        System.out.println(cnt);
    }

    private static void dfs(int depth) {
        if(depth == N) {
            cnt++;
            return;
        }

        for(int i = 1 ; i <= 4 ; i++) {
            if(depth + i > N) {
                return;
            }
            else {
                for(int j = 0 ; j < i ; j++) {
                    arr[depth + j] = i;
                }
                dfs(depth + i);
            }
        }
    }
}