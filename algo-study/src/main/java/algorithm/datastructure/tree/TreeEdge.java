package algorithm.datastructure.tree;

/**
 * 打印树的边界节点
 */
public class TreeEdge {


    /**
     * 1. 头节点为边界节点
     * 2. 叶节点为边界节点
     * 3. 所在层的最左、最右节点为边界节点
     *
     * @param head
     */
    public static void treeEdge1(Node head) {

        if (head == null) return;

        int h = TreeUtils.getHeight(head);
        Node[][] edgeMap = new Node[h][2];
        edgeMap(head, 0, edgeMap);

        for (Node[] nodeXY : edgeMap) {
            System.out.println(nodeXY[0].value);
        }

        printLeaf(head, 0, edgeMap);

        for (int i = h - 1; i >= 0; i--) {
            System.out.println(edgeMap[i][1].value);
        }
    }


    /**
     * 查找每一层的最左、最右节点： 找第一次出现的左和最后一次出现的右
     *
     * @param head
     * @param h
     * @param nodeMap
     */
    public static void edgeMap(Node head, int h, Node[][] nodeMap) {
        if (head == null) return;
        nodeMap[h][0] = (nodeMap[h][0] == null) ? head : nodeMap[h][0];
        nodeMap[h][1] = head;
        edgeMap(head.left, h + 1, nodeMap);
        edgeMap(head.right, h + 1, nodeMap);
    }

    public static void printLeaf(Node head, int h, Node[][] nodeMap) {
        if (head == null) return;
        if (head.left == null && head.right == null && head != nodeMap[h][0] && head != nodeMap[h][1]) {
            System.out.println(head.value);
        }
        printLeaf(head.left, h + 1, nodeMap);
        printLeaf(head.right, h + 1, nodeMap);
    }

    public static void main(String[] args) {


        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.right = new Node(4);
        head.right.left = new Node(5);
        head.right.right = new Node(6);
        head.left.right.left = new Node(7);
        head.left.right.right = new Node(8);
        head.right.left.left = new Node(9);
        head.right.left.right = new Node(10);
        head.right.left.left.left = new Node(12);
        head.right.left.left.left.left = new Node(15);
        head.right.left.left.left.right = new Node(16);
        head.left.right.left .right = new Node(11);
        head.left.right.left .right.left = new Node(13);
        head.left.right.left .right.right = new Node(14);

        treeEdge1(head);
        return;


    }
}
