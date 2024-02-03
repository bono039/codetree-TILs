import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] arr, tmp;

    static int endOfArr, endOfTmpArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        for(int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        endOfArr = n;        

        for(int i = 0 ; i < 2 ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            endOfTmpArr = 0;
            deleteBlocks(s - 1, e - 1);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(endOfArr).append("\n");

        for(int i = 0 ; i < endOfArr ; i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void deleteBlocks(int s, int e) {
        tmp = new int[endOfArr];

        // 1) (s,e) 범위의 블록 제거하기
        for(int i = 0 ; i < endOfArr ; i++) {
            if(s <= i && i <= e)    continue;

            if(arr[i] != 0) {
                tmp[endOfTmpArr] = arr[i];
                endOfTmpArr++;
            }
        }

        // 2) 원본 배열에 적용하기
        endOfArr = endOfTmpArr;

        for(int i = 0 ; i < endOfArr ; i++) {
            arr[i] = tmp[i];
        }
    }
}