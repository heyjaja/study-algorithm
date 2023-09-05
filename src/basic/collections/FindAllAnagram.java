package collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FindAllAnagram {
    public int solution(String s, String t) {
        int answer = 0;
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();

        int tLength = t.length();

        for(int i = 0; i<tLength; i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        if(tMap.equals(sMap)) answer++;

        for(int i = tLength; i < s.length(); i++) {
            sMap.put(s.charAt(i-tLength), sMap.get(s.charAt(i-tLength)) - 1);
            if(sMap.get(s.charAt(i-tLength)) == 0) {
                sMap.remove(s.charAt(i-tLength));
            }
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);

            if(tMap.equals(sMap)) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        // S 단어에 T 문자열과 아나그램이 되는 부분 문자열의 개수
        FindAllAnagram main = new FindAllAnagram();

        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();

        System.out.println(main.solution(s, t));
    }
}
