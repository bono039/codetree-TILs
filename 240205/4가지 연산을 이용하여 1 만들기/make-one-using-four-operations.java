import java.util.*;
import java.io.*;

public class Main {
    static final int MAX = 1_000_000;

    static int N;
    static int[] cntArr = new int[MAX + 1];

    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        Arrays.fill(cntArr, MAX);

        bfs();
        System.out.println(cntArr[1]);
    }

    private static void bfs() {
        cntArr[N] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(N, 0));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            int n1 = cur.num - 1;
            if(inRange(n1) && cntArr[n1] > cur.cnt + 1) {
                cntArr[n1] = cur.cnt + 1;
                pq.add(new Node(n1, cntArr[n1]));
            }
            
            int n2 = cur.num + 1;
            if(inRange(n2) && cntArr[n2] > cur.cnt + 1) {
                cntArr[n2] = cur.cnt + 1;
                pq.add(new Node(n2, cntArr[n2]));
            }

            if(cur.num % 2 == 0) {
                int n3 = cur.num / 2;
                if(inRange(n3) && cntArr[n3] > cur.cnt + 1) {
                    cntArr[n3] = cur.cnt + 1;
                    pq.add(new Node(n3, cntArr[n3]));
                }
            }
            
            if(cur.num % 3 == 0) {
                int n4 = cur.num / 3;
                if(inRange(n4) && cntArr[n4] > cur.cnt + 1) {
                    cntArr[n4] = cur.cnt + 1;
                    pq.add(new Node(n4, cntArr[n4]));
                }
            }         
        }
    }

    private static boolean inRange(int num) {
        return (1 <= num && num <= MAX);
    }
}

class Node implements Comparable<Node> {
    int num, cnt;

    public Node(int num, int cnt) {
        this.num = num;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Node n) {
        return this.cnt - n.cnt;
    }
}