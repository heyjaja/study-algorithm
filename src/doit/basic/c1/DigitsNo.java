package basic.c1;

import java.util.Scanner;

public class DigitsNo {
  
  static int getNo(int n) {
    int result=0;
    
    while (n > 0) {
      n /= 10;
      result++;
    }
    
    return result;
  }

  public static void main(String[] args) {
    // 양의 정수를 입력받고 자릿수를 출력
    
    Scanner sc = new Scanner(System.in);
    
    int n;
    do {
      System.out.print("양의 정수 입력: ");
      n = sc.nextInt();
    } while(n <= 0);
    
    System.out.println("입력한 수는 " + (int)(Math.log10(n)+1) + "자리");
    System.out.println("메서드를 이용하여 풀이: " + getNo(n)+"자리");
  }

}
