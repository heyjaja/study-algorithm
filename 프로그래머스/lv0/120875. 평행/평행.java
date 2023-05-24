import java.util.*;
class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        for(int i=0; i<dots.length; i++) {
            double temp = (double)(dots[i][1] - dots[(i+1)%4][1]) / (dots[i][0] - dots[(i+1)%4][0]);
            double temp2 = (double)(dots[(i+2)%4][1] - dots[(i+3)%4][1]) / (dots[(i+2)%4][0] - dots[(i+3)%4][0]);

            if(temp == temp2) {
                answer = 1;
                break;
            }
        }
        return answer;
    }
}