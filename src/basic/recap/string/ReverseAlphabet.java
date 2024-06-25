package recap.string;

import java.util.Scanner;

public class ReverseAlphabet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();

        String word = solution(sentence);

        System.out.println(word);
    }

    private static String solution(String sentence) {
        char[] arr = sentence.toCharArray();
        int length = arr.length;
        char[] answer = new char[length];

        int lt = 0;
        int rt = length - 1;
        while (lt <= rt) {
            answer[lt] = arr[lt];
            answer[rt] = arr[rt];
            if(!Character.isAlphabetic(arr[lt])) {
                lt++;
                continue;
            }

            if(!Character.isAlphabetic(arr[rt])) {
                rt--;
                continue;
            }

            answer[lt] = arr[rt];
            answer[rt] = arr[lt];
            lt++;
            rt--;
        }
        return String.valueOf(answer);
    }
}
