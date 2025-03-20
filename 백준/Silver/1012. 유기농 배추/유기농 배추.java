import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트케이스 수

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0 , -1};

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int i=0; i<t; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken()); // 밭의 세로 길이
            int n = Integer.parseInt(st.nextToken()); // 밭의 가로 길이
            int k = Integer.parseInt(st.nextToken()); // 배추의 개수
            int[][] board = new int[n][m];
            boolean[][] vis = new boolean[n][m];
            Queue<Pair> q = new LinkedList<>();
            for(int j=0; j<k; j++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                board[x][y] = 1;
            }

            int count = 0;
            for(int x = 0; x<n; x++) {
                for(int y=0; y<m; y++) {
                    if(vis[x][y] || board[x][y] == 0) continue;
                    count++;
                    vis[x][y] = true;
                    q.offer(new Pair(x, y));

                    while(!q.isEmpty()) {
                        Pair cur = q.poll();
                        for(int dir = 0; dir < 4; dir++) {
                            int nx = cur.x + dx[dir];
                            int ny = cur.y + dy[dir];

                            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                            if(vis[nx][ny] || board[nx][ny] == 0) continue;
                            vis[nx][ny] = true;
                            q.offer(new Pair(nx, ny));
                        }
                    }
                }
            }

            sb.append(count).append('\n');


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