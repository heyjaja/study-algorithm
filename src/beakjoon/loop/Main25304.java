package beakjoon.loop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main25304 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    StringTokenizer st;
    
    int x = Integer.parseInt(br.readLine());
    int n = Integer.parseInt(br.readLine());
    
    int sum = 0;
    
    for(int i=0; i<n; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      sum += (Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken()));
    }
    
    System.out.println(x == sum ? "Yes" : "No");
  }

}
