import java.util.*;
import java.io.*;

public class Main {
    static int max = Integer.MIN_VALUE;

    static int N, M;
    static int[] arr;
    static List<Integer> comb = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i <  N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        getComb(0, 0);
        System.out.println(max);
    }

    private static void getComb(int lastNum, int depth) {
        if(depth == M) {
            max = Math.max(max, XOR());
            return;
        }

        for(int i = lastNum ; i < N ; i++) {
            comb.add(arr[i]);
            getComb(i + 1, depth + 1);
            comb.remove(comb.size() - 1);
        }
    }

    private static int XOR() {
        int tmp = comb.get(0);
        for(int i = 1 ; i < comb.size() ; i++) {
            tmp = tmp ^ comb.get(i);   // 비트 연산
        }

        return tmp;
    }                                                                                                                                                     
}