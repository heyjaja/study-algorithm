package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CommonElement {
    public ArrayList<Integer> solution(int n, int m, int[] a, int[] b) {
        ArrayList<Integer> answer = new ArrayList<>();
        Arrays.sort(a);
        Arrays.sort(b);
        int ap = 0, bp = 0;
        while(ap < n && bp < m) {
            if(a[ap] < b[bp]) {
                ap++;
            } else if(a[ap] > b[bp]) {
                bp++;
            } else {
                answer.add(a[ap]);
                ap++;
                bp++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        // 공통원소 구하기
        // A, B 두 집합의 공통 원소를 오름차순으로 출력
        CommonElement main = new CommonElement();
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

        for(int i : main.solution(n, m, a, b)) {
            System.out.print(i+" ");
        }
    }
}
