package basic.twopointers;

import java.util.Scanner;

public class MaxSubsequence {
    public int solution(int n, int k, int[] arr) {
        int answer = 0;
        int lt = 0, count = 0;
        for(int rt = 0; rt < n; rt++) {
            if(arr[rt] == 0) {
                // rt++? 0 -> 1
                count++;
            }

            while(count > k) {
                if(arr[lt] == 0) count--;
                // lt++? 1 -> 0
                lt++;
            }

            answer = Math.max(answer, (rt - lt + 1));
        }

        return answer;
    }

    public static void main(String[] args) {
        // 최대 길이 연속부분수열
        // 0과 1로 구성된 N 길이 수열
        // 최대 k번 0을 1로 변경하여 1로만 구성된 연속부분수열의 최대 길이
        MaxSubsequence main = new MaxSubsequence();
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
