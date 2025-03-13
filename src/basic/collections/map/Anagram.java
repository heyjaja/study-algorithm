package basic.collections.map;

import java.util.HashMap;
import java.util.Scanner;

public class Anagram {
    public String solution(String a, String b) {
        String answer = "YES";
        HashMap<Character, Integer> map = new HashMap<>();

        for(char c : a.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(char c : b.toCharArray()) {
            if(!map.containsKey(c) || map.get(c) == 0) {
                return "NO";
            }
            map.put(c, map.get(c) - 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        // 아나그램 알파벳의 개수가 일치하여 재배치하면 서로 같은 단어
        // 길이가 같은 두 문자열이 서로 아나그램인지 판별
        Anagram main = new Anagram();

        Scanner sc = new Scanner(System.in);
        String input1 = sc.next();
        String input2 = sc.next();

        System.out.println(main.solution(input1, input2));
    }
}
