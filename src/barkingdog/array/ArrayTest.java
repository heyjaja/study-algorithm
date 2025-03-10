package barkingdog.array;

public class ArrayTest {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 0, 0, 0, 0, 0, 0, 0};
        int len = 3;
        insert(3, 40, arr, len++); // 10 20 30 40
        printArr(arr, len);
        insert(1, 50, arr, len++); // 10 50 20 30 40
        printArr(arr, len);
        insert(0, 15, arr, len++); // 15 10 50 20 30 40
        printArr(arr, len);

        int[] arr2 = {10, 50, 40, 30, 70, 20, 0, 0, 0, 0};
        int len2 = 6;
        erase(4, arr2, len2--); // 10 50 40 30 20
        printArr(arr2, len2);
        erase(1, arr2, len2--); // 10 40 30 20
        printArr(arr2, len2);
        erase(3, arr2, len2--); // 10 40 30
        printArr(arr2, len2);
    }

    private static void erase(int idx, int[] arr, int len) {
        // 배열의 중간 요소 삭제
        // 인덱스 오른쪽 요소부터 요소를 왼쪽으로 한 칸씩 이동
        for(int i=idx; i<len; i++) {
            arr[i] = arr[i+1];
        }
    }

    private static void printArr(int[] arr, int len) {
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static void insert(int idx, int n, int[] arr, int len) {
        // 배열 중간에 요소를 추가
        // 마지막 요소부터 오른쪽으로 한 칸씩 이동
        // 중간 요소부터 이동하면 데이터가 덮어쓰기 됨
        for(int i = len; i > idx; i--) {
            arr[i] = arr[i-1];
        }
        arr[idx] = n;
    }

}
