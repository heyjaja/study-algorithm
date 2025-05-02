package barkingdog.recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Recursion {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        printN(N);
        System.out.println("sum = " + sumN(N));
        System.out.println(func1(6, 100, 5)); // 6의 100 제곱은 int의 범위를 벗어나 답이 0으로 나옴(정답: 1)
        System.out.println(func2(6, 100, 5)); // 범위가 넓은 BigInteger 사용
    }

    private static void printN(int n) {
        if(n == 0) return; // base case, base condition
        System.out.println(n + " ");
        printN(n-1);
    }

    private static int sumN(int n) {
        if(n == 1) {
            return n;
        }
        return n + sumN(n-1);
    }

    private static int func1(int a, int b, int m) {
        // a^b를 m으로 나눈 나머지
        int val = 1;
        while(b-- > 0) val *= a;
        return val % m;
    }

    private static BigInteger func2(int a, int b, int m) {
        // a^b를 m으로 나눈 나머지 => a^b mod m
        BigInteger val = BigInteger.ONE;
        BigInteger aa = BigInteger.valueOf(a);
        BigInteger mm = BigInteger.valueOf(m);
        while(b-- > 0) val = val.multiply(aa).mod(mm);
        return val;
    }
}
