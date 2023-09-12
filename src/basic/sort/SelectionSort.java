package sort;

import java.util.Scanner;

public class SelectionSort {
    public int[] solution(int n, int[] arr) {
        // 최솟값을 찾아 맨 앞으로
        for(int i=0; i<n; i++) {
            int index = i;
            for(int j=i+1; j<n; j++) {
                if(arr[index] > arr[j]) {
                    index = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }

        return arr;
    }

    public static void main(String[] args) {
        // 선택정렬 오름차순
        SelectionSort main = new SelectionSort();
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
