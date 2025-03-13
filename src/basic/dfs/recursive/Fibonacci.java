package basic.dfs.recursive;

import java.util.Scanner;

public class Fibonacci {
    public int DFS(int n) {
        if(n==1) {
            return 1;
        }

        if(n==2) {
            return 1;
        }

        return DFS(n-2) + DFS(n-1);

    }

    static int[] arr;
    public int DFS2(int n) {
        // 추가 메모리를 이용해 호출 1번으로 값을 구함
        if(n == 1) {
            return arr[n] = 1;
        }
        if(n == 2) {
            return arr[n] = 1;
        }

        return arr[n] = DFS2(n-2) + DFS2(n-1);

    }

    public int DFS3(int n) {
        // 메모이제이션: 동일한 계산을 반복해야 할 때,
        // 이전에 계산한 값을 메모리에 저장하여 반복 제거
        if(arr[n] > 0) {
            return arr[n];
        }
        if(n == 1) {
            return arr[n] = 1;
        }
        if(n == 2) {
            return arr[n] = 1;
        }

        return arr[n] = DFS3(n-2) + DFS3(n-1);
    }

    public static void main(String[] args) {
        // 이진수 출력 - 재귀함수
        Fibonacci main = new Fibonacci();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=1; i<=n; i++) {
            System.out.print(main.DFS(i) + " ");
        }
        System.out.println();
        arr = new int[n+1];
        main.DFS2(n);
        for(int i=1; i<=n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        main.DFS3(n);
        for(int i=1; i<=n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
