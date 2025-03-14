import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Integer[] buildings = new Integer[n];
        for(int i=0; i<n; i++) {
            buildings[i] = Integer.parseInt(br.readLine());
        }

        long count = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<n; i++) {
            int building = buildings[i];
            while(!stack.isEmpty() && stack.peek() <= building) {
                stack.pop();
            }

            count += stack.size();
            stack.push(building);
        }

        System.out.println(count);
    }
}