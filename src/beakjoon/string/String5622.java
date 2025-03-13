package beakjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class String5622 {

  public static void main(String[] args) throws IOException {
    // 다이얼 전화기 1: 2초, 1++: +1초
    // 번호에 적힌 문자로 전화번호 인식 예) UNUCIC=868242
    // 입력1> 알파벳 대문자 단어 2<=s<=15
    // 출력1> 다이얼을 걸기 위해 필요한 최소 시간
    
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    
    map.put("ABC", 2);
    map.put("DEF", 3);
    map.put("GHI", 4);
    map.put("JKL", 5);
    map.put("MNO", 6);
    map.put("PQRS", 7);
    map.put("TUV", 8);
    map.put("WXYZ", 9);
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    String s = br.readLine();
    
    int ans = 0;
    
    for(String st : map.keySet()) {
      for(char c : s.toCharArray()) {
        if (st.indexOf(c) != -1) {
          ans += (map.get(st)+1);
        }
      }
    }
    System.out.println(ans);
  }

}
