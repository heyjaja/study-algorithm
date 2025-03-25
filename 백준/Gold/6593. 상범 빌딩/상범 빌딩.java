
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(st.hasMoreTokens()) {
            int L = Integer.parseInt(st.nextToken()); // 층
            int R = Integer.parseInt(st.nextToken()); // 행
            int C = Integer.parseInt(st.nextToken()); // 열

            if(L == 0 && R == 0 && C == 0) break;
            char[][][] building = new char[L][R][C];
            Point goal = null;
            Queue<Point> q = new LinkedList<>();
            int[][][] dis = new int[L][R][C];
            for(int i=0; i<L; i++) {
                for(int j=0; j<R; j++) {
                    String s = br.readLine();
                    for(int k=0; k<C; k++) {
                        building[i][j][k] = s.charAt(k);
                        if(building[i][j][k] == 'S') {
                            q.offer(new Point(i, j, k));
                            dis[i][j][k] = 1;
                        }
                        if(building[i][j][k] == 'E') {
                            goal = new Point(i, j, k);
                        }
                    }
                }
                br.readLine();
            }

            int[] dx = {-1, 0 , 1, 0, 0, 0};
            int[] dy = {0, 1, 0, -1, 0, 0};
            int[] dz = {0, 0, 0, 0, -1, 1};

            while(dis[goal.z][goal.x][goal.y] == 0 && !q.isEmpty()) {
                Point cur = q.poll();
                for(int i=0; i<6; i++) {
                    int nz = cur.z + dz[i];
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];
                    if(nx < 0 || nx >= R || ny < 0 || ny >= C || nz < 0 || nz >= L) continue;
                    if(dis[nz][nx][ny] != 0 || building[nz][nx][ny] == '#') continue;
                    q.offer(new Point(nz, nx, ny));
                    dis[nz][nx][ny] = dis[cur.z][cur.x][cur.y] + 1;
                }
            }

            if(dis[goal.z][goal.x][goal.y] == 0) {
                sb.append("Trapped!").append('\n');
            } else {
                sb.append("Escaped in ").append(dis[goal.z][goal.x][goal.y] - 1).append(" minute(s).\n");
            }

            st = new StringTokenizer(br.readLine());
        }

        System.out.println(sb);

    }
}

class Point {
    int z;
    int x;
    int y;

    public Point(int z, int x, int y) {
        this.z = z;
        this.x = x;
        this.y = y;
    }
}