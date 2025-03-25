import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //https://www.acmicpc.net/workbook/view/7313

        int N = Integer.parseInt(br.readLine());
        int[][] area = new int[N][N];

        StringTokenizer st;
        int max = 0;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(area[i][j], max);
            }
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int answer = 0;
        Queue<Pair> q = new LinkedList<>();
        for(; max >= 0; max--) {
            int count = 0;
            boolean[][] vis = new boolean[N][N];
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(area[i][j] <= max || vis[i][j]) continue;
                    count++;
                    q.offer(new Pair(i, j));
                    vis[i][j] = true;

                    while(!q.isEmpty()) {
                        Pair cur = q.poll();
                        for(int dir=0; dir<4; dir++) {
                            int nx = cur.x + dx[dir];
                            int ny = cur.y + dy[dir];

                            if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
                            if(vis[nx][ny] || area[nx][ny] <= max) continue;
                            q.offer(new Pair(nx,ny));
                            vis[nx][ny] = true;
                        }
                    }
                }
            }
            answer = Math.max(answer, count);
        }

        System.out.println(answer);

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