package basic.dfs;

import java.util.Scanner;

public class Maze {

    static int[] dx = {-1, 0, 1, 0}; // 상-우-하-좌
    static int[] dy = {0, 1, 0, -1};
    static int[][] maze;
    static int answer = 0;

    public void DFS(int x, int y) {
        if(x == 7 && y == 7) {
            answer++;
            return;
        }
        for(int i=0; i<4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(isInRange(nx, ny) && maze[nx][ny] == 0) {
                maze[nx][ny] = 1;
                DFS(nx, ny);
                maze[nx][ny] = 0;
            }
        }

    }

    public boolean isInRange(int nx, int ny){
        return nx >= 1 && nx <= 7 && ny >= 1 && ny <=7;
    }

    public static void main(String[] args) {
        // 미로 탐색
        // 7*7 격자판 미로를 탈출하는 경로 경우의 수
        // 출발점 (1,1) 도착점 (7,7)
        // 1: 벽, 0: 통로, 방향: 상하좌우
        Maze main = new Maze();
        Scanner sc = new Scanner(System.in);
        maze = new int[8][8];

        for(int i=1; i<=7; i++) {
            for(int j=1; j<=7; j++) {
                maze[i][j] = sc.nextInt();
            }
        }

        maze[1][1] = 1;
        main.DFS(1, 1);
        System.out.println(answer);
    }
}
