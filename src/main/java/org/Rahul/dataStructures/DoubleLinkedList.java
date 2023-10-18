package org.Rahul.dataStructures;

import java.util.HashSet;

@SuppressWarnings("usused")
public class DoubleLinkedList {
    static class Node{
        int data;
        Node prev;
        Node next;
        public Node(int data){
            this.data = data;
            next = prev = null;
        }
    }
    Node head,tail;

    public void add(int data){
        Node node = new Node(data);
        if (head == null){
            head = node;
            tail = node;

            head.prev = null;
            tail.next = null;
        }
        else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }
    public void addAtFirst(int data){
        Node node = new Node(data);
        if (head == null){
            head = node;
            tail = node;

            head.prev = null;
            tail.next = null;
        }
        else {
            head.prev=node;
            node.next=head;
            head=node;
        }
    }

    public int size(){
        Node n =head;
        int count = 0;
        while(n != null){
            count++;
            n = n.next;
        }
        return count;
    }

    public int get(int m){
        if(m>size())
            throw new IndexOutOfBoundsException();
        else {
            m--;
            if (m>size()/2){
                Node n=tail;
                while (m>(size()/2)){
                    n=n.prev;
                    m--;
                }
                return n.data;
            }
            else{
                Node n = head;
                while(m>0){
                    n=n.next;
                    m--;
                }
                return n.data;
            }
        }
    }

    public boolean contains(int element){
        Node n = head;
        while(n != null){
            if(element == n.data)
                return true;
            n = n.next;
        }
        return false;
    }
    public void showFromHead(){
        Node n = head;
        while(n != null){
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }
    public void showFromTail(){
        Node n = tail;
        while(n != null){
            System.out.print(n.data + " ");
            n = n.prev;
        }
        System.out.println();
    }
    private void removeDuplicat(){
        Node n = head;
        HashSet<Integer> hs = new HashSet<>();
        while (n!=null){
            if(hs.contains(n.data)) {
                n.next.prev = n.prev;
                n.prev.next = n.next;
            }
            else hs.add(n.data);
            n=n.next;
        }
    }
//    private void requiredSum(int num){
//        Node first = head,sec = tail;
//        while ()
//    }
    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        list.add(12);
        list.add(13);
        list.add(14);
        list.add(12);
        list.removeDuplicat();
        list.showFromHead();
//        System.out.println(list.contains(15));
//        System.out.println(list.contains(44));
    }
}