package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class ReportResult {
  
  public static int[] solution(String[] id_list, String[] report, int k) {
    int[] answer = new int[id_list.length];
    StringTokenizer st = null;
    
    // 피신고인, 신고인
    HashMap<String, HashSet<String>> reportMap = new HashMap<String, HashSet<String>>();
    
    // 신고인, 메일 개수
    HashMap<String, Integer> countMail = new HashMap<String, Integer>();

    String reportUser ="";
    String reportedUser = "";
    
    // reportMap 데이터 저장
      for(String re : report) {
        HashSet<String> reportUserSet = new HashSet<String>();
        st = new StringTokenizer(re, " ");
        reportUser = st.nextToken();
        reportedUser=st.nextToken();
        reportMap.put(reportedUser, reportUserSet);
      }
    
    // reportMap에서 신고자 메일 수신 횟수 구하기
    for(HashSet<String> reportUserSet : reportMap.values()) {
      if(reportUserSet.size()>=k) {
        for(String user : reportUserSet) {
          countMail.put(user, countMail.getOrDefault(user,0)+1);
        }
      }
    }
    
    for(int i=0; i<id_list.length; i++) {
      answer[i]=countMail.getOrDefault(id_list[i], 0);
    }

    return answer;
  }

  public static void main(String[] args) {
    String[] id_list = {"muzi", "frodo", "apeach", "neo"};
    String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
    int k=2;
    
    System.out.println(Arrays.toString(solution(id_list, report, k)));

  }

}
