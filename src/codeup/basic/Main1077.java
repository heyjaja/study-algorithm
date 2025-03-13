package codeup.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1077 {
  public static void main(String[] args) throws IOException {
    // 1077 : [기초-반복실행구조] 정수 1개 입력받아 그 수까지 출력하기
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int n = Integer.parseInt(br.readLine());
    
    for(int i=0; i<=n; i++) {
      System.out.println(i);
    }
    
    
  }
  
}