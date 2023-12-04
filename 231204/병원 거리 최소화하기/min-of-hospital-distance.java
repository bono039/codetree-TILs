import java.util.*;
import java.io.*;

public class Main {
    static int min = Integer.MAX_VALUE;

    static int N, M;
    static int[][] map, tmpMap;

    static List<Node> people = new ArrayList<>();   // 사람 리스트
    static List<Node> hospitals = new ArrayList<>();    // 병원 리스트
    static boolean[] visited;   // 중복 방지용 배열
    static int[] ans;

    static List<String> combList = new ArrayList<>(); // 조합 리스트

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        int idx = 0;

        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 1)  people.add(new Node(i, j));
                else if(map[i][j] == 2)  hospitals.add(new Node(i, j));
            }
        }

        // 1. 남아있을 병원 M개 고르기 (조합 리스트)
        ans = new int[M];
        visited = new boolean[hospitals.size()];
        comb(0, 0);

        // 2. 조합 리스트 돌면서, 최솟값 구하고 갱신하기
        // getMinDistance
        for(String numArr : combList) {
            min = Math.min(min, getDistSum(numArr.split(" ")));
        }

        System.out.println(min);
    }

    // 병원 M개 조합 뽑는 메소드
    private static void comb(int idx, int depth) {
        if(depth == M) {
            StringBuilder tmpSb = new StringBuilder();
            for(int i : ans) {
               tmpSb.append(i).append(" ");
            }
            combList.add(tmpSb.toString());
            return;
        }

        for(int i = idx ; i < hospitals.size() ; i++) {
            if(visited[i])  continue;

            visited[i] = true;
            ans[depth] = i;
            comb(i + 1, depth + 1);
            visited[i] = false;
        }
    }
    
    private static int getDist(int a, int b, int x, int y) {
        return Math.abs(a - x) + Math.abs(b - y);
    }

    private static int getDistSum(String[] str) {
        int[] combArr = new int[str.length];
        for(int i = 0 ; i < str.length ; i++) {
            combArr[i] = Integer.parseInt(str[i]);
        }

        int distSum = 0;

        for(Node p : people) {
            int tmp = N * 2;

            for(int num : combArr) {
                Node hos = hospitals.get(num);
                tmp = Math.min(tmp, getDist(hos.x, hos.y, p.x, p.y));
            }
            distSum += tmp;
        }

        return distSum;
    }
}

class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}