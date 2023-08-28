package array;

import java.util.Scanner;

public class GridMaxSum {

    public int solution(int n, int[][] arr) {
        int answer = 0;
        int sum1 , sum2, sum3 = 0, sum4 = 0;
        for(int i=0; i<n; i++) {
            sum1 = 0;
            sum2 = 0;
            for(int j=0; j<n; j++) {
                sum1 += arr[i][j]; // 가로
                sum2 += arr[j][i]; // 세로
            }

            answer = Math.max(answer, sum1);
            answer = Math.max(answer, sum2);

            sum3 += arr[i][i]; // 대긱석 \
            sum4 += arr[i][n-i-1]; // 대각선 /
        }

        answer = Math.max(answer, sum3);
        answer = Math.max(answer, sum4);

        return answer;
    }

    public static void main(String[] args) {
        // 격자판 최대합
        // n*n 격자판 가로, 세로, 대각선 합 중 가장 큰 값 출력
        GridMaxSum main = new GridMaxSum();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j=0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.print(main.solution(n, arr));
    }
}
