package search;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        int lt = 0;
        int rt = arr.length - 1;
        while(lt <= rt) {
            int idx = (lt + rt)/2;
            if(arr[idx] == m) {
                answer = idx + 1;
                break;
            }

            if(arr[idx] > m) {
                rt = idx-1;
            } else {
                lt = idx+1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        // 이분검색
        // N개의 수를 오름차순으로 정렬한 다음 M의 순서 구하기
        BinarySearch main = new BinarySearch();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print(main.solution(n, m, arr));
    }
}
