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
        for(int i=0; i<n; i++) {
            while(value <= arr[i]) {
                stack.push(value++);
                sb.append('+').append('\n');
            }

            if(stack.peek() == arr[i]) {
                stack.pop();
                sb.append('-').append('\n');
            }
        }
        
        if(stack.isEmpty()) System.out.println(sb);
        else System.out.println("NO");

    }
}
