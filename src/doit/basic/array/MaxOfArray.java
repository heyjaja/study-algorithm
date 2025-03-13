package doit.basic.array;

import java.util.Random;
import java.util.Scanner;

class MaxOfArray {

    static int maxOf(int[] a) {
        int max = a[0];
        for(int i = 1; i < a.length; i++) {
            if(a[i] > max) {
                max = a[i];
            }
        }

        return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("사람 수: ");
        int n = sc.nextInt();

        int[] a = new int[n];

        for(int i = 0; i < n; i++) {
            a[i] = 100 + (new Random()).nextInt(100); // nextInt(n)의 반환값은 0 ~ n-1
            System.out.println("a[" + i + "]: "+ a[i]);
        }

        System.out.println("가장 큰 키는 " + maxOf(a));
    }
}
