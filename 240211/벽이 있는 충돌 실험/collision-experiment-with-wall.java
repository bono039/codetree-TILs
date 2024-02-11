import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1, 0, 0, 1};   // (0,3) (1,2)가 대칭이 되도록 설정
    static int[] dy = {0, 1, -1, 0};

    static int T,N,M;
    static int[][] marbleCnt;
    static List<Marble> marbles = new ArrayList<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        while(T --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());   // 구슬 수

            marbles = new ArrayList<>();
            marbleCnt = new int[N+1][N+1];

            for(int j = 0 ; j < M ; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                char d = st.nextToken().charAt(0);

                int dir = 0;
                if(d == 'U')    dir = 0;
                else if(d == 'R')   dir = 1;
                else if(d == 'L')   dir = 2;
                else if(d == 'D')   dir = 3;

                marbles.add(new Marble(x, y, dir));
            }

            for(int i = 1 ; i <= 2 * N ; i++)   // 최대 충돌 횟수 : 2 * n
                simulate();            
            sb.append((int)marbles.size()).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void simulate() {
        // 1. 구슬 전부 한 번씩 움직이기
        moveAll();

        // 2. 움직임 이후 충돌 일어나는 구슬들 골라 목록에서 지우기
        removeMarbles();
    }

    // 구슬들 전부 한 번씩 움직이는 메소드
    private static void moveAll() {
        for(int i = 0 ; i < (int)marbles.size() ; i++) {
            Marble nextM = moveMarble(marbles.get(i));
            marbles.set(i, nextM);
        }
    }

    // 해당 구슬이 1초 후 어떤 위치에서 어떤 방향 바라보는지 상태 반환 함수
    private static Marble moveMarble(Marble mm) {
        int nx = mm.x + dx[mm.d];
        int ny = mm.y + dy[mm.d];

        if(inRange(nx, ny)) // 벽이 없는 경우, 한 칸 전진
            return new Marble(nx, ny, mm.d);
        else  // 벽이 있는 경우, 방향 반대로 전환
            return new Marble(mm.x, mm.y, 3 - mm.d);
    }

    // 충돌이 일어나는 구슬들 전부 지우기
    private static void removeMarbles() {
        ArrayList<Marble> tmpList = new ArrayList<>();

        // 1. 각 구슬의 위치에 cnt 증가시키기
        for(int i = 0 ; i < (int)marbles.size() ; i++) {
            marbleCnt[marbles.get(i).x][marbles.get(i).y]++;
        }

        // 2. 충돌이 일어나지 않는 구슬만 전부 기록
        for(int i = 0 ; i < (int)marbles.size() ; i++) {
            if(!collideOccurs(i))
                tmpList.add(marbles.get(i));
        }

        // 3. 나중 위해 각 구슬의 위치에 적어놓은 cnt 수 다시 초기화
        for(int i = 0 ; i < (int)marbles.size() ; i++) {
            marbleCnt[marbles.get(i).x][marbles.get(i).y]--;
        }

        // 4. 충돌 일어나지 않은 구슬들로 다시 채우기
        marbles = tmpList;
    }

    // 충돌 일어나는 구슬 있는지 확인하는 메소드
    private static boolean collideOccurs(int targetIdx) {
        return marbleCnt[marbles.get(targetIdx).x][marbles.get(targetIdx).y] >= 2;
    }

    private static boolean inRange(int x, int y) {
        return (1 <= x && x <= N && 1 <= y && y <= N);
    }
}

class Marble {
    int x, y, d;

    public Marble(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }
}