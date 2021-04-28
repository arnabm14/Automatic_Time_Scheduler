package atsmanager;

public class Course {
    private int id=0;
    private String code = null;
    private String name = null;
    private int contactSlots = 0;
    private String courseType = null;
    private String resource = null;
    private String association = null;
    Course(int i,String c,String n,int cs,String ct,String r,String a)
    {
        id = i;
        code = c;
        name = n;
        contactSlots = cs;
        courseType = ct;
        resource = r;
        association = a;
    }
    public String getCode(){return code;}
    public String getName(){return name;}
    public int getContactSlots(){return contactSlots;}
    public String getCourseType(){return courseType;}
    public String getResource(){return resource;}
    public String getAssociation(){return association;}
    public int getId(){return id;}
}