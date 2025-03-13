package basic.string;

import java.util.Scanner;

public class Palindrome {

    public String solution(String word) {
        String answer = "YES";

        word = word.toUpperCase();

        int lt = 0;
        int rt = word.length() - 1;

        while(lt < rt) {
            if(word.charAt(lt) != word.charAt(rt)) {
                answer = "NO";
                break;
            }
                lt++;
                rt--;
        }

        return answer;
    }

    public String solution2(String word) {
        String answer = "YES";
        word = word.toUpperCase();
        int length = word.length() - 1;

        // for
        for(int i=0; i<word.length()/2; i++) {
            if(word.charAt(i) != word.charAt(length - i)) {
                answer = "NO";
                break;
            }
        }

        return answer;
    }

    public String solution3(String word) {
        String answer = "NO";
        String reverse = new StringBuilder(word).reverse().toString();

        if(word.equalsIgnoreCase(reverse)) {
            answer = "YES";
        }

        return answer;

    }
    public static void main(String[] args) {
        // 회문
        // ioi -> yes
        Palindrome main = new Palindrome();

        Scanner sc = new Scanner(System.in);
        String input1 = sc.next();

        System.out.println(main.solution(input1));
    }
}
