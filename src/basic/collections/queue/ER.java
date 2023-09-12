package collections.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ER {
    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<n; i++) {
            queue.offer(i);
        }

        while(!queue.isEmpty()){
            boolean flag = true;
            int patient = queue.poll();
            for(int i=0; i<n; i++) {
                if(arr[patient] < arr[i]) {
                    queue.offer(patient);
                    flag = false;
                    break;
                }
            }

            if(flag) {
                answer++;
                arr[patient] = 0;
                if(patient == m) break;
            }

        }

        return answer;
    }

    public int solution2(int n, int m, int[] arr) {
        int answer = 0;
        Queue<Patient> queue = new LinkedList<>();
        for(int i=0; i<n; i++) {
            queue.offer(new Patient(i, arr[i]));
        }

        while(!queue.isEmpty()){
            Patient patient = queue.poll();

            for(Patient p : queue) {
                if(patient.priority < p.priority) {
                    queue.offer(patient);
                    patient = null;
                    break;
                }
            }

            if(patient != null) {
                answer++;
                if(patient.id == m) break;
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        // 응급실
        // n명의 대기 환자 중 m번째 환자 순서
        // 위험도가 낮으면 대기번호 맨 뒤로
        ER main = new ER();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print(main.solution2(n, m, arr));
    }
}

class Patient {
    int id;
    int priority;

    public Patient(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }
}