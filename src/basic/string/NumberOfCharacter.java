package basic.string;

import java.util.Scanner;

public class NumberOfCharacter {
    public int solution(String word, char c) {
        int result = 0;
        word = word.toUpperCase();
        c = Character.toUpperCase(c);

        for(char i : word.toCharArray()) {
            if(i == c) {
                result++;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        // 단어, 문자 -> 단어 안 문자의 개수
        NumberOfCharacter main = new NumberOfCharacter();

        Scanner sc = new Scanner(System.in);
        String input1 = sc.next();
        char input2 = sc.next().charAt(0);

        System.out.println(main.solution(input1, input2));
    }
}
