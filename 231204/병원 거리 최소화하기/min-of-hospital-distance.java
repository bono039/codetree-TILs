import java.util.*;
import java.io.*;

public class Main {
    static int min = Integer.MAX_VALUE;

    static int N, M;
    static int[][] map, tmpMap;

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

                if(map[i][j] == 2)  hospitals.add(new Node(idx++, i, j));
            }
        }

        // 0 : 빈 칸 / 1 : 사람 / 2 : 병원

        // 1. 남아있을 병원 M개 고르기 (조합 리스트)
        ans = new int[M];
        visited = new boolean[hospitals.size()];
        Collections.sort(hospitals);
        comb(0, 0);

        // 2. 조합 리스트 돌면서, 최솟값 구하고 갱신하기
        for(int k = 0 ; k < combList.size() ; k++) {
            // M만큼의 병원 조합이 있는 2차원 배열 따로 또 만들기
            tmpMap = new int[N][N];

            String[] arr = combList.get(k).split(" ");
            for(int i = 0 ; i < arr.length ; i++) {
                int xx = hospitals.get(Integer.parseInt(arr[i])).x;
                int yy = hospitals.get(Integer.parseInt(arr[i])).y;

                tmpMap[xx][yy] = 2;
            }

            for(int i = 0 ; i < N ; i++) {
                for(int j = 0 ; j < N ; j++) {
                    if(map[i][j] == 1) {
                        tmpMap[i][j] = 1;
                    }
                }
            }

            // 새로 만든 배열에서 거리 총합 구하기
            for(int i = 0 ; i < N ; i++) {
                int tmp = 0;    // 병원 거리의 총합
                for(int j = 0 ; j < N ; j++) {
                    if(tmpMap[i][j] == 1) {
                        //System.out.println(i + " " + j);
                        tmp += getDist(i, j);
                    }
                }
                //System.out.println("min > " + min);

                min = Math.min(min, tmp);
            }
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
            ans[depth] = hospitals.get(i).idx;
            comb(idx + 1, depth + 1);
            visited[i] = false;
        }
    }

    private static int getDist(int x, int y) {
        int dist = Integer.MAX_VALUE;

        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N ; j++) {
                if(tmpMap[i][j] == 2) {
                    int tmpDist = Math.abs(x - i) + Math.abs(y - j);
                    dist = Math.min(dist, tmpDist);
                }
            }
        }

        return dist;
    }
}

class Node implements Comparable<Node> {
    int idx, x, y;

    public Node(int idx, int x, int y) {
        this.idx = idx;
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Node n) {
        return this.idx - n.idx;
    }
}