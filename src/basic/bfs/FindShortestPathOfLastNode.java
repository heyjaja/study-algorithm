package basic.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class FindShortestPathOfLastNode {
    static class Node {
        int value;
        Node left; // 왼쪽 자식
        Node right; // 오른쪽 자식

        public Node(int val) {
            value = val;
            left = null;
            right = null;
        }
    }
    Node root;
    public int BFS(Node root) {
        int answer = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int length = queue.size();
            for(int i=0; i<length; i++) {
                Node node = queue.poll();
                if(node.left == null && node.right == null) {
                    return answer;
                }
                if(node.left != null ) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }

            answer++;

        }

        return answer;
    }
    public static void main(String[] args) {
        // 자식이 없는 말단 노드까지 가장 짧은 경로 -> BFS가 적합
        FindShortestPathOfLastNode tree = new FindShortestPathOfLastNode();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println(tree.BFS(tree.root));
    }

}
