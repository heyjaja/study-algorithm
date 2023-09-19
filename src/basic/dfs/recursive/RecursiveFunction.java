package dfs.recursive;

import java.util.Scanner;

public class RecursiveFunction {

    public void DFS(int n) {
        if(n == 0) return;
        // 재귀함수는 stack을 사용
        // DFS(3) | DFS(2) | DFS(1) | DFS(0)
        // DFS(0)에서 return을 만나면 1->2->3 순으로 출력
        DFS(n-1);
        System.out.print(n+" ");
    }

    public static void main(String[] args) {
        // 재귀함수
        // 1 ~ n까지 출력
        RecursiveFunction main = new RecursiveFunction();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        main.DFS(n);
    }
}
