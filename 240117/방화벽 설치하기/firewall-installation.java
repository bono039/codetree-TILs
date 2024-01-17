import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int N, M;
    static int[][] map;
    static boolean[][] visited;

    static int[][] copy;
    static List<int[]> realWalls = new ArrayList<>();
    static List<int[]> tmpWalls = new ArrayList<>();    // 방화벽 설치할 위치 3개 조합 리스트
    static List<int[]> fireList = new ArrayList<>();

    static int max = 0; // 불이 퍼지지 않는 영역 크기의 최댓값

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        copy = new int[N][M];

        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < M ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                copy[i][j] = map[i][j];

                if(map[i][j] == 0)  tmpWalls.add(new int[]{i, j});
                if(map[i][j] == 2)  fireList.add(new int[]{i, j});
            }
        }

        visited = new boolean[N][M];
        dfs(0, 0);

        System.out.println(max);
    }

    // 불 전파하며 영역 세는 함수
    private static int fire() {
        int[][] tmpMap = new int[N][M];

        // 원본 배열 값으로 초기화
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < M ; j++) {
                tmpMap[i][j] = copy[i][j];
            }
        }

        for(int[] w : realWalls) {
            tmpMap[w[0]][w[1]] = 1;
        }

        for(int[] f : fireList) {
            Queue<int[]> q = new ArrayDeque<>();
            q.add(f);

            while(!q.isEmpty()) {
                int[] cur = q.poll();

                for(int d = 0 ; d < 4 ; d++) {
                    int nx = cur[0] + dx[d];
                    int ny = cur[1] + dy[d];

                    if(nx < 0 || nx >= N || ny < 0 || ny >= M)    continue;

                    if(tmpMap[nx][ny] == 0) {
                        tmpMap[nx][ny] = 2;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }

        // 불이 퍼지지 않는 영역 구하기
        int cnt = 0;
        for(int[] i : tmpMap) {
            for(int j : i) {
                if(j == 0) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    // 방화벽 세울 위치 3개 구하는 조합 메소드
    private static void dfs(int idx, int cnt) {
        if(cnt == 3) {
            max = Math.max(max, fire());
            return;
        }

        for(int i = idx ; i < tmpWalls.size() ; i++) {
            realWalls.add(new int[] {tmpWalls.get(i)[0], tmpWalls.get(i)[1]});
            dfs(i + 1, cnt + 1);
            realWalls.remove(realWalls.size() - 1);
        }
    }
}