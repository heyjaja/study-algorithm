package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1063 {
  public static void main(String[] args) throws IOException {
    // 1063 : [기초-삼항연산] 두 정수 입력받아 큰 수 출력하기
    // 1064 : [기초-삼항연산] 정수 3개 입력받아 가장 작은 수 출력하기
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());
    
    System.out.println(a>b ? a : b); // 1063
    int d;
    System.out.println( (d = a<b ? a:b) > c ? c : d ); // 1064
    
    
  }
  
}