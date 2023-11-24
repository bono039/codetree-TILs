import java.util.*;
import java.io.*;

class Person {
    int t, x, y;

    public Person(int t, int x, int y) {
        this.t = t;
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        Person[] people = new Person[N + 1];

        for(int i = 0 ; i < T ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int t = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            people[i] = new Person(t, x, y);
        }

        Arrays.sort(people, 0, T, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.t - p2.t;
            }
        });

        int[] answer = new int[N + 1];  // 전염병 여부 배열
        for(int i = 0 ; i < T ; i++) {
            if(people[i].x == P || people[i].y == P) {
                if(K > 0) {
                    answer[people[i].x] = 1;
                    answer[people[i].y] = 1;
                    K--;
                }
            }
        }
     
        // 출력하기
        for(int i = 1 ; i <= N ; i++) {
            System.out.print(answer[i]);
        }
    }
}