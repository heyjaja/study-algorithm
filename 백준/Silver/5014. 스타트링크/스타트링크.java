import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int F = Integer.parseInt(st.nextToken()); // 가장 높은 층
        int S = Integer.parseInt(st.nextToken()); // 현재 위치
        int G = Integer.parseInt(st.nextToken()); // 목적지
        int U = Integer.parseInt(st.nextToken()); // 위 이동 층
        int D = Integer.parseInt(st.nextToken()); // 아래 이동 층

        bfs(F, S, G, U, D);

    }

    private static void bfs(int F, int S, int G, int U, int D) {

        if(S == G) {
            System.out.println(0);
            return;
        }
        int[] dis = new int[F + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(S);
        dis[S] = 1;

        while(dis[G] == 0 && !q.isEmpty()) {
            Integer cur = q.poll();
            int u = cur + U;
            if(u > 0 && u <= F && dis[u] == 0) {
                q.offer(u);
                dis[u] = dis[cur] + 1;
            }
            int d = cur - D;

            if(d > 0 && d <= F && dis[d] == 0 ) {
                q.offer(d);
                dis[d] = dis[cur] + 1;
            }
        }

        if(dis[G] == 0) {
            System.out.println("use the stairs");
        } else {
            System.out.print(dis[G] - 1);
        }
    }
}
