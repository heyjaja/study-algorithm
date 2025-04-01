package barkingdog.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    // 너비 우선 탐색
    // 0,0부터 모든 파란색 칸에 방문하기
    // 파란색: 1, 빨간색: 0
    static int[][] board = {
            {1, 1, 1, 1, 1},
            {1, 0, 1, 1, 1},
            {0, 1, 0, 1, 0},
            {1, 1, 1, 1, 1},
            {0, 1, 1, 0, 1},
            {1, 0, 1, 0, 1}
    };
    static boolean[][] vis = new boolean[6][5]; // 방문 여부 저장

    static int n = 6, m = 5; // 열과 행의 개수
    static int[] dx = {1, 0, -1, 0}; // 아래부터 반시계방향
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Queue<Pair> queue = new LinkedList<>();
        vis[0][0] = true; // 시작점 방문 여부 표시 꼭!
        queue.offer(new Pair(0, 0));

        while(!queue.isEmpty()) {
            Pair cur = queue.poll();
            System.out.println(cur.x + ", " + cur.y); // 방문 순서
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || nx >=n || ny < 0 || ny >= m) continue; // 보드의 범위에 들어오는지 인덱스 값 확인
                if(vis[nx][ny] || board[nx][ny] != 1) continue; // 이미 방문을 했는지, 빨간색인지 여부 확인
                vis[nx][ny] = true; // 방문 여부 표시
                queue.offer(new Pair(nx, ny)); // 큐에 넣을 때 방문 여부를 표시!
            }
        }
    }
}

class Pair {
    int x; // 행
    int y; // 열

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
