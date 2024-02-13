package org.rest.api;

public class Node {

    int value;
    Node next;
    Node(int data){
        this.value=data;
        next=null;
    }
    public Node head = null;
    public Node tail = null;
    public void add(int data){
        Node newnode=new Node(data);
        if(head==null){
            head=newnode;
            tail=newnode;
        }
        else{
            tail.next=newnode;
            tail=newnode;
        }
    }

    public void display(){
        Node current=head;
        if(head!=null){
            System.out.println("empty list");

        }
        while (current!=null){
            System.out.println(current.value+" ");
            current=current.next;
        }
    }
}
