package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1092 {
  public static void main(String[] args) throws IOException {
    // 1092 : [기초-종합] 함께 문제 푸는 날
    // 같은 날 동시에 가입한 인원 3명이 규칙적인 방문 주기가 공백을 두고 입력 (단, 입력값은 100이하)
    // 3명이 다시 모두 함께 방문해 문제를 풀어보는 날을 출력

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());
    
    System.out.println(solution(a, b, c));

  }
  
  static int solution(int a, int b, int c) {
    int day=1;
    
    for(day = 1; ; day++) {
      if(day%a==0 && day%b==0 && day%c==0) {
        break;
      }
    }
    
    return day;
  }
  

}