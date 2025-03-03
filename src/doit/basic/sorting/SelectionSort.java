package basic.sorting;

public class SelectionSort {
    static void selectionSort(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            int min = i; // 아직 정렬 되지 않은 부분에서 가장 작은 요소의 인덱스
            for (int j = i + 1; j < n; j++) {
                if(a[j] < a[min]) {
                    min = j; // 가장 작은 요소의 인덱스 찾기
                }
            }
            swap(a, i, min); // 첫 요소와 가장 작은 요소 교환
        }
    }
    private static void swap(int[] a, int idx1, int idx2) {
        int temp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = temp;
    }

    public static void main(String[] args) {
        int[] a = new int[]{6, 4, 3, 7, 1, 9, 8};
        selectionSort(a, 7);
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
