package algorithm.datastructure.link;

public class Josephuskill {

    /**
     * 前面的节点推动当前节点往前走
     *
     * @param head
     * @param m
     * @return
     */
    static public Node josephusKill(Node head, int m) {
        if (head == null || head.next == head || m < 1) return head;
        Node last = head;
        while (head != last.next) {
            last = last.next;
        }
        int count = 0;
        while (head != last) {
            if (++count == m) {
                last.next = head.next;
                count = 0;
            } else {
                last = last.next;
            }
            head = last.next;
        }
        return head;
    }

    static public Node josephusKill2(Node head, int m) {
        if (head == null || head.next == head || m < 1) return head;
        Node pre = null;
        Node next;
        int n = 0;
        while (head.next != head) {
            if (++n == m) {
                next = head.next;
                n = 0;
                pre.next = next;
                head = next;
            } else {
                next = head.next;
                pre = head;
                head = next;
            }
        }
        return head;
    }


    public static void main(String[] args) {
        Node head = LinkUtils.createExampleNode();

        Node res = josephusKill2(head, 2);
        return;

    }
}
