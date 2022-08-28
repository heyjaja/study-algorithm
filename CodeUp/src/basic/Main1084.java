package basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main1084 {
  public static void main(String[] args) throws IOException {
    // 1084 : [기초-종합] 빛 섞어 색 만들기

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // print 사용시 시간초과로 bufferedWriter 사용
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    int cnt = 0;
    for (int i = 0; i < a; i++) {
      for (int j = 0; j < b; j++) {
        for (int k = 0; k < c; k++) {
          bw.write(i + " " + j + " " + k + "\n");
          cnt++;
        }
      }
    }
    // 시간 초과시 flush() 위치 중요
    bw.flush();
    System.out.println(cnt);

  }

}