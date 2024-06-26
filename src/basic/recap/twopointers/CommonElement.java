package recap.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CommonElement {

    public static void main(String[] args) {
        // 공통원소 구하기
        // A, B 두 집합의 공통 원소를 오름차순으로 출력
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];

        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] b = new int[m];

        for(int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }

        for(int i : solution(a, b)) {
            System.out.print(i+" ");
        }
    }

    private static List<Integer> solution(int[] a, int[] b) {
        List<Integer> list = new ArrayList<>();

        Arrays.sort(a);
        Arrays.sort(b);

        int i = 0;
        int j = 0;

        while(i < a.length && j < b.length) {
            if(a[i] == b[j]) {
                list.add(a[i]);
                i++;
                j++;
                continue;
            }

            if(a[i] > b[j]) {
                j++;
            } else {
                i++;
            }

        }

        return list;
    }
}
