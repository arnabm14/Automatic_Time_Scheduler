/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atsmanager;
import java.io.*;
import java.util.*;

/**
 *
 * @author Debargha Das & Arnab Mondal
 */
public class DataManager {
        
	
	
	ArrayList<TimeSlot> readTimeslots(String filename){
            ArrayList<TimeSlot> t=new ArrayList<TimeSlot>();
            try{
		FileReader fr=new FileReader(filename);
		BufferedReader br=new BufferedReader(fr);
		String line=br.readLine();
		while((line=br.readLine())!=null){
			String ar[]=line.split(",");
                        t.add(new TimeSlot(ar[0],Integer.parseInt(ar[1]),ar[2],ar[3]));
		}
                
                }
		catch(FileNotFoundException exception){
                System.out.println(" File Not found. Please Check again : " +exception.getMessage());
                }
		catch(IOException e){
		System.out.println(" IOException Occured : " +e.getMessage());

		}
	return t;	
	}
	ArrayList<Course> readCourses(String filename){
            ArrayList<Course> c=new ArrayList<Course>();
            try{
		FileReader fr=new FileReader(filename);
		BufferedReader br=new BufferedReader(fr);
		
		String line=br.readLine();
                int i = -1;
		while((line=br.readLine())!=null){
                    //System.out.println(i);
                    i++;
			String ar[]=line.split(",");
                        try{
			c.add(new Course(i,ar[0],ar[1],Integer.parseInt(ar[2]),ar[3],ar[4],ar[5]));
                        }
                        catch(ArrayIndexOutOfBoundsException a){
                            c.add(new Course(i,ar[0],ar[1],Integer.parseInt(ar[2]),ar[3],ar[4],""));
                        }
		}
                }
		catch(FileNotFoundException exception){
                System.out.println(" File Not found. Please Check again : " +exception.getMessage());
                }
		catch(IOException e){
		System.out.println(" IOException Occured : " +e.getMessage());
		}
	return c;	
	}
	ArrayList<Instructor> readInstructor(String filename){
            ArrayList<Instructor> i=new ArrayList<Instructor>();
            try{
		FileReader fr=new FileReader(filename);
		BufferedReader br=new BufferedReader(fr);
		
		String line=br.readLine();
                int id = 0;
		while((line=br.readLine())!=null){
			String ar[]=line.split(",");
                        if (ar.length==5)
                            i.add(new Instructor(id++,ar[0],ar[1],ar[2],ar[3],ar[4]));
                        else if(ar.length==4)
                            i.add(new Instructor(id++,ar[0],ar[1],ar[2],ar[3],""));
                        else if(ar.length==3)
                            i.add(new Instructor(id++,ar[0],ar[1],ar[2],"",""));
                        else if(ar.length==2)
                            i.add(new Instructor(id++,ar[0],ar[1],"","",""));
                        else
                            i.add(new Instructor(id++,ar[0],"","","",""));
			
                }
            }
		catch(FileNotFoundException exception){
                System.out.println(" File Not found. Please Check again : " +exception.getMessage());
                }
		catch(IOException e){
		System.out.println(" IOException Occured : " +e.getMessage());
		}
            return i;
	}
	ArrayList<Section> readSections(String filename){
            ArrayList<Section> s=new ArrayList<Section>();
		try{
		FileReader fr=new FileReader(filename);
		BufferedReader br=new BufferedReader(fr);
		int id = 0;
		String line=br.readLine();
		while((line=br.readLine())!=null){
			String ar[]=line.split(",");
                        s.add(new Section(id++,Integer.parseInt(ar[0]),ar[1],ar[2],Integer.parseInt(ar[3])));
			
		}
                }
		catch(FileNotFoundException exception){
                System.out.println(" File Not found. Please Check again : " +exception.getMessage());
                }
		catch(IOException e){
		System.out.println(" IOException Occured : " +e.getMessage());
		}
        return s;
	}
	ArrayList<Room> readRooms(String filename){
            ArrayList<Room> r=new ArrayList<Room>();
            try{
		FileReader fr=new FileReader(filename);
		BufferedReader br=new BufferedReader(fr);
		int id = 0;
		String line=br.readLine();
		while((line=br.readLine())!=null){
			String ar[]=line.split(",");
                        r.add(new Room(id++,ar[0],ar[1],Integer.parseInt(ar[2])));
			
		}
                }
		catch(FileNotFoundException exception){
                System.out.println(" File Not found. Please Check again : " +exception.getMessage());
                }
		catch(IOException e){
		System.out.println(" IOException Occured : " +e.getMessage());
		}
	return r;	
	}

    public DataManager(ATSManager Mgr) {
        Mgr.timeslots = readTimeslots(Mgr.filenames[4]);
        Mgr.courses = readCourses(Mgr.filenames[0]);
        Mgr.sections =readSections(Mgr.filenames[2]);
        Mgr.rooms = readRooms(Mgr.filenames[1]);       
        Mgr.instructors = readInstructor(Mgr.filenames[3]);
    }

    
}
