import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for(int i=0; i<n; i++) {
            String s = br.readLine();
            if(s.length() % 2 != 0) continue;
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if(stack.isEmpty()) stack.push(c);
                else {
                    if(c == stack.peek()) {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                }
            }
            if(stack.isEmpty()) count++;
        }
        System.out.println(count);
    }
}