package barkingdog.array;

import java.util.Scanner;

public class Practice {
    public static void main(String[] args) {
        // 길이 n의 int 배열에서 합이 100인 서로 다른 위치의 두 원소가 존재하면 1, 존재하지 않으면 0
        // 0 < arr[i] <= 100, n <= 1000
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(func1(arr, n));
        System.out.println(func2(arr, n));
    }

    private static int func1(int[] arr, int n) {
        System.out.print("fuc1 = ");
        // O(N^2)의 풀이
        for(int i=0; i<n-1; i++) {
            for (int j=i+1; j < n; j++) {
                if(arr[i] + arr[j] == 100) {
                    return 1;
                }
            }
        }

        return 0;
    }

    private static int func2(int[] arr, int n) {
        System.out.print("fuc2 = ");
        // O(N)의 풀이
        // 각 수의 등장 여부를 판단하는 배열을 선언
        int[] occur = new int[101]; // 0 < arr[i] <= 100 -> 길이 101 배열
        for (int i = 0; i < n; i++) {
            if(occur[100-arr[i]] == 1) { // 현재 arr의 요소와 더해서 100이 되는 요소가 존재하는지 확인
                return 1; // 존재하면 1
            }
            occur[arr[i]] = 1; // 현재 arr의 요소 등장 여부를 저장
        }

        return 0;
    }
}
