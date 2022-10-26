package BST;

import java.util.LinkedList;
import java.util.Queue;

class binaryNode{
    int value;
    binaryNode left;
    binaryNode right;
}

class binarySearchTree{
    binaryNode root;

    binarySearchTree(){
        this.root = null;

    }

    private binaryNode insert(binaryNode currentNode, int value){
        if (currentNode == null){
            binaryNode node = new binaryNode();
            node.value = value;
            return currentNode;
        }
        else if (value <= currentNode.value) {
            currentNode.left = insert(currentNode,value);
            return currentNode;
        }
        else {
            currentNode.right = insert(currentNode,value);
            return currentNode;
        }
    }

    void insert(int value){
        insert(this.root,value);
    }
    void preOrder(binaryNode node) {
        if (node == null) {
            System.out.println("Empty Tree");
        } else {
            System.out.println(node.value);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    void postOrder(binaryNode node) {
        if (node == null) {
            System.out.println("Empty Tree");
        } else {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.value);
        }
    }

    void inOrder(binaryNode node) {
        if (node == null) {
            System.out.println("Empty Tree");
        } else {
            inOrder(node.left);
            System.out.println(node.value);
            inOrder(node.right);
        }
    }

    void levelOrder() {
        Queue<binaryNode> queue = new LinkedList<binaryNode>();
        queue.add(this.root);

        while (!queue.isEmpty()) {
            binaryNode node = queue.remove();

            System.out.println(node.value);

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    void search(int value){
        Queue<binaryNode> queue = new LinkedList<binaryNode>();
        queue.add(root);

        while (!queue.isEmpty()){
            binaryNode node = queue.remove();

            if (node.value == value){
                System.out.println("Node found");
                break;
            }
            else if (value  < node.left.value) {
                queue.add(node.left);

            }
            else{
                queue.add(node.right);
            }
        }
    }

    public static binaryNode minimumNode(binaryNode root) {
        if (root.left == null) {
            return root;
        } else {
            return minimumNode(root.left);
        }
    }

    public binaryNode deleteNode(binaryNode root, int value) {
        if (root == null) {
            System.out.println("Value not found in BST");
            return null;
        }
        if (value < root.value) {
            root.left = deleteNode(root.left, value);
        } else if (value > root.value) {
            root.right = deleteNode(root.right, value);
        } else {
            if (root.left != null && root.right != null) {
                binaryNode temp = root;
                binaryNode minNodeForRight = minimumNode(temp.right);
                root.value = minNodeForRight.value;
                root.right = deleteNode(root.right, minNodeForRight.value);
            } else if (root.left != null) {
                root = root.left;
            } else if (root.right != null) {
                root = root.right;
            } else {
                root = null;
            }
        }

        return root;

    }

    void deleteBST(){
        this.root = null;
    }
}
public class bst {
    public static void main(String[] args) {

    }
}
