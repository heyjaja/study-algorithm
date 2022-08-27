package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1069 {
  public static void main(String[] args) throws IOException {
    // 1069 : [기초-조건/선택실행구조] 평가 입력받아 다르게 출력하기
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    char c = br.readLine().charAt(0);
    
    switch (c) {
    case 'A':
      System.out.println("best!!!");
      break;
    case 'B':
      System.out.println("good!!");
      break;
    case 'C':
      System.out.println("run!");
      break;
    case 'D':
      System.out.println("slowly~");
      break;
    default:
      System.out.println("what?");
      break;
    }
    
  }
  
}