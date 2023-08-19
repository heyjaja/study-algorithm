package string;

import java.util.Scanner;

public class Longest {
    public String solution(String str) {
        String answer = "";

        for(String s : str.split(" ")) {
            if(answer.length() < s.length()) {
                answer = s;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        // 문장 -> 문장에서 가장 긴 단어
        Longest main = new Longest();

        Scanner sc = new Scanner(System.in);
        String input1 = sc.nextLine();

        System.out.println(main.solution(input1));
    }
}
