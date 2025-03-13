package basic.sort;

import java.util.Arrays;
import java.util.Scanner;

public class DuplicationCheck {
    public char solution(int n, int[] arr) {
        char answer = 'U';

        Arrays.sort(arr);

        for(int i=0; i<n-1; i++) {
            if(arr[i] == arr[i+1]) {
                return 'D';
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        // 중복 확인
        // 중복이 존재하면 D, 아니면 U
        DuplicationCheck main = new DuplicationCheck();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(main.solution(n, arr));
    }
}
