package dp;

import java.util.Scanner;

public class Stones {

    public static void main(String[] args) {
        // 돌다리 건너기
        // N개의 돌로 만든 다리
        // 한번에 1~2칸 건너는 방법의 수
        Stones main = new Stones();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(main.solution(n));
    }

    private int solution(int n) {
        int answer = 0;

        // n개의 돌을 건너서 건너편으로 도착하는 것까지
        int[] dynamic = new int[n+2];
        dynamic[1] = 1;
        dynamic[2] = 2;

        for(int i=3; i<=n+1; i++) {
            dynamic[i] = dynamic[i-2] + dynamic[i-1];
        }

        answer = dynamic[n+1];

        return answer;
    }
}
