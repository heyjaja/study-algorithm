package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1053 {
  public static void main(String[] args) throws IOException {
    // 1053 : [기초-논리연산] 참 거짓 바꾸기
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int a = Integer.parseInt(br.readLine());
    
    System.out.println( a == 0 ? 1: 0);
    
  }
  
}