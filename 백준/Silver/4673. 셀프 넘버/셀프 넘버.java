import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
  static void selfNum() {
    List<Integer> list = new ArrayList<Integer>();
    
    for(int i=1; i<=10000; i++) {
      int a=getNum(i);
      list.add(a);
    }
    
    for(int i=1; i<=10000; i++) {
      boolean s=true;
      for(int j : list) {
        if(i==j) {
          s=false;
          break;
        }
      }
      if(s)
        System.out.println(i);
    }
  }
  
  static int getNum(int i) {
    int ans = i;
    while(i>0) {
      ans += i%10;
      i /= 10;
    }
    return ans;
  }
  
  public static void main(String[] args) {
    selfNum();
  }
}
