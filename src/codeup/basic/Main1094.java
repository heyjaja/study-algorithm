package codeup.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1094 {
  public static void main(String[] args) throws IOException {
    // 1094 : [기초-1차원배열] 이상한 출석 번호 부르기2
    // 거꾸로 출력
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    
    int[] students = new int[n];
    
    for(int i=0; i<n; i++) {
      students[i]=Integer.parseInt(st.nextToken());
    }
    
    for(int i=n-1; i>=0; i--) {
      System.out.print(students[i]+" ");
    }
    
  }
  

}