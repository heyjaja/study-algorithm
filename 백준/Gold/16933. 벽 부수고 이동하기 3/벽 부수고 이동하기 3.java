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

        int[][][] dis = new int[K+1][N][M];
        Queue<Point> q = new LinkedList<>();
        dis[0][0][0] = 1;
        q.offer(new Point(0, 0, 0, 0, true));

        while(!q.isEmpty()) {
            Point cur = q.poll();
            for(int i=0; i<4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(map[nx][ny] == 1) { // 벽인 경우
                    if(cur.broken >= K) continue; // 벽을 더이상 부술 수 없으면 다음
                    if(dis[cur.broken + 1][nx][ny] != 0) continue; // 이미 방문한 곳이면 다음
                    if(cur.day) { // 낮일 때
                        dis[cur.broken + 1][nx][ny] = dis[cur.broken][cur.x][cur.y] + 1 + cur.plus; // 거리 값에 밤에 머무른 시간 더하기
                        q.offer(new Point(nx, ny, cur.broken+1, 0, false));
                    } else {
                        q.offer(new Point(cur.x, cur.y, cur.broken, 1, true)); // 다시 큐에 넣을 때 밤에 머무른 시간 더하기
                    }
                } else { // 벽이 아닌 곳은 바로 이동
                    if(dis[cur.broken][nx][ny] != 0) continue;
                    dis[cur.broken][nx][ny] = dis[cur.broken][cur.x][cur.y] + 1;
                    q.offer(new Point(nx, ny, cur.broken, 0, !cur.day));
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i<=K; i++) {
            if(dis[i][N-1][M-1] == 0) continue;
            min = Math.min(min, dis[i][N-1][M-1]);
        }

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);

    }
}

class Point {
    int x;
    int y;
    int broken; // 벽을 부순 횟수
    int plus; // 벽을 부술 때 해당 위치에 머물렀던 기간
    boolean day;

    public Point(int x, int y, int broken, int plus, boolean day) {
        this.x = x;
        this.y = y;
        this.broken = broken;
        this.plus = plus;
        this.day = day;
    }
}
