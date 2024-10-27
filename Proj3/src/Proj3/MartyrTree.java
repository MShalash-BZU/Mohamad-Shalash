package Proj3;

import java.util.ArrayList;



public class MartyrTree {
	TNode root; 
    int height(TNode N) { 
        if (N == null) 
            return 0; 
  
        return N.height; 
    } 
  
    int max(int a, int b) { 
        return (a > b) ? a : b; 
    } 
  
    TNode rightRotate(TNode y) { 
        TNode x = y.left; 
        TNode T2 = x.right; 
 
        x.right = y; 
        y.left = T2; 
  
        y.height = max(height(y.left), height(y.right)) + 1; 
        x.height = max(height(x.left), height(x.right)) + 1; 
   
        return x; 
    } 
   
    TNode leftRotate(TNode x) { 
        TNode y = x.right; 
        TNode T2 = y.left; 
  
        y.left = x; 
        x.right = T2; 
  
        x.height = max(height(x.left), height(x.right)) + 1; 
        y.height = max(height(y.left), height(y.right)) + 1; 
  
        return y; 
    }

    public TNode getRoot() {
        return root;
    }

    int getBalance(TNode N) {
        if (N == null) 
            return 0; 
  
        return height(N.left) - height(N.right); 
    }
    public TNode find(Martyr data) {
        return find( data,this.getRoot());
    }

    public TNode find(Martyr data, TNode node) {
        if(node==null) {
            return null;
        }

        if((node.getKey()).compareTo(data)==0) {
            return node;
        }
        else if(node.getKey().compareTo(data)<0) {
            return find(data, node.getRight());

        }else  {
            return find(data, node.getLeft());

        }


    }

    public void setRoot(TNode root) {
        this.root = root;
    }

    public void insert(Martyr data) {
        this.setRoot(insert( this.getRoot(),data));

    }
  
    TNode insert(TNode node, Martyr key) {
  
        if (node == null) 
            return (new TNode(key)); 
  
        if (key.compareTo(node.key) <0)
            node.left = insert(node.left, key); 
        else if (key.compareTo(node.key) >0)
            node.right = insert(node.right, key); 
        else 
            return node; 
  
        node.height = 1 + max(height(node.left), 
                              height(node.right)); 
  
        int balance = getBalance(node); 
  
        if (balance > 1 && key.compareTo(node.left.key) < 0)
            return rightRotate(node); 
  
        if (balance < -1 && key.compareTo(node.right.key) > 0)
            return leftRotate(node); 
  
        if (balance > 1 && key.compareTo(node.left.key) > 0) {
            node.left = leftRotate(node.left); 
            return rightRotate(node); 
        } 
  
        if (balance < -1 && key.compareTo(node.right.key) < 0) {
            node.right = rightRotate(node.right); 
            return leftRotate(node); 
        } 
  
        return node; 
    } 
    TNode minValueNode(TNode node) 
    { 
        TNode current = node; 
        while (current.left != null) 
        current = current.left; 
 
        return current; 
    }
    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(TNode node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight()));
    }
    public void delete(Martyr data) {
        this.setRoot(deleteNode( this.getRoot(),data));

    }

    TNode deleteNode(TNode root, Martyr key)
    { 
        if (root == null) 
            return root; 
 
        if (key.compareTo(root.key) <0)
            root.left = deleteNode(root.left, key); 
 
        else if (key.compareTo(root.key) >0)
            root.right = deleteNode(root.right, key); 
 
        else
        { 
 
            if ((root.left == null) || (root.right == null)) 
            { 
                TNode temp = null; 
                if (temp == root.left) 
                    temp = root.right; 
                else
                    temp = root.left; 
 
                if (temp == null) 
                { 
                    temp = root; 
                    root = null; 
                } 
                else  
                    root = temp; 
            } 
            else
            { 
 
                TNode temp = minValueNode(root.right); 
  
                root.key = temp.key; 
 
                root.right = deleteNode(root.right, temp.key); 
            } 
        }  
        if (root == null) 
            return root; 
 
        root.height = max(height(root.left), height(root.right)) + 1; 
 
        int balance = getBalance(root); 
 
        if (balance > 1 && getBalance(root.left) >= 0) 
            return rightRotate(root); 
 
        if (balance > 1 && getBalance(root.left) < 0) 
        { 
            root.left = leftRotate(root.left); 
            return rightRotate(root); 
        } 
 
        if (balance < -1 && getBalance(root.right) <= 0) 
            return leftRotate(root);
        if (balance < -1 && getBalance(root.right) > 0) 
        { 
            root.right = rightRotate(root.right); 
            return leftRotate(root); 
        } 
 
        return root; 
    }
    public int countMarloc(String loc) {
        return countMarloc(root, loc);
    }

    private int countMarloc(TNode node, String loc) {
        if (node == null) {
            return 0;
        }
        int count = 0;
        if (node.getKey().getLocation().equalsIgnoreCase(loc)) {
            count = 1;
        }
        return count + countMarloc(node.left, loc) + countMarloc(node.right, loc);
    }
    public String Maxloc(){
        String s="";
        s=Maxloc(this.getRoot(),s);
        return s;
    }
    private String Maxloc(TNode node,String s){
        if(node==null){
            return s;
        }
        s= Maxloc(node.getLeft(),s);
        if (countMarloc(node.getKey().getLocation())>countMarloc(s)){
            s=node.getKey().getLocation();
        }
        s= Maxloc(node.getRight(),s);
        return s;
    }
    public int countMarDis(String district) {
        return countMarDis(root, district);
    }

    private int countMarDis(TNode node, String district) {
        if (node == null) {
            return 0;
        }
        int count = 0;
        if (node.getKey().getDistrict().equalsIgnoreCase(district)) {
            count = 1;
        }
        return count + countMarDis(node.left, district) + countMarDis(node.right, district);
    }
    public String Maxdis(){
        String s="";
        s=Maxdis(this.getRoot(),s);
        return s;
    }
    private String Maxdis(TNode node,String s){
        if(node==null){
            return s;
        }
        s= Maxdis(node.getLeft(),s);
        if (countMarDis(node.getKey().getDistrict())>countMarDis(s)){
            s=node.getKey().getDistrict();
        }
        s= Maxdis(node.getRight(),s);
        return s;
    }

    public int countMar() {
        return countMar(this.getRoot());
    }
    private int countMar(TNode node) {
        if(node==null)
            return 0;
        return 1 + countMar(node.left) + countMar(node.right);
    }
    public ArrayList<String> Discomb() {
        ArrayList<String> sDis = new ArrayList<>();
        Discomb(this.getRoot(), sDis);
        return sDis;
    }
    private void Discomb(TNode node, ArrayList<String> sDis) {
        if (node == null) {
            return;
        }
        Discomb(node.getLeft(), sDis);
        if(!sDis.contains(node.getKey().getDistrict())) {
            sDis.add(node.getKey().getDistrict());
        }
        Discomb(node.getRight(), sDis);
    }
    public ArrayList<Martyr> levelOrdermartyr() {
        ArrayList<Martyr> martyrs=new ArrayList<>();
        if (root == null)
            return martyrs;

        Queue q =new Queue();

        q.enQueue(this.getRoot());

        while (!q.isEmpty()) {

            TNode curr = q.deQueue();
            if (curr.getRight() != null)
                q.enQueue(curr.getRight());

            if (curr.getLeft() != null)
                q.enQueue(curr.getLeft());

            martyrs.add(curr.getKey());
        }
        return martyrs;
    }
    private int size;
    private Martyr [] martyrs;
    private Martyr[] martyrList(){
        ArrayList<Martyr> list1=levelOrdermartyr();
        Martyr [] marlist=new Martyr[list1.size()];
        for(int i=0;i<list1.size();i++){
            marlist[i]=list1.get(i);
        }
        return marlist;
    }
    private void minHeapify(int i) {
        int largest = i;
        int l = i*2+1;
        int r = i*2+2;
        if(l<size && Integer.parseInt(martyrs[l].getAge()) >Integer.parseInt(martyrs[largest].getAge())) {
            largest = l;
        }
        if(r<size && Integer.parseInt(martyrs[r].getAge()) >Integer.parseInt(martyrs[largest].getAge()))
            largest = r;
        if(largest!=i) {
            swap(i, largest);
            minHeapify(largest);
        }
    }

    private void swap(int parent, int i) {
        Martyr x = martyrs[parent];
        martyrs[parent] = martyrs[i];
        martyrs[i] = x;
    }
    public Martyr[] heapSort() {
        martyrs = martyrList();
        size = martyrs.length;

        for (int i = size / 2 - 1; i >= 0; i--) {
            minHeapify(i);
        }
        for (int i = size - 1; i > 0; i--) {
            swap(0, i);
            size--;
            minHeapify(0);
        }
        size = martyrs.length;

        return martyrs;
    }
    public double countAge(){
        martyrs=martyrList();
        int count=0;
        for (int i = 0; i < martyrs.length; i++) {
            if (martyrs[i].getAge().equalsIgnoreCase("n/a")){
                continue;
            }
            count+=Integer.parseInt(martyrs[i].getAge());
        }
        if(martyrs.length==0) {
        
        return 0;
        }else {
        	return count/martyrs.length;
        }
    }
  
    void preOrder(TNode node) { 
        if (node != null) { 
            System.out.print(node.key + " "); 
            preOrder(node.left); 
            preOrder(node.right); 
        } 
    } 
}