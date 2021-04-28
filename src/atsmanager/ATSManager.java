/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atsmanager;
import java.util.*;
import java.lang.String;
/**
 *
 * @author Papan
 */
public class ATSManager{
    public static final int HRS = 15;////////// can't figure out a proper value for this default hours per teacher //////
    DataManager dataMgr;
    LogicManager logicMgr;
    DisplayManager displayMgr;
    public String filenames[]=new String[5];
    public int flag=0;
    ArrayList<TimeSlot> timeslots;
    ArrayList<Course> courses;
    ArrayList<Section> sections;
    ArrayList<Room> rooms;
    ArrayList<Instructor> instructors;
    Period[] timetable;
    public static void main(String[] args) {
        
        ATSManager myMgr = new ATSManager();
        
        // create all managers
        myMgr.displayMgr = new DisplayManager(myMgr);        

        // initialise data
        
        // generate timetable
//        myMgr.logicMgr=new LogicManager(myMgr.timeslots,myMgr.courses,myMgr.sections,myMgr.rooms,myMgr.instructors);
       // myMgr.logicMgr.generate();
        myMgr.displayMgr.showPage1();
       // while(myMgr.flag==0);
        //myMgr.displayMgr.showPage2();
    }
}
