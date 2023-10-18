package dfs;

import java.util.Scanner;

public class Permutation {
    static int[] pm;
    public void DFS(int n, int m, int level) {
        if(level == m) {
            for(int i : pm) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        for(int i=1; i<=n; i++) {
            pm[level] = i;
            DFS(n, m, level+1);
        }
    }

    public static void main(String[] args) {
        // 중복순열 구하기(DFS)
        // 1~N까지 번호가 적인 구슬
        // M번을 뽑아 일렬로 나열하는 방법(중복 가능)
        // 오름차순 출력
        Permutation main = new Permutation();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        pm = new int[m];

        main.DFS(n, m, 0);


    }
}
