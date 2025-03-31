import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/2206
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] ocean = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                ocean[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(BFS(N, M, ocean));
    }

    private static int BFS(int N, int M, int[][] ocean) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int count = 1;
        int[][] dis = new int[N][M];
        Queue<Pair> q = new LinkedList<>();
        while(true) {
            for(int i = 0; i< N; i++) {
                for(int j = 0; j< M; j++) {
                    if(ocean[i][j] > 0 && dis[i][j] < count) {
                        q.offer(new Pair(i, j));
                        dis[i][j] = count;
                    }
                }
            }

            if(q.isEmpty()) {
                return 0;
            }

            while(!q.isEmpty()) {
                Pair cur = q.poll();

                for(int dir = 0; dir<4; dir++) {
                    int nx = cur.x + dx[dir];
                    int ny = cur.y + dy[dir];

                    if(nx<0 || nx >= N || ny<0 || ny>=M) continue;
                    if(dis[nx][ny] >= count) continue;
                    if(ocean[nx][ny] <= 0) {
                        ocean[cur.x][cur.y] = ocean[cur.x][cur.y] - 1;
                    } else {
                        dis[nx][ny] = count;
                        q.offer(new Pair(nx, ny));
                    }
                }
            }


            boolean[][] vis = new boolean[N][M];
            Queue<Pair> q2 = new LinkedList<>();
            int area = 0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(ocean[i][j] > 0 && !vis[i][j]) {
                        area++;
                        q2.offer(new Pair(i, j));
                        vis[i][j] = true;
                    }

                    while(!q2.isEmpty()) {
                        Pair cur = q2.poll();
                        for(int dir = 0; dir<4; dir++) {
                            int nx = cur.x + dx[dir];
                            int ny = cur.y + dy[dir];

                            if(nx<0 || nx >= N || ny<0 || ny>=M) continue;
                            if(vis[nx][ny] || ocean[nx][ny] <= 0) continue;
                            vis[nx][ny] = true;
                            q2.offer(new Pair(nx, ny));
                        }
                    }
                }
            }

            if(area >= 2) {
                return count;
            }

            count++;
        }
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
