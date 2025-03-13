package basic.search;

import java.util.Arrays;
import java.util.Scanner;

public class MusicVideo {
    public int count(int[] arr, int capacity) {
        // capacity(용량)만큼 저장하면 몇개 DVD가 필요한지
        int count = 1, sum = 0;
        for(int x : arr) {
            if(sum + x > capacity) {
                count++;
                sum = x;
            } else {
                sum += x;
            }
        }
        return count;
    }
    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        // DVD 용량으로 가능한 가장 작은 숫자는 배열 중 가장 큰 값
        // 가장 큰 숫자는 배열을 모두 합한 값
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();

        // mid = (lt+rt)/2부터 이분검색
        // mid 용량의 DVD m개에 노래 저장 가능한지 확인하여
        // 범위를 좁힌다.
        while(lt<=rt) {
            int mid = (lt+rt)/2;
            if(count(arr, mid) <= m) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        // 뮤직비디오 - 결정알고리즘
        // N개의 노래(노래 길이 배열), M개의 DVD
        // 같은 크기의 DVD를 M개 만들 때 최소 용량
        MusicVideo main = new MusicVideo();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print(main.solution(n, m, arr));
    }
}
