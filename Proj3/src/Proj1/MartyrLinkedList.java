package Proj1;

import Proj2.Stack;
import Proj3.Martyr;

public class MartyrLinkedList {
    private SNode first, last;
    int count=-1;


    public MartyrLinkedList() {
        super();
    }

    public SNode getFirst() {
        return first;
    }

    public Object getFirstD() {
        if(first==null)
            return null;

        return first.getData();
    }

    public Object getLast() {
        if(last==null)
            return null;

        return last.getData();
    }

    public void addFirst(Object data) {
        SNode newNode= new SNode(data);

        if(first==null) {
            first = last = newNode;
            last.next=first;
        }

        else {
            newNode.next=first;
            first=newNode;
            last.next=first;
        }
        count++;
    }

    public void addLast(Object data) {
        SNode newNode= new SNode(data);

        if(last==null){
            first=last=newNode;
            last.next=first;
        }

        else {
            last.next=newNode;
            last=newNode;
            last.next=first;
        }
        count++;
    }
    public boolean removeByName(String name){
        if (first==null){
            return false;
        }
        else{
            SNode temp=first;
            do{
                if(((Martyr)temp.getData()).getName().equalsIgnoreCase(name)){
                    if(temp==first){
                       return removeFirst();
                    } else if (temp==last) {
                       return removeLast();
                    }
                    return true;

                }
                temp=temp.next;

            }while (temp==first);
            return false;
        }
    }
    public Martyr searchMar(String name){
        if (first==null){
            return null;
        }
        SNode ptr=first;
        do{
            if(((Martyr)ptr.getData()).getName().equalsIgnoreCase(name)){
                return (Martyr)ptr.getData();
            }
            ptr=ptr.next;
        }while (ptr==first);
        return null;
    }
    public void Update(String oldname,Martyr newmar){
        if(first==null){
            return;
        }
        SNode ptr=first;
        do {
            if(((Martyr)ptr.getData()).getName().equals(oldname)){
                ptr.setData(newmar);
                return;
            }
            ptr=ptr.next;
        }while(ptr!=null);
    }

    public void add(Object data, int index) {
        SNode newNode= new SNode(data);

        if(index<0)
            addFirst(data);

        else if(index>count)
            addLast(data);

        else {
            SNode temp=first;
            for(int i=0; i<index; i++) {
                temp=temp.next;
            }

            newNode.next=temp.next;
            temp.next=newNode;
            count++;
        }
    }
    public void insert(Object data) {
        SNode current = new SNode(data);
        if (first==null){
            first=last=current;
            last.next=first;
            count++;
            return;
        }
        SNode temp = first;
        do {
            if (((Martyr) first.getData()).compareTo((Martyr) data) > 0){
                current.next=first;
                first=current;
                last.next=first;
                count++;
                return;

            }
            if(temp.next==first){
                temp.next=current;
                last=current;
                last.next=first;
                count++;
                return;
            }
            if (((Martyr) temp.next.getNext().getData()).compareTo((Martyr) data) > 0) {
                break;
            }
            temp = temp.getNext();

        } while (temp != first);
        current.next=temp.next;
        temp.next=current;
        count++;


    }


    public int countmale(){
        int m=0;
        SNode temp= first;
        if (temp==null){
            return 0;
        }
        do {

            if (((Martyr)temp.getData()).getGender().equals("M")) {
                m++;
            }
            temp=temp.next;
        } while(temp != first);
        return m;
    }
    public int countfemale(){
        int f=0;
        SNode temp= first;
        if (temp==null){
            return 0;
        }
        do {

            if (((Martyr)temp.getData()).getGender().equals("F")) {
                f++;
            }
            temp=temp.next;
        } while(temp != first);
        return f;
    }
    public double average(){
        double avg=0;
        SNode ptr=first;
        if (ptr==null){
            return 0;
        }
       do {
           if(((Martyr)ptr.getData()).getAge().equals("n/a")){
               ptr=ptr.next;
               continue;
           }
            avg+=Integer.parseInt(((Martyr)ptr.getData()).getAge());
            ptr=ptr.next;
        }while (ptr!=first);
        return avg/getSize();
    }
    public Martyr[] listMar(){
        Martyr []mar=new Martyr[getSize()];
        Stack stack = new Stack();
        SNode curr=first;
        if(curr!=null) {
            do {
                stack.push((Martyr) curr.getData());
                curr = curr.next;
            } while (curr != first);
            Stack tempStack = new Stack();
            while (!stack.isEmpty()) {
                Martyr temp = (Martyr) stack.pop();
                while (!tempStack.isEmpty() && temp.getName().compareToIgnoreCase(((Martyr) tempStack.peek()).getName()) > 0) {
                    stack.push(tempStack.pop());
                }
                tempStack.push(temp);
            }
            while (!tempStack.isEmpty()) {
                stack.push(tempStack.pop());
            }
            while (!stack.isEmpty()) {
                tempStack.push(stack.pop());
            }
            int i = 0;
            while (!tempStack.isEmpty()) {
                mar[i] = (Martyr) tempStack.pop();
                i++;
            }
        }

        return mar;
    }

    public int countAge(){
        int avg=0;
        SNode ptr=first;
        if (ptr==null){
            return 0;
        }
        do {
            if(((Martyr)ptr.getData()).getAge().equals("n/a")){
                ptr=ptr.next;
                continue;
            }

            avg+=Integer.parseInt(((Martyr)ptr.getData()).getAge());
            ptr=ptr.next;
        }while (ptr!=first);
        return avg;
    }
    public String oldest(){

        SNode ptr=first;
        if (ptr==null){
            return null;
        }
        String s=((Martyr)ptr.getData()).getName();
        do {
            if(((Martyr)ptr.getData()).getAge().equals("n/a")){
                ptr=ptr.next;
                continue;
            }
            SNode cur=ptr.next;
            do {
                if (((Martyr)cur.getData()).getAge().equals("n/a")){
                    cur=cur.next;
                    continue;
                }
                if(Integer.parseInt(((Martyr)cur.getData()).getAge())>Integer.parseInt(((Martyr)ptr.getData()).getAge())){
                    s=((Martyr)cur.getData()).getName();
                }
               cur=cur.next;
            }while (cur!=first);

            ptr=ptr.next;
        }while (ptr!=first);
        return s;
    }
    public String youngest(){

        SNode ptr=first;
        if (ptr==null){
            return null;
        }
        String s=((Martyr)ptr.getData()).getName();

        do {
            if(((Martyr)ptr.getData()).getAge().equals("n/a")){
                ptr=ptr.next;
                continue;
            }
            SNode cur=ptr.next;
            do {
                if (((Martyr)cur.getData()).getAge().equals("n/a")){
                    cur=cur.next;
                    continue;
                }
                if(Integer.parseInt(((Martyr)cur.getData()).getAge())<Integer.parseInt(((Martyr)ptr.getData()).getAge())){
                    s=((Martyr)cur.getData()).getName();
                }
                cur=cur.next;
            }while (cur!=first);

            ptr=ptr.next;
        }while (ptr!=first);
        return s;
    }


    public boolean remove(Object data) {
        if(count<0 ) {
            return false;
        }
        else if(((Object)first.getData()).equals(data)) {
            return removeFirst();
        }
        else if(((Object)last.getData()).equals(data)) {
            return removeLast();
        }

        else {
            SNode ptr = first;
            for(int i=0; i<count-1;i++) {
                if(((Object)ptr.getData()).equals(data)){
                    return remove(i);
                }else
                    ptr=ptr.next;
            }
        }
        return false;
    }
    //1+1+n+n -----> O(n)
    public boolean remove(int index) {

        if(count<0 || index>count) {
            return false;
        }
        else if(index==0 ||count==0) {
            return removeFirst();
        }
        else if(index==count) {
            return removeLast();
        }

        else {
            SNode ptr = first;
            for(int i=0; i<index-1;i++) {
                ptr=ptr.next;
            }
            SNode temp = ptr.next;

            ptr.next=temp.next;
            temp.next=null;
            count--;

        }
        return true;
    }
    //O(1).
    public boolean removeFirst() {

        if(count<0) {
            return false;
        }
        else if(count==0) {
            first=last=null;
        }else {
            SNode temp = first;
            first = first.next;
            temp.next=null;
            last.next=first;
        }
        count--;

        return true;
    }

    //O(n).
    public boolean removeLast() {

        if (count < 0) {
            return false;
        } else if (count == 0) {
            first = last = null;
        } else {
            SNode ptr = first;
            for (int i = 0; i < count - 1; i++) {
                ptr = ptr.next;
            }
            ptr.next = null;
            last = ptr;
            last.next = first;
        }
        count--;
        return true;
    }


    public String printList() {
        String s = "";
        if (first != null) {
            SNode temp = first;
            if (temp!=null) {
                System.out.print("LinkedList: ");
                do {
                    s += ((Martyr) temp.getData()).getName() + " ";
                    temp = temp.next;
                } while (temp != first);
            }
        }
        return s;
    }


    public int getSize() {
        int size=0;
        SNode temp= first;
        if (temp==null){
            return 0;
        }
        do {
            if (temp==null){
                return 0;
            }
            size++;
            temp=temp.next;
        } while(temp != first);
        return size;
    }
}
