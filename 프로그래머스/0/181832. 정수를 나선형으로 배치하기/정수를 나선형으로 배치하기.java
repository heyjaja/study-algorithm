class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int half = n / 2;
        if(n % 2 != 0) {
            answer[half][half] = n*n;
        }
        
        int a = 1;
        for(int i = 0; i<half; i++) {
            int x = i;
            int y = i;
            // right
            for(; y<n-i-1; y++) {
                answer[x][y] = a++;
            }
            
            // down
            for(; x<n-i-1; x++) {
                answer[x][y] = a++;
            }
            
            // left
            for(; y > i; y--) {
                answer[x][y] = a++;
            }
            
            // up
            for(; x > i; x--) {
                answer[x][y] = a++;
            }
        }
        
        return answer;
    }
}