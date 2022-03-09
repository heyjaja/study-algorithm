package bj.conditional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class If2480 {

  public static void main(String[] args) throws IOException {
    // 3개의 주사위
    // 같은 눈 3개 = 10,000+(같은 눈)*1,000원
    // 2개 = 1,000+(같은 눈)*100원
    // X = (가장 큰 눈)*100원
    // 입력1> 3개의 눈 빈칸으로 구분
    // 출력1> 상금
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());
    
    int prize, max;
    
    if(a==b && b==c) {
      prize = 10000+a*1000;
    } else if(a==b || a==c) {
      prize = 1000+a*100;
    } else if(b==c) {
      prize =1000+b*100;
    } else {
      if(a>b) {
        max=a;
      } else {
        max=b;
      }
      if(max<c) {
        max=c;
      }
      prize = max*100;
    }
    System.out.println(prize);
  }

}
