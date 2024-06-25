package recap.array;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(solution(n));
    }

    private static int solution(int n) {
        int answer = 0;
        boolean[] arr = new boolean[n+1];

        for(int i=2; i<=n; i++) {
            if(!arr[i]) {
                answer++;
                // 2의 배수 제외 - 3의 배수 제외 - 5의 배수 제외 ...
                for(int j=i; j<=n; j+=i) {
                    arr[j] = true;
                }
            }
        }

        return answer;
    }
}
