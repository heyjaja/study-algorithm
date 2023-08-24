package array;

import java.util.Scanner;

public class GetRank {
    public int[] solution(int n, int[] arr) {
        int[] answer = new int[n];

        for(int i = 0; i<n; i++) {
            answer[i] = 1;
            for(int j = 0; j<n; j++) {
                if(arr[i] < arr[j]) {
                    answer[i]++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        // 등수 구하기
        // N명 점수 -> 순서대로 등수 출력, 같은 점수는 같은 등수
        // 5
        // 87 89 92 100 76 -> 4 3 2 1 5
        GetRank main = new GetRank();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i : main.solution(n, arr)) {
            System.out.print(i + " ");
        }
    }
}
