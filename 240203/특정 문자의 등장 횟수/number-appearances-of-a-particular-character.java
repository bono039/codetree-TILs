import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        
        int[] cnt = new int[2];
        for(int i = 0 ; i < str.length() - 1 ; i++) {
            if(str.substring(i, i+2).equals("ee")) cnt[0]++;
            if(str.substring(i, i+2).equals("eb")) cnt[1]++;
        }

        System.out.println(cnt[0] + " " + cnt[1]);
    }
}