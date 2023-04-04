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
        System.out.println(solution(new int[]{7, 77, 17}));
        System.out.println(solution(new int[]{10, 20}));
        System.out.println(solution(new int[]{17017, 0, 23377, 7, 19872, 0}));
    }
}
