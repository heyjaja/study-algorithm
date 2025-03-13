package codeup.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1046 {
  public static void main(String[] args) throws IOException{
    // 1046 : [기초-산술연산] 정수 3개 입력받아 합과 평균 출력하기
    // 합과 평균을 줄을 바꿔 출력한다.
    // 평균은 소수점 이하 둘째 자리에서 반올림해서 소수점 이하 첫째 자리까지 출력한다.
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    
    long a = Long.parseLong(st.nextToken());
    long b = Long.parseLong(st.nextToken());
    long c = Long.parseLong(st.nextToken());
    
    System.out.printf("%d\n%.1f", (a+b+c), (float)(a+b+c)/3);
    
    
  }
}
