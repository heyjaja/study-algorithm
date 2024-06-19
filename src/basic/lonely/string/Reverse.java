package lonely.string;

import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();

        String word = reverseString(sentence);

        System.out.println(word);
    }

    private static String reverseString(String sentence) {
        return new StringBuilder(sentence).reverse().toString();
    }
}
