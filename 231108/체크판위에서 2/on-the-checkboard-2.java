import java.util.*;
import java.io.*;

public class Main {
    static int R, C;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 입력받기
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for(int i = 0 ; i < R ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < C ; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }

        int cnt = 0;
        for(int i = 1 ; i < R ; i++) {
            for(int j = 1 ; j < C ; j++) {
                for(int k = i + 1 ; k < R - 1 ; k++) {
                    for(int l = j + 1 ; l < C - 1 ; l++) {
                        if(map[0][0] != map[i][j] && map[i][j] != map[k][l] && map[k][l] != map[R-1][C-1])
                            cnt++;
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}