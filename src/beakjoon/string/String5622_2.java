package beakjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String5622_2 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    String s = br.readLine();
    
    int ans = 0;
    
    for(char c : s.toCharArray()) {
      
      switch (c) {
      case 'A': case 'B': case 'C':
        ans += 3;
        break;
      case 'D': case 'E': case 'F':
        ans += 4;
        break;
      case 'G': case 'H': case 'I':
        ans += 5;
        break;
      case 'J': case 'K': case 'L':
        ans += 6;
        break;
      case 'M': case 'N': case 'O':
        ans += 7;
        break;
      case 'P': case 'Q': case 'R': case 'S':
        ans += 8;
        break;
      case 'T': case 'U': case 'V':
        ans += 9;
        break;
      case 'W': case 'X': case 'Y': case 'Z':
        ans += 10;
        break;
      }
      
    }
    
    System.out.println(ans);
  }
}
