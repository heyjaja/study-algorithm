package codeup.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1047 {
  public static void main(String[] args) throws IOException {
    // 1047 : [기초-비트시프트연산] 정수 1개 입력받아 2배 곱해 출력하기
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    long a = Long.parseLong(br.readLine());
    
    System.out.println(a<<1);
    
  }
  
}