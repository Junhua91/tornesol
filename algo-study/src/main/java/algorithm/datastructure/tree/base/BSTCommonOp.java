package algorithm.datastructure.tree.base;

import com.junhua.algorithm.tree.Node;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;


/**
 * 包含BST 增、删、查，遍历（非递归、Morris遍历）、最大节点、最小节点、前继节点、后继节点
 */
public class BSTCommonOp {

    protected Node head;

    public BSTCommonOp(int num) {
        this.head = new Node(num);
    }

    /**
     * BST
     * 增加节点：节点添加到叶子节点
     *
     * @param num
     */
    public Node add(int num) {
        Node node = head;
        Node newNode = null;
        while (node != null) {
            if (num > node.value) {
                if (node.right == null) {
                    newNode = new Node(num);
                    node.right = newNode;
                    newNode.parent = node;
                    break;
                }
                node = node.right;
            } else {
                if (node.left == null) {
                    newNode = new Node(num);
                    node.left = newNode;
                    newNode.parent = node;
                    break;
                }
                node = node.left;
            }
        }
        return newNode;
    }

    /**
     * 判断某一个元素是否是某个节点的子元素
     *
     * @param root
     * @param num
     * @return
     */
    public boolean isSubTree(Node root, int num) {
        return !(get(root, num) == null);
    }

    public Node get(Node head, int num) {

        Node node = head;
        if (num == node.value) return node;

        while (node != null) {
            if (num > node.value) {
                node = node.right;
            } else if (num == node.value) {
                return node;
            } else {
                node = node.left;
            }
        }
        return null;
    }

    /**
     * 1. 删除节点为叶子节点：直接删除
     * 2. 删除节点有一个子节点：左子树或者右子树
     * 3. 删除节点有两个子节点
     * 4. 返回替代者
     *
     *
     */
    public Node delete(Node destNode ) {
        //查无该节点
        if (destNode == null) return null;
        Node nodeToReturn = null;
        //只有一个子节点时，直接替换
        if (destNode.left == null) {
            nodeToReturn = transplant(destNode, destNode.right);
        } else if (destNode.right == null) {
            nodeToReturn = transplant(destNode, destNode.left);
        } else {//左右节点同时存在
            //目标节点的后继节点：
            Node next = findNextNode(destNode);
            if (next.parent != destNode) {
                transplant(next, next.right);
                next.right = destNode.right;
                destNode.right.parent = next;
            }
            transplant(destNode, next);
            next.left = destNode.left;
            destNode.left.parent = next;
            nodeToReturn = next;
        }
        return nodeToReturn;
    }

    private Node transplant(Node replaceNode, Node newNode) {

        if (replaceNode.parent == null) {
            head = newNode;
        }
        if (replaceNode.parent.left == replaceNode) {
            replaceNode.parent.left = newNode;
        } else if (replaceNode.parent.right == replaceNode) {
            replaceNode.parent.right = newNode;
        }
        if (newNode != null) {
            newNode.parent = replaceNode;

        }

        return newNode;
    }


    /**
     * 最左子树为最小
     *
     * @return
     */
    public Node getMin() {
        if (head == null) return null;
        return getLeftMost(head);
    }

    /**
     * 最右子树为最大
     *
     * @return
     */
    public Node getMax() {
        if (head == null) return null;
        return getRightMost(head);
    }


    /**
     * 查找一个节点的后继节点
     *
     * @param node
     * @return
     */
    public Node findNextNode(Node node) {
        if (node == null) return null;
        if (node.right != null) {
            return getLeftMost(node.right);
        } else {
            Node parent = node.parent;
            while (parent != null && parent.left != node) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }


    /**
     * 查找一个节点的前继节点
     *
     * @param node
     * @return
     */
    public Node findPreNode(Node node) {

        if (node == null) return null;
        if (node.left != null) return getRightMost(node.left);
        Node parent = node.parent;
        while (parent != null && parent.right != node) {
            node = parent;
            parent = node.parent;
        }
        return parent;
    }


    /**
     * 前序遍历
     *
     * @return
     */
    public List<Integer> getPreOrder() {
        if (head == null) return Collections.emptyList();
        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            Node tmp = stack.pop();
            res.add(tmp.value);
            if (tmp.right != null) {
                stack.push(tmp.right);
            }
            if (tmp.left != null) {
                stack.push(tmp.left);
            }
        }
        return res;
    }

    /**
     * 中序遍历
     *
     * @return
     */
    public List<Integer> getInOrder() {
        if (head == null) return Collections.emptyList();
        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node node = head;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                Node tmp = stack.pop();
                res.add(tmp.value);
                if (tmp.right != null) {
                    node = tmp.right;
                }
            }
        }
        return res;
    }


    /**
     * 后续遍历
     *
     * @return
     */
    public List<Integer> getPostOrder() {
        if (head == null) return Collections.emptyList();
        List<Integer> res = new ArrayList<>();

        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            Node tmp = stack.pop();
            res.add(tmp.value);
            if (tmp.left != null) {
                stack.push(tmp.left);
            }
            if (tmp.right != null) {
                stack.push(tmp.right);
            }
        }
        return Lists.reverse(res);

    }

    /**
     * morris中序遍历:
     * - 可以使用O(1) 的空间复杂读度实现树的遍历
     * - morris中，如果一个节点有左子树，则会达到这个节点两次；如果没有，则只能来到一次
     * - 第二次来到一个节点的时候，将节点插入
     * <p>
     * <p>
     * ### morris过程
     * 1.如果当前节点(cur)没有左子树，当前节点（cur）来到它的右节点
     * 2.如果当前节点（cur）有左子树, 找到左子树的最右节点(mostRight)
     * 2.1. 如果最右节点(mostRight)的右节点指向null，则最右节点的右子树指向当前节点（cur), cur来到cur的左节点
     * 2.2. 如果最右节点(mostRight)的右节点指向当前节点（cur）, 则最右节点(mostRight)的右节点指向null，cur来到cur的右节点
     *
     * @return
     */
    public List<Integer> getMorrisIn() {
        if (head == null) {
            return Collections.emptyList();
        }
        List<Integer> res = new ArrayList<>();
        Node cur = head;
        while (cur != null) {
            Node left = cur.left;
            if (left != null) {
                Node mostRight = left;
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                } else {
                    res.add(cur.value);
                    cur = cur.right;
                    mostRight.right = null;
                }
            } else {
                res.add(cur.value);
                cur = cur.right;
            }
        }
        return res;
    }

    /**
     * 先序遍历：第一次来到节点的时候，插入数组
     *
     * @return
     */
    public List<Integer> getMorrisPre() {
        if (head == null) {
            return Collections.emptyList();
        }
        List<Integer> res = new ArrayList<>();
        Node cur = head;
        while (cur != null) {
            Node left = cur.left;
            if (left != null) {
                Node mostRight = left;
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    res.add(cur.value);
                    mostRight.right = cur;
                    cur = cur.left;
                } else {
                    cur = cur.right;
                    mostRight.right = null;
                }
            } else {
                res.add(cur.value);
                cur = cur.right;
            }
        }
        return res;
    }


    /**
     * 只关注能第二次到达的节点：
     * 1. 逆序打印这些节点（能够到达两次的节点）的左子树的右边界
     * 2. 逆序打印头节点的右边界
     *
     * @return
     */
    public List<Integer> getMorrisPost() {
        if (head == null) {
            return Collections.emptyList();
        }
        List<Integer> res = new ArrayList<>();
        Node cur = head;
        while (cur != null) {
            Node left = cur.left;
            if (left != null) {
                Node mostRight = left;
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                } else {
                    mostRight.right = null;

                    Node tail = reverseRightNode(cur.left);
                    Node tmp = tail;
                    while (tmp != null) {
                        res.add(tmp.value);
                        tmp = tmp.right;
                    }
                    reverseRightNode(tail);
                    cur = cur.right;
                }
            } else {
                cur = cur.right;
            }
        }
        Node tail = reverseRightNode(head);
        Node tmp = tail;
        while (tmp != null) {
            res.add(tmp.value);
            tmp = tmp.right;
        }
        reverseRightNode(tail);
        return res;
    }

    /**
     * 获取节点的最左节点
     *
     * @param node
     * @return
     */
    private Node getLeftMost(Node node) {
        if (node == null) return null;
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    /**
     * 获取节点的最右节点
     *
     * @param node
     * @return
     */
    private Node getRightMost(Node node) {
        if (node == null) return null;

        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    /**
     * 逆序右子树
     *
     * @param from
     * @return
     */
    private Node reverseRightNode(Node from) {

        Node pre = null;
        Node next = null;
        while (from != null) {
            next = from.right;
            from.right = pre;
            pre = from;
            from = next;
        }
        return pre;
    }

}
