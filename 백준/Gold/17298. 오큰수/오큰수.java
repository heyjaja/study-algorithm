import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Number[] nums = new Number[n];
        int[] arr = new int[n];
        Arrays.fill(arr, -1);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            nums[i] = new Number(i, Integer.parseInt(st.nextToken()));
        }
        Stack<Number> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            Number a = nums[i];

            while(!stack.isEmpty() && stack.peek().data < a.data) {
                    arr[stack.pop().index] = a.data;
            }
            stack.push(a);
        }

        StringBuilder sb = new StringBuilder();
        for(int i : arr) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }
}

class Number {
    int index;
    int data;

    public Number(int index, int data) {
        this.index = index;
        this.data = data;
    }
}