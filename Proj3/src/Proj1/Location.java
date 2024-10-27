package Proj1;

public class Location implements Comparable<Location> {
    private String name;
    private MartyrLinkedList list;
    public Location(String name){
        this.name=name;
        list=new MartyrLinkedList();
    }

    public String getName() {
        return name;
    }

    public MartyrLinkedList getList() {
        return list;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Location o) {
        return ((int)(this.getName().indexOf(0)))-((int)(o.getName().indexOf(0)));
    }
}
