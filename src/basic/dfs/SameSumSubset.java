package dfs;

import java.util.Scanner;

public class SameSumSubset {
    static String answer = "NO";
    static int n;
    static int total = 0;
    boolean flag = false;

    public void DFS(int level, int sum, int[] arr) {
        if(flag) return;
        if(sum > total/2) return;
        if(level == n) {
            if((total - sum) == sum) {
                answer = "YES";
                flag = true;
            }
        } else {
            // 현재 수를 포함
            DFS(level + 1, sum + arr[level], arr);
            // 미포함
            DFS(level + 1, sum, arr);
        }
    }

    public static void main(String[] args) {
        // 합이 같은 부분집합
        // N개의 원소로 구성된 자연수 집합을 두개의 부분집합으로 나누었을 때
        // 원소의 합이 서로 같으면 YES, 다르면 NO
        // 두 부분집합은 서로소 집합
        SameSumSubset main = new SameSumSubset();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
        }

        main.DFS(0, 0, arr);

        System.out.println(answer);
    }
}
