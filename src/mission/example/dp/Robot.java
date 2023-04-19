package example.dp;


import java.util.ArrayList;

public class Robot {
    public ArrayList<Point> findPath(boolean[][] grid) {
        // grid -> false 아무것도 없는 칸, true 막힌 칸
        // null check
        if(grid == null || grid.length==0) return null;

        ArrayList<Point> path = new ArrayList<>();

        // 재귀함수 호출 grid, 시작 포인트(도착점), 돌아올 때 경로를 저장할 array
        if(findPath(grid, grid.length - 1, grid[0].length - 1, path)) {
            return path;
        } else {
            return null;
        }


    }

    private boolean findPath(boolean[][] grid, int row, int col, ArrayList<Point> path) {
        // 해당 포인트가 grid 안에 있는지 || 막혀있는 칸(true)인지 확인
        if(!isInRange(grid, row, col) || grid[row][col]) return false;

        // or 연산자로 도착점인지, 왼쪽으로 이동했을 때 막혀있으면 위로 이동해서 막혀있는지 확인하기
        if((row == 0 && col == 0) ||
            findPath(grid, row, col - 1, path) ||
            findPath(grid, row - 1, col, path)) {
            // 이것 중 하나가 true를 반환하면 현재 경로를 저장
            Point p = new Point(row, col);
            path.add(p);
            return true;
        }

        return false;
    }

    private boolean isInRange(boolean[][] grid, int row, int col) {
        return row >= 0 && row <= grid.length - 1
            && col >= 0 && col <= grid.length - 1;
    }


    public static void main(String[] args) {
        boolean[][] grid = {
            {false, false, false, false},
            {false, false, false, true},
            {true, true, false, false},
            {false, false, false, false}
        };

        Robot robot = new Robot();

        ArrayList<Point> path = robot.findPath(grid);

        if(path != null) {
            for(Point p : path) {
                System.out.print(p.row + "" + p.col + " -> ");
            }
        }
    }
}