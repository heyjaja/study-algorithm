import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트케이스 개수

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++) { // 테스트 케이스
            int I = Integer.parseInt(br.readLine()); // 체스판 한 변의 길이

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            sb.append(bfs(I, x, y, endX, endY)).append('\n');
        }
        System.out.println(sb);

    }

    private static int bfs(int I, int x, int y, int endX, int endY) {
        if(x == endX && y == endY) return 0;

        int[][] dis = new int[I][I];
        int[] dx = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

        Queue<Pair> q = new LinkedList<>();
        dis[x][y] = 1;
        q.offer(new Pair(x,y));

        while(dis[endX][endY] == 0) {
            Pair cur = q.poll();
            for(int i=0; i<8; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx < 0 || nx >= I || ny < 0 || ny >= I) continue;
                if(dis[nx][ny] > 0) continue;
                if(nx == endX && ny == endY) {
                    return dis[cur.x][cur.y];
                }
                dis[nx][ny] = dis[cur.x][cur.y] + 1;
                q.offer(new Pair(nx, ny));
            }
        }

        return dis[endX][endY];
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