package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Array8958 {

  public static void main(String[] args) throws IOException {
    // OX 퀴즈 정답 O, 오답 X
    // 정답당 1점씩 연속 정답 시 1+2+3+...
    // 첫째줄에 테스트케이스 n
    // 둘째줄부터 OX 퀴즈 정답 문자열 한줄씩 "OOXXOXOXOOX"
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String arr[] = new String[n];
    
    
    for(int i=0; i<n; i++) {
      int score=0;
      int sum=0;
      arr[i] = br.readLine();
      for(char c : arr[i].toCharArray()) {
        if(c=='O') {
          score += 1;
          sum += score;
        } else {
          score = 0;
        }
      }
      System.out.println(sum);
    }
    
    
  }

}