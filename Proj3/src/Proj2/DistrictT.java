package Proj2;

public class DistrictT {
    private String namedis;
    private LocationTree list;
    public DistrictT(String name){
        namedis=name;
        list=new LocationTree();
    }

    public String getNamedis() {
        return namedis;
    }

    public void setNamedis(String namedis) {
        this.namedis = namedis;
    }

    public void setList(LocationTree list) {
        this.list = list;
    }

    public LocationTree getList() {
        return list;
    }
    public int compareTo(Object o) {
        return Integer.parseInt(namedis)-Integer.parseInt(((DistrictT)o).getNamedis());
    }

}
