package beakjoon.basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3003 {
  
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    
    int[] arr = {1, 1, 2, 2, 2, 8};
    
    for(int i=0; i<arr.length; i++) {
      int n = Integer.parseInt(st.nextToken());
      
      arr[i] = arr[i] - n;
      
      System.out.print(arr[i] + " ");
    }
    
    
  }

}
