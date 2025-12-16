import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(function(n));
    }

    private static int function(int n) {
        if(n == 1) return 0;

        int[] dist = new int[n+1];

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(n);

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            if(cur % 3 == 0) {
               int a = cur / 3;
               if(a == 1) return dist[cur] + 1;
               if(dist[a] == 0) {
                   dist[a] = dist[cur] + 1;
                   queue.offer(a);
               }
            }

            if(cur % 2 == 0) {
                int a = cur / 2;
                if(a == 1) return dist[cur] + 1;
                if(dist[a] == 0) {
                    dist[a] = dist[cur] + 1;
                    queue.offer(a);
                }
            }

            int a = cur - 1;
            if(a == 1) return dist[cur] + 1;
            if(dist[a] == 0) {
                dist[a] = dist[cur] + 1;
                queue.offer(a);
            }

        }

        return dist[1];
    }
}