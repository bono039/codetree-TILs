import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] arr;

    static int endOfArr;

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
        int[] tmp = new int[endOfArr];
        int endOfTmpArr = 0;

        // 1) (s,e) 범위의 블록 제거하기
        for(int i = 0 ; i < endOfArr ; i++) {
            if(s <= i && i <= e)    continue;

            tmp[endOfTmpArr] = arr[i];
            endOfTmpArr++;

        }

        // 2) 원본 배열에 적용하기
        for(int i = 0 ; i < endOfTmpArr ; i++) {
            arr[i] = tmp[i];
        }
        
        endOfArr = endOfTmpArr;
    }
}