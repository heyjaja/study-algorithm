package basic.search;

import java.util.Arrays;
import java.util.Scanner;

public class ChoosingStable {
    public int count(int[] arr, int distance) {
        // 첫번째 말은 무조건 arr[0]에 위치
        // 말 사이의 거리는 distance 보다 크거나 같아야 한다.
        int count = 1; // 배치한 말의 마리 수
        int in = arr[0]; // 말이 있는 마구간 좌표
        for(int i=1; i<arr.length; i++) {
            // 주어진 거리보다 크거나 같을 때 말을 넣는다.
            if(arr[i] - in >= distance) {
                count++;
                in = arr[i];
            }
        }

        return count;
    }
    public int solution(int n, int c, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        int lt = 1; // 말 사이 최소 거리
        int rt = arr[n-1]; // 말 사이 최대 거리
        // 답은 lt ~ rt 사이에 있음

        while(lt<=rt) {
            // 가장 가까운 두 말의 거리: mid
            int mid = (lt+rt)/2;
            // 말이 주어진 마리 수 보다 많이 들어갈 때
            // 거리를 늘린다.
            if(count(arr, mid) >= c) {
                answer = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        // 마굿간 정하기 - 결정알고리즘
        // C마리의 말을 N개의 마굿간에 배치했을 때
        // 가장 가까운 두 말의 거리가 최대가 되는 값
        // N, C, 마굿간의 좌표 배열
        ChoosingStable main = new ChoosingStable();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print(main.solution(n, c, arr));
    }
}
