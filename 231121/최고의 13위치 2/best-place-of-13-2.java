import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        List<Integer> list = new ArrayList<>();

        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N - 2 ; j++) {
                int coin = 0;

                for(int k = j ; k < j + 3 ; k++) {
                    if(map[i][k] == 1) {
                        coin++;
                    }
                }
                list.add(coin);
            }
        }
        Collections.sort(list);

        System.out.println(list.get(list.size() - 1) + list.get(list.size() - 2));
    }
}