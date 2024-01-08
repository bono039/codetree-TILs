import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};   // 상하좌우
    static int[] dy = {0, 0, -1, 1};

    static int N, M, T;
    static int[][] grid, cntArr, nextCnt;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());   // 격자 크기
        M = Integer.parseInt(st.nextToken());   // 구슬 개수
        T = Integer.parseInt(st.nextToken());   // 시간

        grid = new int[N + 1][N + 1];

        for(int i = 1 ; i <= N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1 ; j <= N ; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 구슬 시작 위치
        cntArr = new int[N + 1][N + 1];
        while(M --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            cntArr[r][c] = 1;
        }

        while(T --> 0) {
            // 1. nextCnt 배열 초기화
            nextCnt = new int[N + 1][N + 1];

            // 2. 모든 점에서 구슬 전부 한 번씩 움직여보기
            for(int i = 1 ; i <= N ; i++) {
                for(int j = 1 ; j <= N ; j++) {
                    if(cntArr[i][j] == 1) {
                        move(i, j);
                    }
                }
            }

            // 3. nextCnt 값을 cntArr에 복사
            for(int i = 1 ; i <= N ; i++) {
                for(int j = 1 ; j <= N ; j++) {
                    cntArr[i][j] = nextCnt[i][j];

                    // 충돌이 일어난 구슬 처리
                    if(cntArr[i][j] >= 2) {
                        cntArr[i][j] = 0;
                    }
                }
            }
        }

        // 남아있는 구슬 수 출력
        for(int i = 1 ; i <= N ; i++) {
            for(int j = 1 ; j <= N ; j++) {
                if(cntArr[i][j] == 1) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    private static void move(int x, int y) {
        // 그 다음 위치 계산
        int[] nextPos = getNextPos(x, y);

        int nx = nextPos[0];
        int ny = nextPos[1];

        nextCnt[nx][ny] += 1;
    }

    private static int[] getNextPos(int x, int y) {
        int[] pos = new int[2];
        int max = 0;

        for(int d = 0 ; d < 4 ; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(!inRange(nx, ny))    continue;

            if(grid[nx][ny] > max) {
                max = grid[nx][ny];
                pos = new int[]{nx, ny};
            }
        }

        return pos;
    }

    private static boolean inRange(int x, int y) {
        return (1 <= x && x <= N && 1 <= y && y <= N);
    }
}