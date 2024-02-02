import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        String str = st.nextToken();
        String target = st.nextToken();

        if(str.contains(target)) {
            System.out.println(str.indexOf(target));
        }
        else {
            System.out.println("No");
        }
    }
}