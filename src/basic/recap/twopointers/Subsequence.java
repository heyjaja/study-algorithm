package recap.twopointers;

import java.util.Scanner;

public class Subsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(solution(m, arr));
    }

    private static int solution(int m, int[] arr) {
        int answer = 0;

        int lt = 0;
        int rt = 0;

        int sum = 0;

        while(rt <= arr.length) {
            if(sum < m) {
                if(rt >= arr.length) break;
                sum += arr[rt++];
            } else if(sum > m) {
                sum -= arr[lt++];
            } else {
                answer++;
                sum -= arr[lt++];
            }
        }


        return answer;
    }
}
