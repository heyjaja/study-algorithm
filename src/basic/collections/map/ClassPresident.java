package basic.collections.map;

import java.util.HashMap;
import java.util.Scanner;

public class ClassPresident {
    public char solution(int n, String str) {
        char answer = ' ';
        HashMap<Character, Integer> map = new HashMap<>();

        for(char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int max = 0;
        for(char key : map.keySet()) {
            if(map.get(key) > max) {
                max = map.get(key);
                answer = key;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        // 학급 회장 후보 A,B,C,D,E
        // 학생 수 N, 투표 결과 기호 문자열
        // 가장 많은 표를 얻은 후보의 기호 출력
        ClassPresident main = new ClassPresident();

        Scanner sc = new Scanner(System.in);
        int input1 = sc.nextInt();
        String input2 = sc.next();

        System.out.println(main.solution(input1, input2));
    }
}
