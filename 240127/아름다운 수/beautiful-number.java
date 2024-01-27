import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static List<Integer> list = new ArrayList<>();         // 뽑은 숫자 넣는 리스트
    static Map<Integer, Integer> map = new HashMap<>();    // 해당 숫자에 어떤 숫자가 몇 번 들어있는지 확인하는 용
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dfs(0);
        System.out.println(cnt);
    }

    private static void dfs(int depth) {
        if(depth == N) {
            for(int i : list) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }

            for(int v : map.keySet()) {
                if(map.get(v) == v) {
                    cnt++;
                }
            }
        }

        for(int i = 1 ; i <= 9 ; i++) {
            list.add(i);
            dfs(depth + 1);
            list.remove(list.size() - 1);
        }
    }
}