package PBL;

import java.util.EmptyStackException;

class MyLinkedStack {
    private static class Node{
        String data;
        Node next;
        public Node(String  data,Node n){
            this.data=data;
            this.next=n;
        }
    }
    private Node top;
    private int size;
    public boolean isEmpty(){
        return size==0;
    }
    public int size() {
        return size;
    }

    public void push(String  data) {
        top=new Node(data,top);
        size++;
    }
    public String pop() {
        if(isEmpty())throw new EmptyStackException();
        String temp=top.data;
        top=top.next;
        size--;
        return temp;
    }
    public String peak() {
        if(isEmpty())throw new EmptyStackException();
        return top.data;
    }
    public void push(String key,University university,String orderBy){
        Node temp=top;
        if(orderBy.equals("noOfPublications")){
                if(isEmpty()||Main.getMap().get(top.data).getNoOfPublications()< university.getNoOfPublications()){
                    top=new Node(key,top);
                    size++;
                    return;
                }

                while (temp.next!=null){
                    if(Main.getMap().get(temp.next.data).getNoOfPublications()< university.getNoOfPublications())break;
                    temp=temp.next;
                }

        }
        else if(orderBy.equals("PakRanking")){
            if(isEmpty()||Main.getMap().get(top.data).getPakRanking()> university.getPakRanking()){
                top=new Node(key,top);
                size++;
                return;
            }

            while (temp.next!=null){
                if(Main.getMap().get(temp.next.data).getPakRanking()> university.getPakRanking())break;
                temp=temp.next;
            }


        }
        Node n=new Node(key,null);
        n.next=temp.next;
        temp.next=n;
        size++;

    }
    public String get(int position){
        if(position<1||position>size)throw new IllegalArgumentException("Incorrect index");
        Node temp=top;
        for(int j=1;j<position;j++)temp=temp.next;
        return temp.data;
    }
    public void traverse(){
        for(Node n=top;n!=null;n=n.next) System.out.println(Main.getMap().get(n.data));
    }

}

