package array;

import java.util.Scanner;

public class Array10811 {

    public static void main(String[] args) {
        // 바구니 뒤집기
        // 바구니 N개 1-N 번호 순서
        // M번 바구니의 순서를 역순으로

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] buckets = new int[n];

        for(int i=0; i < n; i++) {
            buckets[i] = i+1;
        }
        for(int i=0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            for(a = a-1, b= b-1; a < b; a++, b--) {
                int temp = buckets[a];
                buckets[a] = buckets[b];
                buckets[b] = temp;
            }
        }

        for(int num : buckets) {
            System.out.print(num + " ");
        }


    }

}
