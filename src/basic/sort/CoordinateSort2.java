package sort;

import java.util.Arrays;
import java.util.Scanner;

class Point implements Comparable<Point> {
    public int x;
    public int y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if(this.x == o.x) {
            if(this.y > o.y) return 1;
            if(this.y < o.y) return -1;
        }

        if(this.x > o.x) return 1;
        if(this.x < o.x) return -1;

        return 0;
    }
}
public class CoordinateSort2 {
    public static void main(String[] args) {
        // 좌표정렬
        // 모든 좌표를 오름차순으로 정렬
        CoordinateSort2 main = new CoordinateSort2();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Point[] arr = new Point[n];

        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr[i] = new Point(x, y);
        }

        Arrays.sort(arr);
        for(Point p : arr) {
            System.out.println(p.x + " " + p.y);
        }

    }
}
