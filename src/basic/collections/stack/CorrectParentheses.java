package collections.stack;

import java.util.Scanner;
import java.util.Stack;

public class CorrectParentheses {
    public String solution(String a) {
        String answer = "YES";
        Stack<Character> stack = new Stack<>();

        for(char c : a.toCharArray()) {
            if(c == '(') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) {
                    return "NO";
                }
                stack.pop();
            }
        }

        if(!stack.isEmpty()) {
            return "NO";
        }
        return answer;
    }

    public static void main(String[] args) {
        // 올바른 괄호
        // (())()() -> YES or NO
        CorrectParentheses main = new CorrectParentheses();

        Scanner sc = new Scanner(System.in);
        String input1 = sc.next();

        System.out.println(main.solution(input1));
    }
}
