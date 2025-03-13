package codeup.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1071 {
  public static void main(String[] args) throws IOException {
    // 1071 : [기초-반복실행구조] 0 입력될 때까지 무한 출력하기1
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    
    print(st);
    
    
  }
  
  static void print(StringTokenizer st) {
    
    int a = Integer.parseInt(st.nextToken());
    
    if(a==0) {
      return;
    }
    System.out.println(a);
    
    if(st.hasMoreTokens()) {
      print(st);
    }
  }
  
}