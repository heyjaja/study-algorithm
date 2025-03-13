import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Stack<Top> tops = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            tops.push(new Top(i+1, Integer.parseInt(st.nextToken())));
        }


        Stack<Top> stack = new Stack<>();
        int[] arr = new int[n];
        while(!tops.isEmpty()) {
            Top front = tops.pop();
            while(!stack.isEmpty()) {
                Top top = stack.peek();
                if(top.height <= front.height) {
                    arr[top.index - 1] = front.index;
                    stack.pop();
                } else {
                    break;
                }
            }
            stack.push(front);
        }

        for (int i : arr) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }
}

class Top {
    int index;
    int height;

    public Top(int index, int height) {
        this.index = index;
        this.height = height;
    }
}