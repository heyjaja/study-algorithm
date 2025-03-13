package basic.sort;

import java.util.Scanner;

public class InsertionSort {
    public int[] solution(int n, int[] arr) {
        // 배열의 2번째 인덱스부터 앞의 요소와 비교 후 자리 찾아
        // 중간에 삽입하고 뒷 요소들은 한 칸씩 뒤로 밀기
        for(int i=1; i<n; i++) {
            int temp = arr[i];
            int j;
            for(j=i-1; j>=0; j--) {
                if(temp < arr[j]) {
                    arr[j+1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j+1] = temp;
        }

        return arr;
    }

    public static void main(String[] args) {
        // 삽입정렬 오름차순
        InsertionSort main = new InsertionSort();
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
