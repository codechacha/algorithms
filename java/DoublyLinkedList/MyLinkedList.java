// https://leetcode.com/explore/learn/card/linked-list/210/doubly-linked-list/1294/

public class MyLinkedList {
    DoublyListNode head = null;

    // Definition for doubly-linked list.
    static class DoublyListNode {
        int val;
        DoublyListNode next, prev;
        DoublyListNode(int x) {val = x;}
    }

    /** Initialize your data structure here. */
    public MyLinkedList() {
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (head == null) {
            return -1;
        }

        DoublyListNode cur = head;
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
     * After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        if (head == null) {
            head = new DoublyListNode(val);
            return;
        }

        DoublyListNode node = new DoublyListNode(val);
        node.next = head;
        head.prev = node;
        head = node;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if (head == null) {
            head = new DoublyListNode(val);
            return;
        }

        DoublyListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        DoublyListNode node = new DoublyListNode(val);
        cur.next = node;
        node.prev = cur;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list,
     * the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (head == null) {
            if (index == 0) {
                head = new DoublyListNode(val);
            }
            return;
        }

        DoublyListNode prev = null;
        DoublyListNode cur = head;
        for (int i = 0; i < index; i++) {
            if (cur == null) {
                return;
            }
            // Move to Index (i + 1)
            prev = cur;
            cur = cur.next;
        }

        DoublyListNode node = new DoublyListNode(val);
        if (prev == null) {
            node.next = head;
            head.prev = node;
            head = node;
        } else if (cur == null) {
            cur = node;
            prev.next = cur;
            cur.prev = prev;
        } else {
            prev.next = node;
            node.prev = prev;
            node.next = cur;
            cur.prev = node;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (head == null) {
            return;
        }

        DoublyListNode cur = head;
        for (int i = 0; i < index; i++) {
            if (cur.next == null) {
                return;
            }
            // Move to Index (i + 1)
            cur = cur.next;
        }

        DoublyListNode prev = cur.prev;
        DoublyListNode next = cur.next;
        if (prev == null) {
            head = next;
        } else if (next == null) {
            prev.next = null;
        } else {
            prev.next = next;
            next.prev = prev;
        }
    }
}