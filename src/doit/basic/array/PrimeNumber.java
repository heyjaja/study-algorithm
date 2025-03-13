package doit.basic.array;

public class PrimeNumber {

    static void printPrime1(int a) {
        int count = 0; // 나눈 횟수
        for(int n=2; n<=a; n++) {
            int i;

            for(i=2; i<n; i++) {
                count++;
                if(n%i==0) break;
            }

            if(n == i) { // 끝까지 나누어 떨어지지 않고 그대로일 때 소수
                System.out.println(n);
            }
        }

        System.out.println("printPrime1 count = " + count);
    }

    public static void main(String[] args) {
        // 1000 이하의 소수
        printPrime1(1000);
        // 2부터 n-1까지 어떤 소수로도 딱 나누어지지 않는다
        // 2로 나눠 지지 않으면 2의 배수로도 딱 나누어지지 않는다.
        printPrime2(1000);
        // 어떤 정수 n은 n의 제곱근 이하의 어떤 소수로도 딱 나누어지지 않는다.
        // 소수의 제곱이 n 이하의 수인가?
        printPrime3(1000);
    }

    private static void printPrime3(int a) {
        int count = 0;
        int num = 0;
        int[] prime = new int[500];

        prime[num++] = 2;
        prime[num++] = 3;

        for(int n=5; n<=a; n+=2) {
            boolean flag = true;
            for(int i=1; prime[i]*prime[i] <= n; i++) {
                count+=2; // 곱셈+나눗셈
                if(n%prime[i]==0) {
                    flag = false;
                    break;
                }
            }

            if(flag) {
                prime[num++] = n;
                count++;
            }
        }

        print(prime, count);
    }

    private static void printPrime2(int a) {
        int count = 0; // 나눈 횟수
        int num = 0; // 소수의 개수
        int[] prime = new int[500]; // 소수 저장

        prime[num++] = 2;

        for(int n=3; n<=a; n+=2) { // 짝수 제외
            int i;
            for(i=1; i<num;i++) {
                count++;
                if(n%prime[i] == 0) break;
            }

            if(num == i) {
                prime[num++] = n;
            }
        }
        print(prime, count);
    }

    private static void print(int[] prime, int count) {
        for (int i : prime) {
            if(i==0) break;
            System.out.println(i);
        }

        System.out.println("count = " + count);
    }
}
