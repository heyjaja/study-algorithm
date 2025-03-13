package codeup.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1086 {
  public static void main(String[] args) throws IOException {
    // 1086 : [기초-종합] 그림 파일 저장용량 계산하기
    // 해상도 1024 * 768, 24bit => 1024*768*24 = 용량 bytes

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int w = Integer.parseInt(st.nextToken()); // 1~1024
    int h = Integer.parseInt(st.nextToken()); // 1~1024
    int b = Integer.parseInt(st.nextToken()); // 4의 배수 ~40
    
    int bytes = w * h * b;
    
    double mb = (bytes/8) / (Math.pow(2, 20));
    
    System.out.printf("%.2f MB", mb);

  }

}