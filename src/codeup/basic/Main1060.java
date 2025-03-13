package codeup.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1060 {
  public static void main(String[] args) throws IOException {
    // 1060 : [기초-비트단위논리연산] 비트단위로 AND 하여 출력하기
    // 1061 : [기초-비트단위논리연산] 비트단위로 OR 하여 출력하기
    // 1062 : [기초-비트단위논리연산] 비트단위로 XOR 하여 출력하기
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    
    System.out.println(a&b); // 비트연산자 and
    System.out.println(a|b); // or
    System.out.println(a^b); // xor
    
    
  }
  
}