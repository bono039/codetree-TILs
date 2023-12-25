import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] map;

    static Node[] nodeArr;

    static List<Integer> list = new ArrayList<>();  // 인덱스 저장 리스트
    static boolean[] visited;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        nodeArr = new Node[N * N];

        int cnt = 0;
        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                nodeArr[cnt] = new Node(i, j, map[i][j]);
                cnt++;
            }
        }


        // N개 고르기
        visited = new boolean[N * N];
        comb(0, 0);

        System.out.println(max);
    }

    // N개 조합 뽑는 메소드
    private static void comb(int idx, int depth) {
        if(depth == N) {
            boolean b = true;

            for(int i = 0 ; i < list.size() ; i++) {
                for(int j = i + 1 ; j < list.size() ; j++) {
                    // 같은 행이나 열에 위치한 값이 있는 경우
                    int n1 = list.get(i);
                    int n2 = list.get(j);

                    if(nodeArr[n1].x == nodeArr[n2].x || nodeArr[n1].y == nodeArr[n2].y) {
                        b = false;
                        break;
                    }
                }
            }

            if(b) {
                int sum = 0;
                for(int i : list) {
                    sum += nodeArr[i].val;
                }
                max = Math.max(max, sum);
            }

            return;
        }

        for(int i = idx ; i < N * N ; i++) {
            if(!visited[i]) {
                visited[i] = true;
                list.add(i);
                comb(i + 1, depth + 1);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}

class Node {
    int x, y, val;

    public Node(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
}