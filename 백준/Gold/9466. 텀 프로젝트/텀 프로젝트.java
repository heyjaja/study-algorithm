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
            if(vis[i] != 0) continue; // 이미 방문한 학생은 건너뛰기
            int cur = i;

            while(vis[cur] == 0) {
                vis[cur] = 1; // 현재 경로에서 방문 중 표시
                cur = students[cur]; // 다음 학생으로 이동
            }

            if(vis[cur] == 1) { // 사이클 발견 -> 현재 경로에서 방문한 노드를 다시 방문
                int start = cur; // 현재 탐색 학생 저장
                inTeam[cur] = true; // 현재 학생은 사이클 내에 있음 -> 팀이 됨
                cur = students[cur]; // 다음 학생으로

                while(cur  != start) { // 사이클을 돌면서 팀으로 만들기
                    inTeam[cur] = true;
                    cur = students[cur];
                }
            }

            cur = i; // 탐색 시작 학생으로 복귀
            while(vis[cur] == 1) { // 이번 경로에서 방문한 학생은 모두 방문 완료로 수정 -> 팀이 안된 학생 포함
                vis[cur] = 2;
                cur = students[cur];
            }
        }

        for (int i = 1; i <= n; i++) {
            if(!inTeam[i]) count++; // 사이클에 포함되지 않은 학생들은 팀이 안됨
        }

        return count;
    }
}
