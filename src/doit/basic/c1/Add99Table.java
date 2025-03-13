package doit.basic.c1;

public class Add99Table {

  public static void main(String[] args) {
    // 덧셈표 출력
    //   | 1 2 3 4 5 6 7 8 9
    // --+-------------------
    // 1 | 2 3 4 5 6 7 8 9 10
    
    System.out.println("  | 1  2  3  4  5  6  7  8  9");
    System.out.println("--+---------------------------");
    for(int i=1; i<=9; i++) {
      System.out.printf("%2d|", i);
      for(int j=1; j<=9; j++) {
        System.out.printf("%3d", i+j);
      }
      System.out.println();
    }
  }

}
