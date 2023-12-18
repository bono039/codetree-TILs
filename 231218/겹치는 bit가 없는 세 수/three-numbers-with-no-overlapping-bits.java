import java.util.*;
import java.io.*;

public class Main {
    static int max = 0;

    static int N;
    static int[] arr;
    static List<Integer> list = new ArrayList<>();    
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 숫자 3개 고르기 (조합)
        visited = new boolean[N];
        comb(0, 0);
        System.out.println(max);
    }

    private static void comb(int idx, int depth) {
        if(depth == 3) {
            if(chkBitOverlap()) {
                max = Math.max(max, getSum());
            }
            return;
        }

        for(int i = idx ; i < arr.length ; i++) {
            if(!visited[i]) {
                list.add(arr[i]);
                visited[i] = true;

                comb(i + 1, depth + 1);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }

        return;
    }

    // bit가 서로 겹치지 않음 = & 연산하고 결과가 0일 때
    private static boolean chkBitOverlap() {
        int a = list.get(0);
        int b = list.get(1);
        int c = list.get(2);

        return ((a & b) == 0 && (a & c) == 0 && (b & c) == 0);
    }

    private static int getSum() {
        int sum = 0;
        for(int i : list) {
            sum += i;
        }
        return sum;
    }
}