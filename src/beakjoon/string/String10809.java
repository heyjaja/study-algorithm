package beakjoon.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class String10809 {

  public static void main(String[] args) throws IOException {
    // 입력1> 소문자 영어 문자열
    // 출력1> 알파벳 자리별 처음 등장 위치, 없으면 -1 공백 구분
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    String ap = "abcdefghijklmnopqrstuvwxyz";
    String str = br.readLine();
    
    for(int i=0; i<ap.length(); i++) {
      int idx=-1;
      for(int j=0; j<str.length(); j++) {
        if(ap.charAt(i)==str.charAt(j)) {
          idx=j;
          break;
        }
      }
      bw.write(idx+" ");
    }
    bw.flush();
    bw.close();
  }

}
