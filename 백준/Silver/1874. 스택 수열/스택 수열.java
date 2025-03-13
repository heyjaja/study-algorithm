import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new ArrayDeque<>();

        for(int i=0; i<n; i++) {
            queue.offer(Integer.parseInt(br.readLine()));
        }

        int value = 1;
        while(value <= n) {
            if(stack.isEmpty() || !stack.peek().equals(queue.peek())) {
                stack.push(value);
                sb.append('+').append('\n');
                value++;
            }

            while(!stack.isEmpty() && stack.peek().equals(queue.peek())) {
                stack.pop();
                queue.poll();
                sb.append('-').append('\n');
            }
        }


        if(stack.isEmpty()) System.out.println(sb);
        else System.out.println("NO");


    }
}