package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge implements Comparable<Edge> {
    int vertex;
    int cost;

    public Edge(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        // 비용 오름차순
        if(cost < o.cost) {
            return 1;
        }

        if(cost > o.cost) {
            return -1;
        }
        return 0;
    }
}
public class DijkstraAlgorithm {
    private int[] solution(ArrayList<ArrayList<Edge>> graph, int start) {
        int[] distance = new int[graph.size()];
        // 거리비용을 일단 최대값으로 초기화
        Arrays.fill(distance, Integer.MAX_VALUE);

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        distance[start] = 0;

        while(!pq.isEmpty()) {
            // cost 값이 가장 작은 값부터 poll()
            Edge edge = pq.poll();
            int vertex = edge.vertex;
            int cost = edge.cost;

            // 기존 cost보다 현재 cost가 더 크면 의미 없음
            if(cost > distance[vertex]) continue;
            // 현재 정점과 연결된 정점들을 탐색
            for(Edge next : graph.get(vertex)) {
                int sumCost = cost + next.cost;
                // 현재 비용과 저장된 비용 비교 -> 최솟값 저장
                if(distance[next.vertex] > sumCost) {
                    distance[next.vertex] = sumCost;
                    pq.offer(new Edge(next.vertex, sumCost));
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        // 다익스트라 알고리즘(priority queue)
        // n개의 정점, m개의 간선
        // 정점, 연결된 정점, 비용
        // 1번 정점에서 각 정점으로 가는데 거리비용 출력
        DijkstraAlgorithm main = new DijkstraAlgorithm();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            graph.get(a).add(new Edge(b, c));
        }

        int[] distance = main.solution(graph, 1);

        for(int i=2; i<=n; i++) {
            String value = distance[i] == Integer.MAX_VALUE
                    ? "impossible" : distance[i] + "";

            System.out.println(i + ": "+value);
        }
    }
}
