import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int i = 1;
        int a = 1;
        while(true) {
            if(n <= a) {
                System.out.println(i);
                break;
            }
    
            a += 6*i;
            i++;
        }
    }
}