import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // NxN

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0 , -1};
        char[] colors = {'R', 'G', 'B'};
        String[] colorsStr = {"RG", "B"};

        StringBuilder sb = new StringBuilder();
        char[][] grid = new char[n][n];

        for(int i=0; i<n; i++) {
            String s = br.readLine();
            for (int j=0; j<n; j++) {
                grid[i][j] = s.charAt(j);
            }
        }

        boolean[][] vis1 = new boolean[n][n];
        int count1 = 0;
        for(int c=0; c<3; c++) {
            char color = colors[c];
            Queue<Pair> q = new LinkedList<>();
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(vis1[i][j] || grid[i][j] != color) continue;
                    count1++;
                    q.offer(new Pair(i, j));
                    vis1[i][j] = true;

                    while(!q.isEmpty()) {
                        Pair cur = q.poll();
                        for(int dir=0; dir<4; dir++) {
                            int nx = cur.x + dx[dir];
                            int ny = cur.y + dy[dir];
                            if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                            if(vis1[nx][ny] || grid[nx][ny] != color) continue;
                            q.offer(new Pair(nx, ny));
                            vis1[nx][ny] = true;
                        }
                    }
                }
            }
        }

        boolean[][] vis2 = new boolean[n][n];
        int count2 = 0;
        for(int c=0; c<2; c++) {
            String color = colorsStr[c];
            Queue<Pair> q = new LinkedList<>();
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(vis2[i][j] || color.indexOf(grid[i][j]) < 0) continue;
                    count2++;
                    q.offer(new Pair(i, j));
                    vis2[i][j] = true;

                    while(!q.isEmpty()) {
                        Pair cur = q.poll();
                        for(int dir=0; dir<4; dir++) {
                            int nx = cur.x + dx[dir];
                            int ny = cur.y + dy[dir];
                            if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                            if(vis2[nx][ny] || color.indexOf(grid[nx][ny]) < 0) continue;
                            q.offer(new Pair(nx, ny));
                            vis2[nx][ny] = true;
                        }
                    }
                }
            }
        }
        sb.append(count1).append(" ").append(count2);
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
