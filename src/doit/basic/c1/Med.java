package doit.basic.c1;

import java.util.Scanner;

public class Med {

  static int med3(int a, int b, int c) {
    // 3개의 정숫값을 입력하고 중앙값을 구한 다음 출력
    if (a >= b) {
      if (b >= c) {
        return b;
      } else if (a <= c) { 
        return a;
      } else {
        return c;
      }
    } else if (a > c) {
      return a;
    } else if (b > c) {
      return c;
    } else {
      return b;
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();
    
    System.out.println("3개 정수의 중앙값은 " + med3(a, b, c));
  }

}
