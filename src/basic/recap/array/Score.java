package basic.recap.array;

import java.util.Scanner;

public class Score {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(solution(arr));
    }

    private static int solution(int[] arr) {
        int answer = 0;

        int score = 0;
        for (int i : arr) {
            score = (i == 1) ? score + 1 : 0;
            answer += score;
        }
        return answer;
    }
}
