import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Gallag {

  public static void main(String[] args) throws IOException {
    // 갤러그 문제
    // A>=B, A는 매일 *2, B는 매일 *3
    // A==B가 되려면 며칠이 걸릴까
    // 입력1> 테스트케이스 1<=T<=50
    // 입력2> A B (A>=B, 1<=B<=5000)
    // 출력> #T 소요일수
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int day;
    int t = Integer.parseInt(br.readLine());
    
    for(int i=1; i<=t; i++) {
      day=0;
      st = new StringTokenizer(br.readLine(), " ");
      int a=Integer.parseInt(st.nextToken());
      int b=Integer.parseInt(st.nextToken());
      
      
      while(true) {
        a*=2;
        b*=3;
        day++;
        if(a<b) break;
      }
      System.out.println("#"+i+" "+day);
    } 
  }

}
