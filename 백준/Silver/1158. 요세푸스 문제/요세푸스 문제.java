import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        IntQueue queue = new IntQueue(n);
        for(int i=0; i<n; i++) {
            queue.offer(i+1);
        }

        sb.append('<');
        while(!queue.isEmpty()) {
            for(int i=1; i<k; i++) {
                queue.offer(queue.poll());
            }
            
            sb.append(queue.poll());
            
            if(queue.isEmpty()) {
                break;
            }
            
            sb.append(", ");
        }
        sb.append('>');

        System.out.println(sb);

    }
}

class IntQueue {
    int[] data;
    int front;
    int rear;
    int size;
    int max;

    public IntQueue(int max) {
        size = front = rear = 0;
        this.max = max;
        data = new int[max];
    }

    public int offer(int n) {
        data[rear++] = n;
        size++;

        if(rear == max) {
            rear = 0;
        }

        return n;
    }

    public int poll() {
        int n = data[front++];
        size--;
        if(front == max) {
            front = 0;
        }

        return n;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}