package codeup.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1044 {

  public static void main(String[] args) throws IOException {
    // 1044 : [기초-산술연산] 정수 1개 입력받아 1 더해 출력하기
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    long n = Long.parseLong(br.readLine());
    
    System.out.println(++n);
  }

}
