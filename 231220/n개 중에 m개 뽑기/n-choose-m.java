import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static boolean[] visited;

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);

        visited = new boolean[N + 1];
        combination(1, 0);
    }

    private static void combination(int idx, int depth) {
        if(depth == M) {
            printList();
        }

        for(int i = idx ; i <= N ; i++) {
            list.add(i);
            combination(i + 1, depth + 1);
            list.remove(list.size() - 1);
        }
    }

    private static void printList() {
        for(int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}