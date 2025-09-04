import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        int[] inputs = {a, b, c, d};
        int[] arr = new int[7];
        
        for(int i=0; i<4; i++) {
            arr[inputs[i]]++;
        }
        
        int p = 0;
        int q = 0;
        int r = 0;
        int count = 0;
        boolean three = false;
        for(int i=1; i<7; i++) {
            if(arr[i] == 4) {
                return 1111 * i;
            } else if(arr[i] == 3) {
                p = i;
                three = true;
            } else if(arr[i] == 2) {
                if(p == 0) p = i;
                else q = i;
            } else if(arr[i] == 1) {
                if(q==0) q = i;
                else r = i;
                count++;
            }
        }
        
        if(three) {
            answer = (10 * p + q) * (10 * p + q);
        } else if(r == 0) {
            answer = (p + q) * Math.abs(p-q);
        } else if(count==4){
            answer = q;
        } else {
            answer = q * r;
        }
        
        return answer;
    }
}