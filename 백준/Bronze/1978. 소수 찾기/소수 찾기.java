import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        int count = 0;
        int total = 0;
        for(int i=0; i<n; i++) {
            count = 0;
            int a = sc.nextInt();
       
            for(int j=2; j<=a; j++) {
                if(a%j==0) {
                    count++;
                }
            }
            if(count == 1) {
                total++;
            }
        }
        
        System.out.println(total);
    }
}