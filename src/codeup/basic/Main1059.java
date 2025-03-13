package codeup.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1059 {
  public static void main(String[] args) throws IOException {
    // 1059 : [기초-비트단위논리연산] 비트단위로 NOT 하여 출력하기
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int a = Integer.parseInt(br.readLine());
    
    System.out.println(~a);
    
  }
  
}