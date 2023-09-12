package collections.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SavePrincess {
    public int solution(int n, int k) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();

        for(int i=1; i<=n; i++) {
            queue.offer(i);
        }

        int count = 0;
        while(queue.size() > 1) {
            count++;
            if(count == k) {
                queue.poll();
                count = 0;
            } else {
                queue.offer(queue.poll());

            }
        }

        answer = queue.poll();

        return answer;
    }
    public int solution2(int n, int k) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();

        for(int i=1; i<=n; i++) {
            queue.offer(i);
        }

        while(!queue.isEmpty()) {
            for(int i=1; i<k; i++) {
                queue.offer(queue.poll());
            }
            queue.poll();
            if(queue.size() == 1) answer = queue.poll();
        }

        return answer;
    }

    public static void main(String[] args) {
        // 공주 구하기
        // 왕자 N명, 나이순으로 1~N 번호
        SavePrincess main = new SavePrincess();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        System.out.print(main.solution2(n, k));
    }
}
