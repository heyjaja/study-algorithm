import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int n = Integer.parseInt(br.readLine());
    
    System.out.println(ap(n));
    
  }
  
  static int ap(int a) {
   int cnt = 0;
   if(a <100) {
     return a;
   } else {
     cnt = 99;
     if(a == 1000) {
       a = 999;
     }
     
     for(int i=100; i<=a; i++) {
       int i1 = i/100;
       int i2 = (i/10)%10;
       int i3 = i%10;
       
       if(i1-i2 == i2-i3)
         cnt++;
     }
     return cnt;
   }

  }
 
}
