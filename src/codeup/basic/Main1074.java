package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1074 {
  public static void main(String[] args) throws IOException {
    // 1074~1075 : [기초-반복실행구조] 정수 1개 입력받아 카운트다운 출력하기1

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int a = Integer.parseInt(br.readLine());
    
//    for(int i=a-1; i>=0; i--) {
//      System.out.println(i);
//    }
    
    while(a-->0) {
      System.out.println(a);
    }
    
  }
  
}