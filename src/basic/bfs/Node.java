package bfs;

class Node {
    int value;
    Node left; // 왼쪽 자식
    Node right; // 오른쪽 자식

    public Node(int val) {
        value = val;
        left = null;
        right = null;
    }
}
