import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray()) {
            if(stack.isEmpty() || c == '(') {
                
                if(c == '(') {
                    stack.push(c);
                    continue;
                } else {
                    return false;
                }
            }
            
            if(stack.peek() == '(') {
                stack.pop();
                continue;
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }
}