package codeup.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1089_2 {
  public static void main(String[] args) throws IOException {
    // 1089 : [기초-종합] 수 나열하기1, 등차수열
    // 시작 값(a), 등차(d), 몇 번째인지를 나타내는 정수(n)가 입력될 때 n번째 수를 출력하는 프로그램

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int a = Integer.parseInt(st.nextToken()); // 시작 값
    int b = Integer.parseInt(st.nextToken()); // 등차
    int n = Integer.parseInt(st.nextToken()); // n번째
    
    int i, j;
    for(i=a, j=1; ;j++, i+=b) {
      if(j==n) break;
    }
    
    System.out.println(i);
    
    System.out.println(a+(b*n-b)); // 등차수열 합공식 = 첫째항+(등차*(n-1))
  }
  

}