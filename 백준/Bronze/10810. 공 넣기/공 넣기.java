import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[] arr = new int[n];
        
        for(int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int nn = sc.nextInt();
			
			for(; a <= b; a++) {
			    arr[a - 1] = nn;
			}
		}
		
		for(int i = 0; i < n; i++) {
		    System.out.print(arr[i] + " ");
		}
        
    }
}