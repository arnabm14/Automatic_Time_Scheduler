package atsmanager;

public class Instructor {
    private String name = null;
    private int id;
    private String expertise1 = null;
    private String expertise2 = null;
    private String expertise3 = null;
    private String expertise4 = null;
    Instructor(int i,String n,String e1,String e2,String e3,String e4)
    {
        id = i;
        name=n;
        expertise1 = e1;
        expertise2 = e2;
        expertise3 = e3;
        expertise4 = e4;
    }
    public String getName(){return name;}
    public int getId(){return id;}
    public String getExpertise1(){return expertise1;}
    public String getExpertise2(){return expertise2;}
    public String getExpertise3(){return expertise3;}
    public String getExpertise4(){return expertise4;}
}