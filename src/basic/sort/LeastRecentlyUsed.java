package basic.sort;

import java.util.Scanner;

public class LeastRecentlyUsed {
    public int[] solution(int s, int n, int[] arr) {
        // 삽입정렬 응용
        int[] answer = new int[s];
        for(int number : arr) {
            int idx = s-1;

            // 이미 저장된 캐시가 있는지 확인
            for(int j=0; j<s; j++) {
                if(number == answer[j]) {
                    idx = j;
                }
            }

            // 저장된 캐시 인덱스부터 밀기 or 마지막 인덱스부터
            for(int j=idx; j > 0; j--) {
                answer[j] = answer[j-1];
            }
            answer[0] = number;
        }

        return answer;
    }

    public static void main(String[] args) {
        // 캐시메모리 사용 규칙
        // 가장 최근에 사용되지 않은 것부터 제거
        // 1. cache miss: 해야할 작업이 캐시에 없는 상태
        // -> 모든 작업이 뒤로 규칙에 따라 제거
        // 2. cache hit: 해야할 작업이 캐시에 있는 상태
        // -> 해당 작업을 맨 앞으로, 앞 작업들 한 칸씩 뒤로
        // 캐시의 크기 S, N개의 작업을 차례로 처리, 최근->오래된 순으로 출력
        LeastRecentlyUsed main = new LeastRecentlyUsed();
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i : main.solution(s, n, arr)) {
            System.out.print(i + " ");
        }
    }
}
