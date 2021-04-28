package atsmanager;

public class Room {
    private int Id=0;
    private String resources = null;
    private String type = null;
    private int capacity = 0;
    Room(int id,String r,String t,int c)
    {
        Id =id;
        resources = r;
        type =t;
        capacity = c;
    }
    public int getId(){return Id;}
    public String getResources(){return resources;}
    public String getType(){return type;}
    public int getCapacity(){return capacity;}
    
}