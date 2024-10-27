package Proj1;

public class DoubleList {
    private DNode first, last;
    static int count = -1;


    public DNode getFirst() {
        return first;
    }

    public Object getFirstD() {
        if (first == null)
            return null;

        return first.getData();
    }


    public void addFirst(Object data) {
        DNode newNode = new DNode(data);

        if (first == null) {
            first = newNode;
            first.next = first;
            first.prev = first;
        } else {
            last.next = newNode;
            newNode.prev = last;
            newNode.next = first;
            first.prev = newNode;
        }
        count++;
    }

    public void Update(String oldname, String newname) {
        if (first == null) {
            return;
        }
        DNode ptr = first;
        do {
            if (((District) ptr.getData()).getNamedis().equals(oldname)) {
                ((District) ptr.getData()).setNamedis(newname);
                return;
            }
            ptr = ptr.next;
        } while (ptr != null);
    }

    public void deleteDis(String name) {
        if (first == null) {
            return;
        }

        DNode ptr = first;
        do {
            if (((District) ptr.getData()).getNamedis().equalsIgnoreCase(name)) {
                if (count == 1) {
                    first = null;
                } else {
                    ptr.prev.next = ptr.next;
                    ptr.next.prev = ptr.prev;
                    if (ptr == first) {
                        first = ptr.next;
                    }
                }
                count--;
                return;
            }
            ptr = ptr.next;
        } while (ptr != first);
    }
    public District Find(String name){
        if (first==null){
            return null;
        }
        DNode ptr=first;

        do{
            if (((District)ptr.getData()).getNamedis().equals(name)){
                return (District)ptr.getData();
            }
            ptr=ptr.next;
        }while (ptr!=first);
        return null;
    }


    public void addLast(Object data) {
        DNode newNode = new DNode(data);
        if (first == null) {
            first = last = newNode;
            last.next = first;
            first.prev = last;

        } else {
            last.next = newNode;
            last.next.prev = newNode;
            last = newNode;
            last.next = first;
            first.prev = last;
        }
        count++;
    }

    public void add(Object data, int index) {
        DNode newNode;

        if (count < 0)
            addFirst(data);

        else if (index > count)
            addLast(data);

        else {
            newNode = new DNode(data);
            DNode temp = first;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }

            newNode.next = temp.next;
            newNode.prev = temp;
            temp.next = newNode;
            newNode.next.prev = newNode;
            count++;
        }
    }

    public boolean removeFirst() {

        if (count < 0)
            return false;
        else if (count == 0){
            first=last = null;
        }

        else {
            DNode temp = first;
            first = first.next;
            first.prev = last;
            last.next=first;
            temp.next = null;
        }
        count--;
        return true;
    }

    public boolean removeLast() {

        if (count < 0)
            return false;

        else if (count == 0)
            first = last = null;

        else {
            DNode temp = last;
            last = last.prev;
            last.next=first;
            first.prev=last;
            temp.next = null;
            temp.prev = null;

        }
        count--;
        return true;
    }
    public int totalmartyr(){
        DNode temp=first;
        int size=0;
        if(temp==null){
            return 0;
        }
        do {
            size+=((District)temp.getData()).getList().totalMartyr();
            temp=temp.next;
        }while (temp!=first);
        return size;
    }

    public boolean remove(int index) {
        if (count < 0 || count < index)
            return false;

        else if (index == 0)
            return removeFirst();

        else if (index == count)
            return removeLast();

        else {
            DNode ptr = first;
            for (int i = 0; i < index - 1; i++) {
                ptr = ptr.next;
            }
            DNode temp = ptr.next;
            ptr.next = temp.next;
            temp.next.prev = ptr;
            temp.next = null;
            temp.prev = null;
            count--;
        }
        return true;
    }

    public boolean removeD(Object data) {
        if (first == null)
            return false;

        else {
            if (first.getData().equals(data))
                return removeFirst();

            if (last.getData().equals(data))
                return removeLast();

            else {
                DNode ptr = first.next;
                for (int i = 1; i < count - 1; i++) {
                    if (ptr.getData().equals(data))
                        return remove(i);
                    ptr = ptr.next;
                }
                return false;
            }
        }
    }

    public  String printList() {
        String s="";
        DNode temp = first;
        System.out.print("LinkedList: ");
        do{
            s+=((District)temp.getData()).getNamedis() + " ";
            temp = temp.next;
        }while (temp !=first);
        return s;
    }

    public int getSize() {
        int size=0;
        DNode temp= first;
        if (temp==null){
            return 0;
        }

        do {
            size++;
            temp=temp.next;
        } while(temp != first);
        return size;
    }

    public void insert(Object data) {
        DNode current = new DNode(data);
        if (first==null){
            first=last=current;
            last.next=first;
            first.prev=last;
            count++;
            return;
        }
        DNode temp = first;
        do {
            if (((District) first.getData()).getNamedis().compareToIgnoreCase(((District) data).getNamedis()) > 0){
                current.next=first;
                first.prev=current;
                first=current;
                first.prev=last;
                last.next=first;
                count++;
                return;

            }
            if (((District) temp.next.getData()).getNamedis().compareToIgnoreCase(((District) data).getNamedis()) > 0) {

                break;
            }
            if(temp.next==first){
                temp.next=current;
                current.prev=temp;
                last=current;
                first.prev=last;
                last.next=first;
                count++;
                return;
            }
            temp = temp.next;

        } while (temp != first);
        current.next=temp.next;
        temp.next.prev=current;
        temp.next=current;
        current.prev=temp;
        count++;


    }
    public String maxMartyrDate(District dis){
        SNode ptr=dis.getList().getFirst();
        if (ptr==null){
            return null;
        }
        String max="";
        do {
            SNode cur=((Location)ptr.getData()).getList().getFirst();
            if(cur!=null) {
                do {
//                    if (countmarDate(max, dis) < countmarDate(((Martyr) cur.getData()).getDate(), dis)) {
//                        max = ((Martyr) cur.getData()).getDate();
//                    }
                    cur = cur.next;
                } while (cur != ((Location) ptr.getData()).getList().getFirst());
            }

            ptr=ptr.next;
        }while (ptr!=dis.getList().getFirst());
        return max;
    }
    public int countmarDate(String date,District dis){
        int size=0;
        SNode temp=dis.getList().getFirst();
        if (temp==null){
            return 0;
        }
        do{
            SNode ptr=((Location)temp.getData()).getList().getFirst();
            if(ptr!=null) {
                do {
//                    if (((Martyr) ptr.getData()).getDate().equalsIgnoreCase(date)) {
//                        size++;
//                    }
                    ptr = ptr.next;
                } while (ptr != ((Location) temp.getData()).getList().getFirst());
            }
            temp=temp.next;
        } while (temp!=dis.getList().getFirst());
        return size;
    }

}
