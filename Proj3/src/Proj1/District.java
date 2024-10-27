package Proj1;

public class District implements Comparable<District>{
    private String namedis;
    private LocationLinkedList list;
    public District(String name){
        namedis=name;
        list=new LocationLinkedList();
    }

    public String getNamedis() {
        return namedis;
    }

    public void setNamedis(String namedis) {
        this.namedis = namedis;
    }

    public LocationLinkedList getList() {
        return list;
    }

    @Override
    public int compareTo(District o) {
        return ((int)(this.getNamedis().indexOf(0)))-((int)(o.getNamedis().indexOf(0)));
    }
}
