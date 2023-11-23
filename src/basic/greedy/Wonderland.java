package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Road implements Comparable<Road> {
    int cityA;
    int cityB;
    int cost;

    public Road(int cityA, int cityB, int cost) {
        this.cityA = cityA;
        this.cityB = cityB;
        this.cost = cost;
    }

    @Override
    public int compareTo(Road o) {
        if(cost < o.cost) {
            return -1;
        }

        if(cost > o.cost) {
            return 1;
        }

        return 0;
    }
}

public class Wonderland {

    int[] unf;

    public int find(int v) {
        if(v == unf[v]) return v;
        return unf[v] = find(unf[v]);
    }

    public int union(Road road) {
        int findA = find(road.cityA);
        int findB = find(road.cityB);
        if(findA != findB) {
            unf[findA] = findB;
            return road.cost;
        }
        return 0;
    }

    public int solution(int v, int[][] arr) {
        int answer = 0;

        ArrayList<Road> roads = new ArrayList<>();

        for(int i=0; i<arr.length; i++) {
            roads.add(new Road(arr[i][0], arr[i][1], arr[i][2]));
        }

        Collections.sort(roads);

        unf = new int[v+1];
        for(int i=1; i<=v; i++) {
            unf[i] = i;
        }

        for(Road road : roads) {
            answer += union(road);
        }

        return answer;
    }
    public static void main(String[] args) {
        // 원더랜드(최소스패닝트리: 크루스칼, Union&Find)
        // 최소스패닝트리: 그래프에서 모든 간선이 최소비용으로 연결된 트리
        // 모든 도시를 서로 연결하면서 최소의 유지비용이 들도록 도로 선택
        // 도시를 1~V로 표현, 연결된 도시와 유지비용 입력
        Wonderland main = new Wonderland();
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int e = sc.nextInt();

        int[][] arr = new int[e][3];

        for(int i=0; i<e; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            arr[i][2] = sc.nextInt();
        }

        System.out.println(main.solution(v, arr));
    }
}
