package twopointers;

import array.Fibonacci;

import java.util.Scanner;

public class SumOfConsecutiveNumbers {

    public int solution(int n) {
        int answer = 0;

        int length = n/2 + 1;
        int[] arr = new int[length];

        for(int i = 0; i<length; i++) {
            arr[i] = i+1;
        }

        int lt = 0, rt = 0, sum = arr[0];
        while(rt < length) {
            if(sum == n) {
                answer++;
                sum -= arr[lt++];
            } else if(sum < n) {
                if(++rt >= length) break;
                sum += arr[rt];
            } else {
                sum -= arr[lt++];
            }
        }

        return answer;
    }

    public int solution2(int n) {
        int answer = 0;

        int length = n/2 + 1;
        int[] arr = new int[length];

        for(int i = 0; i<length; i++) {
            arr[i] = i+1;
        }

        int lt = 0, sum = 0;
        for(int rt = 0; rt<length; rt++) {
            sum += arr[rt];
            if(sum == n) answer++;
            while(sum >= n) {
                sum -= arr[lt++];
                if(sum == n) answer++;
            }
        }

        return answer;
    }

    public int solution3(int n) {
        // 수학으로 풀기
        // n = 15,
        // 2개 연속: 1+2
        // (15-(1+2)) = 12
        // 12/2 = 6
        // (1+6) + (2+6) = 15
        // 3개 연속: 1+2+3
        // (15 - (1+2+3)) = 9
        // 9/3 = 3
        // 1+3 + 2+3 + 3+3 = 15
        int answer = 0;
        int count = 1; // 연속된 자연수의 개수

        n--; // n - 1
        while(n > 0) {
            count++;
            n -= count; // n - 2 ...
            if(n%count == 0) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        // 연속된 자연수의 합
        // 2개 이상 연속된 자연수의 합이 N이 되는 경우의 수
        SumOfConsecutiveNumbers main = new SumOfConsecutiveNumbers();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(main.solution3(n));
    }
}
