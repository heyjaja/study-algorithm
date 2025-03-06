package basic.sorting;

public class InsertionSort {

    public static void main(String[] args) {
        int[] a = new int[]{6, 4, 3, 7, 1, 9, 8};
        insertionSort(a);
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();

        int[] b = new int[]{0, 6, 4, 3, 7, 1, 9, 8};
        insertionSort2(b);
        for (int i = 1; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println();

        int[] c = new int[]{6, 4, 3, 7, 1, 9, 8};
        insertionSort3(c);
        for (int i : c) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static void insertionSort(int[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) { // 두 번째 요소부터 시작
            int j = i;
            int temp = a[i];
            for (; j > 0 && a[j-1] > temp; j--) { // 조건을 만족할 때
                a[j] = a[j-1]; // 왼쪽의 요소와 교환
            }
            a[j] = temp;
        }
    }

    static void insertionSort2(int[] a) {
        // 삽입 조건 줄이기
        int n = a.length;

        for (int i = 2; i < n; i++) { // 두 번째 요소부터 시작
            int j = i;
            int temp = a[0] = a[i];
            for (; a[j-1] > temp; j--) { // 조건을 만족할 때
                a[j] = a[j-1]; // 왼쪽의 요소와 교환
            }
            a[j] = temp;
        }
    }

    static void insertionSort3(int[] a) {
        // 이미 정렬된 부분에서 이진 검색을 사용하여 삽입할 위치 찾기
        int n = a.length;

        for (int i = 1; i < n; i++) { // 두 번째 요소부터 시작
            int key = a[i];
            int index = binarySearch(a, i-1, key); // 삽입할 요소가 들어갈 위치

            for (int j = i; j > index; j--) { // 삽입할 인덱스의 근접 요소 이동
                a[j] = a[j-1]; // 왼쪽의 요소와 교환
            }
            a[index] = key; // 값 삽입
        }

    }

    static int binarySearch(int[] a, int pr, int key) {
        int pl = 0, pc;

        while(pl <= pr) {
            pc = (pl+pr)/2;

            if(a[pc] < key) {
                pl = pc + 1;
            } else if (a[pc] > key) {
                pr = pc - 1;
            } else { // 동일한 값이 있는 경우 + 1
                return pc + 1;
            }
        }

        return pr + 1; // 찾는 요소가 없는 경우
    }
}
