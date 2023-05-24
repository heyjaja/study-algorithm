import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        
        Arrays.sort(arr);
        
        int sum = 0;
        int count = 0;
        int i = 0;
        int j = n-1;
        
        while(i < j) {
            sum = arr[i] + arr[j];
            
            if(sum == m) {
                count++;
                i++;
                j--;
            }
            
            if(sum < m) {
                i++;
            }
            
            if(sum > m) {
                j--;
            }
            
        }
        
        System.out.println(count);
	}
}
