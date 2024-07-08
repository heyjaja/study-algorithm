package recap.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Anagram {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input1 = sc.next();
        String input2 = sc.next();

        System.out.println(solution(input1, input2));
    }

    private static String solution(String input1, String input2) {
        Map<Character, Integer> map = new HashMap<>();

        for(Character c : input1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(Character c : input2.toCharArray()) {
            if(!map.containsKey(c)) {
                return "NO";
            }

            map.put(c, map.get(c) - 1);

            if(map.get(c) == 0) {
                map.remove(c);
            }
        }

        return map.isEmpty() ? "YES" : "NO";
    }
}
