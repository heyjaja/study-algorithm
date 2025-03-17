import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            String s = br.readLine();
            sb.append(getAnswer(s)).append('\n');
        }

        System.out.println(sb);

    }

    private static String getAnswer(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if(c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if(stack.isEmpty() || stack.peek() != '(') {
                    return "NO";
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty() ? "YES" : "NO";
    }

}