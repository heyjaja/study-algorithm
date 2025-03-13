package doit.basic.recursive;

import java.util.Scanner;

public class EuclidGCD {

    static int gcd(int x, int y) {
        // 정수 x, y의 최대 공약수
        if(y == 0) {
            return x;
        } else {
            return gcd(y, x%y);
        }
    }

    static int gcd2(int x, int y) {
        // 재귀 사용 하지 않고
        while(y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }

        return x;
    }

    static int gcd3(int[] arr) {
        // 배열의 최대 공약수
        int a = arr[0];

        for(int i=0; i<arr.length - 1; i++) {
            a = gcd2(a, arr[i+1]);
        }

        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        System.out.println("gcd(x,y) = " + gcd(x, y));
        System.out.println("gcd2(x,y) = " + gcd2(x, y));

        int[] arr = new int[5];

        for(int i=0; i<5; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("gcd3(arr) = " + gcd3(arr));
    }
}
