package codeup.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1080 {
  public static void main(String[] args) throws IOException {
    // 1080 : [기초-종합] 언제까지 더해야 할까?
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int n = Integer.parseInt(br.readLine());
    
    int sum = 0;
    
    for(int i=1; ; i++) {
      sum += i;
      if(sum >= n) {
        System.out.println(i);
        break;
      }
    }
    
  }
  
}