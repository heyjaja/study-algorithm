package dfs;

public class BinaryTree {
    Node root;
    public void DFS(Node root) {
        if(root == null) return;
        System.out.print(root.value + " "); // 전위순회
        DFS(root.left); // 2
        System.out.print(root.value + " "); // 중위순회
        DFS(root.right); // 3
        System.out.print(root.value + " "); // 후위순회
    }
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        tree.DFS(tree.root);
    }

}
