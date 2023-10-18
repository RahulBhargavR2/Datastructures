package org.Rahul.dataStructures;

public class CircularLinkedList {
    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            next = null;
        }
    }
    Node head,tail;
    public void add(int data){
        Node node=new Node(data);
        if(head == null){
            head=node;
        }
        else{
            tail.next=node;


        }
        tail=node;
        tail.next=head;

    }
    private int sizeOf(){
        Node node = head;
        int size = 0;
        do {
            size++;
            node = node.next;
        }while (node != head);
        return size;
    }
    public void show(){
        Node n =head;
        while (n!=tail){
            System.out.print(n.data+" ");
            n=n.next;
        }
        System.out.print(n.data+"\n");
    }
    public void repeat(int n){
        Node node =head;
        while (n>0){
            System.out.print(node.data+" ");
            node=node.next;
            n--;
        }
    }

    public static void main(String[] args) {
        CircularLinkedList list=new CircularLinkedList();
        list.add(12);
        list.add(34);
        list.add(34);
        list.add(34);
        list.add(34);
        list.add(34);
        list.add(34);
        list.add(45);
//        list.show();
        System.out.println(list.sizeOf());

    }
}