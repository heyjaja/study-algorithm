package codeup.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1090 {
  public static void main(String[] args) throws IOException {
    // 1090 : [기초-종합] 수 나열하기2, 등비수열
    // 시작 값(a), 공비(d), 몇 번째인지를 나타내는 정수(n)가 입력될 때 n번째 수를 출력하는 프로그램

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int a = Integer.parseInt(st.nextToken()); // 시작 값
    int b = Integer.parseInt(st.nextToken()); // 공비
    int n = Integer.parseInt(st.nextToken()); // n번째
    
    System.out.println(sol(a, b, n));
    
    // 공식: n번째 = 시작값 * 공비^n-1
    long c = (long) (a* Math.pow(b, n-1));
    System.out.println(c);
    
    // for문을 이용한 풀이
    long i, j;
    for(i=a, j=1; ; j++, i *= b) {
      if(j == n) {
        break;
      }
    }
    System.out.println(i);

  }
  
  static Long sol(int a, int b, int n) {
    if(n==1) {
      return (long)a;
    }
    return sol(a, b, n-1) * b;
  }
  

}