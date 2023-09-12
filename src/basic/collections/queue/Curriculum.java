package collections.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Curriculum {
    public String solution(String a, String b) {
        String answer = "YES";
        Queue<Character> queue = new LinkedList<>();

        for(char c : a.toCharArray()) {
            queue.offer(c);
        }

        for(char c : b.toCharArray()) {
//            if(queue.isEmpty()) break;
//
//            if(c == queue.peek()) {
//                queue.poll();
//            }

            if(queue.contains(c)) {
                if(c != queue.poll()) {
                    return "NO";
                }
            }
        }

        if(!queue.isEmpty()) {
            return "NO";
        }

        return answer;
    }

    public static void main(String[] args) {
        // 교육과정 설계
        // 필수 과목이 순서대로 들어가야 한다.
        Curriculum main = new Curriculum();

        Scanner sc = new Scanner(System.in);
        String input1 = sc.next();
        String input2 = sc.next();

        System.out.println(main.solution(input1, input2));
    }
}
