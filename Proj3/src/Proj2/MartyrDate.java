package Proj2;

import Proj1.MartyrLinkedList;

import java.time.LocalDate;

public class MartyrDate {
    private String date;
    private MartyrLinkedList mar;
    public MartyrDate(String  date){
        this.date=date;
        mar=new MartyrLinkedList();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public MartyrLinkedList getMar() {
        return mar;
    }

    public void setMar(MartyrLinkedList mar) {
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
}
