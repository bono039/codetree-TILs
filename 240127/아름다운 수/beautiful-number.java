import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static ArrayList<Integer> list = new ArrayList<>();
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dfs(0);
        System.out.println(cnt);
    }

    private static void dfs(int depth) {
        if(depth == N) {
            if(isBeautiful())
                cnt++;
            return;
        }

        for(int i = 1 ; i <= 4 ; i++) {
            list.add(i);
            dfs(depth + 1);
            list.remove(list.size() - 1);
        }
    }

    private static boolean isBeautiful() {
        for(int i = 0 ; i < N ; i += list.get(i)) {
            if(i + list.get(i) > N) {
                return false;
            }
            for(int j = i ; j < i + list.get(i) ; j++) {
                if(list.get(j) != list.get(i))
                    return false;
            }
        }

        return true;
    }
}