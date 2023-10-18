package org.Rahul.dataStructures;

@SuppressWarnings("unused")
public class Queue {

    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            next = null;
        }
    }
    Node front,rear;
    static int size;
    Queue(){
        this.front=this.rear=null;
        size=0;
    }


    public void enQueue(int data){
        Node node = new Node(data);
        if(front==null){
            front=rear=node;
        }else{
            rear.next=node;
            rear=node;
        }
        size++;
    }

    public void deQueue(){
        if(front == null){
            System.out.println("queue is empty");
            return;
        }
        front = front.next;
        size--;
    }

    public void show(){

        Node n=front;
        System.out.print("[");
        while(n.next!=null){
            System.out.print(n.data+",");
            n=n.next;
        }
        System.out.print(n.data+"]\n");
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.enQueue(12);
        q.enQueue(23);
        q.show();

    }
}