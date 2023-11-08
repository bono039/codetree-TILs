import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[] ch = br.readLine().toCharArray();
        int[] arr = new int[3];

        for(int i = 0 ; i < ch.length ; i++) {
            if(ch[i] == 'C')        arr[0]++;
            else if(ch[i] == 'O')   arr[1]++;
            else if(ch[i] == 'W')   arr[2]++;
        }

        int answer = 1;
        for(int i : arr) {
            answer *= i;
        }
        System.out.println(answer);
    }
}