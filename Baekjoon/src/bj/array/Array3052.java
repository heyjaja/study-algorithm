package bj.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Array3052 {

  public static void main(String[] args) throws IOException {
    // 숫자 10개를 입력 받아 42의 나머지를 구하고
    // 서로 다른 나머지 값이 몇개인지 출력
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int arr[] = new int[10];
    
    int cnt = 10;
    for(int i=0; i<arr.length; i++) {
      arr[i] = (Integer.parseInt(br.readLine()))%42;
    }
    
    for(int i=0; i<arr.length; i++) {
      for(int j=0; j<i; j++) {
        if (i!=j && arr[j]==arr[i]) {
          cnt--;
          break;
        } 
      }
    }
    System.out.println(cnt);
    System.out.println(Arrays.toString(arr));
  }

}
