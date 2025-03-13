package doit.basic.search;

public class SearchIndex {
    public static void main(String[] args) {
        int[] a = {1, 9, 2, 9, 4, 6, 7, 9};
        int[] idx = new int[8];
        System.out.println(searchIndex(a, 8, 9, idx));

        int[] b = {1, 3, 5, 7, 7, 7, 7, 8, 8, 9, 9};
        System.out.println(binSearchX(b, 11, 9));
    }

    // 배열 idx에 key와 일치하는 인덱스를 저장하고 개수 반환
    static int searchIndex(int[] a, int n, int key, int[] idx) {
        int count = 0;
        for(int i = 0; i<n; i++) {
            if(a[i] == key) {
                idx[count++] = i;
            }
        }

        return count;
    }

    // 이진 검색 알고리즘에서 같은 값을 갖는 요소가 하나 이상일 경우 요소 중 맨 앞의 요소 찾기
    static int binSearchX(int[] a, int n, int key) {
        int pl = 0;
        int pr = n-1;

        while(pl <= pr) {
            int pc = (pr + pl) / 2;

            if(a[pc] == key) {
                for(; pc > pl; pc--) {
                    if(a[pc - 1] < key) {
                        break;
                    }
                }
                return pc;
            } else if(a[pc] < key) {
                pl = pc + 1;
            } else {
                pr = pc - 1;
            }
        }

        return -1;
    }
}
