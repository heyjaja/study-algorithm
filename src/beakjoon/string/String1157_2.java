package beakjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String1157_2 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    String str = br.readLine().toUpperCase();
    int arr[] = new int[26];
    
    for(char c : str.toCharArray()) {
      arr[c-'A']++;
    }
    
    int max=-1;
    char ans = ' ';
    for(int i=0; i<arr.length; i++) {
      if(arr[i]>max) {
        max=arr[i];
        ans = (char)(i+'A');
      } else if(arr[i]==max){
        ans = '?';
      }
    }
    System.out.println(ans);
  }
}
