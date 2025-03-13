package codeup.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1076 {
  public static void main(String[] args) throws IOException {
    // 1076 : [기초-반복실행구조] 문자 1개 입력받아 알파벳 출력하기
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    char a = br.readLine().charAt(0);
    
    char b = 'a';
    
    do {
      System.out.print((a == b) ? b++ : (b++)+" " );
    } while (b < (a + 1));
    
  }
  
}