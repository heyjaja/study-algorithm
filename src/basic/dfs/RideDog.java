package dfs;

import java.util.Scanner;

public class RideDog {

    static int answer = 0;
    static int c, n;

    public static void main(String[] args) {
        // 바둑이 승차(DFS) - 부분집합
        // Ckg 이하만 태울 수 있는 트럭
        // N마리의 바둑이와 각 바둑이 무게 W
        // 트럭에 태울 수 있는 가장 무거운 무게 구하기
        RideDog main = new RideDog();
        Scanner sc = new Scanner(System.in);

        c = sc.nextInt();
        n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        main.DFS(0, 0, arr);

        System.out.println(answer);
    }

    public void DFS(int index, int sum, int[] arr) {
        if(sum > c) return;

        if(index == n) {
            answer = Math.max(answer, sum);
        } else {
            DFS(index + 1, sum + arr[index], arr);
            DFS(index + 1, sum, arr);
        }

    }
}
