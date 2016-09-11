package net.gadbois.BTreeIterator;

import java.util.*;

/**
 * Created by rgadbois on 9/11/16.
 */
public class IterableBinaryTree<E> {

    private static class TreeNode<E> {
        E item;
        TreeNode<E> left;
        TreeNode<E> right;
        TreeNode(E item) {
            this.item = item;
            this.left = null;
            this.right = null;
        }
    }

    private TreeNode<E> root;

    public IterableBinaryTree(List<E> items) {
        create(items);
    }
    private void create(List<E> items) {
        root = null;

        if ((items == null) || items.isEmpty()) {
            return;
        }

        root = new TreeNode<E>(items.get(0));
        final Queue<TreeNode<E>> queue = new LinkedList<TreeNode<E>>();
        queue.add(root);

        final int half = items.size() / 2;
        for (int i = 0; i < half; i++) {
            if (items.get(i) == null) {
                continue;
            }
            final TreeNode<E> current = queue.poll();
            final int left = 2 * i + 1;
            final int right = 2 * i + 2;
            if (items.get(left) != null) {
                current.left = new TreeNode<E>(items.get(left));
                queue.add(current.left);
            }
            if (items.get(right) != null) {
                current.right = new TreeNode<E>(items.get(right));
                queue.add(current.right);
            }
        }
    }
    /**
     * Returns the preorder representation for the given tree.
     *
     * @return  the iterator for preorder traversal
     */
    public Iterator<E> preOrderIterator() {
        return new PreOrderIterator();
    }

    public class PreOrderIterator implements Iterator<E> {
        private final Stack<TreeNode<E>> stack;

        public PreOrderIterator() {
            this.stack = new Stack<TreeNode<E>>();
            this.stack.add(root);
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more nodes remaining to iterate");
            }
            final TreeNode<E> node = stack.pop();
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            return node.item;
        }
    }
    /**
     * Returns the in-order representation for the given tree.
     *
     * @return  the iterator for preorder traversal
     */
    public Iterator<E> inOrderIterator() {
        return new InOrderIterator();
    }
    private class TreeNodeVisited<E> {
        TreeNode<E> treeNode;
        boolean visited;
        public TreeNodeVisited(TreeNode<E> treeNode) {
            this.treeNode = treeNode;
            this.visited = false;
        }
    }

    private class InOrderIterator<E> implements Iterator<E> {
        private final Stack<TreeNodeVisited> stack;

        public InOrderIterator() {
            this.stack = new Stack<TreeNodeVisited>();
            this.stack.add(new TreeNodeVisited(root));
        }
        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more nodes remaining to iterate");
            }
            while (hasNext()) {
                final TreeNodeVisited treeNodeVisited = stack.peek();
                final TreeNode<E> treeNode = treeNodeVisited.treeNode;
                if (!treeNodeVisited.visited) {
                    if (treeNode.left != null) {
                        stack.add(new TreeNodeVisited(treeNode.left));
                    }
                    treeNodeVisited.visited = true;

                } else {
                    stack.pop();
                    if (treeNode.right != null) {
                        stack.add(new TreeNodeVisited(treeNode.right));
                    }
                    return treeNode.item;
                }
            }
            throw new AssertionError("A node has not been returned when it should have been.");
        }
    }

    /**
     * Returns the post-order representation for the given tree.
     *
     * @return  the iterator for postorder traversal
     */
    public Iterator<E> postOrderIterator() {
        return new PostOrderIterator();
    }
    private class PostOrderIterator<E> implements Iterator<E> {
        private final Stack<TreeNodeVisited> stack;

        public PostOrderIterator() {
            this.stack = new Stack<TreeNodeVisited>();
            this.stack.add(new TreeNodeVisited(root));
        }
        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more nodes remaining to iterate");
            }
            while (hasNext()) {
                final TreeNodeVisited treeNodeVisited = stack.peek();
                final TreeNode<E> treeNode = treeNodeVisited.treeNode;
                if (!treeNodeVisited.visited) {

                    if (treeNode.right != null) {
                        stack.add(new TreeNodeVisited(treeNode.right));
                    }

                    if (treeNode.left != null) {
                        stack.add(new TreeNodeVisited(treeNode.left));
                    }

                    treeNodeVisited.visited = true;

                } else {
                    stack.pop();
                    return treeNode.item;
                }
            }
            throw new AssertionError("A node has not been returned when it should have been.");
        }
    }
}
