package doit.basic.c1;

public class MaxMin {

  public static void main(String[] args) {
    long before = System.currentTimeMillis();
    
    System.out.println(max4(1,2,3,4));
    
    long after = System.currentTimeMillis();
    
    System.out.println("max4: "+ (after - before));
    
    System.out.println(min4(5, 8, 7, 2));
  }
  
  // 4개의 값 중 최댓값 구하기
  static int max4(int a, int b, int c, int d) {
    int max = a;
    
    if(max < b) {
      max = b;
    } 
    
    if (max < c) {
      max = c;
    } 
    
    if(max < d) {
      max = d;
    }
    
    return max;
  }
  
  // 4개의 값 중 최솟값 구하기
  static int min4(int a, int b, int c, int d) {
    int min = a;
    
    if(min > b) {
      min = b;
    }
    if(min >c) {
      min = c;
    }
    
    if(min > d) {
      min = d;
    }
    
    return min;
  }

}
