import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트케이스 개수
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++) { // 테스트 케이스
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken()); // 너비
            int h = Integer.parseInt(st.nextToken()); // 높이
            char[][] map = new char[h][w];
            int[][] dis1 = new int[h][w];
            int[][] dis2 = new int[h][w];

            Queue<Pair> q1 = new LinkedList<>();
            Queue<Pair> q2 = new LinkedList<>();
            for(int i=0; i<h; i++) {
                String s = br.readLine();
                for (int j = 0; j <w; j++) {
                    map[i][j] = s.charAt(j);
                    if(map[i][j] == '*') {
                        dis1[i][j] = 1;
                        q1.offer(new Pair(i, j));
                    }
                    if(map[i][j] == '@') {
                        dis2[i][j] = 1;
                        q2.offer(new Pair(i, j));
                    }
                }
            }

            while(!q1.isEmpty()) {
                Pair cur = q1.poll();
                for(int dir = 0; dir < 4; dir++) {
                    int nx = cur.x + dx[dir];
                    int ny = cur.y + dy[dir];
                    if(nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                    if(dis1[nx][ny] > 0 || map[nx][ny] != '.') continue;
                    dis1[nx][ny] = dis1[cur.x][cur.y] + 1;
                    q1.offer(new Pair(nx, ny));
                }
            }

            int count = 0;
            while(count == 0 && !q2.isEmpty()) {
                Pair cur = q2.poll();
                for(int dir = 0; dir < 4; dir++) {
                    int nx = cur.x + dx[dir];
                    int ny = cur.y + dy[dir];
                    if(nx < 0 || nx >= h || ny < 0 || ny >= w) {
                        count = dis2[cur.x][cur.y];
                        break;
                    }
                    if(dis2[nx][ny] > 0 ||  map[nx][ny] != '.') continue;
                    if(dis1[nx][ny] != 0 && dis1[nx][ny] <= dis2[cur.x][cur.y] + 1) continue;
                    dis2[nx][ny] = dis2[cur.x][cur.y] + 1;
                    q2.offer(new Pair(nx, ny));
                }
            }
            if(count != 0) sb.append(count).append('\n');
            else sb.append("IMPOSSIBLE").append('\n');

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