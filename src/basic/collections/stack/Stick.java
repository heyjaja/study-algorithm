package basic.collections.stack;

import java.util.Scanner;
import java.util.Stack;

public class Stick {
    public int solution(String s) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else {
                stack.pop();
                if(s.charAt(i-1) == '(') {
                    // 레이저일 때 stack에 남은 괄호가 잘린 막대기
                    answer += stack.size();
                } else {
                    // 막대기의 끝일 때 끝난 막대기 1개 추가
                    answer += 1;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        // 쇠막대기
        Stick main = new Stick();

        Scanner sc = new Scanner(System.in);
        String input1 = sc.next();

        System.out.println(main.solution(input1));
    }
}
