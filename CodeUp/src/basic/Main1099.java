package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1099 {
  public static void main(String[] args) throws IOException {
    // 1099 : [기초-2차원배열] 성실한 개미

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[][] miro = new int[10][10];
    
    for(int i=0; i<miro.length; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      for(int j=0; j<miro.length; j++) {
        miro[i][j]=Integer.parseInt(st.nextToken());
      }
    }
    int i,j;
    int y = 1; // y좌표 기억하기
    boolean flag = false; // 먹이 발견 종료
    
    for(i=1 ; i<miro.length; i++) {
      for(j=y ; j<miro[i].length; j++) {
       int location = miro[i][j];
       if(location==0) { // 그냥 길
         miro[i][j]=9;
         continue;
       } else if(location==1) { // 벽
         y=j-1;
         break;
       } else if (location==2) { // 먹이
         miro[i][j]=9;
         flag = true;
         break;
       }
      }
      if(flag) {
        break;
      }
    }

    for (i = 0; i < miro.length; i++) {
      for (j = 0; j < miro[i].length; j++) {
        System.out.print(miro[i][j] + " ");
      }
      System.out.println();
    }

  }

}