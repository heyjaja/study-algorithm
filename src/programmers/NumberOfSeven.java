public class NumberOfSeven {
    public static int solution(int[] array) {
        int answer = 0;

        for(int i : array) {
            int a = i;
            while(a > 0) {
                if(a%10 == 7) {
                    answer++;
                }
                a /= 10;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] a = {7, 77, 17};
        int[] b = {10, 20};
        int[] c = {17017, 0, 23377, 7, 19872, 0};

        System.out.println(solution(a));
        System.out.println(solution(b));
        System.out.println(solution(c));
    }
}
