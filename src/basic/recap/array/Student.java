package basic.recap.array;

import java.util.Scanner;

public class Student {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(solution(arr));
    }

    private static int solution(int[] arr) {
        int answer = 1;

        int max = arr[0];
        for (int i : arr) {
            if(max < i) {
                answer++;
                max = i;
            }
        }
        return answer;
    }
}
