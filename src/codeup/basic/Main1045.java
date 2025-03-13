package codeup.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1045 {
  public static void main(String[] args) throws IOException{
    // 1045 : [기초-산술연산] 정수 2개 입력받아 자동 계산하기
    // 첫 줄에 합
    // 둘째 줄에 차,
    // 셋째 줄에 곱,
    // 넷째 줄에 몫,
    // 다섯째 줄에 나머지,
    // 줄에 나눈 값을 순서대로 출력한다.
    // (실수, 소수점 이하 셋째 자리에서 반올림해 둘째 자리까지 출력)
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    
    long a = Long.parseLong(st.nextToken());
    long b = Long.parseLong(st.nextToken());
    
    System.out.printf("%d\n%d\n%d\n%d\n%d\n%.2f", a+b, a-b, a*b, a/b, a%b, (float)a/b);
    
    
  }
}
