package basic.dfs;

import java.util.Scanner;

public class Permutation {
    static int[] pm;
    static boolean[] check;

    public static void main(String[] args) {
        // 순열 구하기
        // N개의 자연수로 M 길이의 순열 구하기(중복x)
        Permutation main = new Permutation();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        pm = new int[m];
        check = new boolean[n];

        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        main.DFS(0, n, m, arr);

    }

    private void DFS(int level, int n, int m, int[] arr) {
        if(level == m) {
            for(int i : pm) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        for(int i=0; i<n; i++) {
            // arr[i] 사용 여부 체크
            if(check[i]) {
                continue;
            }
            pm[level] = arr[i];
            check[i] = true;
            DFS(level + 1, n, m, arr);
            check[i] = false;
        }
    }
}
