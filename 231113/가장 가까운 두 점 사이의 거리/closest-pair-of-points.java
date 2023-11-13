import java.util.*;
import java.io.*;

class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static int getDist(Node a, Node b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
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

        int diff = Integer.MAX_VALUE;
        for(int i = 0 ; i < N - 1 ; i++) {
            for(int j = i + 1 ; j < N ; j++) {
                int tmp = Node.getDist(arr[i], arr[j]);
                diff = Math.min(diff, tmp);
            }
        }
        System.out.println(diff);
    }
}