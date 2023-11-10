import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        for(int i = 0 ; i < N ; i++) {  // 모든 구간 다 정하기
            boolean exists = false;

            for(int j = i ; j < N ; j++) {  // 구간 시작점
                Set<Double> set = new HashSet<>();
                
                double tmpSum = 0;
                int tmpCnt = 0;

                for(int k = i ; k <= j ; k++) {  // 구간 끝점
                    //System.out.print(arr[k] + " ");
                    tmpSum += arr[k];
                    tmpCnt++;
                    set.add((double)arr[k]);
                }

                //System.out.println("|| " + tmpSum + " " + tmpCnt);
                double avg = tmpSum / tmpCnt;
                //System.out.println("avg -> " + avg);
                if(set.contains(avg)) exists = true;
            }

            if(exists)  answer++;
        }

        System.out.println(answer+2);
    }
}