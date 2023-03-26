package basic.c1;

import java.util.Scanner;

public class SumFor {
  
  static int gauss(int n) {
  // 가우스 덧셈: 1~10의 합은 (1+10)*5로 표현
    return (int)((1+n)*(n/2.0));
  }
  
  static int sumof(int a, int b) {
    int atoB;
    if(a > b) {
      atoB = a - b + 1;
    } else {
      atoB = b - a + 1;
    }
    
    return (int)((a+b)*(atoB/2.0));
  }

  public static void main(String[] args) {
    // 1, 2, 3, ..., n의 합
    Scanner sc = new Scanner(System.in);
    
    System.out.println("1부터 n까지의 합 구하기");
    System.out.print("n: ");
    int n = sc.nextInt();
    
    int sum = 0;
    
    for(int i=1; i<=n; i++) {
      sum += i;
    }
    
    System.out.println("1부터 "+n+"까지의 합: " + sum);
    System.out.println("가우스 덧셈을 이용한 연산 결과: "+gauss(n));
    
    System.out.println("a부터 b까지 모든 정수의 합 구하기");
    System.out.print("a: ");
    int a = sc.nextInt();
    System.out.print("b: ");
    int b = sc.nextInt();
    
    System.out.println("a부터 b까지 모든 정수의 합: "+ sumof(a, b));
    
  }

}
