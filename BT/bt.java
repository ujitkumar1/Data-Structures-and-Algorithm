package BT;

import java.util.LinkedList;
import java.util.Queue;

class binaryNode {
    int value;
    binaryNode leftNode;
    binaryNode rightNode;
}

class binaryTree {
    binaryNode root;

    binaryTree() {
        this.root = null;
    }

    void preOrder(binaryNode node) {
        if (node == null) {
            System.out.println("Empty Tree");
        } else {
            System.out.println(node.value);
            preOrder(node.leftNode);
            preOrder(node.rightNode);
        }
    }

    void postOrder(binaryNode node) {
        if (node == null) {
            System.out.println("Empty Tree");
        } else {
            postOrder(node.leftNode);
            postOrder(node.rightNode);
            System.out.println(node.value);
        }
    }

    void inOrder(binaryNode node) {
        if (node == null) {
            System.out.println("Empty Tree");
        } else {
            inOrder(node.leftNode);
            System.out.println(node.value);
            inOrder(node.rightNode);
        }
    }

    void levelOrder() {
        Queue<binaryNode> queue = new LinkedList<binaryNode>();
        queue.add(this.root);

        while (!queue.isEmpty()) {
            binaryNode node = queue.remove();

            System.out.println(node.value);

            if (node.leftNode != null) {
                queue.add(node.leftNode);
            }
            if (node.rightNode != null) {
                queue.add(node.rightNode);
            }
        }
    }

    void search(int node) {
        Queue<binaryNode> queue = new LinkedList<binaryNode>();
        queue.add(this.root);

        while (!queue.isEmpty()) {
            binaryNode pnode = queue.remove();
            if (pnode.value == node) {
                System.out.println("Node Found");
            } else {
                if (pnode.leftNode != null) {
                    queue.add(pnode.leftNode);
                }
                if (pnode.rightNode != null) {
                    queue.add(pnode.rightNode);
                }
            }
        }
    }

    void insert(int value) {
        binaryNode newNode = new binaryNode();
        newNode.value = value;

        if (this.root == null) {
            this.root = newNode;
        } else {
            Queue<binaryNode> queue = new LinkedList<binaryNode>();
            queue.add(root);

            while (!queue.isEmpty()) {
                binaryNode node = queue.remove();

                if (node.leftNode == null) {
                    node.leftNode = newNode;
                    break;
                } else if (node.rightNode == null) {
                    node.rightNode = newNode;
                    break;
                } else {
                    queue.add(node.leftNode);
                    queue.add(node.rightNode);
                }
            }
        }
    }

    binaryNode getDeepestNode(){
        Queue<binaryNode> queue = new LinkedList<binaryNode>();
        queue.add(root);

        binaryNode node = null;
        while(!queue.isEmpty()){
            node = queue.remove();

            if (node.leftNode != null){
                queue.add(node.leftNode);
            }

            if (node.rightNode != null){
                queue.add(node.rightNode);
            }
        }
        return node;
    }
    
    void deleteDeepestNode(){
        Queue<binaryNode> queue = new LinkedList<binaryNode>();
        queue.add(root);
        
        binaryNode present = null, previous = null;
        
        while(!queue.isEmpty()){
            previous = present;
            present = queue.remove();

            if (present.leftNode == null){
                previous.rightNode = null;
                break;
            }
            else if (present.rightNode == null) {
                present.leftNode = null;
                break;
            }
            queue.add(present.leftNode);
            queue.add(present.rightNode);
        }
    }

    void deleteNode(int value){
        Queue<binaryNode> queue = new LinkedList<binaryNode>();
        queue.add(root);

        while(!queue.isEmpty()){
            binaryNode node = queue.remove();

            if(node.value == value){
                node.value = getDeepestNode().value;
                deleteDeepestNode();
                break;
            }
            else{
                if (node.leftNode != null){
                    queue.add(node.leftNode);
                }

                if (node.rightNode != null){
                    queue.add(node.rightNode);
                }
            }
        }
        System.out.println("Node does not exist");
    }

    void deleteBT(){
        this.root = null;
    }
}

public class bt {
    public static void main(String[] args) {
        binaryTree bt = new binaryTree();
        bt.insert(1);
        bt.insert(2);
        bt.insert(3);
        bt.insert(4);
        bt.insert(5);
        bt.insert(6);
        bt.insert(7);
        bt.insert(8);

        //bt.levelOrder();
        System.out.println(bt.getDeepestNode().value);
        bt.deleteDeepestNode();
        System.out.println(bt.getDeepestNode().value);


    }
}
