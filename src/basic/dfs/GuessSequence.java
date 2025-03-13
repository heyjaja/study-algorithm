package basic.dfs;

import java.util.Scanner;

public class GuessSequence {
    static int[] b, pm;
    static boolean[] check;
    int[][] dynamic = new int[35][35];
    boolean flag = false;

    private int combination(int n, int r) {
        if(dynamic[n][r] > 0) return dynamic[n][r];
        if(n == r || r == 0) return 1;

        return dynamic[n][r] = combination(n-1, r-1) + combination(n-1, r);
    }

    private void DFS(int level, int sum, int n, int f) {
        if(flag) return;
        if(level == n) {
            if(sum == f) {
                for(int i : pm) {
                    System.out.print(i+ " ");
                }
                flag = true;
            }
            return;
        }

        for(int i=1; i<=n; i++) {
            if(check[i]) continue;
            check[i] = true;
            pm[level] = i;
            DFS(level + 1, sum + (i*b[level]), n, f);
            check[i] = false;
        }

    }

    public static void main(String[] args) {
        // 수열 추측하기
        // 가장 윗줄에 1부터 N까지 숫자가 1개씩
        // 위의 두개를 더한 값이 저장
        // N과 가장 밑의 숫자 f가 주어질 때
        // 가장 윗줄에 있는 숫자를 구하기
        // 답이 여러가지일 경우 사전순으로 가장 앞에 오는 것 출력
        // 규칙: sum = 1 * n-1C0 + 2 * n-1C1 + ... + n * n-1Cn-1
        GuessSequence main = new GuessSequence();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int f = sc.nextInt();

        pm = new int[n];
        b = new int[n];
        check = new boolean[n+1];

        for(int i=0; i<n; i++) {
            b[i] = main.combination(n-1, i);
        }

        main.DFS(0, 0, n, f);
    }
}
