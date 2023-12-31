import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] arr;

    static List<Integer> list = new ArrayList<>();
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        combination(0, 0);
        System.out.println(max);
    }

    private static void combination(int currIdx, int depth) {
        if(depth == M) {
            max = Math.max(max, xor());
            return;
        }

        for(int i = currIdx ; i < N ; i++) {
            list.add(arr[i]);
            combination(i + 1, depth + 1);
            list.remove(list.size() - 1);
        }
    }

    private static int xor() {
        int num = list.get(0);

        for(int i = 1 ; i < list.size() ; i++) {
            num ^= list.get(i);
        }

        return num;
    }
}