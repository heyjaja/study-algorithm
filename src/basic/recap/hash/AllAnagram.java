package basic.recap.hash;

import java.util.HashMap;
import java.util.Scanner;

public class AllAnagram {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();

        System.out.println(solution(s, t));
    }

    private static int solution(String s, String t) {
        int answer = 0;

        // s에서 t의 길이 만큼 처음부터 자른다.
        int lp = 0;
        int rp = t.length();

        while(rp <= s.length()) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (char c : t.toCharArray()) {
                map.put(c, (map.getOrDefault(c, 0) + 1));
            }
            // 자른 s에 t 요소가 모두 있는지 확인
            String str = s.substring(lp++, rp++);
            for(char c : str.toCharArray()) {
                if(!map.containsKey(c)) {
                    break;
                }
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0) {
                    map.remove(c);
                }
            }
            if(map.isEmpty()) {
                answer++;
            }
        }
        return answer;
    }
}
