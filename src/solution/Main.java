package solution;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/9466
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 테스트케이스

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine()); // 학생 수
            int[] students = new int[n+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                students[j] = Integer.parseInt(st.nextToken());
            }

            sb.append(dfs(n, students)).append('\n');
        }
        System.out.println(sb);
    }

    private static int dfs(int n, int[] students) {
        int[] vis = new int[n+1]; // 0: 미방문, 1: 탐색 중, 2: 방문 완료
        boolean[] inTeams = new boolean[n+1]; // 팀이 만들어진 학생
        for (int i = 1; i < n + 1; i++) {
            if(vis[i] == 2) continue;
            Stack<Integer> s = new Stack<>();
            vis[i] = 1;
            s.push(i);

            while(!s.isEmpty()) {
                int cur = s.pop();

                int nx = students[cur];
                if(vis[nx] == 1) {
                    // 사이클 -> 사이클에 속한 학생을 모두 inTeams에 표시
                }
            }
        }
        return 0;
    }
}
