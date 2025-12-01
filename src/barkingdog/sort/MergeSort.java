package barkingdog.sort;

public class MergeSort {
    static void mergeArray(int[] a, int[] b) {
        // 정렬된 2개 배열 합치기

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

    static int n = 10;
    static int[] arr = {15, 25, 22, 357, 16, 23, -53, 12, 46, 3};
    static int[] tmp = new int[arr.length]; // merge 함수에서 리스트 2개를 합친 결과를 임시로 저장하고 있을 변수

    // mid = (st+en)/2라고 할 때
    // arr[st:mid], arr[mid:en]은 이미 정렬이 되어있는 상태일 때 arr[st:mid]와 arr[mid:en]을 합친다.
    static void merge(int st, int en){
        int mid = (st+en)/2;

        int ap = st;
        int bp = mid;
        for(int i = st; i<en; i++) {
            if(bp == en) tmp[i] = arr[ap++];
            else if(ap == mid) tmp[i] = arr[bp++];
            else if(arr[ap] <= arr[bp]) tmp[i] = arr[ap++];
            else tmp[i] = arr[bp++];
        }

        for (int i = st; i < en; i++) {
            arr[i] = tmp[i];
        }
    }

    // arr[st:en]을 정렬하고 싶다.
    static void mergeSort(int st, int en){
        if(en == st+1) return; // 길이 1인 경우
        int mid = (st+en)/2;
        mergeSort(st, mid); // arr[st:mid]을 정렬한다.
        mergeSort(mid, en); // arr[mid:en]을 정렬한다.
        merge(st, en); // arr[st:mid]와 arr[mid:en]을 합친다.
    }

    public static void main(String[] args) {
        int[] a = {-9, 1, 6, 8, 12};
        int[] b = {-7, 7, 13, 15};

        mergeArray(a, b);
        System.out.println();
        mergeSort(0, n);

        for (int i : tmp) {
            System.out.print(i + " ");
        }
    }

}
