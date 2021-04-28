package atsmanager;

public class Section {
    private int Id = 0;
    private int year = 0;
    private String section = null;
    private String labSection = null;
    private int enrollment = 0;
    Section(int id,int y,String s,String ls,int e)
    {
        Id= id;
        year = y;
        section = s;
        enrollment = e;
        labSection = ls;
    }
    public int getId(){return Id;}
    public int getYear(){return year;}
    public String getSection(){return section;}
    public String getLabSection(){ return labSection;}
    public int getEnrollment(){return enrollment;}
    
    
}
