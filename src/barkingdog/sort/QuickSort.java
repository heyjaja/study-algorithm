package barkingdog.sort;

public class QuickSort {

    static int n = 10;
    static int[] arr = {15, 25, 22, 357, 16, 23, -53, 12, 46, 3};

    static void quickSort(int st, int en) { // arr[st to en-1]을 정렬
        if(en <= st+1) return; // 수열의 길이가 1 이하이면 함수 종료
        int pivot = arr[st]; // 제일 앞의 것을 pivot으로 잡는다. 임의의 값을 잡고 arr[st]와 swap해도 상관없음.
        int l = st + 1;
        int r = en - 1;

        while(true) {
            if(l <= r && arr[l] <= pivot) l++;
            if(l <= r && arr[r] > pivot) r--;
            if(l > r) break; // l과 r이 역전되는 즉시 탈출
            swap(l, r, arr);
        }
        swap(st, r, arr);

        quickSort(st, r);
        quickSort(r + 1, en);
    }

    static void swap(int i, int j, int[] a) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        quickSort(0, n);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
