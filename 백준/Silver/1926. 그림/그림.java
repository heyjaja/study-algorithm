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
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] vis = new boolean[n][m];

        int count = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <m; j++) {
                if(vis[i][j] || board[i][j] == 0) continue;
                count++;
                Queue<Pair> q = new LinkedList<>();
                vis[i][j] = true;
                q.offer(new Pair(i, j));
                int area = 0;
                while(!q.isEmpty()) {
                    area++;
                    Pair cur = q.poll();
                    for(int k = 0; k < 4; k++) {
                        int nx = cur.x + dx[k];
                        int ny = cur.y + dy[k];

                        if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                        if(vis[nx][ny] || board[nx][ny] != 1) continue;
                        vis[nx][ny] = true;
                        q.offer(new Pair(nx, ny));
                    }
                }
                max = Math.max(max, area);
            }
        }

        System.out.println(count);
        System.out.println(max);
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