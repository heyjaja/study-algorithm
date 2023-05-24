class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        int[] count = new int[n+1];
        
        for(int i=1; i<=n; i++) {
            count[i] = 1;
        }
        
        for(int i=0; i<=n; i++) {
            if(i < lost.length) {
                count[lost[i]] -= 1;
            }
            
            if(i < reserve.length) {
                count[reserve[i]] += 1;
            }
        }
        
        for(int i=1; i<=n; i++) {
            if(count[i] < 1) {
                if(i > 1 && count[i-1] > 1) {
                    count[i]++;
                    count[i-1]--;
                } else if(i < n && count[i+1] > 1) {
                    count[i]++;
                    count[i+1]--;
                }
                
            }
            if(count[i] > 0) {
                answer++;
            }
        }
        
        return answer;
    }
}