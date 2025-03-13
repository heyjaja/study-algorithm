package doit.basic.c1;

public class Multi99Table {

  public static void main(String[] args) {
    // 곱셈표 출력
    //   | 1 2 3 4 5 6 7 8 9
    // --+-------------------
    // 1 | 1 2 3 4 5 6 7 8 9
    
    System.out.println("  | 1  2  3  4  5  6  7  8  9");
    System.out.println("--+---------------------------");
    for(int i=1; i<=9; i++) {
      System.out.print(" "+i+"|");
      for(int j=1; j<=9; j++) {
        int m = i * j;
        System.out.print(m < 10 ? " "+m+" " : m+ " ");
      }
      System.out.println();
    }
  }

}
