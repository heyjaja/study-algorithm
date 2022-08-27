package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1067 {
  public static void main(String[] args) throws IOException {
    // 1067 : [기초-조건/선택실행구조] 정수 1개 입력받아 분석하기
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int a = Integer.parseInt(br.readLine());
    
    if(a>0) {
      System.out.println("plus");
      check(a);
    } else {
      System.out.println("minus");
      check(a);
    }
    
  }
  static void check(int n) {
    if(n%2==0) {
      System.out.println(("even"));
    } else {
      System.out.println("odd");
    }
  }
  
}