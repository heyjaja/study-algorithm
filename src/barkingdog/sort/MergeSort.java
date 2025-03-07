package barkingdog.sort;

public class MergeSort {
    static void merge_array() throws Exception {
        // 정렬된 2개 배열 합치기
        int[] a = {-9, 1, 6, 8, 12};
        int[] b = {-7, 7, 13, 15};

        int[] arr = new int[a.length + b.length];

        int ap = 0;
        int bp = 0;
        for(int i = 0; i<arr.length; i++) {
            if(bp >= b.length) arr[i] = a[ap++];
            else if(ap >= a.length) arr[i] = b[bp++];
            else if(a[ap] <= b[bp]) arr[i] = a[ap++];
            else arr[i] = b[bp++];
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }

    }
}
