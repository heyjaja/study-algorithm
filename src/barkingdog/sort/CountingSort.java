package barkingdog.sort;

public class CountingSort {
    static final int n = 10; // 수의 범위 0~10

    static void countingSort(int[] arr) {
        // 수의 범위만큼 배열을 생성하여 나온 수를 count -> 차례대로 나온 숫자만큼 출력
        int[] count = new int[n+1];

        for (int i : arr) {
            count[i]++;
        }

        for (int i = 0; i < count.length; i++) {
            while(count[i]-- > 0) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 1, 2, 6, 2, 6, 10, 1, 5, 4, 8};

        countingSort(arr);
    }
}
