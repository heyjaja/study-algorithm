package basic.sorting;

public class BubbleSort {

    public static void bubbleSort(int[] a, int n) {
        int count = 0;
        int swapCount = 0;
        for (int i = 0; i < n-1; i++) {
            for(int j = n-1; j > i; j--) {
                count++;
                if(a[j-1] > a[j]) {
                    swapCount++;
                    swap(a, j, j-1);
                }
            }
        }
        System.out.println("count = " + count);
        System.out.println("swapCount = " + swapCount);
    }

    public static void bubbleSortFromFirst(int[] a, int n) {
        int count = 0;
        int swapCount = 0;
        for (int i = 0; i < n-1; i++) {
            for(int j = i + 1; j < n; j++) {
                count++;
                if(a[j-1] > a[j]) {
                    swapCount++;
                    swap(a, j, j-1);
                }
            }
        }
        System.out.println("count = " + count);
        System.out.println("swapCount = " + swapCount);
    }

    private static void swap(int[] a, int idx1, int idx2) {
        int temp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = temp;
    }

    public static void main(String[] args) {
        int[] a = new int[]{6, 4, 3, 7, 1, 9, 8};
        bubbleSort(a, 7); // 작은 요소 부터 정렬
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();

        int[] b = new int[]{22, 5, 11, 32, 120, 68, 70};
        bubbleSortFromFirst(b, 7); // 큰 요소 부터 정렬
        for (int i : b) {
            System.out.print(i + " ");
        }
        System.out.println();

        int[] c = new int[]{1, 3, 4, 6, 7, 9, 8};
        bubbleSort2(c, 7); // 더이상 교환이 없을 때 중지
        for (int i : c) {
            System.out.print(i + " ");
        }
        System.out.println();

        int[] d = new int[]{1, 3, 4, 6, 7, 9, 8};
        bubbleSort3(d, 7); // 이미 정렬이 된 요소 저장 후 제외
        for (int i : d) {
            System.out.print(i + " ");
        }
        System.out.println();

        int[] e = new int[]{9, 1, 3, 4, 6, 7, 8};
        bubbleSort3(e, 7);
        for (int i : e) {
            System.out.print(i + " ");
        }
        System.out.println();

        int[] g = new int[]{9, 1, 3, 4, 6, 7, 8};
        shakerSort(g, 7); // 양방향 버블 정렬
        for (int i : g) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void bubbleSort2(int[] a, int n) {
        // 중간에 정렬을 마쳤을 때 중지
        int count = 0;
        int swapCount = 0;
        for (int i = 0; i < n-1; i++) {
            int exchange = 0; // 패스의 교환 횟수 기록
            for(int j = n-1; j > i; j--) {
                count++;
                if(a[j-1] > a[j]) {
                    exchange++;
                    swap(a, j, j-1);
                    swapCount++;
                }
            }
            if(exchange == 0) break;
        }
        System.out.println("count = " + count);
        System.out.println("swapCount = " + swapCount);
    }

    private static void bubbleSort3(int[] a, int n) {
        // 이미 정렬이 된 요소 제외
        int count = 0;
        int swapCount = 0;
        int k = 0; // a[k]보다 앞쪽은 정렬을 마친 상태(처음엔 첫 번째 요소)
        while(k < n - 1) {
            int last = n - 1; // 마지막으로 요소를 교환한 위치 저장(처음엔 마지막 요소)
            for(int j = n - 1; j>k; j--) {
                count++;
                if(a[j-1] > a[j]) {
                    swapCount++;
                    swap(a, j, j-1);
                    last = j; // 순서를 바꾼 오른쪽 요소의 인덱스 저장
                }
            }
            k = last;
        }
        System.out.println("count = " + count);
        System.out.println("swapCount = " + swapCount);
    }

    // 양방향 버블정렬(셰이커정렬)
    static void shakerSort(int[] a, int n) {
        // 양방향 버블 정렬(칵테일, 셰이커 정렬) - 홀수 번째 패스는 가장 작은 요소 부터, 짝수 번째 패스는 가장 큰 요소 부터 정렬하는 방식
        int left = 0; // 작은 요소 부터 정렬할 때 정렬된 마지막 위치
        int right = n - 1; // 큰 요소 부터 정렬할 때 정렬된 마지막 위치
        int last = 0; // 마지막으로 요소를 교환한 위치 변수(처음 값 중요x)
        int count = 0;
        int swapCount = 0;

        while (left < right) {
            // 홀수 번째 - 작은 요소를 맨 앞으로 옮기기
            for (int j = right; j > left; j--) {
                count++;
                if (a[j - 1] > a[j]) {
                    swapCount++;
                    swap(a, j - 1, j);
                    last = j;
                }
            }
            left = last;

            // 짝수 번째 - 큰 요소를 맨 뒤로 옮기기
            for (int j = left; j < right; j++) {
                count++;
                if (a[j] > a[j + 1]) {
                    swapCount++;
                    swap(a, j, j + 1);
                    last = j;
                }
            }
            right = last;
        }
        System.out.println("count = " + count);
        System.out.println("swapCount = " + swapCount);
    }
}
