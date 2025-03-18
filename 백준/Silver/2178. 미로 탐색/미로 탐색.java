import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 세로
        int m = Integer.parseInt(st.nextToken()); // 가로
        int[][] board = new int[n][m];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(s[j]);
            }
        }

        int[][] dis = new int[n][m];

        Queue<Pair> q = new LinkedList<>();
        dis[0][0] = 1;
        q.offer(new Pair(0, 0));
        while(!q.isEmpty()) {
            Pair cur = q.poll();
            for(int k = 0; k < 4; k++) {
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(dis[nx][ny] > 0 || board[nx][ny] == 0) continue;
                dis[nx][ny] = dis[cur.x][cur.y] + 1;
                q.offer(new Pair(nx, ny));
            }
        }

        System.out.println(dis[n-1][m-1]);
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