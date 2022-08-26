package array;

import java.util.Scanner;

public class Array2562 {

  public static void main(String[] args) {
    //최대값을 찾고 몇 번째 수인지 구하기
    //9개의 서로 다른 자연수
    Scanner sc = new Scanner(System.in);
    int arr[] = new int[9];
    int max=0;
    int no=-1;
    for(int i=0; i<9; i++) {
      arr[i] = sc.nextInt();
      if (arr[i]>max) {
        max=arr[i];
        no=i+1;
      }
    }
    System.out.println(max);
    System.out.println(no);
  }

}
