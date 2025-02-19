package basic.recursive;

import java.util.Scanner;

public class Factorial {
    static int factorial(int n) {
        if(n <= 1) {
            return 1;
        }
        return n * factorial(n-1);
    }

    static int factorial2(int n) {
        int result = 1;

        while(n > 1) {
            result *= n--;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(factorial(n));
        System.out.println(factorial2(n));
    }
}
