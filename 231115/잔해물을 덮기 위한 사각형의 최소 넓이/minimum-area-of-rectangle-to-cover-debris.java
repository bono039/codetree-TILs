import java.util.*;
import java.io.*;

public class Main {
    static final int OFFSET = 1000;
    static int[][] grid = new int[2001][2001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // 첫 번쨰 직사각형
        int x1 = Integer.parseInt(st.nextToken()) + OFFSET;
        int y1 = Integer.parseInt(st.nextToken()) + OFFSET;
        int x2 = Integer.parseInt(st.nextToken()) + OFFSET;
        int y2 = Integer.parseInt(st.nextToken()) + OFFSET;
        paint(x1, y1, x2, y2, 1);

        // 두 번째 직사각형
        st = new StringTokenizer(br.readLine(), " ");
        int x3 = Integer.parseInt(st.nextToken()) + OFFSET;
        int y3 = Integer.parseInt(st.nextToken()) + OFFSET;
        int x4 = Integer.parseInt(st.nextToken()) + OFFSET;
        int y4 = Integer.parseInt(st.nextToken()) + OFFSET;
        paint(x3, y3, x4, y4, 2);

        int minX = 2000;    int minY = 2000;
        int maxX = 0;       int maxY = 0;

        for(int i = x1 ; i < x2 ; i++) {
            for(int j = y1 ; j < y2 ; j++) {
                if(grid[i][j] == 1) {
                    //System.out.print("HI");
                    minX = Math.min(minX, i);
                    maxX = Math.max(maxX, i);

                    minY = Math.min(minY, j);
                    maxY = Math.max(maxY, j);
                }
            }
        }
        
        if(minX == 2000 && minY == 2000 && maxX == 0 && maxY == 0)
            System.out.println(0);
        else
            System.out.println((maxX - minX + 1) * (maxY - minY + 1));
    }

    private static void paint(int x1, int y1, int x2, int y2, int num) {
        for(int i = x1 ; i < x2 ; i++) {
            for(int j = y1 ; j < y2 ; j++) {
                grid[i][j] = num;
            }
        }
    }
}