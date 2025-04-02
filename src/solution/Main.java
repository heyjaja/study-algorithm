package solution;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N, K));
    }

    private static int bfs(int N, int K) {
        int[][] vis = new int[2][500001]; // 홀수, 짝수로 나누어서 방문 표시 -> 수빈이가 +1 -1을 반복하면 같은 위치에 2초 간격(짝수, 홀수로)으로 도달. 중복을 줄이기 위함
        for (int[] arr : vis) Arrays.fill(arr, -1);
        Queue<Integer> q = new LinkedList<>();
        vis[0][N] = 0; // 시작 위치 방문 표시
        q.offer(N);

        int t = 0;
        while(!q.isEmpty()) {
            t++;
            int k = K + t*(t+1)/2; // k = k + 1 + 2 + 3 ... 시간만큼 증가

            if(k > 500000) {
                return -1;
            }

            int idx = t%2; // 현재 시간 짝수? 홀수?
            int size = q.size(); // 현재 큐 크기만큼 반복(같은 시간 k에 도달할 수 있는 모든 위치 처리)
            for (int i = 0; i < size; i++) { // q.size()로 하면 q의 크기가 변동되기 때문에 오류
                int cur = q.poll();

                for (int nx : new int[]{cur - 1, cur + 1, cur * 2}) {
                    if(nx < 0 || nx > 500000) continue;
                    if(vis[idx][nx] != -1) continue;// 같은 홀짝 시간에 방문 확인
                    vis[idx][nx] = t;
                    q.offer(nx);
                }

            }

            if(vis[idx][k] != -1 && vis[idx][k] <= t) return t;
        }

        return -1;
    }
}
