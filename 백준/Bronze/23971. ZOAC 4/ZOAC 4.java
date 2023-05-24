import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int h = sc.nextInt();
        int w = sc.nextInt();
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        double result = Math.ceil((double)h/(n+1)) * Math.ceil((double)w/(m+1));
        System.out.println((int)result);
    }
}