import java.util.*;
import java.io.*;
// 반시계 방향으로만 이동
// 각 방에 정해진 인원이 들어가는 데까지의 거리의 합을 최소화
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 시작점 돌아가면서 설정해보고, 그 중 최솟값 구해보기
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < N ; i++) {
            int num = i;
            int tmp = 0;

            for(int j = 0 ; j < N ; j++) {
                if(j == num)    continue;

                if(j >= i) {
                    tmp += (j - i) * arr[j];
                }
                else {
                    tmp += (arr.length - i + j) * arr[j];
                }
            }
            //System.out.println(tmp);
            min = Math.min(min, tmp);
        }

        System.out.println(min);

    }
}