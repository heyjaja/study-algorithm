package lonely.string;

import java.util.Scanner;

public class WordInSentence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();

        String word = findLongestWord(sentence);

        System.out.println(word);
    }

    private static String findLongestWord(String sentence) {
        String answer = "";
        String[] arr = sentence.split(" ");
        for (String s : arr) {
            if(answer.length() < s.length()) {
                answer = s;
            }
        }
        return answer;
    }
}
