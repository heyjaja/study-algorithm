package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1072 {
  public static void main(String[] args) throws IOException {
    // 1072 : [기초-반복실행구조] 정수 입력받아 계속 출력하기
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    br.readLine();
    
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    
    print(st);
    
    
  }
  
  static void print(StringTokenizer st) {
    
    int a = Integer.parseInt(st.nextToken());
    
    System.out.println(a);
    
    if(st.hasMoreTokens()) {
      print(st);
    } 
  }
  
}