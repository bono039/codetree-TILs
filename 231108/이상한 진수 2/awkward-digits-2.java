import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        int max = 0;

        // 모든 숫자를 다른 숫자로 바꿔보며 경우의 수 구하기
        for(int i = 0 ;i  < arr.length ; i++) {
            if(arr[i] == '0') {
                arr[i] = '1';
            }
            else {
                arr[i] = '0';
            }

            String str = "";
            for(char c : arr) str += c; // 1110
            //System.out.println(str);

            // String을 int형으로
            int num = Integer.parseInt(str);

            // 2진수 int형을 10진수로
            int tmp = 0;
            for(int j = 0 ; j < str.length() ; j++) {
                tmp += Math.pow(2, str.length () - 1 - j) * (str.charAt(j) - '0');
            }

            max = Math.max(max, tmp);
            arr[i] = arr[i] == '0' ? '1' : '0'; // 원상복구
        }

        System.out.println(max);
    }
}