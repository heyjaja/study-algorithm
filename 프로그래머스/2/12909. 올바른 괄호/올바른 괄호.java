import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray()) {
            if(stack.isEmpty() || c == '(') {
                stack.push(c);
            } else if(stack.peek() == '(') {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }
}