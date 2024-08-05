package recap.hash;

import java.util.*;

public class KthMaxNumber {


    public static void main(String[] args) {
        // k번쨰 큰 수
        // N장의 카드 중 3장을 뽑아 합한 값을 기록
        // 기록한 값의 K번째 큰 수
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(solution(n, k, arr));

    }

    private static int solution(int n, int k, int[] arr) {
        int answer = -1;
        Set<Integer> set = new TreeSet<>(Comparator.reverseOrder());

        for(int i=0; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                for(int l=j+1; l<arr.length; l++){
                    set.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }

        int count = 0;
        for (Integer i : set) {
            count++;
            if(count == k) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}
