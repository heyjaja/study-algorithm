package barkingdog.sort;

import java.util.ArrayList;
import java.util.List;

public class RadixSort {
    static List<Integer>[] list = new List[10]; // 자릿수별로 요소를 저장할 리스트
    static int n = 10; // 요소 개수
    static int d = 3; // 최대 자릿수
    static int[] p10 = new int[d]; // 10의 i승
    static int[] arr = {12, 421, 46, 674, 103, 502, 7, 100, 21, 545}; // 정렬할 배열

    static int digitNum(int x, int a) {
        return (x / p10[a]) % 10; // a+1 자리의 수 반환
    }

    public static void main(String[] args) {
        for(int i = 0; i < 10; i++){
            list[i] = new ArrayList<>();
        }

        p10[0] = 1;
        // 1, 10, 100 10의 i승 p10에 할당
        for (int i = 1; i < d; i++) {
            p10[i] = p10[i-1] * 10;
        }

        for (int i = 0; i < d; i++) {
            // 사용한 리스트 비우기
            for (int j = 0; j < 10; j++) {
                list[j].clear();
            }
            // i번째 자릿수 리스트에 요소 넣기
            for (int j = 0; j < n; j++) {
                list[digitNum(arr[j], i)].add(arr[j]);
            }
            int idx = 0;
            // 자릿수별로 저장한 리스트의 값 순서대로 배열에 저장
            for(int j = 0; j<10; j++) {
                for (Integer num : list[j]) {
                    arr[idx++] = num;
                }
            }
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }

    }


}
