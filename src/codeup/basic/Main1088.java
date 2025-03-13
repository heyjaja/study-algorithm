package codeup.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1088 {
  public static void main(String[] args) throws IOException {
    // 1088 : [기초-종합] 3의 배수는 통과?

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int n = Integer.parseInt(st.nextToken()); // 1~100
    
    for(int i=1; i<=n; i++) {
      if(i%3==0) {
        continue;
      }
      System.out.print(i+" ");
    }

  }

}