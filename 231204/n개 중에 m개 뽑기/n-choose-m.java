import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] arr;

    static List<Integer> combList = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        comb(1, 0);
        System.out.println(sb);
    }

    private static void comb(int idx, int depth) {
        if(depth == M) {
            print();
            return;
        }

        for(int i = idx ; i <= N ; i++) {
            combList.add(i);
            comb(i + 1, depth + 1);
            combList.remove(combList.size() - 1);
        }
    }

    private static void print() {
        for(int i = 0 ; i < combList.size() ; i++) {
            sb.append(combList.get(i)).append(" ");
        }
        sb.append("\n");
    }
}