import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()); // 가로
        int n = Integer.parseInt(st.nextToken()); // 세로
        int[][] board = new int[n][m];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int[][] dis = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Pair> q = new LinkedList<>();

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(board[i][j] == -1) dis[i][j] = -1;
                if(dis[i][j] > 0 || board[i][j] != 1) continue;
                dis[i][j] = 1;
                q.offer(new Pair(i, j));
            }
        }

        while(!q.isEmpty()) {
            Pair cur = q.poll();
            for(int k = 0; k < 4; k++) {
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(dis[nx][ny] > 0 || board[nx][ny] < 0) continue;
                dis[nx][ny] = dis[cur.x][cur.y] + 1;
                q.offer(new Pair(nx, ny));
            }
        }

        int max = getAnswer(dis);

        System.out.println(max);
    }

    private static int getAnswer(int[][] dis) {
        int max = -1;
        for (int[] di : dis) {
            for (int i : di) {
                if(i == 0) return -1;
                max = Math.max(max, i-1);
            }
        }
        return max;
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