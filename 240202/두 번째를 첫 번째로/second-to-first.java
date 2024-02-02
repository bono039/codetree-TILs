import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        StringBuilder ans = new StringBuilder();

        for(int i = 0 ; i < str.length() ; i++) {
            if(str.charAt(i) == str.charAt(1)) {
                ans.append(str.charAt(0));
            }
            else {
                ans.append(str.charAt(i));
            }
        }

        System.out.println(ans);
    }
}