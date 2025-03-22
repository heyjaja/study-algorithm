import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트케이스 개수
        int[] dx = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++) { // 테스트 케이스
            int I = Integer.parseInt(br.readLine()); // 체스판 한 변의 길이
            int[][] board = new int[I][I];
            int[][] dis = new int[I][I];
            Queue<Pair> q = new LinkedList<>();
            boolean flag = false;
            for(int i=1; i<=2; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                board[x][y] = i;
                if(dis[x][y] > 0) {
                    flag = true;
                    sb.append("0\n");
                    break;
                }

                if(i==1) {
                    dis[x][y] = 1;
                    q.offer(new Pair(x, y));
                }

            }

            while(!flag && !q.isEmpty()) {
                Pair cur = q.poll();
                for(int i=0; i<8; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];
                    if(nx < 0 || nx >= I || ny < 0 || ny >= I) continue;
                    if(dis[nx][ny] > 0) continue;
                    if(board[nx][ny] == 2) {
                        sb.append(dis[cur.x][cur.y]).append('\n');
                        flag = true;
                        break;
                    }
                    dis[nx][ny] = dis[cur.x][cur.y] + 1;
                    q.offer(new Pair(nx, ny));
                }
            }

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