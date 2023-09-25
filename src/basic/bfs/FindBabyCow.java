package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FindBabyCow {
    public int solution(int s, int e) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);

        while(!queue.isEmpty()) {
            int length = queue.size();
            for(int i=0; i<length; i++) {
                int n = queue.poll();
                if(n == e) {
                    return answer;
                }
                queue.offer(n - 1);
                queue.offer(n + 1);
                queue.offer(n + 5);
            }
            answer++;
        }

        return answer;
    }

    public int BFS(int s, int e) {
        int answer = 0;
        int[] steps = {-1, 1, 5};
        boolean[] check = new boolean[10001];
        Queue<Integer> q = new LinkedList<>();

        check[s] = true;
        q.offer(s);

        while(!q.isEmpty()) {
            int length = q.size();
            for(int i=0; i<length; i++) {
                int n = q.poll();
                for(int j=0; j<steps.length; j++) {
                    int x = n + steps[j];
                    if(x == e) return answer + 1;
                    if(x >= 1 && x <= 10000 && !check[x]) {
                        check[x] = true;
                        q.offer(x);
                    }
                }
            }
            answer++;
        }
        return answer;

    }

    public static void main(String[] args) {
        FindBabyCow main = new FindBabyCow();
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int e = sc.nextInt();

        System.out.println(main.BFS(s, e));
    }
}
