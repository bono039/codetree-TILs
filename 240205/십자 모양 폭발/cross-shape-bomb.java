import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] grid;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];

        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        } 

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;
        
        //1. 제거
        pop(r, c);

        //2. 중력 적용하기
        for(int i = 0; i < n; i++){
            down(i);
        }

        print();        
    }

    public static void down(int c){
        int[] temp = new int[n];
        int idx = n-1;

        //1. temp 배열에 복사
        for(int i = n-1; i >= 0; i--){
            if(grid[i][c] != 0){
                temp[idx--] = grid[i][c];
            }
        }

        //2. grid에 값 넣기
        for(int i = 0; i < n; i++){
            grid[i][c] = temp[i];
        }
    }

    public static void pop(int r, int c){
        int[][] dist = {{0, 0}, {-1, 0}, {1, 0}, {0, -1}, {0, 1}}; //자신, 상하좌우
        int target = grid[r][c]; //범위

        for(int k = 0; k < target; k++){
            for(int i = 0; i < dist.length; i++) {
                int nx = r + dist[i][0] * k;
                int ny = c + dist[i][1] * k;

                if(nx < 0 || nx >= n || ny < 0 || ny >= n)  continue;   // 범위 확인
                grid[nx][ny] = 0;
            }
        }
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                sb.append(grid[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}