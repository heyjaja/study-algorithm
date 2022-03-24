package bj.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class String1152 {
  
  public static void main(String[] args) throws IOException {
    // 알파벳 문장의 단어 개수
    // 입력1> 영어 대소문자+공백 문자열 <1,000,000, 단어는 공백 1개로 구분 앞,뒤 공백 가능
    // 출력1> 단어의 개수
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
    
//    int count=0;
//    while (st.hasMoreTokens()) {
//      st.nextToken();
//      count++;
//    }
//    System.out.println(count);
    
    System.out.print(st.countTokens());
  }

}
