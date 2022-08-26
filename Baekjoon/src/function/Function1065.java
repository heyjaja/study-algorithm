package function;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Function1065 {

  public static void main(String[] args) throws IOException {
    // 한수 = 어떤 양의 정수 X의 각 자리가 등차수열을 이루는 수
    // 입럭1> 양의 정수 n
    // 출력1> 1~n 중 한수의 개수 출력
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int n = Integer.parseInt(br.readLine());
    
    System.out.println(ap(n));
    
  }
  
  static int ap(int a) {
   int cnt = 0;
   if(a <100) { // 1~99는 모두 한수
     return a;
   } else {
     cnt = 99; // 100보다 크면 한수의 수는 99부터 시작
     if(a == 1000) { // 1000은 한수가 아니므로 제외하고 999로 설정
       a = 999;
     }
     
     for(int i=100; i<=a; i++) {
       int i1 = i/100; // 100의 자리수
       int i2 = (i/10)%10; // 10의 자리수
       int i3 = i%10; // 1의 자리수
       
       if(i1-i2 == i2-i3) // 각 자리수의 차가 같을 경우 등차수열 성립
         cnt++;
     }
     return cnt;
   }

  }
 
}
