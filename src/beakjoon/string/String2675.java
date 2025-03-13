package beakjoon.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class String2675 {

  public static void main(String[] args) throws IOException {
    // 반복 횟수만큼 문자열의 각 문자 반복
    // 입력1> 테스트케이스 개수 1<=T<=1000
    // 입력2> 반복횟수 1<=R<=8 +" "+ 문자열 S(1<=s.length()<=20)
    // 출력1> 결과 문자열 p 출력
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    
    int t = Integer.parseInt(br.readLine());
    String p = "";
    for(int i=0; i<t; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int r = Integer.parseInt(st.nextToken());
      String s = st.nextToken();
      p = "";
      for(int j=0; j<s.length(); j++) {
        for(int k=0; k<r; k++) {
          p += s.charAt(j);
        }
      }
      bw.write(p+"\n");
      bw.flush();
    }
  }

}
