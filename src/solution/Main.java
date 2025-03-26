package solution;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/2206
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        Queue<Pair> walls = new LinkedList<>();
        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<M; j++) {
                map[i][j] = s.charAt(j) - '0';
                if(map[i][j] == 1) {
                    walls.offer(new Pair(i, j));
                }
            }
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};



        int size = walls.size();
        int min = Integer.MAX_VALUE;
        for(int i=0; i<size; i++) {
            Pair wall = walls.poll();

            int[][] dis = new int[N][M];
            Queue<Pair> q = new LinkedList<>();
            dis[0][0] = 1;
            q.offer(new Pair(0,0));

            while(dis[N-1][M-1] == 0 && !q.isEmpty()) {
                Pair cur = q.poll();
                for(int dir=0; dir<4; dir++) {
                    int nx = cur.x + dx[dir];
                    int ny = cur.y + dy[dir];

                    if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                    if(map[nx][ny] == 1) {
                        if(nx != wall.x && nx != wall.y) continue;
                    }
                    if(dis[nx][ny] > 0) continue;
                    dis[nx][ny] = dis[cur.x][cur.y] + 1;
                    q.offer(new Pair(nx, ny));
                }
            }

            min = Math.min(dis[N-1][M-1], min);
        }

        if(min == 0) System.out.println(-1);
        else System.out.println(min);


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
