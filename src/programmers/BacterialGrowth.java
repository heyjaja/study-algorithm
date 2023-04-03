public class BacterialGrowth {
    public static int solution(int n, int t) {
        int answer = n;
        for(int i = 0; i < t; i++) {
            answer *= 2;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(2, 10));
        System.out.println(solution(7, 15));
    }
}
