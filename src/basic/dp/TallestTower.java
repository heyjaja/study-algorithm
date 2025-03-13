package basic.dp;

import java.util.Arrays;
import java.util.Scanner;

class Brick implements Comparable<Brick> {
    int area;
    int height;
    int weight;

    public Brick(int area, int height, int weight) {
        this.area = area;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Brick o) {
        return Integer.compare(o.area, area);
    }

    public boolean compareWeight(Brick brick) {
        return weight < brick.weight;
    }
}

public class TallestTower {
    public static void main(String[] args) {
        // 가장 높은 탑
        // 밑면이 정사각형인 직육면체 벽돌로 탑을 쌓는다.
        // 조건1: 벽돌의 옆면을 밑면으로 사용할 수 없다.
        // 조건2: 밑면의 넓이나 무게가 같은 벽돌은 없다.
        // 조건3: 벽돌들의 높이는 같을 수 있다.
        // 조건4: 밑면이 더 좁고 가벼운 벽돌을 위로 쌓아야 한다.
        // 벽돌의 수 N(<=100)개 넓이, 높이, 무게 순서로 주어진다.
        // 가장 높이 쌓을 수 있는 탑의 높이
        TallestTower main = new TallestTower();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Brick[] bricks = new Brick[n];

        for(int i=0; i<n; i++) {
            int area = sc.nextInt();
            int height = sc.nextInt();
            int weight = sc.nextInt();
            bricks[i] = new Brick(area, height, weight);
        }

        System.out.println(main.solution(n, bricks));
    }

    private int solution(int n, Brick[] bricks) {
        int answer = 0;
        int[] dynamic = new int[n];
        Arrays.sort(bricks);

        // 정렬을 하지 않으면 입력순으로 앞의 벽돌만 비교하게 된다.
        for(int i=0; i<n; i++) {
            dynamic[i] = bricks[i].height;
            for(int j=0; j<i; j++) {
                if(bricks[i].compareWeight(bricks[j])) {
                    dynamic[i] = Math.max(dynamic[j] + bricks[i].height, dynamic[i]);
                }
            }
            answer = Math.max(dynamic[i], answer);
        }
        return answer;
    }
}
