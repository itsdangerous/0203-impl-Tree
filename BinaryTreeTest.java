//                         11
//                      /      \
//                     10        4
//                   /   \     /   \
//                  3     5   2     6
//                /   \    \
//               9   15    8
//                      \
//                       20

public class BinaryTreeTest {
    static int LEFT = 0;
    static int RIGHT = 1;

    public static void main(String[] args) {
        System.out.println("========================");
        System.out.println("======배열 트리 순회======");
        System.out.println("========================");
        System.out.println();

        ArrayBinaryTree arrayTree = new ArrayBinaryTree(11);

        arrayTree.addChild(11, 10, LEFT);
        arrayTree.addChild(11, 4, RIGHT);

        arrayTree.addChild(10, 3, LEFT);
        arrayTree.addChild(10, 5, RIGHT);
        arrayTree.addChild(4, 2, LEFT);
        arrayTree.addChild(4, 6, RIGHT);

        arrayTree.addChild(3, 9, LEFT);
        arrayTree.addChild(3, 15, RIGHT);
        arrayTree.addChild(5, 8, RIGHT);

        arrayTree.addChild(15, 20, RIGHT);

        System.out.println("------배열 트리 전위순회------");
        arrayTree.preOrder();
        System.out.println();

        System.out.println("------배열 트리 중위순회------");
        arrayTree.inOrder();
        System.out.println();

        System.out.println("------배열 트리 후위순회------");
        arrayTree.postOrder();
        System.out.println();

        System.out.println();
        System.out.println("========================");
        System.out.println("===연결리스트 트리 순회===");
        System.out.println("========================");
        System.out.println();

        LinkedListBinaryTree linkedListTree = new LinkedListBinaryTree(11);

        linkedListTree.addChild(11, 10, LEFT);
        linkedListTree.addChild(11, 4, RIGHT);

        linkedListTree.addChild(10, 3, LEFT);
        linkedListTree.addChild(10, 5, RIGHT);
        linkedListTree.addChild(4, 2, LEFT);
        linkedListTree.addChild(4, 6, RIGHT);

        linkedListTree.addChild(3, 9, LEFT);
        linkedListTree.addChild(3, 15, RIGHT);
        linkedListTree.addChild(5, 8, RIGHT);

        linkedListTree.addChild(15, 20, RIGHT);

        System.out.println("------연결리스트 트리 전위순회------");
        linkedListTree.preOrder();
        System.out.println();

        System.out.println("------연결리스트 트리 중위순회------");
        linkedListTree.inOrder();
        System.out.println();

        System.out.println("------연결리스트 트리 후위순회------");
        linkedListTree.postOrder();
        System.out.println();
    }
}
