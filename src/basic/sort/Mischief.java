package basic.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Mischief {
    public int[] solution(int n, int[] arr) {
        // 이 풀이는 연속 중복 이후 값이 오면 알 수 없다.
        // 예) 161 167 167 161 여기서 뒤의 경우 밖에 잡지 못함.
        int[] answer = new int[2];
        int index = 0;
        for(int i=0; i<n-1; i++) {
            if(arr[i] > arr[i+1]) {
                answer[index] = i+1+index++;
            }
        }
        return answer;
    }

    public ArrayList<Integer> solution2(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        // 배열을 정렬하면 자리를 바꾼 2명만 값이 다르다.
        int[] temp = arr.clone();
        Arrays.sort(temp);

        for(int i=0; i<n; i++) {
            if(temp[i] != arr[i]) {
                answer.add(i+1);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        // 장난꾸러기
        // 키 순서 배열에서 자리가 바뀐 사람의 번호 2개
        Mischief main = new Mischief();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i : main.solution(n,arr)) {
            System.out.print(i + " ");
        }

    }
}
