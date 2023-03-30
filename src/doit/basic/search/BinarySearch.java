package basic.search;

import java.util.Scanner;

public class BinarySearch {

    static int search(int[] a, int n, int key) {
        int start = 0;
        int end = n - 1;

        while(start <= end) {
            int mid = (start + end)/2;

            if(key == a[mid]) {
                return mid;
            }

            if(a[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }

        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 배열의 길이, 배열의 값, 찾을 숫자 입력
        int n = sc.nextInt();

        int[] a = new int[n+1];

        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int key = sc.nextInt();

        int idx = search(a, n, key);

        if (idx > 0) {
            System.out.println(key + ": 배열의 인덱스 " + idx + "에 있습니다.");
        } else {
            System.out.println(key + ": 존재하지 않습니다.");
        }

    }
}
