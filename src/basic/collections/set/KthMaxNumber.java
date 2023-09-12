package collections.set;

import java.util.*;

public class KthMaxNumber {
    public int solution(int n, int k, int[] arr) {
        int answer = -1;
        // 내림차순 TreeSet
        Set<Integer> set = new TreeSet<>(Collections.reverseOrder());

        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                for(int l = j+1; l<n; l++) {
                    set.add(arr[i]+arr[j]+arr[l]);
                }
            }
        }

        int count = 0;
        for(int i : set) {
            count++;
            if(count == k) {
                return i;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        // k번쨰 큰 수
        // N장의 카드 중 3장을 뽑아 합한 값을 기록
        // 기록한 값의 K번째 큰 수
        KthMaxNumber main = new KthMaxNumber();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(main.solution(n, k, arr));

    }
}
