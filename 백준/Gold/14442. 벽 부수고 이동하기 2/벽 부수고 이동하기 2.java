import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int[][][] vis = new int[K+1][N][M];
        Queue<Point> q = new LinkedList<>();
        vis[0][0][0] = 1;
        q.offer(new Point(0, 0, 0));

        while(!q.isEmpty()) {
            Point cur = q.poll();
            for(int i=0; i<4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(vis[cur.broken][nx][ny] == 0 && map[nx][ny] == 0) {
                    vis[cur.broken][nx][ny] = vis[cur.broken][cur.x][cur.y] + 1;
                    q.offer(new Point(nx, ny, cur.broken));
                } else if(map[nx][ny] == 1 && cur.broken < K && vis[cur.broken+1][nx][ny] == 0) {
                    vis[cur.broken + 1][nx][ny] = vis[cur.broken][cur.x][cur.y] + 1;
                    q.offer(new Point(nx, ny, cur.broken+1));
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i<=K; i++) {
            if(vis[i][N-1][M-1] == 0) continue;
            min = Math.min(min, vis[i][N-1][M-1]);
        }

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);

    }
}

class Point {
    int x;
    int y;
    int broken;

    public Point(int x, int y, int broken) {
        this.x = x;
        this.y = y;
        this.broken = broken;
    }
}
