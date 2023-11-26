import java.util.*;
import java.io.*;

public class Main {
    static final Node NOT_EXISTS = new Node(-1, -1);

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};

    static int N, time;
    static int[][] grid, ans;   // ans : 로봇 위치 ~ 몬스터까지의 최단 거리 배열
    static boolean[][] visited;

    static Node robotPos;   // 로봇 위치 저장 객체
    static int lv = 2;      // 로봇 레벨
    static int caughtCnt = 0;   // 잡은 몬스터 개수

    static Queue<Node> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        ans = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());

                // 전투로봇 위치 저장
                if(grid[i][j] == 9) {
                    grid[i][j] = 0;
                    robotPos = new Node(i, j);
                }                
            }
        }

        // 없앨 수 있는 몬스터가 없어질 때까지 계속 반복
        while(true) {
            boolean isMoved = moveRobot();
            if(!isMoved)    break;
        }

        System.out.println(time);
    }

    // 로봇 위치로부터 각 몬스터까지의 최단 거리 전부 계산
    private static void BFS() {
        while(!q.isEmpty()) {
            Node now = q.poll();

            for(int d = 0 ; d < 4 ; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if(inRange(x, y) && !visited[x][y] && grid[x][y] <= lv) {
                    q.add(new Node(nx, ny));
                    ans[nx][ny] = ans[now.x][now.y] + 1;
                    visited[nx][ny] = true;
                }
            }
        }
    }

    // 최고 위치를 새 위치로 바꿀지 판단하는 함수
    private static boolean needUpdate(Node bestPos, Node newPos) {
        // 첫 도달 가능한 몬스터라면, 업데이트 필요
        if(bestPos == NOT_EXISTS)   // NOT_EXISTS : (-1, -1)
            return true;

        int bestX = bestPos.x;
        int bestY = bestPos.y;

        int nx = newPos.x;
        int ny = newPos.y;

        // 거리 > 행 > 열 순으로 더 작은 경우 고르기
        if(ans[bestX][bestY] != ans[nx][ny])
            return ans[bestX][bestY] > ans[nx][ny];
        if(bestX != nx) 
            return bestX > nx;
        return bestY > ny;
    }

    // 우선순위 높은 곳에 있는 몬스터 찾아 로봇 이동하는 함수
    private static boolean moveRobot() {
        clearVisited(); // 방문 배열 초기화

        // Step1. 로봇 위치에서 각 몬스터까지 최단거리 전부 계산
        int robotX = robotPos.x;
        int robotY = robotPos.y;

        // 시작 로봇 위치에서 BFS 진행
        visited[robotX][robotY] = true;
        ans[robotX][robotY] = 0;
        q.add(robotPos);
        BFS();

        // Step2. 도달할 수 있는 몬스터들 중, 최우선순위의 몬스터 위치 구함
        Node bestPos = NOT_EXISTS;  //(-1, -1)
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N ; j++) {
                // 도달 불가능하거나, 몬스터가 없거나, 레벨이 같은 경우 패스
                if(!visited[i][j] || grid[i][j] == 0 || grid[i][j] == lv)   continue;

                Node newPos = new Node(i, j);
                if(needUpdate(bestPos, newPos))
                    bestPos = newPos;
            }
        }

        // 2-1. 도달 가능한 몬스터가 있다면, 로봇 위치를 해당 위치로 옮김
        if(bestPos != NOT_EXISTS) {
            int bestX = bestPos.x;
            int bestY = bestPos.y;

            time += ans[bestX][bestY];
            grid[bestX][bestY] = 0;
            robotPos = bestPos;
            caughtCnt++;    // 잡은 몬스터 개수

            // 몬스터를 로봇 레벨만큼 잡으면 레벨 + 1
            if(caughtCnt == lv) {
                lv++;
                caughtCnt = 0;
            }
            return true;
        }

        // 2-2. 도달 가능한 몬스터가 없다면, 움직임 종료
        else
            return false;
    }

    // 범위 내에 있는지 판별 여부 함수
    private static boolean inRange(int x, int y) {
        return (0 <= x && x < N && 0 <= y && y < N);
    }

    // 방문 배열 초기화 함수
    private static void clearVisited() {
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N ; j++) {
                visited[i][j] = false;
            }
        }
    }
}

class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}