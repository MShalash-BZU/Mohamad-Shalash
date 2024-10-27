package Proj2;

import Proj3.Martyr;
import Proj1.SNode;

public class MartyrDateTree  {
    private TNode root;

    public TNode getRoot() {
        return root;
    }
    public void setRoot(TNode root) {
        this.root = root;
    }
    public TNode find(Object data) {
        return find( data,this.getRoot());
    }

    public TNode find(Object data,TNode node) {
        if(node==null) {
            return null;
        }
        if (((MartyrDate) node.getData()).getDate() == null || ((MartyrDate) data).getDate() == null) {
            return null;
        }
        if(((MartyrDate)node.getData()).compareTo((((MartyrDate)data).getDate()))==0) {
            return node;
        }
        else if(((MartyrDate)node.getData()).compareTo(((MartyrDate)data).getDate())<0) {
            return find(data, node.getRight());

        }else  {
            return find(data, node.getLeft());

        }


    }

    public void insert(Object data) {
        this.setRoot(insert( data,this.getRoot()));

    }


    public TNode insert(Object data,TNode node) {
        if(node==null) {
            node = new TNode(data);
        }
        if (((MartyrDate)data).getDate().equalsIgnoreCase(((MartyrDate)node.getData()).getDate())){
            return node;
        }

        if(((MartyrDate)node.getData()).compareTo(((MartyrDate)data).getDate())<0 ) {
            node.setRight( insert(data, node.getRight()));

        }else if(((MartyrDate)node.getData()).compareTo(((MartyrDate)data).getDate())>0) {
            node.setLeft( insert(data, node.getLeft()));

        }

        return node;
    }

    public void delete(Object data) {
        this.setRoot(delete(data, this.getRoot()));
    }
    private TNode delete(Object data, TNode node) {
        if(node==null)
            return null;
        if(((MartyrDate)node.getData()).getDate().compareTo(((MartyrDate) data).getDate())<0)
            node.setRight(delete(data, node.getRight()));
        else if(((MartyrDate)node.getData()).compareTo(((MartyrDate) data).getDate())>0)
            node.setLeft(delete(data, node.getLeft()));
        else if(node.getRight()==null && node.getLeft()==null)
            node=null;
        else if(node.getLeft()==null)
            node=node.getRight();
        else if(node.getRight()==null)
            node=node.getLeft();
        else
            deleteNodeWithTwoChildren(node);
        return node;
    }
    private void deleteNodeWithTwoChildren(TNode node) {
        TNode suc = getMin(node.getRight());
        node.setData(suc.getData());
        delete(suc.getData(), node.getRight());
    }
    protected TNode getMin(TNode node) {
        if (node == null) {
            return null;
        }
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }
    public TNode getMax(TNode node){
        if (node.getRight()==null){
            return node;
        }
        return getMax(node.getRight());
    }
    public String LatestDate() {
        String s="0/0/0000";
        s= LatestD(getRoot(), s );
        return s;

    }
    private String LatestD(TNode node, String max) {
        if (node == null) {
            return max;
        }
        max= LatestD(node.getLeft(), max);
        if(((MartyrDate)node.getData()).compareTo(max)>0){
            max=((MartyrDate)node.getData()).getDate();
        }
        max= LatestD(node.getRight(), max);
        return max;
    }
    public String MaxDateMartyr() {
        String s="";
        int count=0;
        s= MaxDateMar(getRoot(), s ,count);
        return s;

    }
    private String MaxDateMar(TNode node, String max,int count) {
        if (node == null) {
            return max;
        }
        max= MaxDateMar(node.getLeft(), max,count);
        if(((MartyrDate)node.getData()).getMar().getSize()>count){
            count=((MartyrDate)node.getData()).getMar().getSize();
            max=((MartyrDate)node.getData()).getDate();
        }
        max= MaxDateMar(node.getRight(), max,count);
        return max;
    }


    public void traverseInOrder() {
        traverseInOrder(this.getRoot());
    }
    private void traverseInOrder(TNode node) {
        if(node==null) return;
        traverseInOrder(node.getLeft());
        System.out.println(node.getData());
        traverseInOrder(node.getRight());
    }
    public int countMar() {
        return countMar(this.getRoot());
    }
    private int countMar(TNode node) {
        if(node==null)
            return 0;
        int c=countMar(node.getLeft());
        c+=((MartyrDate)node.getData()).getMar().getSize();
        c+=countMar(node.getRight());
        return c;
    }

    public int getDepth(TNode node) {
        if(node==null) return 0;
        return Math.max(1+getDepth(node.getLeft()), 1+getDepth(node.getRight()));
    }

    public int size(TNode node) {
        if(node==null) return 0;
        return 1+size(node.getLeft())+size(node.getRight());
    }

    public boolean checkBalance(TNode node) {
        if(node==null) return true;
        int balance = getRightDepth(node.getRight())-getLeftDepth(node.getLeft());
        if(balance<-1 || balance>1) return false;
        return checkBalance(node.getLeft()) && checkBalance(node.getRight());
    }
    private int getRightDepth(TNode node) {
        if(node==null) return 0;
        return Math.max(1+getDepth(node.getLeft()), 1+getDepth(node.getRight()));
    }
    private int getLeftDepth(TNode node) {
        if(node==null) return 0;
        return Math.max(1+getDepth(node.getLeft()), 1+getDepth(node.getRight()));
    }
    public Martyr[] listMar(String date){
        Martyr []mar=new Martyr[((MartyrDate)find(new MartyrDate(date)).getData()).getMar().getSize()];
        SNode temp=((MartyrDate)find(new MartyrDate(date)).getData()).getMar().getFirst();
        int i=0;
        do{
            mar[i]=(Martyr)temp.getData();
            i++;
        }while (temp!=((MartyrDate)find(new MartyrDate(date)).getData()).getMar().getFirst());
        return mar;
    }

    public boolean checkFull() {
        return this.size(this.getRoot())==Math.pow(2, this.getDepth(this.getRoot()));
    }

    public int countLeafs(TNode node) {
        if(node==null) return 0;
        if(node.getLeft()==null && node.getRight()==null) return 1;
        return countLeafs(node.getLeft())+countLeafs(node.getRight());
    }

}
