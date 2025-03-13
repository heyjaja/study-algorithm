package basic.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
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
        return Integer.compare(cost, o.cost);
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

    public int kruskal(int v, int[][] arr) {
        int answer = 0;

        ArrayList<Road> roads = new ArrayList<>();

        for(int[] a : arr) {
            roads.add(new Road(a[0], a[1], a[2]));
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

        System.out.println(main.kruskal(v, arr));
        System.out.println(main.prim(v, arr));
    }

    private int prim(int v, int[][] arr) {
        // 프림 알고리즘
        int answer = 0;

        // 인접리스트
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        boolean[] check = new boolean[v+1];

        for(int i=0; i<=v; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] ints : arr) {
            int a = ints[0];
            int b = ints[1];
            int c = ints[2];
            // 인접리스트는 양방향으로
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        // 1번 정점부터 출발
        pq.offer(new Node(1, 0));

        while(!pq.isEmpty()) {
            Node current = pq.poll();
            int vertex = current.vertex;
            if(check[vertex]) {
                continue;
            }
            check[vertex] = true;
            answer += current.cost;
            for(Node node : graph.get(vertex)) {
                // 현재 노드에서 뻗어나가는 정점 중 아직 지나지 않은 정점
                if(!check[node.vertex]) {
                    pq.offer(new Node(node.vertex, node.cost));
                }
            }
        }
        return answer;
    }
}

class Node implements Comparable<Node> {
    int vertex;
    int cost;

    public Node(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(cost, o.cost);
    }

    @Override
    public String toString() {
        return "("+ vertex +", " + cost + ")";
    }
}
