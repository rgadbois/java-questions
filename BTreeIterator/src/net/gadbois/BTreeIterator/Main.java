package net.gadbois.BTreeIterator;

import java.util.Arrays;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        Iterator<Integer> itr;

        Integer[] arr = {1, 2, 3, 4, null, 6, 7};
        Integer[] arr1 = {1, 2, 3, 4, 5, 6, 7}; // full
        Integer[] arr2 = {1, 2, null, 3, null, null, null}; // left skew
        Integer[] arr3 = {1, null, 3, null, null, null, 7}; // right skew
        Integer[] arr4 = {1}; // single element


        System.out.println("---- TESTING FOR PREORDER -----------");


        IterableBinaryTree<Integer> iteratePreOrder = new IterableBinaryTree<Integer>(Arrays.asList(arr));
        System.out.print("Expected: 1 2 4 3 6 7, Actual: ");
        itr = iteratePreOrder.preOrderIterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }

        System.out.println();

        IterableBinaryTree<Integer> iteratePreOrder1 = new IterableBinaryTree<Integer>(Arrays.asList(arr1));
        System.out.print("Expected: 1 2 4 5 3 6 7, Actual: ");
        itr = iteratePreOrder1.preOrderIterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }

        System.out.println();

        IterableBinaryTree<Integer> iteratePreOrder2 = new IterableBinaryTree<Integer>(Arrays.asList(arr2));
        System.out.print("Expected: 1 2 3, Actual: ");
        itr = iteratePreOrder2.preOrderIterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }

        System.out.println();

        IterableBinaryTree<Integer> iteratePreOrder3 = new IterableBinaryTree<Integer>(Arrays.asList(arr3));
        System.out.print("Expected: 1 3 7, Actual: ");
        itr = iteratePreOrder3.preOrderIterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }

        System.out.println();

        IterableBinaryTree<Integer> iteratePreOrder4 = new IterableBinaryTree<Integer>(Arrays.asList(arr4));
        System.out.print("Expected: 1, Actual: ");
        itr = iteratePreOrder4.preOrderIterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }

        System.out.println();

        System.out.println("---- TESTING FOR INORDER -----------");

        IterableBinaryTree<Integer> iterateInOrder = new IterableBinaryTree<Integer>(Arrays.asList(arr));
        System.out.print("Expected: 4 2 1 6 3 7, Actual: ");
        itr = iterateInOrder.inOrderIterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }

        System.out.println();

        IterableBinaryTree<Integer> iterateInOrder1 = new IterableBinaryTree<Integer>(Arrays.asList(arr1));
        System.out.print("Expected: 4 2 5 1 6 3 7, Actual: ");
        itr = iterateInOrder1.inOrderIterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }

        System.out.println();

        IterableBinaryTree<Integer> iterateInOrder2 = new IterableBinaryTree<Integer>(Arrays.asList(arr2));
        System.out.print("Expected: 3 2 1, Actual: ");
        itr = iterateInOrder2.inOrderIterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }

        System.out.println();

        IterableBinaryTree<Integer> iterateInOrder3 = new IterableBinaryTree<Integer>(Arrays.asList(arr3));
        System.out.print("Expected: 1 3 7, Actual: ");
        itr = iterateInOrder3.inOrderIterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }

        System.out.println();

        IterableBinaryTree<Integer> iterateInOrder4 = new IterableBinaryTree<Integer>(Arrays.asList(arr4));
        System.out.print("Expected: 1, Actual: ");
        itr = iterateInOrder4.inOrderIterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }

        System.out.println();

        System.out.println("---- TESTING FOR POSTORDER -----------");

        IterableBinaryTree<Integer> iteratePostOrder = new IterableBinaryTree<Integer>(Arrays.asList(arr));
        System.out.print("Expected: 4 2 6 7 3 1, Actual: ");
        itr = iteratePostOrder.postOrderIterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }

        System.out.println();

        IterableBinaryTree<Integer> iteratePostOrder1 = new IterableBinaryTree<Integer>(Arrays.asList(arr1));
        System.out.print("Expected: 4 5 2 6 7 3 1, Actual: ");
        itr = iteratePostOrder1.postOrderIterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }

        System.out.println();

        IterableBinaryTree<Integer> iteratePostOrder2 = new IterableBinaryTree<Integer>(Arrays.asList(arr2));
        System.out.print("Expected: 3 2 1, Actual: ");
        itr = iteratePostOrder2.postOrderIterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }

        System.out.println();

        IterableBinaryTree<Integer> iteratePostOrder3 = new IterableBinaryTree<Integer>(Arrays.asList(arr3));
        System.out.print("Expected: 7 3 1, Actual: ");
        itr = iteratePostOrder3.postOrderIterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }

        System.out.println();

        IterableBinaryTree<Integer> iteratePostOrder4 = new IterableBinaryTree<Integer>(Arrays.asList(arr4));
        System.out.print("Expected: 1, Actual: ");
        itr = iteratePostOrder4.postOrderIterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
    }
}
