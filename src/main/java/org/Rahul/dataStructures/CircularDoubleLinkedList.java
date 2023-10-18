package org.Rahul.dataStructures;

public class CircularDoubleLinkedList {
    public static class Node{
        int data;
        Node next,prev;
        public Node(int data){
            this.data = data;
            next = prev = null;
        }
    }
    Node head,tail;
    public void add(int data){
        Node node=new Node(data);
        if(head == null){
            head=node;
            tail=node;
            head.next=tail;
            tail.prev=head;
        }
        else if(size()==1) {
            tail = node;
            head.next=tail;
            tail.prev=head;
            tail.next=head;
            head.prev=tail;

        }
        else {
            node.next=tail;
            tail.prev=node;
            head.next=node;
            node.prev=head;
            tail=node;
        }
    }
    public void show(){
        Node n = head;
        while(n.next!=head){
            System.out.print(n.data+" ");
            n=n.next;
        }
        System.out.print(n.data+"\n");
    }
    public void repeat(int no){
        Node n=head;
        while(no>0){
            System.out.print(n.data+" ");
            n=n.next;
            no--;
        }
        System.out.println();
    }

    public int size(){
        Node n = head;
        int si=0;
        while(n.next!=head){
            si++;
            n=n.next;
        }
        si++;
        return si;
    }


    public static void main(String[] args) {
        CircularDoubleLinkedList list = new CircularDoubleLinkedList();
        list.add(12);
        list.add(13);
        list.add(14);
        list.add(15);
        list.repeat(10);
        list.show();
        System.out.println("size is "+list.size());
    }
}