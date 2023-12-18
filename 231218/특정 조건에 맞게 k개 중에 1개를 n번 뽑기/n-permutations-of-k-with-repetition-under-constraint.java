import java.util.*;
import java.io.*;

public class Main {
    static int K, N;
    static int[] arr;
    static List<Integer> list = new ArrayList<>();
    static Set<String> set = new TreeSet<>();   // 결과 출력

    static int lastNum = 0;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // K 이하 숫자 N번 고르기
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[K + 1];

        choose(0);

        // 출력하기
        StringBuilder sb = new StringBuilder();
        for(String s : set) {
            sb.append(s + "\n");
        }
        System.out.println(sb);
    }

    private static void choose(int cnt) {
        if(cnt == N) {

            addToSet();
            return;
        }

        // 단, 연속해서 숫자 3번 나오면 안 됨
        for(int i = 1 ; i <= K ; i++) {
            if(cnt >= 2 && i == list.get(list.size() - 1) && i == list.get(list.size() - 2))    continue;
            else {
                list.add(i);
                choose(cnt + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    private static void addToSet() {
        StringBuilder tmp = new StringBuilder();
        for(int i : list) {
            tmp.append(i + " ");
        }
        set.add(tmp.toString());
        return;
    }
}