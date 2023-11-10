import java.util.*;
import java.io.*;
// 양쪽 끝에 있는 사람 간의 거리

public class Main {
    static final int MAX_NUM = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[MAX_NUM + 1];

        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int G = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);

            arr[G] = (c == 'G') ? 1 : 2;
        }

        int answer = 0;
        for(int i = 1 ; i <= MAX_NUM ; i++) {
            if(arr[i] == 0)  continue;
            int g = 0;
            int h = 0;

            for(int j = i ; j <= MAX_NUM ; j++) {
                if(arr[j] == 0) continue;
                else if(arr[j] == 1) g++;
                else    h++;

                if(g == 0 || h == 0 || g == h) {
                    answer = Math.max(answer, j - i);
                }
            }
        }

        System.out.println(answer);
    }
}