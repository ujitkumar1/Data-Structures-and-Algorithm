package linkedlist;

class Node{
    int value;
    Node next;

}

class singleLinkedList{
    Node head;
    Node tail;
    int size;

    singleLinkedList(){
        this.head = null;
        this.tail = null;
    }

    void insert(int value,int postion){
        Node newNode = new Node();
        newNode.value = value;

        if (this.head == null){
            head = newNode;
            newNode.next = null;
            tail = newNode;
        }

        else{
            if (postion == 0){
                newNode.next = head.next;
                head = newNode;
            }

            else{
                for (int i = 1 ; i<postion ; i++){

                }
            }
        }
    }

}

public class singleLL {
    public static void main(String[] args) {

    }
}
