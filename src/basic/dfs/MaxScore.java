package dfs;

import java.util.Scanner;

public class MaxScore {
    static int n, m;
    static int answer = 0;


    public void DFS(int index, int sum, int time, int[][] arr) {
        if(time > m) {
            return;
        }
        if(index == n) {
            answer = Math.max(answer, sum);
        } else {
            DFS(index + 1, sum + arr[index][0], time + arr[index][1], arr);
            DFS(index + 1, sum, time, arr);
        }
    }
    public static void main(String[] args) {
        // 최대점수 구하기(DFS) - 부분집합
        // 제한시간 M 안에 N개의 문제 중 최대 점수 얻기
        // M, N, 점수-시간
        MaxScore main = new MaxScore();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        int[][] arr = new int[n][2];

        for(int i=0; i<n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[i][0] = a;
            arr[i][1] = b;
        }

        main.DFS(0, 0, 0, arr);

        System.out.println(answer);
    }
}
