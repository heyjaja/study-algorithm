package beakjoon.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Array1546 {

  public static void main(String[] args) throws IOException {
    // 점수 중 최대값 m, 모든 점수를 점수/m*100
    // 최고점 70, 수학점수 50 => 50/70*100 = 71.43
    // 고친 점수의 새로운 평균 구하기
    // 첫째 줄에 시험 본 과목의 개수 n <= 1000
    // 둘째 줄 0=<현재 성적<=100
        
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n= Integer.parseInt(br.readLine());
    
    
    double arr[] = new double[n];
    
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    
    double max = 0;
    for(int i=0; i<arr.length; i++) {
      arr[i] = Double.parseDouble(st.nextToken());
      if(arr[i]>max) {
        max=arr[i];
      }
    }
    double sum=0.0;
    for(int i=0; i<arr.length; i++) {
      arr[i] = arr[i]/max*100;
      sum+=arr[i];
    }
    System.out.println(sum/arr.length);
    
    
  }

}
