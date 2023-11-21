import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static Point[] arr;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new Point[N];

        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[i] = new Point(x, y);
        }

        for(int i = 1 ; i < N - 1 ; i++) {
            int tmpX = arr[i].x;
            int tmpY = arr[i].y;

            arr[i] = new Point(arr[i-1].x, arr[i-1].y); // 건너뛰기

            int dist = getDistance(arr);
            min = Math.min(min, dist);
            
            // 원상복구
            arr[i].x = tmpX;
            arr[i].y = tmpY;
        }
        
        System.out.println(min);
    }

    private static int getDistance(Point[] p) {
        int distance = 0;

        for(int i = 0 ; i < N - 1 ; i++) {
            distance += (Math.abs(p[i + 1].y - p[i].y) + Math.abs(p[i + 1].x - p[i].x));
        }
        return distance;
    }
}

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}