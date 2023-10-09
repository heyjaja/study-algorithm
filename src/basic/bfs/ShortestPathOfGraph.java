package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ShortestPathOfGraph {
    static int n, m, answer = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] check;
    static int[] distance;

    public void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();
        check[v] = true;
        distance[v] = 0;
        queue.offer(v);
        while(!queue.isEmpty()) {
            int current = queue.poll();
            for(int next : graph.get(current)) {
                if(!check[next]) {
                    check[next] = true;
                    queue.offer(next);
                    distance[next] = distance[current] + 1;
                }
            }
        }
    }
    public static void main(String[] args) {
        // 그래프 최단거리(최단거리는 BFS)
        // 1번 정점에서 각 정점으로 가는 최소 이동 간선수
        // 배열에 거리를 저장
        ShortestPathOfGraph main = new ShortestPathOfGraph();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        graph = new ArrayList<>();
        for(int i=0; i<=m; i++) {
            graph.add(new ArrayList<>());
        }

        check = new boolean[n+1];
        distance = new int[n+1];
        for(int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph.get(a).add(b);
        }

        main.BFS(1);

        for(int i=2; i<=n; i++) {
            System.out.println(i+ ": "+distance[i]);
        }
    }
}
