package dfs.recursive;

import java.util.Scanner;

public class Factorial {
    public int DFS(int n) {
        if(n == 1) return 1;
        return n * DFS(n-1);
    }

    public static void main(String[] args) {
        // 이진수 출력 - 재귀함수
        Factorial main = new Factorial();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(main.DFS(n));
    }
}
