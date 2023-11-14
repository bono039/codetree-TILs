import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // 첫 번쨰 직사각형
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

        // 두 번째 직사각형
        st = new StringTokenizer(br.readLine(), " ");
        int x3 = Integer.parseInt(st.nextToken());
        int y3 = Integer.parseInt(st.nextToken());
        int x4 = Integer.parseInt(st.nextToken());
        int y5 = Integer.parseInt(st.nextToken());

        int total = 0;

        int diffX = Math.abs(x2 - x1);
        int diffY = Math.abs(y2 - y1);
        total = diffX * diffY;

        System.out.println(total);
    }
}