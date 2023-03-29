package basic.array;

import java.util.Scanner;

class ArrayEqual {

    static boolean equals(int[] a, int[] b) {
        if(a.length != b.length) {
            return false;
        }

        for(int i = 0; i < a.length; i++) {
            if(a[i] != b[i]) {
                return false;
            }
        }

        return true;

    }

    static void copy(int[] a, int[] b) {
        // 배열 b의 모든 요소를 배열 a에 복사
        int n = (a.length <= b.length ? a.length : b.length);
        for(int i = 0; i < n; i++) {
            a[i] = b[i];
        }
    }

    static void rcopy(int[] a, int[] b) {
        // 배열 b의 모든 요소를 배열 a에 역순으로 복사
        int n = (a.length <= b.length ? a.length : b.length);
        for(int i = 0; i < n; i++) {
            a[i] = b[b.length - i - 1];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("a 배열의 길이 = ");
        int n = sc.nextInt();

        int[] a = new int[n];

        for(int i = 0; i < n; i++) {
            System.out.print("a 배열의 "+i+"번째 요소 = ");
            a[i] = sc.nextInt();
        }

        System.out.print("b 배열의 길이 = ");
        int m = sc.nextInt();

        int[] b = new int[m];

        for(int i = 0; i < m; i++) {
            System.out.print("b 배열의 "+i+"번째 요소 = ");
            b[i] = sc.nextInt();
        }

        System.out.println("두 배열은 " + (equals(a, b) ? "같습니다." : "같지 않습니다."));


    }
}
