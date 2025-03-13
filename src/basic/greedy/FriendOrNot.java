package basic.greedy;

import java.util.Scanner;

public class FriendOrNot {
    int[] unf;

    private String solution(int n, int[][] pairs, int a, int b) {
        // 학생번호를 인덱스로 갖는 배열 생성
        // 집합 번호를 값으로 가진다.
        // 서로 같은 집합에 있으면 둘은 친구가 된다.
        unf = new int[n+1];

        for(int i=1; i<=n; i++) {
            unf[i] = i;
        }

        for(int[] pair : pairs) {
            union(pair[0], pair[1]);
        }

        int findA = find(a);
        int findB = find(b);

        return findA == findB ? "YES" : "NO";
    }

    public int find(int v) {
        // 집합번호를 찾는 함수
        // 학생 번호와 집합 번호가 같으면 해당 값을 리턴
        // 재귀함수로 이어진 노드를 찾는다.
        if(v == unf[v]) return v;
        return unf[v] = find(unf[v]); // 같은 집합 번호를 저장하여 경로를 압축시킨다.
    }

    public void union(int a, int b) {
        // 집합 번호 저장(연결된 노드를 저장하여 이어지는 노드인지 확인)
        int findA = find(a);
        int findB = find(b);
        if(findA != findB) unf[findA] = findB;

    }
    public static void main(String[] args) {
        // 친구인가? (Disjoint-Set : Union&Find): 서로소 집합
        // 1~N번 학생, 2명씩 친구 관계 숫자쌍
        // 특정 두 명이 친구인지 판별
        FriendOrNot main = new FriendOrNot();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] pairs = new int[m][2];

        for(int j=0; j<m; j++) {
            pairs[j][0] = sc.nextInt();
            pairs[j][1] = sc.nextInt();
        }

        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(main.solution(n, pairs, a, b));
    }

}
