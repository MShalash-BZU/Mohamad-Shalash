package Proj3;

import java.util.Objects;

import Proj1.MartyrLinkedList;

public class Date {
    private String date;
    private MartyrTree mar;
    public Date(String  date){
        this.date=date;
        mar=new MartyrTree();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public MartyrTree getMar() {
        return mar;
    }

    public void setMar(MartyrTree mar) {
        this.mar = mar;
    }
    public int compareTo(String d) {
        String[] Date1 = this.date.split("/");
        String[] Date2 = d.split("/");

        int year = Integer.parseInt(Date1[2]);
        int year2 = Integer.parseInt(Date2[2]);
        if (year != year2) {

            return Integer.compare(year, year2);
        }
        int mounth = Integer.parseInt(Date1[0]);
        int mounth2 = Integer.parseInt(Date2[0]);
        if (mounth != mounth2) {
            return Integer.compare(mounth, mounth2);
        }
        int day = Integer.parseInt(Date1[1]);
        int day2 = Integer.parseInt(Date2[1]);
        return Integer.compare(day, day2);
    }

	
	public int hashCode(String date) {
		int s=0;
		for(int i=0;i<date.length();i++) {
			s+=(int)date.charAt(i)*(int)Math.pow(31, i);
		}
		return s;
	}

	
}
