package string;

import java.util.Scanner;

public class Code {
    public String solution(int n, String str) {
        StringBuilder answer = new StringBuilder();

        for(int i=0; i<n; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<7; j++) {
                int insert = str.charAt(j) == '#' ? 1 : 0;
                sb.append(insert);
            }
            int number = Integer.parseInt(sb.toString(), 2);
            char c = (char)(number); // 괄호 생략했을 때 null 값 나옴
            answer.append(c);
            str = str.substring(7);
        }

        return answer.toString();
    }

    public String solution2(int n, String str) {
        StringBuilder answer = new StringBuilder();

        for(int i=0; i<n; i++) {
            String temp = str.substring(0, 7).replace('#', '1').replace('*', '0');
            int number = Integer.parseInt(temp, 2);
            answer.append((char)(number));
            str = str.substring(7);
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        // 암호
        // 문자의 개수 + #: 1, *: 0
        // 7자리 이진수 -> 10진수 -> 아스키코드 알파벳 대문자
        // 4 #****###**#####**#####**##** -> COOL
        Code main = new Code();

        Scanner sc = new Scanner(System.in);
        int input1 = Integer.parseInt(sc.next());
        String input2 = sc.next();

        System.out.println(main.solution2(input1, input2));
    }
}
