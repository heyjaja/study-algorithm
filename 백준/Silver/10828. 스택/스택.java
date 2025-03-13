import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Stack stack = new Stack(n);

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch(command) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(stack.pop()).append('\n');
                    break;
                case "size":
                    sb.append(stack.size()).append('\n');
                    break;
                case "empty":
                    sb.append(stack.isEmpty() ? 1 : 0).append('\n');
                    break;
                case "top":
                    sb.append(stack.top()).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }
}

class Stack {
    int[] data;
    int pos = 0;
    int size = 0;

    public Stack(int max) {
        data = new int[max];
    }

    void push(int x) {
        data[pos++] = x;
        size++;
    }

    int pop() {
        if(isEmpty()) {
            return -1;
        }
        size--;
        return data[--pos];
    }

    boolean isEmpty() {
        return size == 0;
    }

    int size() {
        return size;
    }

    int top() {
        if(isEmpty()) {
            return -1;
        }
        return data[pos - 1];
    }
}