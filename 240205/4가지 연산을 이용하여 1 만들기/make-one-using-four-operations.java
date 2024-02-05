import java.util.*;
import java.io.*;

public class Main {
    static final int MAX = 1_000_000;
    
    static int n;
    static boolean[] visited = new boolean[MAX + 1];
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        System.out.print(bfs());
    }
    static int bfs(){
        int ans = 0;

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{n, 0});

        visited[n] = true;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            int val = now[0];
            int cnt = now[1];
            
            if(val == 1){
                ans = cnt;
                break;
            }
            
            if(inRange(val - 1) && !visited[val - 1]){
                visited[val-1] = true;
                q.add(new int[]{val - 1, cnt + 1});
            }
            
            if(inRange(val + 1) && !visited[val + 1]){
                visited[val + 1] = true;
                q.add(new int[]{val + 1, cnt + 1});
            }
            
            if(inRange(val) && val % 2 == 0 && !visited[val / 2]){
                visited[val / 2] = true;
                q.add(new int[]{val / 2, cnt + 1});
            }
            
            if(inRange(val) && val % 3 == 0 && !visited[val/3]){
                visited[val / 3] = true;
                q.add(new int[]{val / 3, cnt + 1});
            }
        }
        
        return ans;
    }
    
    private static boolean inRange(int num) {
        return (1 <= num && num <= MAX);
    }
}