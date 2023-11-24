import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        int cnt = 0;    // 움직여야 할 최소 블럭 수
        int total = 0;
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            total += arr[i];
        }

        int target = total / N;

        for(int i = 0 ; i < N ; i++) {
            if(arr[i] == target) continue;

            if(arr[i] < target) {
                for(int j = i + 1 ; j < N ; j++) {
                    if(arr[j] > target) {
                        int diff = target - arr[i];
                        arr[i] = target;
                        arr[j] -= diff;
                        cnt += diff;
                    }
                }
            }
            else if(arr[i] > target) {
                for(int j = i + 1 ; j < N ; j++) {
                    if(arr[j] < target) {
                        arr[j] += (arr[i] - target);
                        cnt += (arr[i] - target);
                        arr[i] -= target;
                        break;
                    }
                }
            }
        }

        System.out.println(cnt);

    }
}