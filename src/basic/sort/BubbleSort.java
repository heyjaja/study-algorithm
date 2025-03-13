package basic.sort;

import java.util.Scanner;

public class BubbleSort {
    public int[] solution(int n, int[] arr) {
        // 바로 뒤랑 비교하여 자리 바꾸기
        // 맨 마지막 최댓값부터 정렬됨
        for(int i=0; i<n-1; i++) {
            for(int j=0; j<n-i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        // 버블정렬 오름차순
        BubbleSort main = new BubbleSort();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i : main.solution(n, arr)) {
            System.out.print(i + " ");
        }
    }
}
