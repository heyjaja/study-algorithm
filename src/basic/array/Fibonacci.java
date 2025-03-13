package basic.array;

import java.util.Scanner;

public class Fibonacci {

    public int[] solution(int n) {
        int[] answer = new int[n];

        answer[0] = 1;
        answer[1] = 1;

        for(int i=2; i<n; i++) {
            answer[i] = answer[i-2] + answer[i-1];
        }

        return answer;
    }

    public void solution2(int n) {
        int a = 1, b = 1, c;
        System.out.print(a + " " + b + " ");
        for(int i=2; i<n; i++) {
            c = a+b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
    }

    public static void main(String[] args) {
        // 피보나치 수열 n개
        Fibonacci main = new Fibonacci();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i : main.solution(n)) {
            System.out.print(i + " ");
        }
        System.out.println();
        main.solution2(n);
    }
}
