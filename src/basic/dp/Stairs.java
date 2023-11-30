package dp;

import java.util.Scanner;

public class Stairs {

    public static void main(String[] args) {
        // 계단오르기
        // 한번에 한 계단 또는 두 계단
        // N 계단을 올라갈 수 있는 경우의 수
        Stairs main = new Stairs();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(main.solution(n));
    }

    private int solution(int n) {
        // dp는 큰 문제를 작은 단위의 문제로 쪼개서 답을 구한다.
        int answer = 0;

        // n까지 각 계단을 오르는 경우의 수 저장
        int[] dynamic = new int[n+1];
        dynamic[1] = 1;
        dynamic[2] = 2;
        // dynamic[i] = 앞 두 계단을 오르는 경우의 수의 합
        // 피보나치 수열과 같음
        for(int i=3; i<=n; i++) {
            dynamic[i] = dynamic[i-2] + dynamic[i-1];
        }
        answer = dynamic[n];

        return answer;
    }
}
