package dfs.recursive;

import java.util.Scanner;

public class PrintBinary {
    public void DFS(int n) {
        if(n == 0) return;
        DFS(n/2);
        System.out.print(n % 2);
    }

    public static void main(String[] args) {
        // 이진수 출력 - 재귀함수
        PrintBinary main = new PrintBinary();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        main.DFS(n);
    }
}
