package basic.dfs;

import java.util.Scanner;

public class Island {

    private int solution(int n, int[][] board) {
        int answer = 0;

        // 처음부터 탐색하여 섬(1)을 찾아서 상하좌우대각선을 확인
        // 확인을 마치면 0으로 바꾸어 바다로 만들어 다시 확인하지 않도록
        // DFS 메서드를 호출하는 수가 섬의 개수
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == 1) {
                    board[i][j] = 0;
                    DFS(i, j, board);
                    answer++;
                }
             }
        }
        return answer;
    }

    private void DFS(int x, int y, int[][] board) {
        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

        for(int i=0; i<dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(check(nx, ny, board.length) && board[nx][ny] == 1) {
                board[nx][ny] = 0;
                DFS(nx, ny, board);
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
