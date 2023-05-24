import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt();
        int n = sc.nextInt();
        int v = sc.nextInt();

        int day = (int)Math.ceil((double)(v - n)/(d - n));

        System.out.println(day);
    }

}