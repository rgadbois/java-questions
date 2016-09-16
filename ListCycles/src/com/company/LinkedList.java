package com.company;

/**
 * Created by rgadbois on 9/15/16.
 */
public class LinkedList {
    public static class Node {
        private Node next;
        private String data;

        public Node(String data) {
            this.data = data;
        }

        public Node next() {
            return next;
        }

        public void setNext(Node node) {
            this.next = node;
        }

        public String data() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data;
        }
    }

    private Node head;

    public LinkedList() {
        this.head = new Node("head");
    }

    public Node head() {
        return head;
    }

    public void appendToTail(Node node) {
        Node current = head;
        while (current.next != null) {
            current = current.next();
        }
        current.setNext(node);
    }

    public boolean isCyclic() {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head.next();
        while (current != null) {
            sb.append(current).append("-->");
            current = current.next();
        }
        sb.delete(sb.length() - 3, sb.length()); // to remove --> from last node
        return sb.toString();
    }

}