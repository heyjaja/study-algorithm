import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            String s = br.readLine();
            if(s.equals(".")) break;
            sb.append(getAnswer(s)).append('\n');
        }

        System.out.println(sb);

    }

    private static String getAnswer(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if(c == '(' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == ']') {
                if(stack.isEmpty()) {
                    return "no";
                } else if(c == ')') {
                    if(stack.peek() != '(') {
                        return "no";
                    }
                    stack.pop();
                } else if(c == ']') {
                    if(stack.peek() != '[') {
                        return "no";
                    }
                    stack.pop();
                }
            }
        }
        return stack.isEmpty() ? "yes" : "no";
    }
}