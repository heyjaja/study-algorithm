package codeup.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1082 {
  public static void main(String[] args) throws IOException {
    // 1082 : [기초-종합] 16진수 구구단?
    // 16진수로 한 자리 수가 입력된다. 단, A ~ F 까지만 입력된다.
    // 입력된 16진수에 1~F까지 순서대로 곱한, 16진수 구구단을 줄을 바꿔 출력한다.
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int n = Integer.parseInt(br.readLine(), 16); // 16진수 입력값을 10진수로 변환
    
    for(int i=1; i<16; i++) {
      int re = n * i;
      System.out.printf("%X*%X=%X\n", n, i, re); // 10진수 결과값을 16진수로 출력
    }
    
    
  }
  
}