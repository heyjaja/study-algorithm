package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1081 {
  public static void main(String[] args) throws IOException {
    // 1081 : [기초-종합] 주사위를 2개 던지면?
    // 이중 for문
    // 주사위 2개의 면의 개수 n, m이 공백을 두고 입력된다.
    // 나올 수 있는 주사위의 숫자를 한 세트씩 줄을 바꿔 모두 출력한다.
    // 첫 번째 수는 n, 두 번째 수는 m으로 고정해 출력하도록 한다.
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    
    for(int i=1; i<=a; i++) {
      for(int j=1; j<=b; j++) {
        System.out.println(i+" "+j);
      }
    }
    
    
  }
  
}