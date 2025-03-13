package codeup.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1065 {
  public static void main(String[] args) throws IOException {
    // 1065 : [기초-조건/선택실행구조] 정수 3개 입력받아 짝수만 출력하기
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    
    while(st.hasMoreTokens()) {
      int a = Integer.parseInt(st.nextToken());
      
      if(a % 2==0) {
        System.out.println(a);
      }
    }
    
    
  }
  
}