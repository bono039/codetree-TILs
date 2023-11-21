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

        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N - 2 ; j++) {
                
                for(int k = 0 ; k < N ; k++) {
                    for(int l = 0 ; l < N - 2; l++) {
                        if(i == k && Math.abs(j - l) <= 2)  continue;

                        int cnt1 = map[i][j] + map[i][j + 1] + map[i][j + 2];
                        int cnt2 = map[k][l] + map[k][l + 1] + map[k][l + 2];
                        answer = Math.max(answer, cnt1 + cnt2);
                    }
                }
                
            }
        }

        System.out.println(answer);
    }
}