package basic.dfs;

import java.util.Scanner;

public class AdjacencyMatrix {
    static int n, m, answer = 0;
    static int[][] graph;
    static boolean[] check;
    public void DFS(int v) {
        // n번에 도착하면 경우의 수(answer) + 1
        if(v == n) {
            answer++;
        } else {
            for(int i=1; i<=n; i++) {
                // 현재 노드가 갈 수 있는 노드를 모두 탐색
                if(graph[v][i] == 1 && !check[i]) {
                    check[i] = true;
                    DFS(i);
                    // 탐색 후에 돌아오면 check 풀어주기
                    check[i] = false;
                }
            }
        }

    }
    public static void main(String[] args) {
        // 경로탐색(인접행렬)
        // 1번 정점에서 N번 정점으로 가는 모든 경로의 가지 수 출력
        // 정점의 수 N, 간선의 수 M
        AdjacencyMatrix main = new AdjacencyMatrix();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new int[n+1][n+1];
        // 방문한 노드 체크 배열
        check = new boolean[n+1];

        for(int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
        }
        check[1] = true;
        main.DFS(1);

        System.out.println(answer);
    }
}
