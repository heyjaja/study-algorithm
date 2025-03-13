package basic.sort;

import java.util.Arrays;
import java.util.Scanner;

public class CoordinateSort {
    public int[][] solution(int n, int[][] arr) {
        Arrays.sort(arr, (o1, o2) -> {
            if(o1[0] == o2[0]) {
                if(o1[1] > o2[1]) {
                    return 1;
                }
                if(o1[1] < o2[1]) {
                    return -1;
                }
            }
            if (o1[0] > o2[0]) {
                return 1;
            }
            if (o1[0] < o2[0]) {
                return -1;
            }

            return 0;
        });


        return arr;
    }
    public static void main(String[] args) {
        // 좌표정렬
        // 모든 좌표를 오름차순으로 정렬
        CoordinateSort main = new CoordinateSort();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];

        for(int i = 0; i < n; i++) {
            for(int j=0; j < 2; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        for(int[] i : main.solution(n, arr)) {
            System.out.println(i[0] + " " + i[1]);
        }
    }
}
