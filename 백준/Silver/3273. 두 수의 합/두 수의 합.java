import java.util.*;

public class Main {
    public static void main(String[] args) {
        // n개의 서로 다른 양의 정수로 이루어진 수열
        // 1 <= a[i] <= 1000000
        // 자연수 x, a[i] + a[j] = x를 만족하는 a 쌍의 수
        // 1 <= n <= 100000, 1 <= x <= 2000000
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int x = sc.nextInt();

        System.out.println(solution2(arr, n, x));
    }

    private static int solution2(int[] arr, int n, int x) {
        int count = 0;
        int[] occur = new int[2000001];
        for (int i = 0; i < n; i++) {
            int idx = x - arr[i];
            if(idx >=0 && occur[idx] == 1) {
                count++;
            }
            occur[arr[i]] = 1;
        }

        return count;
    }
}