import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
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
        int[] vis = new int[n+1]; // 0: 미방문, 1: 방문 중, 2: 방문 완료
        boolean[] inTeam = new boolean[n+1];
        int count = 0;
        for (int i = 1; i < n + 1; i++) {
            if(vis[i] != 0) continue;
            int cur = i;

            // 이번 방문에서 지나간 학생에 도달한 경우
            while(vis[cur] == 0) {
                vis[cur] = 1;
                cur = students[cur];
            }

            if(vis[cur] == 1) {
                int start = cur;
                inTeam[cur] = true;
                cur = students[cur];

                while(cur  != start) {
                    inTeam[cur] = true;
                    cur = students[cur];
                }
            }

            cur = i;
            while(vis[cur] == 1) {
                vis[cur] = 2;
                cur = students[cur];
            }
        }

        for (int i = 1; i <= n; i++) {
            if(!inTeam[i]) count++;
        }

        return count;
    }
}