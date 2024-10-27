package Proj2;

import Proj1.Queue;
import Proj2.TNode;
import javafx.css.Size;

public class DistrictTree  {
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
        if (((DistrictT) node.getData()).getNamedis() == null || ((DistrictT) data).getNamedis() == null) {
            return null;
        }

        if(((DistrictT)node.getData()).getNamedis().equalsIgnoreCase(((DistrictT)data).getNamedis())) {
            return node;
        }
        else if(((DistrictT)node.getData()).getNamedis().compareToIgnoreCase(((DistrictT)data).getNamedis())<0) {
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
        if (((DistrictT)data).getNamedis().equalsIgnoreCase(((DistrictT)node.getData()).getNamedis())){
            return node;
        }

        if(((DistrictT)node.getData()).getNamedis().compareToIgnoreCase(((DistrictT)data).getNamedis())<0 ) {
            node.setRight( insert(data, node.getRight()));

        }else if(((DistrictT)node.getData()).getNamedis().compareToIgnoreCase(((DistrictT)data).getNamedis())>0) {
            node.setLeft( insert(data, node.getLeft()));

        }

        return node;
    }



    public void delete(Object data) {
        this.setRoot( delete(data, this.getRoot()));
    }


    public TNode delete(Object data, TNode node) {
        if (node == null) {
            return null;
        }

        if (((DistrictT)data).getNamedis().compareToIgnoreCase(((DistrictT)node.getData()).getNamedis()) < 0) {
            node.setLeft( delete(data, node.getLeft()));
        } else if (((DistrictT)data).getNamedis().compareToIgnoreCase(((DistrictT)node.getData()).getNamedis()) > 0) {
            node.setRight( delete(data, node.getRight()));
        } else {
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getRight();
            } else {
                TNode successor = getMin(node.getRight());
                node.setData(successor.getData());
                node.setRight(delete(successor.getData(), node.getRight()));
            }
        }

        return node;
    }
    private void deleteNodeWithTwoChildren(TNode node) {
        TNode suc = getMin(node.getRight());
        node.setData(suc.getData());
        delete(suc.getData(), node.getRight());
    }
    private TNode getMin(TNode node) {
        if(node.getLeft()==null) return node;
        return getMin(node.getLeft());
    }

    public void traverseInOrder() {
        traverseInOrder(this.getRoot());
    }
    private void traverseInOrder(TNode node) {
        if(node==null) return;
        traverseInOrder(node.getLeft());
        System.out.println(((DistrictT)node.getData()).getNamedis());
        traverseInOrder(node.getRight());
    }
    public String[] cboxDis() {
        String[] s = new String[size()];
        cboxDis(this.getRoot(), s, 0);
        return s;
    }

    private int cboxDis(TNode node, String[] s, int i) {
        if (node == null) {
            return i;
        }

        i = cboxDis(node.getLeft(), s, i);
        s[i] = (((DistrictT) node.getData()).getNamedis());
        i++;
        return cboxDis(node.getRight(), s, i);
    }

    public int getDepth(TNode node) {
        if(node==null) return 0;
        return Math.max(1+getDepth(node.getLeft()), 1+getDepth(node.getRight()));
    }
    int size() { return size(this.getRoot()); }


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

    public boolean checkFull() {
        return this.size(this.getRoot())==Math.pow(2, this.getDepth(this.getRoot()));
    }

    public int countLeafs(TNode node) {
        if(node==null) return 0;
        if(node.getLeft()==null && node.getRight()==null) return 1;
        return countLeafs(node.getLeft())+countLeafs(node.getRight());
    }

}
