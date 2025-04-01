package barkingdog.dfs;

import java.util.Stack;

public class DFS {
    // DFS는 스택을 써서 다타원 배열의 순회를 처리하는 알고리즘
    // 깊이 우선 탐색
    public static void main(String[] args) {
        // 0,0부터 모든 파란색 칸에 방문하기
        // 파란색: 1, 빨간색: 0
        int[][] board = {
                {1, 1, 1, 1, 1},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 1, 1, 0, 1},
                {1, 0, 1, 0, 1}
        };

        boolean[][] vis = new boolean[6][5];
        int n = 6, m = 5;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        Stack<Pair> s = new Stack<>();
        vis[0][0] = true;
        s.push(new Pair(0,0));

        while(!s.isEmpty()) {
            Pair cur = s.pop();
            System.out.println(cur.x + ", " + cur.y);
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(vis[nx][ny] || board[nx][ny] != 1) continue;
                vis[nx][ny] = true;
                s.push(new Pair(nx, ny));
            }
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
