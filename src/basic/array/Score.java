package array;

import java.util.Scanner;

public class Score {
    public int solution(int n, int[] arr) {
        int answer = 0;
        int score = 0;

        for(int i = 0; i<n; i++) {
            score = arr[i] == 1 ? score + 1 : 0;
            answer += score;
        }

        return answer;
    }

    public static void main(String[] args) {
        // OX 문제 점수 계산
        // 연속으로 정답이면 가산점
        // 5
        // 0 1 1 1 0 -> 6
        Score main = new Score();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print(main.solution(n, arr));
    }
}
