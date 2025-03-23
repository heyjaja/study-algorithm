import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); // 가로
        int N = Integer.parseInt(st.nextToken()); // 세로
        int K = Integer.parseInt(st.nextToken()); // 사각형 개수
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int[][] paper = new int[N][M];

        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int fromX = Integer.parseInt(st.nextToken());
            int fromY = Integer.parseInt(st.nextToken());
            int toX = Integer.parseInt(st.nextToken());
            int toY = Integer.parseInt(st.nextToken());
            for(int x=fromX; x<toX; x++) {
                for(int y=fromY; y<toY; y++) {
                    paper[x][y] = 1;
                }
            }
        }

        boolean[][] vis = new boolean[N][M];
        List<Integer> results = new ArrayList<>();
        int area = 0;

        Queue<Pair> q = new LinkedList<>();
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                int count = 0;
                if(vis[i][j] || paper[i][j] != 0) continue;
                area++;
                vis[i][j] = true;
                q.add(new Pair(i,j));

                while(!q.isEmpty()) {
                    Pair cur = q.poll();
                    count++;
                    for(int dir=0; dir<4; dir++) {
                        int nx = cur.x + dx[dir];
                        int ny = cur.y + dy[dir];
                        if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                        if(vis[nx][ny] || paper[nx][ny] != 0) continue;
                        vis[nx][ny] = true;
                        q.offer(new Pair(nx, ny));
                    }
                }
                if(count > 0) {
                    results.add(count);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(area).append('\n');
        results.sort(Integer::compareTo);
        for (Integer result : results) {
            sb.append(result).append(' ');
        }
        System.out.println(sb);

    }
}

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}