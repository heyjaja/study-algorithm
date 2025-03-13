package doit.basic.c1;

import java.util.Scanner;

public class Square {
  public static void main(String[] args) {
    // 1, 2, 3, ..., n의 합
    Scanner sc = new Scanner(System.in);
    
    System.out.println("사각형 출력");
    System.out.print("수: ");
    int n = sc.nextInt();
    
    for(int i=0; i<n; i++) {
      for(int j=0; j<n; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
    
  }
}
