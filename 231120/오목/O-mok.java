import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0, 1, 1, -1};   // 가로 세로 왼쪽대각선 오른쪽대각선 
    static int[] dy = {1, 0, 1, 1};

    static int[][] grid = new int[19][19];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력받기
        for(int i = 0 ; i < 19 ; i++) {
            String[] str = br.readLine().split(" ");
            for(int j = 0 ; j < 19 ; j++) {
                grid[i][j] = Integer.parseInt(str[j]);  // 수정된 부분
            }
        }

        for(int i = 0 ; i < 19 ; i++) {
            for(int j = 0 ; j < 19 ; j++) {
                if(grid[i][j] != 0) {
                    for(int d = 0 ; d < 4 ; d++) {
                        int nx = i;
                        int ny = j;
                        int cnt = 1;    // 일치하는 바둑알 개수

                        // 증가하는 방향 탐색
                        while(true) {
                            nx += dx[d];
                            ny += dy[d];

                            if(inRange(nx, ny)) {
                                if(grid[i][j] == grid[nx][ny]) cnt++;
                                else break;
                            }
                            else    break;
                        }

                        nx = i;
                        ny = j;
                        
                        // 증가하는 방향의 반대 방향 탐색
                        while(true) {
                            nx -= dx[d];
                            ny -= dy[d];

                            if(inRange(nx, ny)) {
                                if(grid[i][j] == grid[nx][ny]) cnt++;
                                else break;
                            }
                            else break;
                        }

                        // 같은 오목눈이 5개라면
                        if(cnt == 5) {
                            System.out.println(grid[i][j]);
                            System.out.println((i + 2 * dx[d] + 1) + " " + (j + 2 * dy[d] + 1));
                            return;
                        }
                    }

                }
            }
        }

        // 아무도 이기지 않았을 경우
        System.out.println(0);
    }

    private static boolean inRange(int x, int y) {
        return (0 <= x && x < 19 && 0 <= y && y < 19);
    }
}