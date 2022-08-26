package conditional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class If2525 {

  public static void main(String[] args) throws IOException {
    // 입력1> 현재시각 시 분
    // 입력2> 소요시간 분
    // 출력1> 종료시각 시 분
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    
    int h = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    
    int t = Integer.parseInt(br.readLine());
    
    if(m+t>=60) {
      h += (m+t)/60;
      m = (m+t)%60;
      if(h>=24) {
        h = h-24;
      }
    } else {
      m = m+t;
    }
    System.out.println(h+" "+m);
  }

}
