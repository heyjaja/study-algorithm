package array;

import java.util.Scanner;

public class Array2577 {

  public static void main(String[] args) {
    // 3개의 자연수, A*B*C를 계산한 결과에 0~9 각각의 숫자가 몇번 쓰였는지 구하는 프로그램
    // A = 150. B=266, C=427 A*B*C = 150*266*427 = 17037300
    // 0 3번, 1 1번, 3 2번, 7 2번
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();
   
    String m = (a*b*c)+"";
    
    int arr[] = new int[10];
    
    for(int i=0; i<arr.length; i++) {
      for(int j=0; j<m.length(); j++) {
        if(m.charAt(j)==(i+'0')) {
          arr[i]++;
        }
      }
      System.out.println(arr[i]);
    }
    
  }
}
