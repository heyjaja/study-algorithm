package beakjoon.math;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class MathQ {

    public static int snail(int d, int n, int v) {

        int day = (int)Math.ceil((double)(v - n)/(d - n));

        return day;
    }

    public static int primeNumber(int n, int[] arr) {
        int count = 0;
        int total = 0;
        for(int i=0; i<n; i++) {
            count = 0;
            int a = arr[i];
            if(a == 1) continue;
            for(int j=2; j<=a; j++) {
                if(a%j==0) {
                    count++;
                }
            }
            if(count == 1) {
                total++;
            }
        }

        return total;
    }

    public static int factorial(int n) {
        if(n <= 1) {
            return 1;
        }
        return n * factorial(n-1);
    }

    public static void main(String[] args) {
        System.out.println(snail(2, 1, 5));
        System.out.println(primeNumber(4, new int[] {1, 3, 5, 7}));
        System.out.println(factorial(0));
    }

}
