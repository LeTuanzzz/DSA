/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.baitap;

/**
 *
 * @author Tunen
 */
public class MyList {
    Node head, tail;
    public MyList(){
    head=tail=null;
    }
    public boolean isEmpty(){
    return (head==null);}
    public void add(int x){
    if(isEmpty()){
    head=tail=new Node(x, null, null);}
    else{
    Node n = new Node(x, null,tail);
    tail.next = n;
    tail =n;}
    }
    public void addMany(int a[]){
    for(int i : a){
    add(i);}  
    }
    public void traverse(){
    Node p = head;
    while(p!=null){
    System.out.println(p.info);
    p = p.next;
    }
       }
}

   

