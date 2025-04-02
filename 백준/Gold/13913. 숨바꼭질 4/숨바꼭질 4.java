import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if(N == K) {
            System.out.println(0);
            System.out.println(N);
            return;
        } else if(N > K) {
            StringBuilder sb = new StringBuilder();
            sb.append(N-K).append('\n');
            for (int i = N; i >= K; i--) {
                sb.append(i).append(' ');
            }
            System.out.println(sb);
            return;
        }

        StringBuilder sb = new StringBuilder();
        int[] dis = new int[100001];
        Queue<Point> q = new LinkedList<>();
        dis[N] = 1;
        q.offer(new Point(N, new StringBuilder()));

        while(dis[K] == 0 && !q.isEmpty()) {
            Point cur = q.poll();
            sb = cur.path;
            check(dis, q, cur, cur.x-1);
            check(dis, q, cur, cur.x+1);
            check(dis, q, cur, cur.x*2);
        }

        System.out.println(dis[K] - 1);
        System.out.println(sb.append(K));

    }

    private static void check(int[] dis, Queue<Point> q, Point cur, int nx) {
        if(nx < 0 || nx >= dis.length) return;
        if(dis[nx] != 0 || dis[nx] >= dis[cur.x]) return;
        dis[nx] = dis[cur.x] + 1;
        q.offer(new Point(nx, new StringBuilder(cur.path)));
    }
}

class Point {
    int x;
    StringBuilder path;

    public Point(int x, StringBuilder past) {
        this.x = x;
        this.path = past.append(x).append(" ");
    }
}
