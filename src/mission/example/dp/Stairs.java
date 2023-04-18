package example.dp;

public class Stairs {

    public static int minCostClimbingStairs(int[] cost) {
        // 경우의 수 1칸 이동
        int case1 = 0;

        // 경우의 수 2칸 이동
        int case2 = 0;

        // 현재 계단의 최소 비용
        int current;

        // 배열의 뒤에서 앞으로
        for(int i = cost.length-1; i >= 0; i--) {
            // 현재 계단의 최소 비용 = 경우의 수 2개 중 작은 것 + 현재 계단의 비용
            current = cost[i] + Math.min(case1, case2);

            // 2칸 이동 경우의 수 = 현재 1칸 이동 경우의 수
            case2 = case1;
            // 1칸 이동 경우의 수 = 현재 계단
            case1 = current;
        }
        // 반복문이 다 돌고 나면 0과 1 중 시작계단을 선택
        // case1 = 0번(1칸 이동), case2 = 1번(2칸 이동)
        return Math.min(case1, case2);
    }

    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[] {1,2,3,4,5,6,7}));
        System.out.println(minCostClimbingStairs(new int[] {10, 15, 20}));
        System.out.println(minCostClimbingStairs(new int[] {1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));

    }
}

class Point {
    // 경로 x,y 저장 객체
    int row, col;

    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
