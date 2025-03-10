import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Policy y = new Policy("Y", 30, 10);
        Policy m = new Policy("M", 60, 15);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        int yResult = y.calculatePrices(n, arr);
        int mResult = m.calculatePrices(n, arr);

        if(yResult < mResult) {
            System.out.println(y.name + " " + yResult);
        } else if(mResult < yResult) {
            System.out.println(m.name + " " + mResult);
        } else {
            System.out.println(y.name + " " + m.name + " " + yResult);
        }
    }
}

class Policy {
    String name;
    int time;
    int rate;

    public Policy(String name, int time, int rate) {
        this.name = name;
        this.time = time;
        this.rate = rate;
    }

    public int calculatePrices(int n, int[] seconds) {
        int sum = 0;
        for(int i=0; i<n; i++) {
            sum += calculatePrice(seconds[i]);
        }

        return sum;
    }

    private int calculatePrice(int seconds) {
        if(seconds < time) {
            return rate;
        }

        return (seconds/time + 1) * rate;
    }
}