import java.util.Arrays;

public class ArrayBinaryTree implements Tree {
    private int[] data; // 해당 노드의 정보를 담을 배열
    private int[] parents; // 해당 노드의 부모 정보를 담을 배열
    private int[][] childs; // 해당 노드의 자식 정보를 담을 배열 row[0] = 왼쪽 자식 row[1] = 오른쪽 자식
    private int size; // 트리의 크기
    private int capacity; // 배열에 담을 수 있는 크기
    private final int root;

    public ArrayBinaryTree(int root) {
        //0번째 인덱스 비우고 1번째 인덱스부터
        // 루트 노드의 부모는 -1
        // 루트 노드의 자식은 왼쪽 ,오른쪽 모두 -1
        this.root = root;
        this.capacity = root + 1;
        this.parents = new int[this.capacity];
        this.childs = new int[this.capacity][2];
        this.data = new int[this.capacity];

        Arrays.fill(parents, -1);

        for (int i = 0; i < this.capacity; i++) {
            childs[i][0] = -1;
            childs[i][1] = -1;
        }
//        Arrays.fill(children, new int[]{-1, -1}); //tq
        this.size = 1;
        data[root] = size;
    }
    // direction은 추가하려는 자식이 왼쪽 자식인지 오른쪽 자식인지 구분
    // left : 0, Right : 1
    public void addChild(int parent, int child, int direction) {

        if (child > this.capacity) { // 만약 현재 capacity가 이 자식을 배열에 추가할 수 없다면
            // large 계산해서 기존의 배열의 크기를 늘려줘야 함
            int large = child + (direction == 0 ? 0 : 1);
            int[][] copyChild = new int[large][2];

            int[] copyParent = new int[large];
            int[] copyData = new int[large];

            // 배열 초기화
            for (int i = 0; i < large; i++) {
                copyChild[i][0] = -1;
                copyChild[i][1] = -1;
            }
            Arrays.fill(copyParent, -1); // 배열 초기화
            Arrays.fill(copyData, 0);

            for (int i = 0; i < this.capacity; i++) {
                //child 배열 복사
                copyChild[i][0] = this.childs[i][0];
                copyChild[i][1] = this.childs[i][1];

                //parent 복사
                copyParent[i] = this.parents[i];

                //data 복사
                copyData[i] = this.data[i];
            }

            // 부모 자식 간 관계 추가
            copyChild[parent][direction] = child;

            copyParent[child] = parent;

            // 사이즈 갱신
            this.size++;
            this.capacity = large;

            // 현재 배열 갱신
            this.childs = new int[this.capacity][2];
            this.parents = new int[this.capacity];
            this.data = new int[this.capacity];

            for (int i = 0; i < this.capacity; i++) {
                this.childs[i][0] = copyChild[i][0];
                this.childs[i][1] = copyChild[i][1];

                this.parents[i] = copyParent[i];
                this.data[i] = copyData[i];
            }

        }
        // 배열 안늘려도 된다면 부모 자식 넣어주기
    else {
            childs[parent][direction] = child;
            this.parents[child] = parent;
            this.size++;
        }
        this.data[child] = size;
    }

    @Override
    public void preOrder() {
        preOrderStart(root);
    }
    public void preOrderStart(int node) {
        if(node == -1) return;

        System.out.print(node+ " ");
        preOrderStart(childs[node][0]);
        preOrderStart(childs[node][1]);

    }

    @Override
    public void inOrder() {
        inOrderStart(root);
    }
    public void inOrderStart(int node) {
        if(node == -1) return;

        inOrderStart(childs[node][0]);
        System.out.print(node+ " ");
        inOrderStart(childs[node][1]);

    }

    @Override
    public void postOrder() {
        postOrderStart(root);
    }
    public void postOrderStart(int node) {
        if(node == -1) return;

        postOrderStart(childs[node][0]);
        postOrderStart(childs[node][1]);
        System.out.print(node+ " ");

    }
}