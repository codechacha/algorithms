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

    /** Get the value of the index-th node in the linked list.
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
            // Move to Index (i + 1)
            cur = cur.next;
        }
        return cur.val;
    }

    /** Add a node of value val before the first element of the linked list.
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

    /** Append a node of value val to the last element of the linked list. */
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

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list,
     * the node will be appended to the end of linked list.
     * If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (head == null) {
            if (index == 0) {
                head = new SinglyLinkedNode(val);
            }
            return;
        }

        SinglyLinkedNode prev = null;
        SinglyLinkedNode cur = head;
        for (int i = 0; i < index; i++) {
            if (cur == null) {
                return;
            }
            // Move to Index (i + 1)
            prev = cur;
            cur = cur.next;
        }

        SinglyLinkedNode node = new SinglyLinkedNode(val);
        if (prev == null) {
            node.next = head;
            head = node;
        } else if (cur == null) {
            cur = node;
            prev.next = cur;
        } else {
            prev.next = node;
            node.next = cur;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (head == null) {
            return;
        }

        SinglyLinkedNode prev = null;
        SinglyLinkedNode cur = head;
        for (int i = 0; i < index; i++) {
            if (cur.next == null) {
                return;
            }
            // Move to Index (i + 1)
            prev = cur;
            cur = cur.next;
        }

        SinglyLinkedNode next = cur.next;
        if (prev == null) {
            head = head.next;
        } else if (next == null) {
            prev.next = null;
        } else {
            prev.next = next;
        }
    }
}