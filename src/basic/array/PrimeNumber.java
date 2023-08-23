package array;

import java.util.Scanner;

public class PrimeNumber {
    public int solution(int n) {
        int answer = 0;
        int[] arr = new int[n+1];

        for(int i=2; i<=n; i++) {
            if(arr[i] == 0) {
                answer++;
                for(int j=i; j<=n; j=j+i) {
                    arr[j] = 1;
                }
            }
        }



        return answer;
    }

    public static void main(String[] args) {
        // 1~n까지 중에 소수
        // 에라토스테네스 체
        // n+1 크기의 배열을 만들어 index로 소수가 아닌 것을 체크하면서 소수 카운트
        PrimeNumber main = new PrimeNumber();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.print(main.solution(n));
    }
}
