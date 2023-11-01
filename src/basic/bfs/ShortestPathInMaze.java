package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ShortestPathInMaze {
    class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public boolean isInRange(int n) {
            return x > 0 && x < n && y > 0 && y < n;
        }

        public boolean isGoal(int n) {
            return x == n-1 && y == n-1;
        }
    }

    public int BFS(int[][] maze, int[][] distance) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(1, 1));
        maze[1][1] = 1;

        while(!queue.isEmpty()) {
            Point point = queue.poll();
            for(int j=0; j<dx.length; j++) {
                int nx = point.x + dx[j];
                int ny = point.y + dy[j];
                Point next = new Point(nx, ny);
                if(next.isGoal(maze.length)) {
                    return distance[point.x][point.y] + 1;
                }
                if(next.isInRange(maze.length) && maze[nx][ny] == 0) {
                    maze[nx][ny] = 1;
                    queue.offer(next);
                    distance[nx][ny] = distance[point.x][point.y] + 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        // 미로의 최단거리 통로(BFS)
        ShortestPathInMaze main = new ShortestPathInMaze();
        Scanner sc = new Scanner(System.in);

        int [][] maze = new int[8][8];
        int[][] distance = new int[8][8];

        for(int i=1; i<=7; i++) {
            for(int j=1; j<=7; j++) {
                maze[i][j] = sc.nextInt();
            }
        }

        System.out.println(main.BFS(maze, distance));


    }
}
