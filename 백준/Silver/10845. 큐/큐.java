import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Queue queue = new Queue(n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push":
                    queue.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(queue.isEmpty() ? -1 : queue.pop()).append('\n');
                    break;
                case "size":
                    sb.append(queue.size()).append('\n');
                    break;
                case "empty":
                    sb.append(queue.isEmpty() ? 1 : 0).append('\n');
                    break;
                case "front":
                    sb.append(queue.isEmpty() ? -1 : queue.front()).append('\n');
                    break;
                case "back":
                    sb.append(queue.isEmpty() ? -1 : queue.back()).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }
}

class Queue {
    int max;
    int[] data;
    int head = 0;
    int tail = 0;
    int size = 0;

    public Queue(int max) {
        this.max = max;
        this.data = new int[max];
    }

    void push(int x) {
        data[tail++] = x;
        size++;
    }

    int pop() {
        size--;
        return data[head++];
    }

    int size() {
        return size;
    }

    boolean isEmpty() {
        return size == 0;
    }

    int front() {
        return data[head];
    }

    int back() {
        return data[tail-1];
    }
}
