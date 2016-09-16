package com.company;

public class Main {

    public static void main(String[] args) {
        //creating LinkedList with 5 elements including head
        LinkedList linkedList = new LinkedList();
        linkedList.appendToTail(new LinkedList.Node("101"));
        linkedList.appendToTail(new LinkedList.Node("201"));
        linkedList.appendToTail(new LinkedList.Node("301"));
        linkedList.appendToTail(new LinkedList.Node("401"));

        System.out.println("Linked List : " + linkedList);
        if(linkedList.isCyclic()){
            System.out.println("Linked List is cyclic as it contains cycles or loop");
        } else {
            System.out.println("LinkedList is not cyclic, no loop or cycle found");
        }


        LinkedList linkedList2 = new LinkedList();
        linkedList2.appendToTail(new LinkedList.Node("101"));
        LinkedList.Node cycle = new LinkedList.Node("201");
        linkedList.appendToTail(cycle);
        linkedList.appendToTail(new LinkedList.Node("301"));
        linkedList.appendToTail(new LinkedList.Node("401"));
        linkedList.appendToTail(cycle);
        //don't call toString method in case of cyclic linked list, it will throw OutOfMemoryError //System.out.println("Linked List : " + linkedList);
        if(linkedList.isCyclic()){
            System.out.println("Linked List 2 is cyclic as it contains cycles or loop");
        } else {
            System.out.println("LinkedList 2 is not cyclic, no loop or cycle found");
        }

    }
}
