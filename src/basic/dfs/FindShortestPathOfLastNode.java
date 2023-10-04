package dfs;

public class FindShortestPathOfLastNode {
    Node root;
    public int DFS(int level, Node root) {
        if(root.left == null && root.right == null) {
            return level;
        } else {
            return Math.min(DFS(level +1, root.left), DFS(level + 1, root.right));
        }
    }
    public static void main(String[] args) {
        // 자식이 없는 말단 노드까지 가장 짧은 경로 -> BFS가 적합
        FindShortestPathOfLastNode tree = new FindShortestPathOfLastNode();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println(tree.DFS(0, tree.root));
    }

}
