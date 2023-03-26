package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Array4344 {

  public static void main(String[] args) throws IOException {
    // 첫째줄 테스트 케이스 C
    // 둘째줄부터 한줄로 학생 수 N, 점수 N개
    // 평균이 넘는 학생의 비율을 소수점 3자리까지 반올림하여 출력
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int c = Integer.parseInt(br.readLine());
    
    while(c>0) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      
      int arr[] = new int[Integer.parseInt(st.nextToken())];
      
      double sum = 0;
      
      for(int i=0; i<arr.length; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
        sum+=arr[i];
      }
      
      double avg = sum/arr.length;
      double count = 0;
      
      for(int i=0; i<arr.length; i++) {
        if(arr[i]>avg) {
          count++;
        }
      }
      
      System.out.printf("%.3f%%\n", (count/arr.length*100));
      
      c--;
      
    }
    
    
  }

}