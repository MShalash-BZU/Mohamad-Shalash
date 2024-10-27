package Proj1;

public class LocationLinkedList {
    private SNode first,last;
    int count=-1;

    public SNode getFirst() {
        return first;
    }

    public SNode getLast() {
        return last;
    }

    public int getCount() {
        return count;
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
            if (((Location) first.getData()).getName().compareToIgnoreCase(((Location) data).getName()) > 0){
                current.next=first;
                first=current;
                last.next=first;
                count++;
                return;

            }
            if (((Location) temp.next.getData()).getName().compareToIgnoreCase(((Location) data).getName()) > 0) {
                break;
            }
            if(temp.next==first){
                temp.next=current;
                last=current;
                last.next=first;
                count++;
                return;
            }
            temp = temp.getNext();

        } while (temp != first);
        current.next=temp.next;
        temp.next=current;
        count++;


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



    public void addFirst(Object data) {
        SNode newNode= new SNode(data);

        if(first==null) {
            last=first = newNode;
            last.next=first;
        }

        else {
            newNode.next=first;
            first=newNode;
            last.next=first;
        }
        count++;
    }
    public void Update(String oldname,String newname){
        if(first==null){
            return;
        }
        SNode ptr=first;
        do {
            if(((District)ptr.getData()).getNamedis().equals(oldname)){
                ((District)ptr.getData()).setNamedis(newname);
                return;
            }
            ptr=ptr.next;
        }while(ptr!=null);
    }
    public  String printList() {
        String s="";
        SNode temp = first;
        System.out.print("LinkedList: ");
        if (temp==null){
            return " ";
        }else {
            do {
                if (temp!=null) {
                    s += ((Location) temp.getData()).getName() + " ";
                }else return " ";
                temp = temp.next;
            } while (temp != first);
            return s;
        }
    }
    public int totalMartyr(){
        int size=0;
        SNode temp= first;
        if (temp==null){
            return 0;
        }

        do {
            size+=((Location)temp.getData()).getList().getSize();
            temp=temp.next;
        } while(temp != first);
        return size;
    }
    public int totalMale(){
        int m=0;
        SNode temp= first;
        if (temp==null){
            return 0;
        }
        do {


                m+=((Location)temp.getData()).getList().countmale();

            temp=temp.next;
        } while(temp != first);
        return m;
    }
    public int totalFemale(){
        int m=0;
        SNode temp= first;
        if (temp==null){
            return 0;
        }
        do {


            m+=((Location)temp.getData()).getList().countfemale();

            temp=temp.next;
        } while(temp != first);
        return m;
    }
    public double averageAge(){
        double avg=0;
        SNode ptr=first;
        if (ptr==null){
            return 0;
        }
        do {

            avg+=((Location)ptr.getData()).getList().countAge();
            ptr=ptr.next;
        }while (ptr!=first);
        return avg/totalMartyr();
    }

    public int getSize() {
        int size=0;
        SNode temp= first;
        if (temp==null){
            return 0;
        }
        do {
            size++;
            temp=temp.next;
        } while(temp != first);
        return size;
    }
    public Location Find(String name){
        if (first==null){
            return null;
        }
        SNode ptr=first;

        do{
            if (((Location)ptr.getData()).getName().equals(name)){
                return (Location)ptr.getData();
            }
            ptr=ptr.next;
        }while (ptr!=first);
        return null;
    }



}
