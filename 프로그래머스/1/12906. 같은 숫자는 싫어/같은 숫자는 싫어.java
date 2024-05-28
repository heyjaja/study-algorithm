import java.util.*;

public class Solution {
    public Stack solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        
        for(int i : arr) {
            if(stack.isEmpty() || stack.peek() != i) {
                stack.push(i);
            }
        }

        return stack;
    }
}