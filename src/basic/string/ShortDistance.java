package basic.string;

import java.util.Scanner;

public class ShortDistance {
    public int[] solution(String s, char c) {
        int[] answer = new int[s.length()];

        int length = s.length();
        // 거리 기준
        int p = length;

        // 왼쪽 -> 오른쪽으로 비교
        for(int i = 0; i < length; i++) {
            if(s.charAt(i) == c) {
                p = 0;
            } else {
                p++;
            }
            answer[i] = p;
        }

        p = length;
        // 오른쪽 -> 왼쪽으로 비교하여 더 작은 값
        for(int i = length-1; i >=0; i--) {
            if(s.charAt(i) == c) {
                p = 0;
            } else {
                p++;
            }

            answer[i] = Math.min(answer[i], p);
        }
        return answer;
    }

    public static void main(String[] args) {
        // 가장 짧은 문자 거리
        // 단어와 문자가 주어지면 단어에서 각 문자와 가장 짧은 거리 출력
        // different e -> 4 3 2 1 0 1 0 1 2
        ShortDistance main = new ShortDistance();

        Scanner sc = new Scanner(System.in);
        String input1 = sc.next();
        char input2 = sc.next().charAt(0);

        int[] arr = main.solution(input1, input2);

        for(int i : arr) {
            System.out.print(i + " ");
        }
    }
}
