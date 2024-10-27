package Proj2;

public class LocationT {
    private String name;
    private MartyrDateTree list;
    public LocationT(String name){
        this.name=name;
        list=new MartyrDateTree();
    }

    public String getName() {
        return name;
    }

    public MartyrDateTree getList() {
        return list;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setList(MartyrDateTree list) {
        this.list = list;
    }

    public int compareTo(Object o) {
        return Integer.parseInt(name)-Integer.parseInt(((LocationT)o).getName());
    }

}
