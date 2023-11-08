import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] ch = br.readLine().toCharArray();
        int cnt = 0;

        for(int i = 0 ; i < ch.length - 3 ; i++) {
            for(int j = i + 1 ; j < ch.length - 1 ; j++) {
                if(ch[i] == '(' && ch[i + 1] == '(' && ch[j] == ')' && ch[j + 1] == ')') {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}