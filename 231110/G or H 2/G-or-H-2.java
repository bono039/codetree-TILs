import java.util.*;
import java.io.*;
// 양쪽 끝에 있는 사람 간의 거리

class Point {
    int idx; char c;

    public Point(int idx, char c) {
        this.idx = idx;
        this.c = c;
    }
}

public class Main {
    static final int MAX_NUM = 100;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Point[] arr = new Point[MAX_NUM + 1];

        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int G = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);

            arr[i] = new Point(G, c);
        }

        if(N == 1) {
            System.out.println(0);
            return;
        }

        int answer = 0;
        for(int i = 0 ; i < N ; i++) {  // 시작점
            int[] tmp = new int[2];
            int start = arr[i].idx;
            int end = 0;

            for(int j = i ; j < N ; j++) {  // 끝점
                end = arr[j].idx;
                //System.out.print(end + " > ");

                if(arr[j].c == 'G') tmp[0]++;
                else if(arr[j].c == 'H') tmp[1]++;

                if(tmp[0] == tmp[1]) {
                    if(tmp[0] != 0)
                        answer = Math.max(answer, end - start);
                }
            }
        }

        System.out.println(answer + 1);
    }
}