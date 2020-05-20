// https://leetcode.com/explore/learn/card/linked-list/209/singly-linked-list/1290/

public class MyLinkedList {

    private SinglyLinkedNode head = null;

    static class SinglyLinkedNode {
        int val;
        SinglyLinkedNode next = null;

        SinglyLinkedNode(int v) {
            val = v;
        }
    }

    /** Initialize your data structure here. */
    public MyLinkedList() {
    }

    /* Get the value of the index-th node in the linked list.
     * If the index is invalid, return -1. */
    public int get(int index) {
        if (head == null) {
            return -1;
        }

        SinglyLinkedNode cur = head;
        for (int i = 0; i < index; i++) {
            if (cur.next == null) {
                return -1;
            }
            cur = cur.next;
        }
        return cur.val;
    }

    /* Add a node of value val before the first element of the linked list.
     * After the insertion, the new node will be the first node of the linked list */
    public void addAtHead(int val) {
        if (head == null) {
            head = new SinglyLinkedNode(val);
            return;
        }

        SinglyLinkedNode node = new SinglyLinkedNode(val);
        node.next = head;
        head = node;
    }

    /* Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if (head == null) {
            head = new SinglyLinkedNode(val);
            return;
        }

        SinglyLinkedNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        SinglyLinkedNode node = new SinglyLinkedNode(val);
        cur.next = node;
    }

    /* Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list,
     * the node will be appended to the end of linked list.
     * If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index == 0) {
            SinglyLinkedNode node = new SinglyLinkedNode(val);
            if (head == null) {
                head = node;
                return;
            }
            node.next = head;
            head = node;
            return;
        }

        SinglyLinkedNode prev = head;
        SinglyLinkedNode cur = head.next;
        for (int i = 1; i < index; i++) {
            if (cur == null) {
                return;
            }
            prev = cur;
            cur = cur.next;
        }

        SinglyLinkedNode node = new SinglyLinkedNode(val);
        node.next = cur;
        prev.next = node;
    }

    /* Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (head == null) {
            return;
        }

        SinglyLinkedNode cur = head;
        SinglyLinkedNode prev = null;
        for (int i = 0; i < index; i++) {
            if (cur.next == null) {
                return;
            }
            prev = cur;
            cur = cur.next;
        }
        if (prev == null) {
            head = head.next;
        } else {
            prev.next = cur.next;
        }
    }
}