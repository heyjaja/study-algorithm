import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        char[][] board = new char[r][c];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<Pair> q = new LinkedList<>();
        int[][] dis = new int[r][c];
        int[][] dis2 = new int[r][c];
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = s.charAt(j);
                if (board[i][j] == 'F') {
                    dis[i][j] = 1;
                    q.offer(new Pair(i, j)); // 불이 이동하는 경로 먼저 탐색
                }
            }
        }

        while(!q.isEmpty()) {
            Pair cur = q.poll();
            for(int k = 0; k < 4; k++) {
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];

                if(nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
                if(dis[nx][ny] > 0 || board[nx][ny] == '#') continue;
                dis[nx][ny] = dis[cur.x][cur.y] + 1;
                q.offer(new Pair(nx, ny));
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 'J') {
                    dis2[i][j] = 1;
                    q.offer(new Pair(i, j)); // 지훈이가 이동하는 경로 탐색
                }
            }
        }

        boolean flag = false;
        int count = 0;
        while(!q.isEmpty()) {
            Pair cur = q.poll();
            for(int k = 0; k < 4; k++) {
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];

                if(nx < 0 || nx >= r || ny < 0 || ny >= c) {
                    // 범위를 벗어났다는 것은 탈출에 성공
                    flag = true;
                    count = dis2[cur.x][cur.y];
                    break;
                }
                if(dis2[nx][ny] > 0 || board[nx][ny] == '#') continue; // 지훈이가 방문했던 위치
                if(dis[nx][ny] > 0 && dis[nx][ny] <= dis2[cur.x][cur.y]+1) continue;
                dis2[nx][ny] = dis2[cur.x][cur.y] + 1;
                q.offer(new Pair(nx, ny));
            }
            if(flag) break;
        }

        System.out.println(flag ? count : "IMPOSSIBLE");
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