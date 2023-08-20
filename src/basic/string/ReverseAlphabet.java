package string;

import java.util.Scanner;

public class ReverseAlphabet {
    public String solution(String word) {
        char[] answer = word.toCharArray();

        int lt = 0;
        int rt = word.length() - 1;
        while(lt < rt) {
            if(!Character.isAlphabetic(answer[lt])) {
                lt++;
                continue;
            }

            if(!Character.isAlphabetic(answer[rt])) {
                rt--;
                continue;
            }

            char temp = answer[lt];
            answer[lt] = answer[rt];
            answer[rt] = temp;
            lt++;
            rt--;

        }

        return String.valueOf(answer);
    }
    public static void main(String[] args) {
        // 알파벳만 뒤집기
        // s#ta%g -> g#at%s
        ReverseAlphabet main = new ReverseAlphabet();

        Scanner sc = new Scanner(System.in);
        String input1 = sc.next();

        System.out.println(main.solution(input1));
    }
}
