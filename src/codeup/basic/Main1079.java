package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1079 {
  public static void main(String[] args) throws IOException {
    // 1079 : [기초-종합] 원하는 문자가 입력될 때까지 반복 출력하기
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    
    while(st.hasMoreTokens()) {
      String a = st.nextToken();
      
      System.out.println(a);
      
      if(a.equals("q")) {
        break;
      } 
      
    }
    
  }
  
}