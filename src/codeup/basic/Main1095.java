package codeup.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1095 {
  public static void main(String[] args) throws IOException {
    // 1095 : [기초-1차원배열] 이상한 출석 번호 부르기3
    // 출석 번호를 n번 무작위로 불렀을 때, 가장 빠른 번호를 출력
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    
    int[] students = new int[n];
    
    for(int i=0; i<n; i++) {
      students[i]=Integer.parseInt(st.nextToken());
    }
    
    int min=students[0];
    for(int i=1; i<students.length; i++) {
      if(min > students[i]) {
        min = students[i];
      }
    }
    System.out.println(min);
  }
  

}