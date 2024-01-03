import java.util.*;
import java.io.*;

public class Main {
    static int N, M, Q;
    static int[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        for(int i = 1 ; i <= N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1 ; j <= M ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(Q --> 0) {
            String[] str = br.readLine().split(" ");
            int r = Integer.parseInt(str[0]);   // 바람에 영향 받는 행 번호
            char d = str[1].charAt(0);          // 바람이 불어오는 방향

            visited = new boolean[N + 1];
            wind(r, d);
        }

        print();
    }

    private static void wind(int r, char d) {
        if(r < 1 || r > N || visited[r])  return;

        visited[r] = true;

        if(d == 'L') {
            int val = map[r][M];

            for(int i = M ; i > 1 ; i--) {
                map[r][i] = map[r][i - 1];
            }

            map[r][1] = val;

            boolean isSame1 = false;
            boolean isSame2 = false;

            for(int i = 1 ; i <= M ; i++) {
                if(((r - 1) >= 1) && map[r][i] == map[r - 1][i]) {
                    isSame1 = true;
                }

                if(((r + 1) <= N) && map[r][i] == map[r + 1][i]) {
                    isSame2 = true;
                }
            }

            if(isSame1) wind(r - 1, 'R');
            if(isSame2) wind(r + 1, 'R');
        }
        else if(d == 'R') {
            int val = map[r][1];

            for(int i = 1 ; i < M ; i++) {
                map[r][i] = map[r][i + 1];
            }

            map[r][M] = val;

            boolean isSame1 = false;
            boolean isSame2 = false;

            for(int i = 1 ; i <= M ; i++) {
                if(((r - 1) >= 1) && map[r][i] == map[r - 1][i]) {
                    isSame1 = true;
                }

                if(((r + 1) <= N) && map[r][i] == map[r + 1][i]) {
                    isSame2 = true;
                }
            }

            if(isSame1) wind(r - 1, 'L');
            if(isSame2) wind(r + 1, 'L');    
        }      
    }
    
    private static void print() {
        StringBuilder sb = new StringBuilder();
        for(int i = 1;  i <= N ; i++) {
            for(int j = 1 ; j <= M ; j++) {
                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}