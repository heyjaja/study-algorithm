package basic.string;

import java.util.Scanner;

public class PalindromeForString {

    public String solution(String word) {
        String answer = "YES";
        String replaceWord = word.toUpperCase().replaceAll("[^A-Z]", "");

        int length = replaceWord.length();
        for(int i = 0; i < length/2; i++) {
            if(replaceWord.charAt(i) != replaceWord.charAt(length - i - 1)) {
                return "NO";
            }
        }
        return answer;

    }

    public static void main(String[] args) {
        // 회문
        // 문자 제외 무시
        // r:ou7or! -> YES
        PalindromeForString main = new PalindromeForString();

        Scanner sc = new Scanner(System.in);
        String input1 = sc.nextLine();

        System.out.println(main.solution(input1));
    }

}
