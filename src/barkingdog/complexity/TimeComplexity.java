package barkingdog.complexity;

public class TimeComplexity {

    public static void main(String[] args) {
        System.out.println("=== func1 ===");
        System.out.println(func1(12));
        System.out.println(func1(34567));
        System.out.println(func1(27639));
        System.out.println("=== func2 ===");
        System.out.println(func2(new int[]{1, 52, 48}, 3));
        System.out.println(func2(new int[]{50, 42}, 2));
        System.out.println(func2(new int[]{4, 13, 63, 87}, 4));
        System.out.println("=== func3 ===");
        System.out.println(func3(9));
        System.out.println(func3(693953651));
        System.out.println(func3(756580036));
        System.out.println("=== func4 ===");
        System.out.println(func4(5));
        System.out.println(func4(97615282));
        System.out.println(func4(1024));
    }

    static int func4(int n) {
        // n이하의 수 중에서 가장 큰 2의 거듭제곱수를 반환 n <= 10억 자연수
        int val = 1; // 2의 거듭제곱이 저장
        while(2*val <= n) // 시간복잡도 O(logN)
            val *= 2; // 2의 거듭 제곱한 수가 n보다 작을 때까지 2 곱하기
        return val;
    }

    static int func3(int n) {
        // n이 제곱수이면 1을 아니면 0을 반환 n <= 10억 자연수
        for(int i=1; i * i <= n; i++) { // 시간복잡도 O(루트N)
            if(i * i == n) return 1;
        }

        return 0;
    }

    static int func2(int[] a, int n) {
        // 길이 n의 int 배열 a에서 합이 100인 서로 다른 위치의 두 원소가 존재하면 1, 존재하지 않으면 0 반환
        // (n <= 1000, a의 요소는 0 이상 100이하)
        for(int i=0; i<n; i++) { // 시간복잡도 O(N^2)
            for(int j=i + 1; j<n; j++) {
                if(a[i] + a[j] == 100) return 1;
            }
        }
        return 0;
    }

    static int func1(int n) {
        // n 이하의 자연수 중에서 3의 배수이거나 5의 배수인 수를 모두 합한 값을 반환하는 함수
        // (n <= 5만)
        int sum = 0;
        for (int i = 1; i <= n; i++) { // 시간복잡도 O(N)
            if(i % 3 == 0 || i % 5 == 0) sum += i;
        }
        return sum;
    }
}
