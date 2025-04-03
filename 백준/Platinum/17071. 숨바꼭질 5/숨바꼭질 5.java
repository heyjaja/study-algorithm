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
        boolean[][] vis = new boolean[2][500001];
        Queue<Integer> q = new LinkedList<>();
        vis[0][N] = true;
        q.offer(N);

        int t = 0, k = K; // 첫번째 시간은 0, 동생 위치 K
        while (!q.isEmpty()) {
            int idx = (t+1)%2; // 다음 시간 탐색 값을 저장할 거니까 다음 시간 기준으로 홀짝을 정함
            int size = q.size();
            for (int i = 0; i < size; i++) { // 레벨 별로 모든 q를 순회(큐에는 다음 레벨만 남음)
                Integer cur = q.poll();
                if(cur == k) return t; // 현재 위치와 동생의 위치가 같으면 현재 시간(= 큐의 탐색 레벨) 반환

                for(int nx : new int[]{cur-1, cur+1, cur*2}) {
                    if(nx < 0 || nx > 500000) continue;
                    if(vis[idx][nx]) continue;
                    vis[idx][nx] = true;
                    q.offer(nx);
                }
            }

            t++; // 이전 반복문에서 저장한 값은 다음 레벨에서 도달할 위치들
            k += t; // 다음 레벨에서 동생의 위치 수정

            if(k > 500000) return -1;
            if(vis[idx][k]) return t; // 큐에 저장된 다음 레벨의 위치를 미리 확인
        }
        return -1;
    }
}