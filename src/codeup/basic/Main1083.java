package codeup.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1083 {
  public static void main(String[] args) throws IOException {
    // 1083 : [기초-종합] 3 6 9 게임의 왕이 되자!
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int n = Integer.parseInt(br.readLine()); // 16진수 입력값을 10진수로 변환
    
    for(int i=1; i<=n; i++) {
     int a = i%10, b=i/10;
      if(a == 3 || a == 6 || a == 9) {
        if( b==3 || b==6||b==9) {
          System.out.print("XX ");
        } else {
          System.out.print("X ");
        }
      } else if(b==3 || b==6 || b==9) {
        System.out.print("X ");
      } else {
        System.out.print(i+ " ");
      }
    }
    
    
    
  }
  
}