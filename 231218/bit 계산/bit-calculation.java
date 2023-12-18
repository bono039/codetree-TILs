import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int q = Integer.parseInt(br.readLine());
        int A = 0;

        while(q --> 0) {
            String[] str = br.readLine().split(" ");
            
            if(str[0].equals("add")) {
                int x = Integer.parseInt(str[1]);

                if((A & (1 << x)) != (1 << x))
                    A ^= (1 << x);
            }
            else if(str[0].equals("delete")) {
                int x = Integer.parseInt(str[1]);

                if((A & (1 << x)) == (1 << x)) {
                    A ^= (1 << x);
                }
            }
            else if(str[0].equals("print")) {
                int x = Integer.parseInt(str[1]);
                sb.append((A & (1 << x)) == (1 << x) ? 1 : 0).append("\n");
            }
            else if(str[0].equals("toggle")) {
                int x = Integer.parseInt(str[1]);
                A ^= (1 << x);
            }
            else if(str[0].equals("clear")) {
                A = 0;
            }
        }

        System.out.println(sb);
    }
}