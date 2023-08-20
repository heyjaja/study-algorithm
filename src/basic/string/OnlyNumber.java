package string;

import java.util.Scanner;

public class OnlyNumber {

    public int solution(String str) {
        StringBuilder answer = new StringBuilder();

        for(char c : str.toCharArray()) {
            if(Character.isDigit(c)) {
                answer.append(c);
            }
        }

        return Integer.parseInt(answer.toString());
    }

    public static void main(String[] args) {
        // 숫자만 추출(자연수로 변환)
        // s2oi1kl9dd0 -> 219
        OnlyNumber main = new OnlyNumber();

        Scanner sc = new Scanner(System.in);
        String input1 = sc.next();

        System.out.println(main.solution(input1));
    }
}
