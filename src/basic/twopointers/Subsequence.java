package basic.twopointers;

import java.util.Scanner;

public class Subsequence {
    public int solution(int n, int m, int[] arr) {
        int answer = 0;

        int p1 = 0, p2 = 0;
        int sum = arr[0];
        while(p2 < n) {
            if(sum == m) {
                answer++;
                sum -= arr[p1++];
            } else if (sum < m) {
                if(++p2 >= n) break;
                sum += arr[p2];
            } else {
                sum -= arr[p1++];
            }
        }

        return answer;
    }

    public int solution2(int n, int m, int[] arr) {
        int answer = 0;
        int sum = 0, p1 = 0;

        for(int p2=0; p2<n; p2++) {
            sum += arr[p2];
            if(sum == m) answer++;
            while(sum >= m) {
                sum -= arr[p1++];
                if(sum == m) answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        // 연속 부분수열
        // N개 숫자 연속 부분수열의 합이 특정숫자 M이 되는 경우의 수
        Subsequence main = new Subsequence();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print(main.solution(n, m, arr));
    }
}
