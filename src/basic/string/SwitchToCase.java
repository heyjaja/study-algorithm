package string;

import java.util.Scanner;

public class SwitchToCase {

    public String solution(String word) {
        StringBuilder answer = new StringBuilder();

        for(char c : word.toCharArray()) {
            c = Character.isUpperCase(c) ?
                    Character.toLowerCase(c) : Character.toUpperCase(c);
            answer.append(c);
        }

        return answer.toString();
    }
    public static void main(String[] args) {
        // sTuDy -> StUdY
        // 대문자/소문자 -> 소문자/대문자
        SwitchToCase main = new SwitchToCase();

        Scanner sc = new Scanner(System.in);
        String input1 = sc.next();

        System.out.println(main.solution(input1));
    }
}
