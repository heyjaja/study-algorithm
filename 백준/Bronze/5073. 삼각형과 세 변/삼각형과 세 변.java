import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] arr = new int[3];
        
        while(true) {
            
            int i = 0;
            
            arr[i++] = sc.nextInt();
            arr[i++] = sc.nextInt();
            arr[i++] = sc.nextInt();
            
            if(arr[0] == 0) break;
            
            String answer = "";
            Arrays.sort(arr);
            
            if(arr[0] + arr[1] <= arr[2]) {
                System.out.println("Invalid");
                continue;
            }
            
            if(arr[0] == arr[1] && arr[1] == arr[2]) {
                answer = "Equilateral";
            } else if(arr[0] != arr[1] && arr[1] != arr[2] && arr[0] != arr[2]) {
                answer = "Scalene";
            } else {
                answer = "Isosceles";
            }
            
            System.out.println(answer);
            
        }
    }
}