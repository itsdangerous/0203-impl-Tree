import java.util.LinkedList;
import java.util.Queue;

class Node {
    Node left;
    Node right;
    int value;

    public Node( Node left, Node right, int value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public Node(int value) {
        this.left = null;
        this.value = value;
        this.right = null;
    }
}
public class LinkedListBinaryTree implements Tree {
    private Node root;
    private int size;

    public LinkedListBinaryTree(int root) {
        this.root = new Node(root);
        this.size = 1;
    }

    public void addChild(int parent, int value, int direction) {
        boolean isOk = addNode(parent, value, direction);
        if (!isOk) {
            System.out.println("노드를 찾을 수 없어 추가할 수 없습니다.");
            System.exit(0);
        }
    }
    private boolean addNode(int parent, int value, int direction) {
        // direction 0 : left | 1 : right

        Node childNode = new Node(value);
        Queue<Node> que = new LinkedList<>();
        que.offer(root);

        while (!que.isEmpty()) {
            Node node = que.poll();
            if (node.value == parent) {
                //만약 direction에 노드가 존재한다면
                if(direction == 0 && node.left != null || direction == 1 && node.right!= null) {
                    System.out.println("추가하려는 곳에 노드가 존재합니다. 종료합니다.");
                    return false;
                }
                if(direction == 0) {
                    node.left = childNode;
                    return true;
                }
                if(direction == 1) {
                    node.right = childNode;
                    return true;
                }
            }
            if(node.left != null ) que.offer(node.left);
            if(node.right != null ) que.offer(node.right);
        }
        System.out.println("추가하려는 노드가 존재하지 않습니다.");
        return false;
    }

    @Override
    public void preOrder() {
        preOrderStart(root);
    }
    public void preOrderStart(Node node) {
        if(node == null) return;

        System.out.print(node.value+ " ");
        preOrderStart(node.left);
        preOrderStart(node.right);

    }
    @Override
    public void inOrder() {
        inOrderStart(root);
    }
    public void inOrderStart(Node node) {
        if(node == null) return;

        inOrderStart(node.left);
        System.out.print(node.value+ " ");
        inOrderStart(node.right);

    }
    @Override
    public void postOrder() {
        postOrderStart(root);
    }
    public void postOrderStart(Node node) {
        if(node == null) return;

        postOrderStart(node.left);
        postOrderStart(node.right);
        System.out.print(node.value+ " ");

    }
}
