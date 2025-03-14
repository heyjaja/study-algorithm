import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            queue.offer(i+1);
        }

        int count = 1;
        while(queue.size() > 1) {
            int card = queue.poll();
            if(count++ % 2 == 0) {
                queue.offer(card);
            }
        }

        System.out.println(queue.poll());
    }
}