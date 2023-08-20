package string;

import java.util.Scanner;

public class Dedupe {

    public String solution(String word) {
        StringBuilder sb = new StringBuilder();

        for(String s : word.split("")) {
            if(sb.indexOf(s) >= 0) {
                continue;
            }

            sb.append(s);
        }

        return sb.toString();
    }

    public String solution2(String word) {
        StringBuilder sb = new StringBuilder();

        // indexOf는 처음으로 찾은 위치 반환 -> i와 같아야 처음 나오는 문자
        for(int i=0; i< word.length(); i++) {
            if(word.indexOf(word.charAt(i)) == i) {
                sb.append(word.charAt(i));
            }
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        // 중복제거
        // different -> difernt
        Dedupe main = new Dedupe();

        Scanner sc = new Scanner(System.in);
        String input1 = sc.next();

        System.out.println(main.solution(input1));
    }
}
