import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //https://www.acmicpc.net/workbook/view/7313
        int N = Integer.parseInt(br.readLine());
        int[][] houses = new int[N][N];

        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<N; j++) {
                houses[i][j] = s.charAt(j) - '0';
            }
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<Pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[N][N];
        List<Integer> results = new ArrayList<>();
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                int count = 0;
                if(vis[i][j] || houses[i][j] == 0) continue;
                q.offer(new Pair(i, j));
                vis[i][j] = true;

                while(!q.isEmpty()) {
                    Pair cur = q.poll();
                    count++;
                    for(int dir=0; dir<4; dir++) {
                        int nx = cur.x + dx[dir];
                        int ny = cur.y + dy[dir];

                        if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                        if(vis[nx][ny] || houses[nx][ny] == 0) continue;
                        q.offer(new Pair(nx, ny));
                        vis[nx][ny] = true;
                    }

                }
                if(count > 0) results.add(count);
            }
        }

        results.sort(Integer::compareTo);
        StringBuilder sb = new StringBuilder();
        sb.append(results.size()).append('\n');
        for (Integer result : results) {
            sb.append(result).append('\n');
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