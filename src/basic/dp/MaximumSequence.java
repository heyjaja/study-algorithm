package basic.dp;

import java.util.Scanner;

public class MaximumSequence {

    public static void main(String[] args) {
        // 최대 부분 증가수열
        // N개의 자연수로 이루어진 수열
        // 2, 7, 5, 8, 6, 4, 7, 12, 3
        // 2, 5, 6, 7, 12 최대 길이 5인 부분 증가수열
        MaximumSequence main = new MaximumSequence();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(main.solution(n, arr));
    }

    private int solution(int n, int[] arr) {
        int answer = 0;
        int[] dynamic = new int[n];

        // dynamic[i] = arr[i]를 마지막 항으로 하는 최대 증가수열의 길이
        for(int i=0; i<n; i++) {
            dynamic[i] = 1;
            for(int j=0; j < i; j++) {
                if(arr[i] > arr[j]) {
                    // dynamic[i]: arr[i]보다 작은 수의 증가수열 길이 + 1
                    dynamic[i] = Math.max(dynamic[j] + 1, dynamic[i]);
                }
            }
            answer = Math.max(dynamic[i], answer);
        }

        return answer;
    }
}
