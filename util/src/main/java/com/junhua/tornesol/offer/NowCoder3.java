package com.junhua.tornesol.offer;


import java.util.ArrayList;

/**
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */
public class NowCoder3 {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ArrayList<Integer> res = new ArrayList<>();

        if (listNode == null) return res;
        while (listNode != null) {
            res.add(0,listNode.val);
            listNode = listNode.next;
        }
        return res;
    }

}
