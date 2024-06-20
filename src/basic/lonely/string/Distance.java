package lonely.string;

import java.util.Arrays;
import java.util.Scanner;

public class Distance {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char t = sc.next().charAt(0);

        for (int i : solution(s, t)) {
            System.out.print(i + " ");
        }
    }

    private static int[] solution(String s, char t) {
        int[] answer = new int[s.length()];
        Arrays.fill(answer, Integer.MAX_VALUE);
        for(int i=0; i<s.length(); i++) {
            if (s.charAt(i) == t) {
                answer[i] = 0;
                continue;
            }
            for(int j=0; j<s.length(); j++) {
                if(s.charAt(j) == t) {
                    answer[i] = Math.min(Math.abs(i - j), answer[i]);
                }
            }
        }
        return answer;
    }
}
