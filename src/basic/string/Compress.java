package string;

import java.util.Scanner;

public class Compress {
    public String solution(String str) {
        StringBuilder answer = new StringBuilder();

        str = str + " ";
        int count = 1;

        for(int i=1; i<str.length()-1; i++) {
            if(str.charAt(i) == str.charAt(i+1)) {
                count++;
            } else {
                answer.append(str.charAt(i));
                if(count > 1) {
                    answer.append(count);
                }
                count = 1;
            }
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        // 압축 문자열
        // 문자열이 주어지고 반복하는 횟수만큼 숫자 붙여서 출력
        // KKKKSSKWWW -> K4S2KW3
        Compress main = new Compress();

        Scanner sc = new Scanner(System.in);
        String input1 = sc.next();

        System.out.println(main.solution(input1));
    }
}
