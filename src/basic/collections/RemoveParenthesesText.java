package collections;

import java.util.Scanner;
import java.util.Stack;

public class RemoveParenthesesText {
    public String solution(String a) {
        StringBuilder answer = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for(char c : a.toCharArray()) {
            if(c == ')') {
                while(stack.pop() != '(');
            } else {
                stack.push(c);
            }
        }

        for(char c : stack) {
            answer.append(c);
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        // 괄호 안의 문자 제거
        RemoveParenthesesText main = new RemoveParenthesesText();

        Scanner sc = new Scanner(System.in);
        String input1 = sc.next();

        System.out.println(main.solution(input1));
    }
}
