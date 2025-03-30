import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 수빈이 위치
        int K = Integer.parseInt(st.nextToken()); // 동생의 위치

        int[] dis = new int[200002];
        Queue<Integer> q = new LinkedList<>();
        q.offer(N);
        dis[N] = 1;

        while(!q.isEmpty()) {
            Integer cur = q.poll();

            checkNext(cur + 1, dis, q, cur, 1);
            checkNext(cur - 1, dis, q, cur, 1);
            checkNext(cur * 2, dis, q, cur, 0);
        }

        System.out.println(dis[K] - 1);

    }

    private static void checkNext(int nx, int[] dis, Queue<Integer> q, Integer cur, int plus) {
        if(nx < 0 || nx >= 200002) return;
        if(dis[nx] != 0 && dis[nx] <= dis[cur] + plus) return;
        q.offer(nx);
        dis[nx] = dis[cur] + plus;
    }
}