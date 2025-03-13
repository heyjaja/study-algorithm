package basic.dfs;

import java.util.Scanner;

public class FindCombination {
    static int[] combination;

    private void DFS(int level, int start, int n, int m) {
        if(level == m) {
            for(int i : combination) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        // 1 > 2,3,4 / 2 > 3,4 / 3 > 4
        for(int i=start; i<=n; i++) {
            combination[level] = i;
            DFS(level+1, i+1, n, m);
        }
    }
    public static void main(String[] args) {
        // 조합 구하기
        // 1~N까지 번호가 적힌 구슬 중 M개를 뽑는 방법의 수
        FindCombination main = new FindCombination();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        combination = new int[m];
        main.DFS(0, 1, n, m);

    }

}
