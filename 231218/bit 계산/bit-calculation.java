import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int q = Integer.parseInt(br.readLine());
        int S = 0;  // 비트마스크로 표현되는 집합

        while(q --> 0) {
            String[] str = br.readLine().split(" ");
            
            if(str[0].equals("add")) {
                int x = Integer.parseInt(str[1]);

                // x 번째 비트가 0인지 확인하고, 0이면 해당 비트를 1로 변경
                if(((S >> x) & 1) == 0)
                    S ^= (1 << x);
            }
            else if(str[0].equals("delete")) {
                int x = Integer.parseInt(str[1]);

                // x 번째 비트가 1인지 확인하고, 1이면 해당 비트를 0으로 변경
                if(((S >> x) & 1) == 1) {
                    S ^= (1 << x);
                }
            }
            else if(str[0].equals("print")) {
                int x = Integer.parseInt(str[1]);

                // x 번째 비트가 1인지 확인하여 결과를 StringBuilder에 추가
                sb.append((S >> x) & 1).append("\n");
            }
            else if(str[0].equals("toggle")) {
                int x = Integer.parseInt(str[1]);
                
                // x번째 비트 토글 (1이면 0으로, 0이면 1로)
                S ^= (1 << x);
            }
            else if(str[0].equals("clear")) {
                // 집합 비움 = 공집합 (모든 비트를 0으로 변경)
                S = 0;
            }
        }

        System.out.println(sb);
    }
}