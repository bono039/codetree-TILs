import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Node n) {
        if(this.x != n.x)
            return this.x - n.x;
        return this.y - n.y;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] grid = new int[1001][1001];
        Node[] arr = new Node[N];

        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            grid[x][y] = 1;
            arr[i] = new Node(x, y);
        }
        Arrays.sort(arr);

        int diff = Integer.MAX_VALUE;
        for(int i = 0 ; i < N - 1 ; i++) {
            int tmp1 = (arr[i].x - arr[i + 1].x) * (arr[i].x - arr[i + 1].x);
            int tmp2 = (arr[i].y - arr[i + 1].y) * (arr[i].y - arr[i + 1].y);

            if((tmp1 + tmp2) < diff) {
                diff = tmp1 + tmp2;
            }
        }
        System.out.println(diff);
    }
}