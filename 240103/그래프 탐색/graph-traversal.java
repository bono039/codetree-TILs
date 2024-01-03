import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static List<Integer>[] A;
    static boolean[] visited;

    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new ArrayList[N + 1];
        for(int i = 1 ; i <= N ; i++) {
            A[i] = new ArrayList<>();
        }

        while(M --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            A[a].add(b);
            A[b].add(a);
        }

        visited = new boolean[N + 1];
        dfs(1);
        System.out.println(cnt);
    }

    private static void dfs(int num) {
        visited[num] = true;

        for(int next : A[num]) {
            if(!visited[next]) {
                cnt++;
                dfs(next);
            }
        }
    }
}