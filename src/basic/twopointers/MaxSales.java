package basic.twopointers;

import java.util.Scanner;

public class MaxSales {
    public int solution(int n, int k, int[] arr) {
        // n = 10, k = 3
        // arr = 12 15 11 20 25 10 20 19 13 15
        // 12 15 11 더한 값을 먼저 answer(max)에 저장한 뒤
        // 다음 값(20)을 더하고 처음 값(12)를 빼주면
        // 다음 연속 3일 매출 15 11 20을 더한 값이 나온다.
        int answer;
        int sum = 0;
        for(int i=0; i<k; i++) {
            sum += arr[i];
        }
        answer = sum;
        for(int i=k; i<n; i++) {
            sum += (arr[i] - arr[i-k]);
            answer = Math.max(answer, sum);
        }

        return answer;
    }

    public static void main(String[] args) {
        // 최대 매출
        // N일 동안 연속된 K일의 최대 매출
        MaxSales main = new MaxSales();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print(main.solution(n, k, arr));
    }
}
