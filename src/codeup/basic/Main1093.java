package codeup.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1093 {
  public static void main(String[] args) throws IOException {
    // 1093 : [기초-1차원배열] 이상한 출석 번호 부르기1
    // 학생들 출석 불린 횟수

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    
    int[] students = new int[23];
    
    while(st.hasMoreTokens()) {
      int i = Integer.parseInt(st.nextToken()) - 1;
      students[i]++;
    }
    
    for(int i=0; i<students.length; i++) {
      System.out.print(students[i]+" ");
    }
    
  }
  

}