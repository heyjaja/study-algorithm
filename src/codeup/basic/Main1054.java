package codeup.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1054 {
  public static void main(String[] args) throws IOException {
    // 1054 : [기초-논리연산] 둘 다 참일 경우만 참 출력하기
    // 1055 : [기초-논리연산] 하나라도 참이면 참 출력하기
    // 1056 : [기초-논리연산] 참/거짓이 서로 다를 때에만 참 출력하기
    // 1057 : [기초-논리연산] 참/거짓이 서로 같을 때에만 참 출력하기
    // 1058 : [기초-논리연산] 둘 다 거짓일 경우만 참 출력하기

    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    
    System.out.println( (a==1 && b==1) ? 1: 0); // 1054
    System.out.println( (a==1 || b==1) ? 1: 0); // 1055
    System.out.println( (a==1 ^ b==1) ? 1: 0); // 1056
    System.out.println( (a==b) ? 1: 0); // 1057
    System.out.println( (a==0 && b==0) ? 1: 0); // 1058
    
    
  }
  
}