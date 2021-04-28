package atsmanager;

public class Period {
    private int id;
    private Instructor instructor;
    private Course course;
    private TimeSlot timeslot;
    private Section section;
    private Room room;
    Period(int i,Instructor in,Course c,TimeSlot t,Section s,Room r)
    {
        id = i;
        instructor  = in;
        course = c;
        timeslot  =t;
        section = s;
        room = r;
    }
    public void setID(int i){id = i;}
    public void setInstructor(Instructor in){instructor = in;}
    public void setCourse(Course c){course = c;}
    public void setTimeslot(TimeSlot t){timeslot = t;}
    public void setSection(Section s){section =s;}
    public void setRoom(Room r){room =r;}
    public int getID(int i){return i;}
    public Instructor getInstructor(){return this.instructor;}
    public Course getCourse(){return this.course;}
    public TimeSlot getTimeslot(){return this.timeslot;}
    public Section getSection(){return this.section;}
    public Room getRoom(){return this.room;}
    public String getString(){
        return "("+course.getCode()+" "+instructor.getName()+" "+course.getCourseType()+" "+timeslot.getDay()+" "+timeslot.getSlot()+" "+section.getLabSection()+" "+room.getResources()+")";
        
    }
   
}