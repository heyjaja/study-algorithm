package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Island {

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private int solution(int n, int[][] board) {
        int answer = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == 1) {
                    board[i][j] = 0;
                    BFS(i, j, board);
                    answer++;
                }
             }
        }
        return answer;
    }

    private void BFS(int x, int y, int[][] board) {
        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));

        while(!queue.isEmpty()) {
            Point point = queue.poll();
            for(int i=0; i<dx.length; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];
                if(check(nx, ny, board.length) && board[nx][ny] == 1) {
                    board[nx][ny] = 0;
                    queue.offer(new Point(nx, ny));
                }
            }
        }
    }

    private boolean check(int nx, int ny, int n) {
        return nx >= 0 && nx < n && ny >= 0 && ny < n;
    }

    public static void main(String[] args) {
        // 섬나라 아일랜드
        // N * N 지도가 격자판으로
        // 섬은 1, 상하좌우 대각선으로 연결
        // 0은 바다
        // 몇개의 섬이 있는지 구하라
        Island main = new Island();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] board = new int[n][n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        System.out.println(main.solution(n, board));
    }

}
