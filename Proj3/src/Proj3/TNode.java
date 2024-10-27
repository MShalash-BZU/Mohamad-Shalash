package Proj3;

public class TNode {
	Martyr key;
    int height;
    TNode left, right; 
  
    TNode(Martyr d) {
        key = d; 
    }

    public Martyr getKey() {
        return key;
    }

    public int getHeight() {
        return height;
    }

    public TNode getLeft() {
        return left;
    }

    public void setLeft(TNode left) {
        this.left = left;
    }

    public void setRight(TNode right) {
        this.right = right;
    }

    public TNode getRight() {
        return right;
    }
}
