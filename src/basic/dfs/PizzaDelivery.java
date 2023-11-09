package dfs;

import java.util.ArrayList;
import java.util.Scanner;

public class PizzaDelivery {

    class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getDistance(Point pizza) {
            return Math.abs(x - pizza.x) + Math.abs(y - pizza.y);
        }
    }

    int answer = Integer.MAX_VALUE;

    private int solution(int n, int m, int[][] city) {
        ArrayList<Point> houses = new ArrayList<>();
        ArrayList<Point> pizzas = new ArrayList<>();

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(city[i][j] == 1) {
                    houses.add(new Point(i, j));
                }
                if(city[i][j] == 2) {
                    pizzas.add(new Point(i, j));
                }
            }
        }

        Point[] comb = new Point[m];

        DFS(0, 0, comb, pizzas, houses);

        return answer;
    }

    private void DFS(int level, int start, Point[] comb, ArrayList<Point> pizzas, ArrayList<Point> houses) {
        if(level == comb.length) {
            // m개의 피자집 조합과 각 집의 피자 배달 거리 비교
            int sum = 0;
            for(Point house : houses) {
                int distance = Integer.MAX_VALUE;
                for(Point pizza : comb) {
                    // 피자 배달 거리가 가장 작은 값 구하기
                    distance = Math.min(distance, house.getDistance(pizza));
                }
                // 도시의 피자 배달 거리
                sum += distance;
            }
            // 조합 별 도시의 피자 배달 거리가 가장 작은 값 저장
            answer = Math.min(sum, answer);
            return;
        }

        // M개의 피자집 조합
        for(int i=start; i<pizzas.size(); i++) {
            comb[level] = pizzas.get(i);
            DFS(level + 1, i + 1, comb, pizzas, houses);
        }
    }

    public static void main(String[] args) {
        // 피자 배달 거리
        // N * N 크기의 도시 지도
        // 0: 빈칸, 1: 집, 2: 피자집
        // 피자 배달 거리: 각 "집"과 피자집들과의 거리 중 최소값
        // 피자 배달 거리 = |x1 - x2| + |y1 - y2|
        // 도시의 피자 배달 거리가 최소가 되는 M개의 피자집만 살리고 나머지는 폐업
        // 도시의 피자 배달 거리: 각 집들의 피자 배달 거리 합
        // 피자 배달 거리는 집을 기준으로 함
        // M개의 피자집을 선택했을 때 최소 도시의 피자 배달 거리 출력
        PizzaDelivery main = new PizzaDelivery();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] city = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                city[i][j] = sc.nextInt();
            }
        }

        System.out.println(main.solution(n, m, city));
    }

}
