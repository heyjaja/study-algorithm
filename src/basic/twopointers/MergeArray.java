package basic.twopointers;

import java.util.ArrayList;
import java.util.Scanner;

public class MergeArray {
    public int[] solution(int n, int m, int[] a, int[] b) {
        int[] answer = new int[n+m];
        int np = 0, mp = 0;

        for(int i=0; i<n+m; i++) {
            if(np >= n) {
                answer[i] = b[mp++];
                continue;
            }
            if(mp >= m) {
                answer[i] = a[np++];
                continue;
            }
            if(a[np] < b[mp]) {
                answer[i] = a[np++];
            } else {
                answer[i] = b[mp++];
            }
        }

        return answer;
    }

    public ArrayList<Integer> solution2(int n, int m, int[] a, int[] b) {
        ArrayList<Integer> answer = new ArrayList<>();
        int np = 0, mp = 0;
        while(np < n && mp < m) {
            if(a[np] < b[mp]) answer.add(a[np++]);
            else answer.add(b[mp++]);
        }
        while(np<n) answer.add(a[np++]);
        while(mp<m) answer.add(b[mp++]);

        return answer;
    }

    public static void main(String[] args) {
        // 배열 합치기
        // 길이 N 오름차순 배열
        // 길이 M 오름차순 배열
        // 2개 배열 오름차순으로 합치기
        MergeArray main = new MergeArray();
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

        for(int i : main.solution2(n, m, a, b)) {
            System.out.print(i+" ");
        }
    }
}
