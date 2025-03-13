package basic.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Tomato {

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean isInRange(int m, int n) {
            return x >= 0 && x < n && y >= 0 && y < m;
        }
    }

    private int BFS(int m, int n, int[][] box) {
        int answer = -1;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int[][] days = new int[n][m];

        Queue<Point> queue = new LinkedList<>();

        // 익은 토마토부터 시작 -> 익은 토마토를 큐에 넣는다.
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(box[i][j] == 1) {
                    queue.offer(new Point(i, j));
                }
            }
        }

        if(queue.isEmpty()) return -1;
        if(queue.size() == n*m) return 0;

        while(!queue.isEmpty()) {
            Point point = queue.poll();
            for(int j=0; j<dx.length; j++) {
                int nx = point.x + dx[j];
                int ny = point.y + dy[j];

                Point next = new Point(nx, ny);
                if(next.isInRange(m, n) && box[nx][ny] == 0) {
                    box[nx][ny] = 1;
                    queue.offer(next);
                    days[nx][ny] = days[point.x][point.y] + 1;
                }
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(box[i][j] == 0) return -1;
                answer = Math.max(answer, days[i][j]);
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        // 토마토
        // 안 익은 토마토는 인접한 익은 토마토의 영향을 받아 하루가 지나면 익는다.
        // 상자의 토마토가 모두 익는데 걸리는 최소 날짜
        // 상자의 크기 세로 M X 가로 N
        // 1은 익은 토마토, 0은 익지 않은 토마토, -1은 빈 칸
        // 처음부터 모두 익은 상태면 0, 모두 익지 못하면 -1 출력
        Tomato main = new Tomato();
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] box = new int[n][m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                box[i][j] = sc.nextInt();
            }
        }
        System.out.println(main.BFS(m, n, box));
    }

}
