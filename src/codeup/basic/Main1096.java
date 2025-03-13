package codeup.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1096 {
  public static void main(String[] args) throws IOException {
    // 1096 : [기초-2차원배열] 바둑판에 흰 돌 놓기
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int n = Integer.parseInt(br.readLine());
    
    int[][] board = new int[19][19];
    
    for(int i=0; i<n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      board[a-1][b-1] = 1;
    }
    br.close();
    
    for(int i=0; i<board.length; i++) {
      for(int j=0; j<board[i].length; j++) {
        System.out.print(board[i][j]+" ");
      }
      System.out.println();
    }
    
  }
  

}