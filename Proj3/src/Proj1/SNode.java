package Proj1;

public class SNode {
    SNode next;
    Object data;
    public SNode(Object data) {
        super();
        this.data = data;
    }
    public SNode getNext() {
        return next;
    }
    public void setNext(SNode next) {
        this.next = next;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    @Override
    public String toString() {
        return "SNode [next=" + next + ", data=" + data + "]";
    }

}
