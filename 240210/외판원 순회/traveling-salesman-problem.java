import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] A;
    static boolean[] visited;
    static List<Integer> list = new ArrayList<>();
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        A = new int[n+1][n+1];
        visited = new boolean[n+1];

        for(int i = 1 ; i <= n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1 ; j <= n ; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[1] = true;
        list.add(1);
        solve(1);

        System.out.println(min);
    }

    private static void solve(int cnt) {
        if(cnt == n) {
            min = Math.min(min, getSum());
            return;
        }

        for(int i = 1 ; i <= n ; i++) {
            if(!visited[i]) {
                visited[i] = true;
                list.add(i);

                solve(cnt + 1);

                visited[i] = false;
                list.remove(list.size() - 1);

            }
        }        
    }

    private static int getSum() {
        int sum = 0;

        for(int i = 0 ; i < list.size() - 1 ; i++) {
            sum += A[list.get(i)][list.get(i + 1)];
        }
        sum += A[list.get(list.size() - 1)][1];

        return sum;
    }
}