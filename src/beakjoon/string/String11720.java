package beakjoon.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class String11720 {

  public static void main(String[] args) throws IOException {
    // 입력1> 숫자의 개수 N
    // 입력2> 공백 없는 숫자 N개
    // 출력1> 숫자 N개의 합
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    int n = Integer.parseInt(br.readLine());
    String str = br.readLine();
    
    int sum =0;
    
    for(int i=0; i<n; i++) {
      sum += (str.charAt(i)-'0');
    }
    bw.write(sum+"");
    bw.flush();
    bw.close();
  }

}
