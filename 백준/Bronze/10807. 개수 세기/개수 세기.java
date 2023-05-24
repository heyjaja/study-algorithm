import java.util.Scanner;

public class Main {
    
    static int getCount(int n, int[] a) {
        int count = 0;
        
        for(int i = 0; i < a.length; i++) {
            if(a[i] == n) {
                count++;
            }
        }
        
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        
        sc.nextLine();
        
        String[] a = sc.nextLine().split(" ");
        
        int n = sc.nextInt();
        
        int[] b = new int[length];
                
        for(int i = 0; i < length; i++) {
            b[i] = Integer.parseInt(a[i]);
        }
        
        System.out.print(getCount(n, b));
    }
}