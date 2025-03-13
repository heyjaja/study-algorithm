package basic.dfs;

import java.util.Scanner;

public class Combination {
    int[][] arr = new int[35][35];

    public int DFS(int n, int r) {
        if(arr[n][r] > 0) return arr[n][r];
        if(n == r || r == 0) {
            return 1;
        }
        arr[n][r] = DFS(n-1, r-1) + DFS(n-1, r);
        return arr[n][r];
    }

    public static void main(String[] args) {
        // 조합의 경우수(메모이제이션)
        // 자연수 n(3<=n<=33)과 r(0<=r<=n) 입력
        // nCr (n combination r): n 중 r개를 뽑는 경우의 수
        // nCr = n-1Cr-1 + n-1Cr
        Combination main = new Combination();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();

        System.out.println(main.DFS(n, r));
    }
}
