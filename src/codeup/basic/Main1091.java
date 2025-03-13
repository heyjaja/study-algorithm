package codeup.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1091 {
  public static void main(String[] args) throws IOException {
    // 1091 : [기초-종합] 수 나열하기3, 수열

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int a = Integer.parseInt(st.nextToken()); // 시작 값
    int b = Integer.parseInt(st.nextToken()); // 곱할 값
    int c = Integer.parseInt(st.nextToken()); // 더할 값
    int n = Integer.parseInt(st.nextToken()); // n번째
    
    System.out.println(sol(a, b, c, n));

  }
  
  static Long sol(int a, int b, int c, int n) {
    if(n==1) {
      return (long)a;
    }
    return sol(a, b, c, n-1) * b + c;
  }
  

}