package string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class String2908 {

  public static void main(String[] args) throws IOException {
    // 세자리수 2개 거꾸로 비교
    // 입력1> 세자리 수 A, B 같지 않고, 0 포함x
    // 출력1> 더 큰 수 1개
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    
    String a = new StringBuffer(st.nextToken()).reverse().toString();
    String b = new StringBuffer(st.nextToken()).reverse().toString();
    
    if(Integer.parseInt(a)>Integer.parseInt(b)) {
      bw.write(a);
    } else {
      bw.write(b);
    }
    bw.flush();
    
  }

}
