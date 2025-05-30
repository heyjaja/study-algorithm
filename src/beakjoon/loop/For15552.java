package beakjoon.loop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class For15552 {

  public static void main(String[] args) throws IOException {
    // 빠른 A+B
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    int n = Integer.parseInt(br.readLine());
    
    for(int i=0; i<n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      
      bw.write((Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken()))+"\n");
      
      
    }
    br.close();
    bw.flush();
    bw.close();
  }

}
