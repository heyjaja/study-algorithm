import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Integer[] buildings = new Integer[n];
        for(int i=0; i<n; i++) {
            buildings[i] = Integer.parseInt(br.readLine());
        }

        long count = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<n; i++) { // 왼쪽 -> 오른쪽 탐색
            int building = buildings[i]; // 현재 빌딩
            while(!stack.isEmpty() && stack.peek() <= building) { // 현재 빌딩보다 낮은 빌딩(현재 빌딩을 볼 수 없는 빌딩) pop
                stack.pop(); // 현재 빌딩보다 낮은 빌딩은 이후 빌딩을 볼 수 없음(제거)
            }

            count += stack.size(); // 스택에 남아있는 빌딩은 현재 빌딩을 볼 수 있는 빌딩의 수
            stack.push(building); // 현재 빌딩 스택에 추가
        }

        System.out.println(count);
    }
}
