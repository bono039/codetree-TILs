import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static List<Integer> permutation = new ArrayList<>();
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];

        getPerm(0);
        System.out.println(sb);
    }

    private static void getPerm(int num) {
        if(num == N) {
            printPerm();
            return;
        }

        for(int i = N ; i >= 1 ; i--) {
            if(visited[i])  continue;

            visited[i] = true;
            permutation.add(i);

            getPerm(num + 1);

            visited[i] = false;
            permutation.remove(permutation.size() - 1);
        }
    }

    private static void printPerm() {
        for(int i = 0 ; i < permutation.size() ; i++) {
            sb.append(permutation.get(i) + " ");
        }
        sb.append("\n");
    }
}