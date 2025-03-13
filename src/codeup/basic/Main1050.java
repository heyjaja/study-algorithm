package codeup.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1050 {
  public static void main(String[] args) throws IOException {
    // 1050 : [기초-비교연산] 두 정수 입력받아 비교하기2
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    
    System.out.println(a==b ? 1: 0);
    
  }
  
}