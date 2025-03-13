package barkingdog.stack;

import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {

        System.out.println("=====SimpleStack=====");
        SimpleStack simple = new SimpleStack();
        simple.push(5);
        simple.push(4);
        simple.push(3);
        System.out.println(simple.top()); // 3
        simple.pop();
        simple.pop();
        System.out.println(simple.top()); // 5
        simple.push(10);
        simple.push(12);
        System.out.println(simple.top()); // 12
        simple.pop();
        System.out.println(simple.top()); // 10

        System.out.println("=====Stack=====");
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.size()); // 3
        if(stack.isEmpty()) System.out.println("stack is empty");
        else System.out.println("stack is not empty");
        stack.pop();
        System.out.println(stack.peek()); // 20
        stack.pop();
        System.out.println(stack.peek()); // 10
        stack.pop();
        if(stack.isEmpty()) System.out.println("stack is empty");
        else System.out.println("stack is not empty");
    }
}
