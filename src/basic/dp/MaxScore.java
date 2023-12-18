package dp;

import java.util.Scanner;

public class MaxScore {

    public static void main(String[] args) {
        // 최대점수 구하기
        // 제한시간 M, N개의 문제, 최대 점수
        // n, m, (점수, 시간)
        MaxScore main = new MaxScore();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n][2];

        for(int i=0; i<n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[i][0] = a;
            arr[i][1] = b;
        }

        System.out.println(main.solution(n, m, arr));
    }

    private int solution(int n, int m, int[][] arr) {
        int[] dynamic = new int[m+1];

        // dynamic[j] = 해당 시간 최대 점수
        for(int i=0; i<n; i++) {
            int score = arr[i][0];
            int time = arr[i][1];
            for(int j=m; j>=time; j--) {
                // 뒤에서부터 탐색을 해야 문제가 한번만 적용
                dynamic[j] = Math.max(dynamic[j], dynamic[j-time] + score);
            }
        }

        return dynamic[m];
    }
}
