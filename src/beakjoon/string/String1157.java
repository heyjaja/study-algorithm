package string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class String1157 {
  
  static char solution(char[] arr) {
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    
    for(char c : arr) {
      map.put(c, map.getOrDefault(c, 0)+1);
    }
    int max = -1;
    char answer = ' ';
    for(char c : map.keySet()) {
      if(map.get(c)>max) {
        max = map.get(c);
        answer = c;
      } else if(map.get(c)==max) {
        answer = '?';
      }
    }
    
    return answer;
    
  }

  public static void main(String[] args) throws IOException {
    // 알파벳 문자열 -> 가장 많이 사용된 알파벳
    // 입력1> 알파벳 대소문자로 이루어진 단어
    // 출력1> 가장 많이 사용된 알파벳을 대문자로, 2개 이상이면 ?
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    bw.write(solution((br.readLine().toUpperCase()).toCharArray()));
    bw.flush();
    
    
  }

}
