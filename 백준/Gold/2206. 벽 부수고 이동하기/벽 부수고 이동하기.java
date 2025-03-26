import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/2206
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int[][][] dis = new int[N][M][2];
        Queue<Point> q = new LinkedList<>();
        dis[0][0][0] = 1;
        q.offer(new Point(0,0, 0));

        while(!q.isEmpty()) {
            Point cur = q.poll();
            for(int dir=0; dir<4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(map[nx][ny] == 0 && dis[nx][ny][cur.broken] == 0) {
                    q.offer(new Point(nx, ny, cur.broken));
                    dis[nx][ny][cur.broken] = dis[cur.x][cur.y][cur.broken] + 1;
                } else if(map[nx][ny] == 1 && cur.broken == 0 && dis[nx][ny][1] == 0) {
                    q.offer(new Point(nx, ny, 1));
                    dis[nx][ny][1] = dis[cur.x][cur.y][cur.broken] + 1;
                }
            }
        }

        int noBroken = dis[N-1][M-1][0];
        int broken = dis[N-1][M-1][1];

        if (noBroken == 0 && broken == 0) {
            System.out.println(-1);
        } else if (noBroken == 0) {
            System.out.println(broken);
        } else if (broken == 0) {
            System.out.println(noBroken);
        } else {
            System.out.println(Math.min(noBroken, broken));
        }

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
