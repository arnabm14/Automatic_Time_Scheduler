package atsmanager;

public class TimeSlot {
    private String day= null;
    private int slot = 0;
    private String start = null;
    private String end = null;
    TimeSlot(String d,int s,String st,String en)
    {
        day = d;
        slot = s;
        start = st;
        end = en;
    }
    public String getDay(){return day;}
    public int getSlot(){return slot;}
    public String getStart(){return start;}
    public String getEnd(){return end;}
    
}