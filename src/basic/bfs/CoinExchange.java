package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CoinExchange {
    public static void main(String[] args) {
        // 동전 교환
        // 동전의 종류 N, 서로 다른 종류의 동전
        // 거스름돈 M
        // 가장 적은 수의 동전으로 거스름돈 주기
        CoinExchange main = new CoinExchange();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] coin = new int[n];
        for(int i=0; i<n; i++) {
            coin[i] = sc.nextInt();
        }
        int m = sc.nextInt();

        System.out.println(main.BFS(n, m, coin));
    }

    private int BFS(int n, int m, int[] coin) {
        int answer = 0;
        boolean[] check = new boolean[501];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        while(!queue.isEmpty()) {
            int length = queue.size(); // 현재 레벨의 노드 개수
            for(int i=0; i<length; i++) {
                int value = queue.poll();
                for (int x : coin) {
                    int sum = x + value;
                    if (sum == m) {
                        return answer + 1;
                    }
                    if(sum < m && !check[sum]) {
                        queue.offer(sum);
                        check[sum] = true;
                    }
                }
            }
            answer++;
        }

        return answer;
    }
}
