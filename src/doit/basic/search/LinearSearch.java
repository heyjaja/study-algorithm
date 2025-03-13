package doit.basic.search;

import java.util.Scanner;

public class LinearSearch {
    static int search(int[] a, int n, int key) {
        int i = 0;
        a[n] = key; // 요소가 없을 경우를 대비하여 배열의 마지막에 찾는 값을 넣는다.

        for (i = 0; i < n; i++) {
            if(a[i] == key) { // 요소가 없을 경우 배열의 마지막 값에서 반복문 종료
                break;
            }
        }

        return i == n ? -1 : i;
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
