package basic.dp;

import java.util.Arrays;
import java.util.Scanner;

public class CoinExchange {
    public static void main(String[] args) {
        // 동전 교환(냅색 알고리즘)
        // 여러 단위의 동전들이 주어졌을 때 거스름돈을 가장 적은 수의 동전으로 교환
        // 동전의 종류 개수 N(1<=N<=50)
        // N개의 동전 종류, 거스름돈 M(1<=M<=500)
        // 각 동전의 종류는 100원을 넘지 않는다.
        CoinExchange main = new CoinExchange();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        int m = sc.nextInt();

        System.out.println(main.solution(n, arr, m));
    }

    private int solution(int n, int[] coins, int m) {
        // 인덱스(거스름돈)을 만들 수 있는 가장 적은 동전 개수 저장
        int[] dynamic = new int[m+1];
        Arrays.fill(dynamic, Integer.MAX_VALUE);
        Arrays.sort(coins);
        dynamic[0] = 0;

        // 처음에 주어진 동전만 있다고 가정하고 초기화
        for(int i=0; i<n; i++) {
            for(int j=coins[i]; j<=m; j++) {
                // dynamic[j] = 거스름돈에서 동전만큼 뺀 수에서 + 1
                dynamic[j] = Math.min(dynamic[j-coins[i]] + 1, dynamic[j]);
            }
        }

        return dynamic[m];
    }
}
