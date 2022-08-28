package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1089 {
  public static void main(String[] args) throws IOException {
    // 1089 : [기초-종합] 수 나열하기1, 등차수열
    // 시작 값(a), 등차(d), 몇 번째인지를 나타내는 정수(n)가 입력될 때 n번째 수를 출력하는 프로그램

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int a = Integer.parseInt(st.nextToken()); // 시작 값
    int b = Integer.parseInt(st.nextToken()); // 등차
    int n = Integer.parseInt(st.nextToken()); // n번째
    
    System.out.println(sol(a, b, n));

  }
  
  static int sol(int a, int b, int n) {
    if(n==1) {
      return a;
    }
    return sol(a, b, n-1) + b;
  }
  

}