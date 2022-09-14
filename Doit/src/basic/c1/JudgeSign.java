package basic.c1;

import java.util.Scanner;

public class JudgeSign {

  public static void main(String[] args) {
    // 입력한 정숫값이 양수인지 음수인지 0인지 판단
    
    Scanner sc = new Scanner(System.in);
    
    int n = sc.nextInt();
    
    if(n > 0) {
      System.out.println("양수");
    } else if(n < 0) {
      System.out.println("음수");
    } else {
      System.out.println("0");
    }
  }

}
