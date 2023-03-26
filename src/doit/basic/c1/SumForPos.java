package basic.c1;

import java.util.Scanner;

public class SumForPos {

  public static void main(String[] args) {
    // b>a가 될 때까지 입력 받고 b-a 출력
    Scanner sc = new Scanner(System.in);
    
    System.out.print("a: ");
    int a = sc.nextInt();
    int b;
    
    do {
      System.out.print("b: ");
      b = sc.nextInt();
      if(b <= a) {
        System.out.println("a보다 큰 값을 입력해주세요.");
      }
    } while (b <= a);
    
    System.out.println("b - a = "+(b-a));
  }

}
