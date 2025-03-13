package basic.array;

import java.util.Scanner;

public class VisibleStudent {

    public int solution(int n, int[] arr) {
        int answer = 1;

        int max = arr[0];
        for(int i=1; i<n; i++) {
            if(max < arr[i]) {
                answer++;
                max = arr[i];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        // 보이는 학생
        // n명, 키가 주어지고 앞의 학생들보다 크면 보이는 학생
        // 4
        // 140 135 150 130 -> 2
        VisibleStudent main = new VisibleStudent();
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());

        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(sc.next());
        }

        System.out.print(main.solution(n, arr));
    }
}
