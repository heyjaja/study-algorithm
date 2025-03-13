package basic.array;

import java.util.ArrayList;
import java.util.Scanner;

public class MaxNumber {

    public ArrayList<Integer> solution(int n, int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(arr[0]);

        for(int i=1; i<n; i++) {
            if(arr[i-1] < arr[i]) {
                list.add(arr[i]);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        // 앞의 수 보다 크면 출력
        // 맨 앞의 수는 무조건 출력
        // 5
        // 7 4 5 1 3 -> 7 5 3
        MaxNumber main = new MaxNumber();
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());

        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(sc.next());
        }

        ArrayList<Integer> list = main.solution(n, arr);

        list.forEach(i -> System.out.print(i + " "));
    }
}
