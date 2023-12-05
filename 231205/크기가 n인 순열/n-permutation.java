import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static boolean[] visited;
    
    static List<Integer> combination = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];

        back(0);
        System.out.println(sb);
    }

    private static void back(int num) {
        if(num == N) {
            printAnswer();
            return;
        }

        for(int i = 1 ; i <= N ; i++) {
            if(visited[i])  continue;

            visited[i] = true;
            combination.add(i);

            back(num + 1);

            visited[i] = false;
            combination.remove(combination.size() - 1);
        }

    }

    private static void printAnswer() {
        for(int i = 0 ; i < combination.size() ; i++) {
            sb.append(combination.get(i)).append(" ");
        }
        sb.append("\n");
    }
}