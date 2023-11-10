import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        for(int i = 0 ; i < N ; i++) {  // 구간 시작점
            for(int j = i ; j < N ; j++) {  // 구간 끝점
                boolean exists = false;
                double tmpSum = 0;
                double avg = 0;

                for(int k = i ; k <= j ; k++) {  // 구간 내 원소 합 구하기
                    tmpSum += arr[k];
                }
                
                avg = tmpSum / (j - i + 1); // 평균 구하기

                for(int k = i ; k <= j ; k++) {  // 구간 내 원소 평균값과 같은 원소가 있다면 정답 + 1
                    if((double)arr[k] == avg)
                        exists = true;
                }

                if(exists)
                    answer++;
            }            
        }

        System.out.println(answer);
    }
}