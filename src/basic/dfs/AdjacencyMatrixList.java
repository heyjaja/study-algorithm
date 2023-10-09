package dfs;

import java.util.ArrayList;
import java.util.Scanner;

public class AdjacencyMatrixList {
    static int n, m, answer = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] check;
    public void DFS(int v) {
        if(v == n) answer++;
        else {
            for(int next : graph.get(v)) {
                if(!check[next]) {
                    check[next] = true;
                    DFS(next);
                    check[next] = false;
                }
            }
        }
    }
    public static void main(String[] args) {
        // 경로탐색(인접리스트)
        // 1번 정점에서 N번 정점으로 가는 모든 경로의 가지 수 출력
        // 정점의 수 N, 간선의 수 M
        AdjacencyMatrixList main = new AdjacencyMatrixList();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            // 리스트 안에 리스트 객체 생성
            graph.add(new ArrayList<>());
        }
        // 방문한 노드 체크 배열
        check = new boolean[n+1];

        for(int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }
        check[1] = true;
        main.DFS(1);

        System.out.println(answer);
    }
}
