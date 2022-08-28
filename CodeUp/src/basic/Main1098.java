package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1098 {
  public static void main(String[] args) throws IOException {
    // 1098 : [기초-2차원배열] 설탕과자 뽑기

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int h = Integer.parseInt(st.nextToken()); // 세로
    int w = Integer.parseInt(st.nextToken()); // 가로

    int[][] board = new int[h][w];

    int n = Integer.parseInt(br.readLine()); // 막대 개수

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine(), " ");

      int l = Integer.parseInt(st.nextToken()); // 막대 길이
      int d = Integer.parseInt(st.nextToken()); // 방향 가로:0, 세로:1
      int x = Integer.parseInt(st.nextToken()) - 1; // x좌표
      int y = Integer.parseInt(st.nextToken()) - 1; // y좌표

      for (int j = 0; j < l; j++) { // 가로
        if (d == 0) {
          board[x][y + j] = 1;
        } else {
          board[x + j][y] = 1;
        }
      }
    }

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }

  }

}