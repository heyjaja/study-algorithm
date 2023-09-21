package dfs;

import java.util.Scanner;

public class Subset {
    static int n;
    static boolean[] ch;
    public void DFS(int L) {
        if(L == n+1) {
            StringBuilder sb = new StringBuilder();
            for(int i=1; i<ch.length; i++) {
                if(ch[i]) {
                    sb.append(i+ " ");
                }
            }
            // 공집합 제외
            if(sb.length() > 0) {
                System.out.println(sb);
            }
            return;
        }
        ch[L] = true;
        DFS(L+1); // 왼쪽 사용o
        ch[L] = false;
        DFS(L+1); // 오른쪽 사용x
    }

    public static void main(String[] args) {
        // 부분집합 구하기
        // 1 ~ N까지 원소를 갖는 집합의 부분집합을 모두 출력
        Subset main = new Subset();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ch = new boolean[n+1];
        main.DFS(1);
    }
}
