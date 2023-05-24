import java.util.*;

class Solution {
    public String solution(String s) {
        
        String[] split = s.split(" ", -1);
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < split.length; i++) {
            for(int j = 0; j < split[i].length(); j++) {
                if(j%2==0) {
                    sb.append(Character.toUpperCase(split[i].charAt(j)));
                } else {
                    sb.append(Character.toLowerCase(split[i].charAt(j)));
                }
            }
            sb.append(i < split.length - 1 ? " ": "");
        }
        
        return sb.toString();
    }
}