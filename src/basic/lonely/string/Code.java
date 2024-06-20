package lonely.string;

import java.util.Scanner;

public class Code {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();

        System.out.println(solution(n, s));
    }

    private static String solution(int n, String s) {
        StringBuilder answer = new StringBuilder();

        int end = 7;
        for(int i=0; i<n; i++) {
            String str = s.substring(end-7, end)
                    .replace('*', '0')
                    .replace('#', '1');
            int parsed = Integer.parseInt(str, 2);
            answer.append((char)parsed);
            end+=7;
        }


        return answer.toString();
    }
}
