package Proj3;

public class Martyr implements Comparable<Martyr> {
    //(Name, Date, Age, location, District, and Gender
    private String name,age,gender,district,location;


    public Martyr(String name,String district,String location, String age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.location=location;
        this.district=district;
    }

    public String getDistrict() {
        return district;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }



    public void setDistrict(String district) {
		this.district = district;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    @Override
    public int compareTo(Martyr o) {
        if(!this.district.equalsIgnoreCase(o.district)) return this.district.compareToIgnoreCase(o.district);
        return this.name.compareToIgnoreCase(o.name);
    }

    //@Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Martyr martyr)) return false;
//        return getName().equalsIgnoreCase(martyr.getName()) ;
//    }

}
