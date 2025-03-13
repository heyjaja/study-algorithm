package basic.array;

import java.util.ArrayList;
import java.util.Scanner;

public class PrimeNumberReverse {

    public boolean isPrime(int number) {
        if(number == 1) {
            return false;
        }

        for(int i=2; i < number; i++) {
            if(number%i == 0 ) {
                return false;
            }
        }
        return true;
    }
    public ArrayList<Integer> solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();

        for(int i=0; i<n; i++) {
//            int number = Integer.parseInt(new StringBuilder().append(arr[i]).reverse().toString());
            int number = reverse(arr[i]);
            if(isPrime(number)) {
                answer.add(number);
            }
        }

        return answer;
    }

    public int reverse(int number) {
        // res = 0
        // res = res * 10 + t
        // t = number % 10
        int temp = number;
        int result = 0;
        while(temp > 0) {
            int t = temp%10;
            result = result * 10 + t;
            temp = temp/10;
        }

        return result;

    }

    public static void main(String[] args) {
        // 주어진 숫자를 뒤집었을 때 소수면 출력
        // 9
        // 32 55 62 20 250 370 200 30 100 -> 23 2 73 2 3
        PrimeNumberReverse main = new PrimeNumberReverse();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i : main.solution(n, arr)) {
            System.out.print(i + " ");
        }
    }
}
