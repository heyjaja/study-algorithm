import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 수빈이 위치
        int k = Integer.parseInt(st.nextToken()); // 동생의 위치
        int[] dx = {1, -1, 2};
        char[] sign = {'+', '+', '*'};
        int[] vis = new int[100001];

        Queue<Integer> queue = new LinkedList<>();
        vis[n] = 1;
        queue.offer(n);

        int count = 0;
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for(int i=0; i<3; i++) {
                int nx = sign[i] == '+' ? cur + dx[i] : cur * dx[i];

                if(nx < 0 || nx >= vis.length) continue;
                if(vis[nx] > 0 && vis[nx] <= vis[cur] + 1) continue;
                if(nx == k) {
                    count = vis[cur];
                    break;
                }
                vis[nx] = vis[cur]+1;
                queue.offer(nx);
            }
            if(count > 0) {
                break;
            }
        }

        System.out.println(count);

    }
}