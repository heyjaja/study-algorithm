package codeup.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1087 {
  public static void main(String[] args) throws IOException {
    // 1087 : [기초-종합] 여기까지! 이제 그만~
    // 1, 2, 3 ... 을 순서대로 계속 더해나갈 때, 그 합이 입력한 정수보다 작을 동안만 계속 더하는 프로그램
    // 최종 합 출력

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int n = Integer.parseInt(st.nextToken()); // 100,000,000 이하
    
    int sum = 0;
    
    for(int i=1; ; i++) {
      sum += i;
      if(sum >= n) {
        break;
      }
    }
    System.out.println(sum);

  }

}