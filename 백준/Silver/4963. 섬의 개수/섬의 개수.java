import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
    static int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};

    static int[][] board;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        while(true) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            if(w == 0 && h == 0) break;

            board = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i <h; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            Queue<Pair> queue = new LinkedList<>();
            int count = 0;
            for(int i=0; i<h; i++) {
                for(int j=0; j<w; j++) {
                    if(!visited[i][j] && board[i][j] == 1) {
                        queue.add(new Pair(i,j));
                        visited[i][j] = true;
                        count++;
                        while(!queue.isEmpty()) {
                            Pair current = queue.poll();

                            for(int dir = 0; dir < 8; dir++) {
                                int nx = current.x + dx[dir];
                                int ny = current.y + dy[dir];

                                if(nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                                if(visited[nx][ny] || board[nx][ny] == 0) continue;

                                queue.add(new Pair(nx, ny));
                                visited[nx][ny] = true;
                            }
                        }
                    }
                }
            }

            System.out.println(count);
        }
    }

    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}