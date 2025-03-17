import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = 0;
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else {
                stack.pop();
                if(s.charAt(i-1) == '(') {
                    count += stack.size();
                } else {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}