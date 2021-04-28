/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atsmanager;
import java.util.*;
import java.io.*;
import java.lang.*;
/**
 *
 * @author Papan
 */
public class LogicManager {
    LogicManager(){}
    ArrayList<TimeSlot> timeslots;
    ArrayList<Section> sections;
    ArrayList<Course> courses;
    ArrayList<Room> rooms;
    ArrayList<Instructor> instructors;
    int LAT[];
    String courseTypeTable[];
    int HAT[];
    int PAT[][];
    int CAT[][];
    float pq[];
    Period Timetable[];
    ArrayList<int[]> batches;
    int dtr[][][]=new int[5][7][30];
    int dti[][][]=new int[5][7][30];
    int dts[][][]=new int [5][7][30];
    int schedule[][]=new int[200][3];
    int sdl[][][] = new int[100][100][300];
    
    ArrayList<int[]> temporary = new ArrayList();
    ArrayList<Period>[] instructorwise = new ArrayList[30];
    ArrayList<Period>[] sectionwise = new ArrayList[30];
    ArrayList<Period>[] roomwise = new ArrayList[30];
    boolean done = false;
    public void generate()
    {
        int success = generateCAT(instructors,courses);
        System.out.println("--------CAT--------");
        for(int p=0;p<instructors.size();p++)
        {
            for(int q=0;q<courses.size();q++)
                System.out.print(CAT[p][q]+" ");
            System.out.print("\n");
        }
        if(success == -1)
            System.out.println("not feasible");
        else System.out.println("success");
        
        if(success == 1)
        {//System.out.print(batches.size());
            createLAT(courses);
            generateBatch();
            /*for(int i=0;i<batches.size();i++)
            {
                System.out.println(i+" "+batches.get(i)[0]+" "+batches.get(i)[1]+" "+batches.get(i)[2]);
            }*/
            done = generateRoutine();
            if(done == false)
            System.out.println("not feasible");
            else{
            System.out.println("-----------final schedule-----------");
            /*for(int i=0;i<153;i++)
            {
                System.out.println("class number "+i+" instructor "+batches.get(i)[0]+" course "+batches.get(i)[1]+
                        " group "+batches.get(i)[2]+" day "+schedule[i][0]+" time "+schedule[i][1]+" room "+ schedule[i][2]);
            }*/
            
            
        }
        }
    }
    public Period[] generatePeriods()
    {
        Period periods[] = new Period[batches.size()];
        System.out.println(batches.size());
        if(done == true)
        {
            for(int i=0;i<batches.size();i++)
            {
                Instructor ins = instructors.get(batches.get(i)[0]);
                Course crs = courses.get(batches.get(i)[1]);
                Room rm = rooms.get(schedule[i][2]);
                TimeSlot ts = timeslots.get(schedule[i][0]*7+schedule[i][1]);
                Section sc = sections.get(batches.get(i)[2]);
                int id = i;
                periods[i]=new Period(id,ins,crs,ts,sc,rm);
                //System.out.println(periods[i].getString());
            }
        }
        System.out.println("Done");
        //Arrays.sort(periods);
        /*for(int i=0;i<periods.length;i++)
        {
            System.out.println(i+" "+periods[i].getString());
        }*/
        for(int i=0;i<batches.size();i++)
            {
                for(int j=i+1;j<batches.size();j++)
                {
                    if(periods[i].getTimeslot().getDay()==periods[j].getTimeslot().getDay()&&periods[i].getTimeslot().getSlot()==periods[j].getTimeslot().getSlot()&&periods[i].getSection().getId()==periods[j].getSection().getId())
                        System.out.println(i+" "+j);
                }
            }
        //System.out.println("hey");
        Timetable = periods;
        return periods;
    }
    public boolean generateRoutine()
    {
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<7;j++)
            {
                for(int k=0;k<30;k++){
                    dtr[i][j][k]=-1;
                    dti[i][j][k]=-1;
                    dts[i][j][k]=-1;
                }
            }
        }
        int j=batches.size();
        for(int i=0;i<batches.size();i++)
        {
            //System.out.println(i);
            int ins = batches.get(i)[0];
            int crs = batches.get(i)[1];
            int grp = batches.get(i)[2];
            int f = 0;
            if(courseTypeTable[crs].equals("Lab"))
            {
                int x,y;
                if(crs==5)
                {
                    x=11;
                    y=11;
                }
                else if(crs==9)
                {
                    x=12;
                    y=12;
                }
                else 
                {
                    x=7;
                    y=10;
                }
                for(int p=0;p<=4;p++)
                {
                    for(int q=x;q<=y;q++)
                    {
                        if(dtr[p][4][q]==-1&&dti[p][4][ins]==-1&&dts[p][4][grp]==-1)
                        {
                            dtr[p][4][q]=i;
                            dtr[p][5][q]=i;
                            dtr[p][6][q]=i;
                            dti[p][4][ins]=1;
                            dti[p][5][ins]=1;
                            dti[p][6][ins]=1;
                            //sdl[grp][p][crs]=1;
                            f=1;
                            //System.out.println(i+" "+p+" "+q);
                            schedule[i][0]=p;
                            schedule[i][1]=4;
                            schedule[i][2]=q;
                            dts[p][4][grp]=1;
                            dts[p][5][grp]=1;
                            dts[p][6][grp]=1;
                            if(f==1)
                               break;
                        }
                    }
                    if(f==1)
                        break;
                }
                if(f==0)
                {
                    for(int p=0;p<=4;p++)
                    {
                        for(int q=y;q>=x;q--)
                        {
                            if(dtr[p][1][q]==-1&&dti[p][1][ins]==-1&&dts[p][1][grp]==-1)
                            {
                                dtr[p][1][q]=i;
                                dtr[p][2][q]=i;
                                dtr[p][3][q]=i;
                                dti[p][1][ins]=1;
                                dti[p][2][ins]=1;
                                dti[p][3][ins]=1; 
                                dts[p][1][grp]=1;
                                dts[p][2][grp]=1;
                                dts[p][3][grp]=1;
                                f=1;
                                //System.out.println(i+" "+q);
                                schedule[i][0]=p;
                            schedule[i][1]=1;
                            schedule[i][2]=q;
                                if(f==1)
                                break;
                            }
                        }
                        if(f==1)
                            break;
                    }
                    /*for(int p=0;p<=4;p++)
                    {
                        for(int q=y;q>=x;q--)
                        {
                            if(dtr[p][1][q]==-1&&dti[p][1][ins]==-1&&dts[p][1][grp+1]==-1)
                            {
                                dtr[p][1][q]=i;
                                dtr[p][2][q]=i;
                                dtr[p][3][q]=i;
                                dti[p][1][ins]=1;
                                dti[p][2][ins]=1;
                                dti[p][3][ins]=1; 
                                dts[p][1][grp]=1;
                                dts[p][2][grp]=1;
                                dts[p][3][grp]=1;
                                f=1;
                                //System.out.println(i+" "+q);
                                schedule[j][0]=p;
                            schedule[j][1]=1;
                            schedule[j][2]=q;
                                if(f==1)
                                break;
                            }
                        }
                        if(f==1)
                            break;
                    }*/
                    //j++;
                }
                
            }
            
        }
        /*for(int i=0;i<5;i++)
        {
            for(int j=0;j<7;j++)
            {
                int x[] = new int[2];
                x[0]=i;
                x[1]=j;
                temporary.add(x);
                
            }
            
        }*/
        //Collections.shuffle(batches);
        for(int i=0;i<batches.size();i++)
        {
            //System.out.println(i);
            int ins = batches.get(i)[0];
            int crs = batches.get(i)[1];
            int grp = batches.get(i)[2];
            int f=0;
            if(courseTypeTable[crs].equals("Lecture")){
            //int r=grp/2;
            
            for(int r=0;r<6;r++)
            {
                for(int p=4;p>=0;p--)
                {
                    for(int q=6;q>=0;q--){
                    if(dtr[p][q][r]==-1&&dti[p][q][ins]==-1&&dts[p][q][grp]==-1&&dts[p][q][grp+1]==-1)
                    {            
                        dtr[p][q][r]=i;
                        //System.out.println(i+" "+p+" "+q+" "+r);
                        schedule[i][0]=p;
                        schedule[i][1]=q;
                        schedule[i][2]=r;
                        dti[p][q][ins]=1;
                        dts[p][q][grp]=1;
                        dts[p][q][grp+1]=1;
                        f=1;
               // for(int l=0;l<35;l++)
                 //   System.out.println(temporary.get(l)[0]+" "+temporary.get(l)[1]);
                    //}
                    }
                    if(f==1)
                        break;
                    }
                    if(f==1)
                        break;
                }
                if(f==1)
                    break;
            }
            if(f==0){
                int arr[] = new int[3];
                arr[0]=ins;
                arr[1]=crs;
                arr[2]=grp+1;
                
                for(int r=0;r<6;r++)
                {
                    for(int p=4;p>=0;p--)
                    {
                        for(int q=6;q>=0;q--){
                        if(dtr[p][q][r]==-1&&dti[p][q][ins]==-1&&dts[p][q][grp]==-1)
                        {            
                            dtr[p][q][r]=i;
                       // System.out.println(i+" "+p+" "+q+" "+r);
                            schedule[i][0]=p;
                            schedule[i][1]=q;
                            schedule[i][2]=r;
                            dti[p][q][ins]=1;
                            dts[p][q][grp]=1;
                            f=1;
               // for(int l=0;l<35;l++)
                 //   System.out.println(temporary.get(l)[0]+" "+temporary.get(l)[1]);
                    //}
                        }
                        if(f==1)
                        break;
                    }
                    if(f==1)
                    break;
                }
                }f=0;
                for(int r=0;r<6;r++)
                {
                    for(int p=0;p<5;p++)
                    {
                        for(int q=6;q>=0;q--){//System.out.println(i+" "+p+" "+q+" "+r);
                        if(dtr[p][q][r]==-1&&dti[p][q][ins]==-1&&dts[p][q][grp+1]==-1)
                        {            
                            dtr[p][q][r]=i;
                        
                            schedule[j][0]=p;
                            schedule[j][1]=q;
                            schedule[j][2]=r;
                            dti[p][q][ins]=1;
                            dts[p][q][grp+1]=1;
                            f=1;
                            batches.add(arr);
                            j++;
               // for(int l=0;l<35;l++)
                 //   System.out.println(temporary.get(l)[0]+" "+temporary.get(l)[1]);
                    //}
                        }
                        if(f==1)
                        break;
                    }
                    if(f==1)
                    break;
                }
                    
                
            }
            }
            
            }
    }
        return true;
    }
    public void generateBatch()
    {
        batches = new ArrayList<int[]>();
        for(int i=0;i<courses.size();i++)
        {
            int k = 0;
            if(check(courses.get(i).getCode(),"6"))
            {
                if(courseTypeTable[i].equals("Lab"))
                {int start = 6;
                    while(LAT[i]!=0){
                    
                    
                    while(CAT[k][i]==0)
                        k++;
                    int arr[]= new int[3];
                    arr[0]=instructors.get(k).getId();
                    arr[1]=courses.get(i).getId();
                    arr[2]=start;
                    LAT[i]-=3;
                    start++;
                    CAT[k][i]-=3;
                    batches.add(arr);
                    //
                    }
                }
                else
                {
                    int persection = LAT[i]/3;int start = 6;
                    int cons = persection;
                    while(LAT[i]!=0){
                    
                    while(CAT[k][i]==0)
                        k++;
                    int arr[]= new int[3];
                    arr[0]=instructors.get(k).getId();
                    arr[1]=courses.get(i).getId();
                    arr[2]=start;
                    batches.add(arr);
                    int arr1[]= new int[3];
                    arr1[0]=instructors.get(k).getId();
                    arr1[1]=courses.get(i).getId();
                    arr1[2]=start+1;
                    //System.out.println(start+" "+arr[0]+" "+arr[1]+" "+arr[2]);
                   // batches.add(arr1);
                    LAT[i]-=1;
                    CAT[k][i]-=1;
                    persection--;
                    if(persection==0)
                    {
                        persection = cons;
                        start+=2;
                    }
                }
            }}
            else
            {
                if(courseTypeTable[i].equals("Lab"))
                {int start = 0;
                    while(LAT[i]!=0){
                    
                    while(CAT[k][i]==0)
                        k++;
                    int arr[]= new int[3];
                    arr[0]=instructors.get(k).getId();
                    arr[1]=courses.get(i).getId();
                    arr[2]=start;
                    LAT[i]-=3;//System.out.println(courses.get(i).getCode());
                    start++;
                    CAT[k][i]-=3;
                    batches.add(arr);
                    }
                }
                else
                {
                    int persection= LAT[i]/3;
                    int cons = persection;
                    int start = 0;
                    while(LAT[i]!=0){
                    while(CAT[k][i]==0)
                        k++;
                    int arr[]= new int[3];
                    arr[0]=instructors.get(k).getId();
                    arr[1]=courses.get(i).getId();
                    arr[2]=start;
                    //System.out.println(start+" "+arr[0]+" "+arr[1]+" "+arr[2]);
                    batches.add(arr);
                    
                    LAT[i]-=1;
                    CAT[k][i]-=1;
                    persection--;
                    if(persection==0)
                    {
                        persection = cons;
                        start+=2;
                    }
                    /*System.out.println(start);
                    for(int l = 0;l<batches.size();l++)
                        
            {
                System.out.println(batches.get(l)[0]+" "+batches.get(l)[1]+" "+batches.get(l)[2]);
            }*/
                }}
            }
        }
        
    }
    public void createLAT(ArrayList<Course> cs)
    {
        for(int i = 0;i<cs.size();i++)
        {
            //System.out.println(cs.size());
            if(cs.get(i).getCourseType().equals("Lab"))
                LAT[cs.get(i).getId()]=6*cs.get(i).getContactSlots();
            else 
            LAT[cs.get(i).getId()]=3*cs.get(i).getContactSlots();
        }
        System.out.println("----------LAT---------");
        for(int i=0;i<cs.size();i++)
            System.out.print(LAT[cs.get(i).getId()]+" ,");
        System.out.print("\n");
    }
    public void createcoursett(ArrayList<Course> cs)
    {
        for(int i = 0;i<cs.size();i++)
            courseTypeTable[cs.get(i).getId()]=cs.get(i).getCourseType();
        System.out.println("-------courseTypeTable-------");
        for(int l=0;l<cs.size();l++)
            System.out.print(courseTypeTable[l]+" ,");
        System.out.print("\n");
        
    }
    public void createHAT(ArrayList<Instructor> is)
    {
        for(int i=0;i<is.size();i++)
            HAT[is.get(i).getId()]=ATSManager.HRS;
        System.out.println("------HAT------");
        for(int l=0;l<is.size();l++)
            System.out.print(HAT[l]+" ,");
        System.out.print("\n");
    }
    public void createPAT(ArrayList<Instructor> is,ArrayList<Course> cs)
    {
        
        for(int i=0;i<is.size();i++)
        {
            for(int j=0;j<cs.size();j++){
                PAT[is.get(i).getId()][cs.get(j).getId()]=0;
            }
            int max = cs.size();
            if(!is.get(i).getExpertise1().equals(""))
            {
                for(int j = 0;j<cs.size();j++)
                {
                    if(cs.get(j).getCode().equals(is.get(i).getExpertise1()))
                    {
                        PAT[is.get(i).getId()][cs.get(j).getId()]=max;
                        max--;
                        break;
                    }
                }
            }
            if(!is.get(i).getExpertise2().equals(""))
            {
                for(int j = 0;j<cs.size();j++)
                {
                    if(cs.get(j).getCode().equals(is.get(i).getExpertise2()))
                    {
                        PAT[is.get(i).getId()][cs.get(j).getId()]=max;
                        max--;
                        break;
                    }
                }
            }
            if(!is.get(i).getExpertise3().equals(""))
            {
                for(int j = 0;j<cs.size();j++)
                {
                    if(cs.get(j).getCode().equals(is.get(i).getExpertise3()))
                    {
                        PAT[is.get(i).getId()][cs.get(j).getId()]=max;
                        max--;
                        break;
                    }
                }
            }
            if(!is.get(i).getExpertise4().equals(""))
            {
                for(int j = 0;j<cs.size();j++)
                {
                    if(cs.get(j).getCode().equals(is.get(i).getExpertise4()))
                    {
                        PAT[is.get(i).getId()][cs.get(j).getId()]=max;
                        max--;
                        break;
                    }
                }
            }
            
        }
        System.out.println("-------PAT-------");
        for(int p = 0;p<is.size();p++)
        {
            for(int q=0;q<cs.size();q++)
                System.out.print(PAT[p][q]+" ");
            System.out.print("\n");
        }
    }
    public int generateCAT(ArrayList<Instructor> is,ArrayList<Course> cs)
    {
        int counter = 0;
        for(int i=0;i<cs.size();i++)
        {
            int courseId = cs.get(i).getId();
            while(LAT[courseId]>0)
            {
                for(int j=0;j<is.size();j++)
                {
                    int teacherId = is.get(j).getId();
                    pq[teacherId]=(PAT[teacherId][courseId]+1f)/10*((HAT[teacherId]+1f)/20);
                }
                int x = 0;
                for(int k = 0;k<instructors.size();k++)
                {
                    float m = 0;int id=0;
                    for(int a=0;a<instructors.size();a++)
                    {
                        if(pq[a]>m)
                        {
                            m=pq[a];
                            id=a;
                        }
                    }
                    int teacherId = instructors.get(id).getId();
                    pq[id]=0f;
                    if(courseTypeTable[courseId].equals("Lecture"))
                    {
                        //System.out.println("here");
                        for(int l=LAT[courseId];l>=1;l--)
                        {
                            if(HAT[teacherId]-l>=0)
                            {
                                x=l;
                                break;   
                        }
                    }
                    
                }
                else
                {
                    if(HAT[teacherId]-3>=0)
                        x=3;
                }
                //System.out.println(x);
                if(x>0)
                {
                    CAT[teacherId][courseId]=CAT[teacherId][courseId]+x;
                    HAT[teacherId]=HAT[teacherId]-x;
                    LAT[courseId]=LAT[courseId]-x;
                    break;
                }
            }
            if(x==0)
            {
                return -1;
            }
            
        }
        }
        
        return 1;
    }
    public boolean check(String x ,String y)
    {
        for(int i=0;i<x.length();i++)
        {
            if(x.charAt(i)==y.charAt(0))
            {
                
            return true;
            }
        }
        return false;
    }
    public void Filter()
    {
        for(int i=0;i<30;i++)
        {
            instructorwise[i]=new ArrayList();
            roomwise[i]=new ArrayList();
            sectionwise[i]=new ArrayList();
        }
        for(int i=0;i<Timetable.length;i++)
        {
            Period now = Timetable[i];
            instructorwise[now.getInstructor().getId()].add(now);
            roomwise[now.getRoom().getId()].add(now);
            sectionwise[now.getSection().getId()].add(now);
        }int k = 0;
        
    }
    LogicManager(ATSManager Mgr)
    {
        timeslots = Mgr.timeslots;
        sections = Mgr.sections;
        courses = Mgr.courses;
        rooms = Mgr.rooms;
        instructors = Mgr.instructors;
        LAT=new int[courses.size()];
        courseTypeTable= new String[courses.size()];
        HAT=new int[instructors.size()];
        PAT=new int[instructors.size()][courses.size()];
        CAT=new int[instructors.size()][courses.size()];
        pq=new float[instructors.size()];
        createLAT(Mgr.courses);
        createHAT(Mgr.instructors);
        createcoursett(Mgr.courses);
        createPAT(Mgr.instructors,Mgr.courses);
        generate();
        Mgr.timetable = generatePeriods();
        Filter();
    }
}
