package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1097 {
  public static void main(String[] args) throws IOException {
    // 1097 : [기초-2차원배열] 바둑알 십자 뒤집기
    // 흰돌:1, 검정돌:0
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int[][] board = new int[19][19];
    
    for(int i=0; i<19; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      for(int j=0; j<19; j++) {
        board[i][j]=Integer.parseInt(st.nextToken());
      }
    }

    int n = Integer.parseInt(br.readLine()); // 십자 뒤집기 횟수
    
    for(int i=0; i<n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      int a = Integer.parseInt(st.nextToken())-1;
      int b = Integer.parseInt(st.nextToken())-1;
      
      for(int j=0; j<board[a].length; j++) { // 가로 바꾸기
        if(board[a][j] == 0) {
          board[a][j] = 1;
        } else {
          board[a][j] = 0;
        }
      }
      
      for(int k=0; k<board.length; k++) { // 세로 바꾸기
        if(board[k][b] == 0) {
          board[k][b] = 1;
        } else {
          board[k][b] = 0;
        }
      }
    }
    
    
    for(int i=0; i<board.length; i++) {
      for(int j=0; j<board[i].length; j++) {
        System.out.print(board[i][j]+" ");
      }
      System.out.println();
    }
    
  }
  

}