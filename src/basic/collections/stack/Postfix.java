package basic.collections.stack;

import java.util.Scanner;
import java.util.Stack;

public class Postfix {
    public int solution(String s) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for(char c : s.toCharArray()) {
            if(Character.isDigit(c)) {
                stack.push(c-48);
                continue;
            }
            int rt = stack.pop();
            int lt = stack.pop();

            if(c == '+') {
                stack.push(lt + rt);
            } else if(c == '-') {
                stack.push(lt - rt);
            } else if(c == '*') {
                stack.push(lt * rt);
            } else if(c == '/') {
                stack.push(lt / rt);
            }
        }

        answer = stack.pop();

        return answer;
    }

    public static void main(String[] args) {
        // 후위식 연산
        Postfix main = new Postfix();

        Scanner sc = new Scanner(System.in);
        String input1 = sc.next();

        System.out.println(main.solution(input1));
    }
}
