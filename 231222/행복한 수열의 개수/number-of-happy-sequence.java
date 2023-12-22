import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] map;

    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 행복한 행 구하기
        for(int i = 0 ; i < N ; i++) {
            int tmp = 1;
            int beforeVal = map[i][0];

            for(int j = 1 ; j < N ; j++) {
                if(map[i][j] == beforeVal) {
                    tmp++;
                }
                else {
                    beforeVal = map[i][j];
                    tmp = 1;
                }

                if(tmp >= M) {
                    cnt++;
                    break;
                }
            }
        }


        // 행복한 열 구하기
        for(int i = 0 ; i < N ; i++) {
            int tmp = 1;
            int beforeVal = 0;

            for(int j = 0 ; j < N - 1 ; j++) {
                if(map[j][i] == map[j + 1][i]) {
                    tmp++;
                }
                else {
                    tmp = 1;
                }

                if(tmp >= M) {
                    cnt++;
                    break;
                }
            }
        }

        System.out.println(cnt);
    }
}