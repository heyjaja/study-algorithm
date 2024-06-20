package lonely.string;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.println(solution(str));
    }

    private static String solution(String str) {
        String answer = "YES";

        String s = str.toUpperCase();
        int lt = 0;
        int rt = s.length() - 1;

        while (lt < rt) {
            if(s.charAt(lt) != s.charAt(rt)) {
                return "NO";
            }
            lt++;
            rt--;
        }

        return answer;
    }
}
