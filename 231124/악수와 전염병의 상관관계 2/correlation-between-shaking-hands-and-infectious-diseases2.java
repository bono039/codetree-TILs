import java.util.*;
import java.io.*;

class Person implements Comparable<Person> {
    int t, x, y;

    public Person(int t, int x, int y) {
        this.t = t;
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Person p) {
        return this.t - p.t;
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

        Person[] people = new Person[T];        
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int t = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            people[i] = new Person(t, x, y);
        }

        Arrays.sort(people);

        int[] answer = new int[N + 1]; // 전염병 여부 배열
        int[] tmp = new int[N + 1];
        Arrays.fill(tmp, K);

        answer[P] = 1;

        for (int i = 0; i < T; i++) {
            if (answer[people[i].x] == 1 && answer[people[i].y] != 1 && tmp[people[i].x] > 0) {
                answer[people[i].x] = 1;
                answer[people[i].y] = 1;
                tmp[people[i].x]--;
            }
            else if(answer[people[i].y] == 1 && answer[people[i].x] != 1  && tmp[people[i].y] > 0) {
                answer[people[i].x] = 1;
                answer[people[i].y] = 1;
                tmp[people[i].y]--;
            }
        }

        // 출력하기
        for (int i = 1; i <= N; i++) {
            System.out.print(answer[i]);
        }
    }
}