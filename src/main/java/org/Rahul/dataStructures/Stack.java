package org.Rahul.dataStructures;

@SuppressWarnings("unused")
public class Stack {
    static class Node{
        int data;
        Node next;
         Node(int data){
            this.data = data;
            next = null;
        }
    }
    Node head;
    private Stack(){
        head=null;
    }

    private void push(int data){
        Node node=new Node(data);
        node.next=head;
        head=node;

    }


    private void size() {
        Node n = head;
        int count = 1;
        if (head == null) {
            count = 0;
        } else {
            while (n.next != null) {
                count++;
                n = n.next;
            }
        }
        System.out.println("size is " + count);
    }


    private void show() {
        Node n = head;
        if (head != null) {
            while (n.next != null) {
                System.out.println(n.data);
                n = n.next;
            }
            System.out.println(n.data);
        }else
            System.out.println("Stack is empty");
    }


    private void max() {
        int ma=-1;
        Node n=head;

        while(n.next!=null){
            if(n.data>ma)
                ma=n.data;
            n=n.next;
        }
        if(n.data>ma)
            ma=n.data;
        System.out.println("Max is "+ma);
    }


    private void reset(){
        head=null;
    }


    private void peek()throws NullPointerException{
        if(head==null) throw new NullPointerException();

        else System.out.println("Top element is "+head.data);
    }


    private void pop(){
        if(head==null)
            System.out.println("Stack is Empty");
        int d= head.data;
        head=head.next;
        System.out.println("The popped element is "+d);
    }

    private boolean isEmpty(){
        return head == null;
    }


    public static void main(String[] args) {
        Stack stack=new Stack();
        Stack second = new Stack();
        second.push(-1);
        int[] arr={1,2,3,4,5,6,7,8,9,8,7,6,5,67,8,5,4,7,564,44,34,33};
        for(int i:arr){
            stack.push(i);
            if(second.head.data<i){
                second.push(i);
                System.out.println(i);
            }
        }

        System.out.println(second.head.data);
    }
}