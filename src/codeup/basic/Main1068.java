package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1068 {
  public static void main(String[] args) throws IOException {
    // 1068 : [기초-조건/선택실행구조] 정수 1개 입력받아 평가 출력하기
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int a = Integer.parseInt(br.readLine());
    
    switch (a/10) {
    case 10:
    case 9:
      System.out.println("A");
      break;
    case 8:
    case 7:
      System.out.println("B");
      break;
    case 6:
    case 5:
    case 4:
      System.out.println("C");
      break;
    default:
      System.out.println("D");
      break;
    }
    
  }
  
}