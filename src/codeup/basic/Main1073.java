package codeup.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1073 {
  public static void main(String[] args) throws IOException {
    // 1073 : [기초-반복실행구조] 0 입력될 때까지 무한 출력하기2
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    
    while(st.hasMoreTokens()) {
      int a = Integer.parseInt(st.nextToken());
      
      if(a==0) {
        break;
      } 
      
      System.out.println(a);
    }
    
  }
  
}