import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[] ch = br.readLine().toCharArray();

        int cnt = 0;
        for(int i = 0 ; i < N - 2 ; i++) {
            for(int j = i + 1 ; j < N - 1 ; j++) {
                for(int k = j + 1 ; k < N ; k++) {
                    if(ch[i] == 'C' && ch[j] == 'O' && ch[k] == 'W') {
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}