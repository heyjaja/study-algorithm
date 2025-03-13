package basic.dfs;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class CoinExchange {
    static int n, m;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) {
        // 동전 교환
        // 동전의 종류 N, 서로 다른 종류의 동전
        // 거스름돈 M
        // 가장 적은 수의 동전으로 거스름돈 주기
        CoinExchange main = new CoinExchange();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        Integer[] coin = new Integer[n];
        for(int i=0; i<n; i++) {
            coin[i] = sc.nextInt();
        }
        m = sc.nextInt();

        // 입력 순서대로 했을 때 시간 초과 발생
        // 큰 동전부터 내림차순으로 하여 시간 단축
        // 오름차순 정렬은 기본형 말고 Integer로 해야 한다.
        Arrays.sort(coin, Collections.reverseOrder());

        main.DFS(0, 0, coin);

        System.out.println(answer);
    }

    private void DFS(int level, int sum, Integer[] coin) {
        if(sum > m) return;
        // 현재 답보다 크거나 같으면 볼 필요가 없다.
        if(level >= answer) return;
        if(sum == m) {
            answer = level;
            return;
        }
        for(int i=0; i<n; i++) {
            DFS(level + 1, sum + coin[i], coin);
        }
    }
}
