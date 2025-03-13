import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int value = 1;
        int index = 0;
        while(value <= n) {
            if(stack.isEmpty() || stack.peek() != arr[index]) {
                stack.push(value);
                sb.append('+').append('\n');
                value++;
            }

            while(!stack.isEmpty() && stack.peek() == arr[index]) {
                stack.pop();
                index++;
                sb.append('-').append('\n');
            }
        }


        if(stack.isEmpty()) System.out.println(sb);
        else System.out.println("NO");


    }
}