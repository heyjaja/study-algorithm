package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1085 {
  public static void main(String[] args) throws IOException {
    // 1085 : [기초-종합] 소리 파일 저장용량 계산하기

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int h = Integer.parseInt(st.nextToken()); // 48000 이하
    int b = Integer.parseInt(st.nextToken()); // 8의 배수 ~32
    int c = Integer.parseInt(st.nextToken()); // 5 이하
    int s = Integer.parseInt(st.nextToken()); // 6000 이하
    
    long bits = h * (b/8) * c * s; // 여기서 먼저 /8로 byte를 bit로 변환 -> 범위 초과 
    
    double mb = bits/(Math.pow(2, 20));
    
    System.out.printf("%.1f MB", mb);


  }

}