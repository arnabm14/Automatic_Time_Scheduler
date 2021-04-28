package atsmanager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JFileChooser.SAVE_DIALOG;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;


class Page2 extends JFrame implements ActionListener,MouseListener{
	//main container
	Container cont_view;
	
	//object of cursor class
	Cursor cur_view = new Cursor(Cursor.HAND_CURSOR);
	
	//objects for the initial view page with 4 buttons
	JLabel top = new JLabel("ACADAMIC TIME TABLE MANAGEMENT SYSTEM");
	JLabel head = new JLabel("please specify the format in which you want to view files:");
	
	
	//buttons for the entire routine view page.
	JButton button1 = new JButton("ENTIRE ROUTINE");
	JButton button2 = new JButton("INSTRUCTOR WISE");
	JButton button3 = new JButton("ROOM WISE");
	JButton button4 = new JButton("SECTION WISE");
	
	//buttons for the entire routine generate page:
	JButton generateBtn_entire = new JButton("generate");
	JButton backBtn_entire = new JButton("Back");
	
	//buttons for the routine as per instructor generate page:
	JButton backBtn_inst = new JButton("back");
	JButton generateBtn_inst = new JButton("generate");
	
	//buttons for the routine as per room generate page:
	JButton backBtn_room = new JButton("Back");
	JButton generateBtn_room = new JButton("generate");
	
	//buttons for the routine as per section generate page:
	JButton backBtn_section = new JButton("Back");
	JButton generateBtn_section = new JButton("generate");
	
	//buttons in the entire routine view page.
	JButton verify_entire = new JButton("verify");
	JButton export_entire = new JButton("export");
	JButton back_entire = new JButton("back");
	
	//buttons in the routine as per instructor view page.
	JButton verify_inst = new JButton("verify");
	JButton export_inst = new JButton("export");
	JButton back_inst = new JButton("back");
	
	//buttons in the routine as per room view page.
	JButton verify_room = new JButton("verify");
	JButton export_room = new JButton("export");
	JButton back_room = new JButton("back");
	
	//buttons in the routine as per section view page.
	JButton verify_section = new JButton("verify");
	JButton export_section = new JButton("export");
	JButton back_section = new JButton("back");
	
	//Color type object for natural color of the buttons:
	Color pink = new Color(255,153,204);
	Color color = new Color(240,240,240);
	
	//font type objects:
	
	Font f3 = new Font("Arial",Font.BOLD,14);
	Font f4 = new Font("Arial",Font.ITALIC,14);
	Font f5 = new Font("Arial",Font.ITALIC,18);
	
	//objects for the button event(2nd set of pages):
	
	JFrame f_entire = new JFrame("ROUTINE");
	JFrame f_inst = new JFrame("ROUTINE AS PER INSTRUCTOR");
	JFrame f_room = new JFrame("ROUTINE AS PER ROOM");
	JFrame f_section = new JFrame("ROUTINE AS PER SECTION");
	
	//object for button event within button event(3rd set of  pages):
	
	JFrame f_entireRoutine = new JFrame("ENTIRE GENERATED ROUTINE");
	JFrame f_instRoutine = new JFrame("ENTIRE GENERATED ROUTINE, AS PER INSTRUCTOR");
	JFrame f_roomRoutine = new JFrame("ENTIRE GENERATED ROUTINE, AS PER ROOM");
	JFrame f_sectionRoutine = new JFrame("ENTIRE GENERATED ROUTINE, AS PER SECTION");
	ATSManager mgr;
        String inst_selected;
        String room_selected;
        String sec_selected;
        JComboBox cb_inst;
        JComboBox cb_room;
        JComboBox cb_sec;
        int iid,sid,rid;
	//constructor:
	public Page2(ATSManager Mgr){
            mgr=Mgr;
		cont_view = this.getContentPane();
		cont_view.setLayout(null);
		cont_view.setBackground(Color.PINK);
		
		top.setBounds(50,0,450,50);
		top.setFont(f3);
		head.setBounds(150,80,500,50);
		head.setFont(f4);
		
		button1.setBounds(150,150,150,40);
		button1.setCursor(cur_view);
		button1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		button1.addActionListener(this);
		button1.addMouseListener(this);
		
		
		button2.setBounds(310,150,150,40);
		button2.setCursor(cur_view);
		button2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		button2.addActionListener(this);
		button2.addMouseListener(this);
		
		button3.setBounds(470,150,150,40);
		button3.setCursor(cur_view);
		button3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		button3.addActionListener(this);
		button3.addMouseListener(this);
		
		button4.setBounds(630,150,150,40);
		button4.setCursor(cur_view);
		button4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		button4.addActionListener(this);
		button4.addMouseListener(this);
		
		cont_view.add(top);
		cont_view.add(head);
		cont_view.add(button1);
		cont_view.add(button2);
		cont_view.add(button3);
		cont_view.add(button4);
			
	}
	//button event for the buttons(button1, button2, button3, button4), of the first page:
        @Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == button1)
		{
			Container cont_entire;
			
			Font f2 = new Font("Arial",Font.ITALIC,20);
			
			JLabel label = new JLabel("are you sure that you want to continue? press generate if yes...");
			label.setBounds(200,150,700,80);
			label.setFont(f2);
			
			//back button for the entire routine
			backBtn_entire.setBounds(200,500,150,40);
			backBtn_entire.setCursor(cur_view);
			backBtn_entire.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
			
			//generate button for the entire routine.
			generateBtn_entire.setBounds(450,500,150,40);
			generateBtn_entire.setCursor(cur_view);
			generateBtn_entire.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
			
			JLabel top_entire = new JLabel("ACADAMIC TIME TABLE MANAGEMENT SYSTEM");
			top_entire.setFont(f3);
			top_entire.setBounds(50,0,800,50);
			
			this.setVisible(false);
			
			f_entire.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f_entire.setBounds(200,0,1000,700);
			f_entire.setVisible(true);
			cont_entire= f_entire.getContentPane();
			cont_entire.setBackground(pink);
			cont_entire.setLayout(null);
			cont_entire.add(backBtn_entire);
			cont_entire.add(generateBtn_entire);
			cont_entire.add(top_entire);
			cont_entire.add(label);
			
			//events of the back and generate buttons in the entire routine page , using anonymous inner class:
			backBtn_entire.addActionListener(new ActionListener(){
				//@override
                                @Override
				public void actionPerformed(ActionEvent event)
				{
					backBtn_entireAction(event);
				}
			});
			
			generateBtn_entire.addActionListener(new ActionListener(){
				//@override
                                @Override
				public void actionPerformed(ActionEvent event)
				{
					generateBtn_entireAction(event);
				}
			});
			//event declaration ends here.
			
			//mouse events for generate and back buttons, using anonymous inner class.
			backBtn_entire.addMouseListener(new MouseListener(){
				//@override
                                @Override
				public void mouseEntered(MouseEvent e)
				{
					backBtn_entireMouseEntered(e);
				}
                                @Override
				public void mouseExited(MouseEvent e)
				{
					backBtn_entireMouseExited(e);
				}
                                @Override
				public void mouseClicked(MouseEvent e)
				{
					
				}
                                @Override
				public void mousePressed(MouseEvent e)
				{
					
				}
                                @Override
				public void mouseReleased(MouseEvent e)
				{
					
				}
			});
			
			generateBtn_entire.addMouseListener(new MouseListener(){
				//@override
                                @Override
				public void mouseEntered(MouseEvent e)
				{
					generateBtn_entireMouseEntered(e);
				}
                                @Override
				public void mouseExited(MouseEvent e)
				{
					generateBtn_entireMouseExited(e);
				}
                                @Override
				public void mouseClicked(MouseEvent e)
				{
					
				}
                                @Override
				public void mousePressed(MouseEvent e)
				{
					
				}
                                @Override
				public void mouseReleased(MouseEvent e)
				{
					
				}
			});
			//event ends here.
		}
		if(e.getSource() == button2)
		{
			Container cont_inst;
			//this.setFocusable(true);
			this.setVisible(false);
			
			//back button for the instructors routine
			backBtn_inst.setBounds(150,500,150,40);
			backBtn_inst.setCursor(cur_view);
			backBtn_inst.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
			
			//generate button for the instructors routine
			generateBtn_inst.setBounds(400,500,150,40);
			generateBtn_inst.setCursor(cur_view);
			generateBtn_inst.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
			
			JLabel top_inst = new JLabel("ACADAMIC TIME TABLE MANAGEMENT SYSTEM");
			top_inst.setFont(f3);
			top_inst.setBounds(50,0,800,50);
			
			//JLabel spec_inst = new JLabel("enter specifications");
			//spec_inst.setBounds(150,200,300,40);
			//spec_inst.setFont(f5);
			
			JLabel inst_name = new JLabel("enter instructor name:");
			inst_name.setBounds(150,250,200,40);
			inst_name.setFont(f5);
			
			//combo box for the instructor choosing:
			String[] arr_inst =new String[mgr.instructors.size()];
                        for(int i=0; i<mgr.instructors.size(); i++){
                            arr_inst[i]=mgr.instructors.get(i).getName();
                        }
			cb_inst = new JComboBox(arr_inst);
			cb_inst.setBounds(450,250,100,40);
			
			//fetching data from the selected item of combo box:
                        inst_selected = cb_inst.getSelectedItem().toString();
			
			
			f_inst.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f_inst.setBounds(200,0,1000,700);
			f_inst.setVisible(true);
			cont_inst= f_inst.getContentPane();
			cont_inst.setBackground(pink);
			cont_inst.setLayout(null);
			cont_inst.add(backBtn_inst);
			cont_inst.add(generateBtn_inst);
			//cont_inst.add(spec_inst);
			cont_inst.add(cb_inst);
			cont_inst.add(inst_name);
			cont_inst.add(top_inst);
			
			cont_inst.revalidate();
			
			//mouse events for generate and back buttons, using anonymous inner class.
			backBtn_inst.addMouseListener(new MouseListener(){
				//@override
                                @Override
				public void mouseEntered(MouseEvent e)
				{
					backBtn_instMouseEntered(e);
				}
                                @Override
				public void mouseExited(MouseEvent e)
				{
					backBtn_instMouseExited(e);
				}
                                @Override
				public void mouseClicked(MouseEvent e)
				{
					
				}
                                @Override
				public void mousePressed(MouseEvent e)
				{
					
				}
                                @Override
				public void mouseReleased(MouseEvent e)
				{
					
				}
			});
			
			generateBtn_inst.addMouseListener(new MouseListener(){
				//@override
                                @Override
				public void mouseEntered(MouseEvent e)
				{
					generateBtn_instMouseEntered(e);
				}
                                @Override
				public void mouseExited(MouseEvent e)
				{
					generateBtn_instMouseExited(e);
				}
                                @Override
				public void mouseClicked(MouseEvent e)
				{
					
				}
                                @Override
				public void mousePressed(MouseEvent e)
				{
					
				}
                                @Override
				public void mouseReleased(MouseEvent e)
				{
					
				}
			});
			//event ends here.
			
			//action event for the back and generate buttons of the instructor routine page, using anonymous inner class:
			backBtn_inst.addActionListener(new ActionListener(){
				//@override
                                @Override
				public void actionPerformed(ActionEvent event)
				{
					backBtn_instAction(event);
				}
			});
			
			generateBtn_inst.addActionListener(new ActionListener(){
				//@override
                                @Override
				public void actionPerformed(ActionEvent event)
				{
					generateBtn_instAction(event);
				}
			});
			//action events end here
			
		}
		if(e.getSource() == button3)
		{
			Container cont_room;
			this.setVisible(false);
			
			//back button for routine as per room
			backBtn_room.setBounds(150,500,150,40);
			backBtn_room.setCursor(cur_view);
			backBtn_room.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
			
			//generate button for routine as per room 
			generateBtn_room.setBounds(400,500,150,40);
			generateBtn_room.setCursor(cur_view);
			generateBtn_room.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
			
			JLabel top_room = new JLabel("ACADAMIC TIME TABLE MANAGEMENT SYSTEM");
			top_room.setFont(f3);
			top_room.setBounds(50,0,800,50);
			
			/*JLabel spec_room = new JLabel("enter specifications");
			spec_room.setBounds(150,200,300,40);
			spec_room.setFont(f5);*/
			
			JLabel room_number = new JLabel("enter room number:");
			room_number.setBounds(150,250,200,40);
			room_number.setFont(f5);
			
			//combo box for choosing room number:
                        String[] arr_room=new String[mgr.rooms.size()];
                        for(int i=0; i<mgr.rooms.size(); i++){
                            arr_room[i]=mgr.rooms.get(i).getResources();
                        }
			
                        //String[] arr_room = {"LG3.1,Lecture Room,100","LG3.2,Lecture Room,100","LG3.3,Lecture Room,100","LG3.4,Lecture Room,100","LG4.3,Lecture Room,100","LG4.5,Lecture Room,100","CSELab Zone1,Computer Lab,20","CSELab Zone2,Computer Lab,20","CSELab Zone3,Computer Lab,20","CSELab Zone4,Computer Lab,20","CSELab Zone5,Computer Lab,20","Annex3.1,Computer Lab,60","CCFL,Computer Lab,50","LG0.1,Communication Lab,50","CSELab Zone0,Hardware Lab,50"};
			cb_room = new JComboBox(arr_room);
			cb_room.setBounds(450,250,300,40);
			
			//fetching data from item chosen from the combo box
			//String room_selected = cb_room.getSelectedItem();
			
			f_room.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f_room.setBounds(200,0,1000,700);
			f_room.setVisible(true);
			cont_room= f_room.getContentPane();
			cont_room.setBackground(pink);
			cont_room.setLayout(null);
			cont_room.add(backBtn_room);
			cont_room.add(generateBtn_room);
			cont_room.add(top_room);
			//cont_room.add(spec_room);
			cont_room.add(room_number);
			cont_room.add(cb_room);
			cont_room.revalidate();
			
			//mouse events for generate and back buttons, using anonymous inner class.
			backBtn_room.addMouseListener(new MouseListener(){
				//@override
                                @Override
				public void mouseEntered(MouseEvent e)
				{
					backBtn_roomMouseEntered(e);
				}
                                @Override
				public void mouseExited(MouseEvent e)
				{
					backBtn_roomMouseExited(e);
				}
                                @Override
				public void mouseClicked(MouseEvent e)
				{
					
				}
                                @Override
				public void mousePressed(MouseEvent e)
				{
					
				}
                                @Override
				public void mouseReleased(MouseEvent e)
				{
					
				}
			});
			
			generateBtn_room.addMouseListener(new MouseListener(){
				//@override
                                @Override
				public void mouseEntered(MouseEvent e)
				{
					generateBtn_roomMouseEntered(e);
				}
                                @Override
				public void mouseExited(MouseEvent e)
				{
					generateBtn_roomMouseExited(e);
				}
                                @Override
				public void mouseClicked(MouseEvent e)
				{
					
				}
                                @Override
				public void mousePressed(MouseEvent e)
				{
					
				}
                                @Override
				public void mouseReleased(MouseEvent e)
				{
					
				}
			});
			//event ends here.
			
			//action event for the back and generate buttons of routine as per room page, using anonymous inner class:
			backBtn_room.addActionListener(new ActionListener(){
				//@override
                                @Override
				public void actionPerformed(ActionEvent event)
				{
					backBtn_roomAction(event);
				}
			});
			
			generateBtn_room.addActionListener(new ActionListener(){
				//@override
                                @Override
				public void actionPerformed(ActionEvent event)
				{
					generateBtn_roomAction(event);
				}
			});
			//action event ends here
			
			
		}
		if(e.getSource() == button4)
		{
			Container cont_section;
			this.setVisible(false);
			
			//back button for the routine as per section part:
			backBtn_section.setBounds(150,500,150,40);
			backBtn_section.setCursor(cur_view);
			backBtn_section.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
			
			//generate button for the routine as per section part:
			generateBtn_section.setBounds(400,500,150,40);
			generateBtn_section.setCursor(cur_view);
			generateBtn_section.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
			
			JLabel top_section = new JLabel("ACADAMIC TIME TABLE MANAGEMENT SYSTEM");
			top_section.setFont(f3);
			top_section.setBounds(50,0,800,50);
			
			//JLabel spec_section = new JLabel("enter specifications");
			//spec_section.setBounds(150,200,300,40);
			//spec_section.setFont(f5);
			
			JLabel section = new JLabel("enter section:");
			section.setBounds(150,250,200,40);
			section.setFont(f5);
			String[] arr_section=new String[mgr.sections.size()];
			//combo box for choosing the section:
                        for(int i=0; i<mgr.sections.size(); i++){
                            arr_section[i]=(mgr.sections.get(i).getYear()+" "+mgr.sections.get(i).getSection()+" "+mgr.sections.get(i).getLabSection()+" ");
                        }
			//String[] arr_section = {"2,A,A1,40","2,A,A2,40","2,B,B1,40","2,B,B2,40","2,C,C1,48","2,C,C2,50","3,A,A1,40","3,A,A2,40","3,B,B1,40","3,B,B2,40","3,C,C1,48","3,C,C2,50"};
			cb_sec = new JComboBox(arr_section);
			cb_sec.setBounds(450,250,200,40);
			
			//fetching data from the item selected from the combo box:
			//String section_selected = cb_section.getSelectedItem();
			
			f_section.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f_section.setBounds(200,0,1000,700);
			f_section.setVisible(true);
			cont_section= f_section.getContentPane();
			cont_section.setBackground(pink);
			cont_section.setLayout(null);
			cont_section.add(backBtn_section);
			cont_section.add(generateBtn_section);
			cont_section.add(top_section);
			//cont_section.add(spec_section);
			cont_section.add(section);
			cont_section.add(cb_sec);
			
			//mouse events for generate and back buttons, using anonymous inner class.
			backBtn_section.addMouseListener(new MouseListener(){
				//@override
                                @Override
				public void mouseEntered(MouseEvent e)
				{
					backBtn_sectionMouseEntered(e);
				}
                                @Override
				public void mouseExited(MouseEvent e)
				{
					backBtn_sectionMouseExited(e);
				}
                                @Override
				public void mouseClicked(MouseEvent e)
				{
					
				}
                                @Override
				public void mousePressed(MouseEvent e)
				{
					
				}
                                @Override
				public void mouseReleased(MouseEvent e)
				{
					
				}
			});
			
			generateBtn_section.addMouseListener(new MouseListener(){
				//@override
                                @Override
				public void mouseEntered(MouseEvent e)
				{
					generateBtn_sectionMouseEntered(e);
				}
                                @Override
				public void mouseExited(MouseEvent e)
				{
					generateBtn_sectionMouseExited(e);
				}
                                @Override
				public void mouseClicked(MouseEvent e)
				{
					
				}
                                @Override
				public void mousePressed(MouseEvent e)
				{
					
				}
                                @Override
				public void mouseReleased(MouseEvent e)
				{
					
				}
			});
			//event ends here.
			
			//action event for the back and generate buttons start here, using anonymous inner class:
			backBtn_section.addActionListener(new ActionListener(){
				//@override
                                @Override
				public void actionPerformed(ActionEvent event)
				{
					backBtn_sectionAction(event);
				}
			});
			generateBtn_section.addActionListener(new ActionListener(){
				//@override
                                @Override
				public void actionPerformed(ActionEvent event)
				{
					generateBtn_sectionAction(event);
				}
			});
			//action event ends here.
			
			
			
		}
	}
	
	//function declaration for the action event of back buttons of the four pages of entire routine and routine as per instructor, section and room:
	public void backBtn_entireAction(ActionEvent event)
	{
		this.setVisible(true);
		f_entire.setVisible(false);
	}
	public void backBtn_instAction(ActionEvent event)
	{
		this.setVisible(true);
		f_inst.setVisible(false);
	}
	public void backBtn_roomAction(ActionEvent event)
	{
		this.setVisible(true);
		f_room.setVisible(false);
	}
	public void backBtn_sectionAction(ActionEvent event)
	{
		this.setVisible(true);
		f_section.setVisible(false);
	}
	//function declaration ends here.
	
	//function declaration for the action event of generate buttons of the four pages of entire routine and routine as per instructor, section and room:
	public void generateBtn_entireAction(ActionEvent event)
	{
		Container cont_entireRoutine ;
		
		f_entire.setVisible(false);
    JFrame f=new JFrame();   
    int LEN_SEC=mgr.sections.size();
    String data[][]=new String[(LEN_SEC*20)+4][11];  
    String column[]={"DAY","YEAR","SEC","1","2","3","4","BREAK","5","6","7"};
    String days[]={"Tue","Wed","Thu","Fri","Sat"};
    int colour[][]=new int[(LEN_SEC*20)+4][11];
    for(int i=0; i<20*LEN_SEC; i=i+4){
        data[i][0]=days[i/(LEN_SEC*4)];
        data[i][1]=Integer.toString(mgr.sections.get((i/4)%LEN_SEC).getYear());
        data[i][2]=mgr.sections.get((i/4)%LEN_SEC).getLabSection();
        data[i][3]="";
        data[i][4]="";
        data[i][5]="";
        data[i][6]="";
        data[i][7]="";
        data[i][8]="";
        data[i][9]="";
        data[i][10]="";
    }
    int len=mgr.timetable.length;
    for(int i=0; i<len; i++){
        String temp1=mgr.timetable[i].getTimeslot().getDay();
        String temp2=Integer.toString(mgr.timetable[i].getSection().getYear());
        String temp3=mgr.timetable[i].getSection().getLabSection();
        int temp4=mgr.timetable[i].getTimeslot().getSlot();
        int temp=temp4;
        String temp5=mgr.timetable[i].getCourse().getCode();
        String temp6=mgr.timetable[i].getInstructor().getName();
         String temp7=mgr.timetable[i].getRoom().getResources();
         String temp8=mgr.timetable[i].getCourse().getCourseType();
        for(int j=0; j<20*LEN_SEC; j=j+4){
            if((temp1.equals(data[j][0]) )&& (temp2.equals(data[j][1])) && (temp3.equals(data[j][2]))){
                if("".equals(data[j][temp4+2]) && temp4<5){
                    if(!("Lab".equals(temp8))){
                        temp4=temp4+2;
                        data[j][temp4]=(temp5);
                        data[j+1][temp4]=(temp6);
                        data[j+2][temp4]=(temp7);
                        if(j>0)
                        colour[j-1][temp4]=3;
                        colour[j][temp4]=1;
                        colour[j+1][temp4]=1;
                        colour[j+2][temp4]=1;
                        colour[j+3][temp4]=1;
                        if("".equals(data[j+4][temp4])){
                        colour[j+4][temp4]=1;
                        colour[j+5][temp4]=1;
                        colour[j+6][temp4]=1;
                        colour[j+7][temp4]=3;
                        }
                    }
                    else{
                        temp4=temp4+3;
                        data[j][temp4]=(temp3+": "+temp5);
                        data[j+1][temp4]=(temp6);
                        data[j+2][temp4]=(temp7);
                        if(j>0)
                        colour[j-1][temp4]=3;
                        colour[j][temp4]=2;
                        colour[j+1][temp4]=2;
                        colour[j+2][temp4]=2;
                        colour[j+3][temp4]=3;
                        if(j>0)
                        colour[j-1][temp4-1]=3;
                        colour[j][temp4-1]=2;
                        colour[j+1][temp4-1]=2;
                        colour[j+2][temp4-1]=2;
                        colour[j+3][temp4-1]=3;
                        if(j>0)
                        colour[j-1][temp4+1]=3;
                        colour[j][temp4+1]=2;
                        colour[j+1][temp4+1]=2;
                        colour[j+2][temp4+1]=2;
                        colour[j+3][temp4+1]=3;
                    }
                }
                else if("".equals(data[j][temp4+3]) && temp4>4){
                    if(!("Lab".equals(temp8))){
                        temp4=temp4+3;
                        data[j][temp4]=(temp5);
                        data[j+1][temp4]=(temp6);
                        data[j+2][temp4]=(temp7);
                        if(j>0)
                        colour[j-1][temp4]=3;
                        colour[j][temp4]=1;
                        colour[j+1][temp4]=1;
                        colour[j+2][temp4]=1;
                        colour[j+3][temp4]=1;
                        if("".equals(data[j+4][temp4])){
                        colour[j+4][temp4]=1;
                        colour[j+5][temp4]=1;
                        colour[j+6][temp4]=1;
                        colour[j+7][temp4]=3;
                        }
                    }
                    else{
                        temp4=temp4+4;
                        data[j][temp4]=(temp3+": "+temp5);
                        data[j+1][temp4]=(temp6);
                        data[j+2][temp4]=(temp7);
                        if(j>0)
                        colour[j-1][temp4]=3;
                        colour[j][temp4]=2;
                        colour[j+1][temp4]=2;
                        colour[j+2][temp4]=2;
                        colour[j+3][temp4]=3;
                        if(j>0)
                        colour[j-1][temp4-1]=3;
                        colour[j][temp4-1]=2;
                        colour[j+1][temp4-1]=2;
                        colour[j+2][temp4-1]=2;
                        colour[j+3][temp4-1]=3;
                        if(j>0)
                        colour[j-1][temp4+1]=3;
                        colour[j][temp4+1]=2;
                        colour[j+1][temp4+1]=2;
                        colour[j+2][temp4+1]=2;
                        colour[j+3][temp4+1]=3;
                    }
                }
                else{
                    System.out.println("problem at "+i);
                }
            }
        }
    }
    JTable jt=new JTable(data,column); 
    TableColumn td;
        for(int j=0; j<11; j++){
            td=jt.getColumnModel().getColumn(j);
            int[] tem=new int[LEN_SEC*20];
            for(int i=0; i<(LEN_SEC*20); i++)
                tem[i]=colour[i][j];
            td.setCellRenderer(new ColorCellRenderer(tem,(LEN_SEC*20)));   
        }
    jt.setBounds(30,40,10000,1000); 
    jt.setRowHeight(20);
    jt.setShowHorizontalLines(false);
    jt.setShowVerticalLines(false);
   /* TableColumn tr;
    
    for(int i=0; i<11;i++){
        tr = jt.getColumnModel().getColumn(i);
        tr.setCellRenderer(new ColorRowRenderer(Color.black, Color.red));
    }
      TableColumn  tm = jt.getColumnModel().getColumn(7);
      tm.setCellRenderer(new ColorColumnRenderer(Color.lightGray, Color.blue));
    // */
    JScrollPane sp=new JScrollPane(jt);    
   
		
		cont_entireRoutine = f_entireRoutine.getContentPane();
		cont_entireRoutine.setLayout(null);
		f_entireRoutine.setBounds(200,0,1000,700);
		cont_entireRoutine.setBackground(pink);
		f_entireRoutine.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f_entireRoutine.setVisible(true);
		//verify entire mouse event:
		verify_entire.addMouseListener(new MouseListener(){
			//@override
                        @Override
			public void mouseEntered(MouseEvent e)
			{
				verify_entireMouseEntered(e);
			}
                        @Override
			public void mouseExited(MouseEvent e)
			{
				verify_entireMouseExited(e);
			}
                        @Override
			public void mousePressed(MouseEvent e)
			{
				
			}
                        @Override
			public void mouseClicked(MouseEvent e)
			{
				
			}
                        @Override
			public void mouseReleased(MouseEvent e)
			{
				
			}
		});
		
		//export_entire button mouse event:
		export_entire.addMouseListener(new MouseListener(){
			//@override
                        @Override
			public void mouseEntered(MouseEvent e)
			{
				export_entireMouseEntered(e);
			}
                        @Override
			public void mouseExited(MouseEvent e)
			{
				export_entireMouseExited(e);
			}
                        @Override
			public void mousePressed(MouseEvent e)
			{
				
			}
                        @Override
			public void mouseClicked(MouseEvent e)
			{
                            try {
                                export_entireMouseClicked(e);
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(Page2.class.getName()).log(Level.SEVERE, null, ex);
                            }
			}
                        @Override
			public void mouseReleased(MouseEvent e)
			{
				
			}
		});
		
		//back entire mouse event:
		back_entire.addMouseListener(new MouseListener(){
			//@override
                        @Override
			public void mouseEntered(MouseEvent e)
			{
				back_entireMouseEntered(e);
			}
                        @Override
			public void mouseExited(MouseEvent e)
			{
				back_entireMouseExited(e);
			}
                        @Override
			public void mousePressed(MouseEvent e)
			{
				
			}
                        @Override
			public void mouseClicked(MouseEvent e)
			{
				
			}
                        @Override
			public void mouseReleased(MouseEvent e)
			{
				
			}
		});
		
		verify_entire.setBounds(150,500,150,40);
		verify_entire.setCursor(cur_view);
		export_entire.setBounds(400,500,150,40);
		export_entire.setCursor(cur_view);
		back_entire.setBounds(600,500,150,40);
		back_entire.setCursor(cur_view);
		verify_entire.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		export_entire.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		back_entire.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		f.add(sp);          
                f.setSize(Integer.MAX_VALUE,Integer.MIN_VALUE); 
                f.setVisible(true);
                cont_entireRoutine.setVisible(true);
		cont_entireRoutine.add(verify_entire);
		cont_entireRoutine.add(export_entire);
		cont_entireRoutine.add(back_entire);
		
		//event within an event: back button event for the page after generation of entire routine:
		back_entire.addActionListener(new ActionListener(){
				//@override
                                @Override
				public void actionPerformed(ActionEvent event)
				{
					back_entireAction(event);
				}
			});
		//action event ends here.
		
	}
	
	public void generateBtn_instAction(ActionEvent event)
	{
		Container cont_instRoutine ;
		
		f_inst.setVisible(false);
		JFrame f=new JFrame();   
    int LEN_SEC=mgr.sections.size();
    inst_selected = cb_inst.getSelectedItem().toString();
    String data[][]=new String[(LEN_SEC*20)+4][11];  
    String column[]={"DAY","YEAR","SEC","1","2","3","4","BREAK","5","6","7"};
    String days[]={"Tue","Wed","Thu","Fri","Sat"};
    int colour[][]=new int[(LEN_SEC*20)+4][11];
    for(int i=0; i<20*LEN_SEC; i=i+4){
        data[i][0]=days[i/(LEN_SEC*4)];
        data[i][1]=Integer.toString(mgr.sections.get((i/4)%LEN_SEC).getYear());
        data[i][2]=mgr.sections.get((i/4)%LEN_SEC).getLabSection();
        data[i][3]="";
        data[i][4]="";
        data[i][5]="";
        data[i][6]="";
        data[i][7]="";
        data[i][8]="";
        data[i][9]="";
        data[i][10]="";
    }
    int l=mgr.instructors.size();
    
    for(int i=0; i<l; i++){
        if(inst_selected.equals(mgr.instructors.get(i).getName()))
            iid=mgr.instructors.get(i).getId();
    }
    int len=mgr.logicMgr.instructorwise[iid].size();
    for(int i=0; i<len; i++){
        String temp1=mgr.logicMgr.instructorwise[iid].get(i).getTimeslot().getDay();
        String temp2=Integer.toString(mgr.logicMgr.instructorwise[iid].get(i).getSection().getYear());
        String temp3=mgr.logicMgr.instructorwise[iid].get(i).getSection().getLabSection();
        int temp4=mgr.logicMgr.instructorwise[iid].get(i).getTimeslot().getSlot();
        //int temp=temp4;
        String temp5=mgr.logicMgr.instructorwise[iid].get(i).getCourse().getCode();
        String temp6=mgr.logicMgr.instructorwise[iid].get(i).getInstructor().getName();
         String temp7=mgr.logicMgr.instructorwise[iid].get(i).getRoom().getResources();
         String temp8=mgr.logicMgr.instructorwise[iid].get(i).getCourse().getCourseType();
        for(int j=0; j<20*LEN_SEC; j=j+4){
            if((temp1.equals(data[j][0]) )&& (temp2.equals(data[j][1])) && (temp3.equals(data[j][2]))){
                if("".equals(data[j][temp4+2]) && temp4<5){
                    if(!("Lab".equals(temp8))){
                        temp4=temp4+2;
                        data[j][temp4]=(temp5);
                        data[j+1][temp4]=(temp6);
                        data[j+2][temp4]=(temp7);
                        if(j>0)
                            colour[j-1][temp4]=3;
                        colour[j][temp4]=1;
                        colour[j+1][temp4]=1;
                        colour[j+2][temp4]=1;
                        colour[j+3][temp4]=1;
                        if("".equals(data[j+4][temp4])){
                        colour[j+4][temp4]=1;
                        colour[j+5][temp4]=1;
                        colour[j+6][temp4]=1;
                        colour[j+7][temp4]=3;
                        }
                    }
                    else{
                        temp4=temp4+3;
                        data[j][temp4]=(temp3+": "+temp5);
                        data[j+1][temp4]=(temp6);
                        data[j+2][temp4]=(temp7);
                        if(j>0)
                            colour[j-1][temp4]=3;
                        colour[j][temp4]=2;
                        colour[j+1][temp4]=2;
                        colour[j+2][temp4]=2;
                        colour[j+3][temp4]=3;
                        if(j>0)
                            colour[j-1][temp4-1]=3;
                        colour[j][temp4-1]=2;
                        colour[j+1][temp4-1]=2;
                        colour[j+2][temp4-1]=2;
                        colour[j+3][temp4-1]=3;
                        if(j>0)
                            colour[j-1][temp4+1]=3;
                        colour[j][temp4+1]=2;
                        colour[j+1][temp4+1]=2;
                        colour[j+2][temp4+1]=2;
                        colour[j+3][temp4+1]=3;
                    }
                }
                else if("".equals(data[j][temp4+3]) && temp4>4){
                    if(!("Lab".equals(temp8))){
                        temp4=temp4+3;
                        data[j][temp4]=(temp5);
                        data[j+1][temp4]=(temp6);
                        data[j+2][temp4]=(temp7);
                        if(j>0)
                            colour[j-1][temp4]=3;
                        colour[j][temp4]=1;
                        colour[j+1][temp4]=1;
                        colour[j+2][temp4]=1;
                        colour[j+3][temp4]=1;
                        if("".equals(data[j+4][temp4])){
                        colour[j+4][temp4]=1;
                        colour[j+5][temp4]=1;
                        colour[j+6][temp4]=1;
                        colour[j+7][temp4]=3;
                        }
                    }
                    else{
                        temp4=temp4+4;
                        data[j][temp4]=(temp3+": "+temp5);
                        data[j+1][temp4]=(temp6);
                        data[j+2][temp4]=(temp7);
                        if(j>0)
                            colour[j-1][temp4]=3;
                        colour[j][temp4]=2;
                        colour[j+1][temp4]=2;
                        colour[j+2][temp4]=2;
                        colour[j+3][temp4]=3;
                        if(j>0)
                            colour[j-1][temp4-1]=3;
                        colour[j][temp4-1]=2;
                        colour[j+1][temp4-1]=2;
                        colour[j+2][temp4-1]=2;
                        colour[j+3][temp4-1]=3;
                        if(j>0)
                            colour[j-1][temp4+1]=3;
                        colour[j][temp4+1]=2;
                        colour[j+1][temp4+1]=2;
                        colour[j+2][temp4+1]=2;
                        colour[j+3][temp4+1]=3;
                    }
                }
                else{
                    System.out.println("problem at "+i);
                }
            }
        }
    }
    JTable jt=new JTable(data,column); 
    TableColumn td;
        for(int j=0; j<11; j++){
            td=jt.getColumnModel().getColumn(j);
            int[] tem=new int[LEN_SEC*20];
            for(int i=0; i<(LEN_SEC*20); i++)
                tem[i]=colour[i][j];
            td.setCellRenderer(new ColorCellRenderer(tem,(LEN_SEC*20)));   
        }
    jt.setBounds(30,40,10000,1000); 
    jt.setRowHeight(20);
    jt.setShowHorizontalLines(false);
    jt.setShowVerticalLines(false);
		
		cont_instRoutine = f_instRoutine.getContentPane();
		cont_instRoutine.setLayout(null);
		f_instRoutine.setBounds(200,0,1000,700);
		f_instRoutine.setVisible(true);
		cont_instRoutine.setBackground(pink);
		f_instRoutine.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		verify_inst.setBounds(150,500,150,40);
		verify_inst.setCursor(cur_view);
		export_inst.setBounds(400,500,150,40);
		export_inst.setCursor(cur_view);
		back_inst.setBounds(600,500,150,40);
		back_inst.setCursor(cur_view);
		verify_inst.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		export_inst.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		back_inst.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		JScrollPane sp=new JScrollPane(jt);
                f.add(sp);
                f.setSize(Integer.MAX_VALUE,Integer.MAX_VALUE);
                f.setVisible(true);
		cont_instRoutine.add(verify_inst);
		cont_instRoutine.add(export_inst);
		cont_instRoutine.add(back_inst);
		
		//event within an event: back button event for the page after generation of routine as per instructor:
		back_inst.addActionListener(new ActionListener(){
				//@override
                                @Override
				public void actionPerformed(ActionEvent event)
				{
					back_instAction(event);
				}
			});
		//action event ends here.
		
		//verify inst mouse event:
		verify_inst.addMouseListener(new MouseListener(){
			//@override
                        @Override
			public void mouseEntered(MouseEvent e)
			{
				verify_instMouseEntered(e);
			}
                        @Override
			public void mouseExited(MouseEvent e)
			{
				verify_instMouseExited(e);
			}
                        @Override
			public void mousePressed(MouseEvent e)
			{
				
			}
                        @Override
			public void mouseClicked(MouseEvent e)
			{
				
			}
                        @Override
			public void mouseReleased(MouseEvent e)
			{
				
			}
		});
		//mouse event adding ends here.
		
		//export_inst button mouse event:
		export_inst.addMouseListener(new MouseListener(){
			//@override
                        @Override
			public void mouseEntered(MouseEvent e)
			{
				export_instMouseEntered(e);
			}
                        @Override
			public void mouseExited(MouseEvent e)
			{
				export_instMouseExited(e);
			}
                        @Override
			public void mousePressed(MouseEvent e)
			{
				
			}
                        @Override
			public void mouseClicked(MouseEvent e)
			{
                            try {
                                export_instMouseClicked(e);
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(Page2.class.getName()).log(Level.SEVERE, null, ex);
                            }
			}
                        @Override
			public void mouseReleased(MouseEvent e)
			{
				
			}
		});
		//export inst mouse event adding ends here.
		
		//back inst mouse event:
		back_inst.addMouseListener(new MouseListener(){
			//@override
                        @Override
			public void mouseEntered(MouseEvent e)
			{
				back_instMouseEntered(e);
			}
                        @Override
			public void mouseExited(MouseEvent e)
			{
				back_instMouseExited(e);
			}
                        @Override
			public void mousePressed(MouseEvent e)
			{
				
			}
                        @Override
			public void mouseClicked(MouseEvent e)
			{
				
			}
                        @Override
			public void mouseReleased(MouseEvent e)
			{
				
			}
		});
		//back button mouse event adding ends here.
		
		
	}
	
	public void generateBtn_roomAction(ActionEvent event)
	{
		Container cont_roomRoutine ;
		
		f_room.setVisible(false);
		room_selected=cb_room.getSelectedItem().toString();
    JFrame f=new JFrame();   
    int LEN_SEC=mgr.sections.size();
    String data[][]=new String[(LEN_SEC*20)+4][11];  
    String column[]={"DAY","YEAR","SEC","1","2","3","4","BREAK","5","6","7"};
    String days[]={"Tue","Wed","Thu","Fri","Sat"};
    int colour[][]=new int[(LEN_SEC*20)+4][11];
    for(int i=0; i<20*LEN_SEC; i=i+4){
        data[i][0]=days[i/(LEN_SEC*4)];
        data[i][1]=Integer.toString(mgr.sections.get((i/4)%LEN_SEC).getYear());
        data[i][2]=mgr.sections.get((i/4)%LEN_SEC).getLabSection();
        data[i][3]="";
        data[i][4]="";
        data[i][5]="";
        data[i][6]="";
        data[i][7]="";
        data[i][8]="";
        data[i][9]="";
        data[i][10]="";
    }
    int l=mgr.rooms.size();
    int id=0;
    for(int i=0; i<l; i++){
        if(room_selected.equals(mgr.rooms.get(i).getResources()))
            id=mgr.rooms.get(i).getId();
    }
    rid=id;
    int len=mgr.logicMgr.roomwise[id].size();
    for(int i=0; i<len; i++){
        String temp1=mgr.logicMgr.roomwise[id].get(i).getTimeslot().getDay();
        String temp2=Integer.toString(mgr.logicMgr.roomwise[id].get(i).getSection().getYear());
        String temp3=mgr.logicMgr.roomwise[id].get(i).getSection().getLabSection();
        int temp4=mgr.logicMgr.roomwise[id].get(i).getTimeslot().getSlot();
        //int temp=temp4;
        String temp5=mgr.logicMgr.roomwise[id].get(i).getCourse().getCode();
        String temp6=mgr.logicMgr.roomwise[id].get(i).getInstructor().getName();
         String temp7=mgr.logicMgr.roomwise[id].get(i).getRoom().getResources();
         String temp8=mgr.logicMgr.roomwise[id].get(i).getCourse().getCourseType();
        for(int j=0; j<20*LEN_SEC; j=j+4){
            if((temp1.equals(data[j][0]) )&& (temp2.equals(data[j][1])) && (temp3.equals(data[j][2]))){
                if("".equals(data[j][temp4+2]) && temp4<5){
                    if(!("Lab".equals(temp8))){
                        temp4=temp4+2;
                        data[j][temp4]=(temp5);
                        data[j+1][temp4]=(temp6);
                        data[j+2][temp4]=(temp7);
                        if(j>0)
                            colour[j-1][temp4]=3;
                        colour[j][temp4]=1;
                        colour[j+1][temp4]=1;
                        colour[j+2][temp4]=1;
                        colour[j+3][temp4]=1;
                        if("".equals(data[j+4][temp4])){
                        colour[j+4][temp4]=1;
                        colour[j+5][temp4]=1;
                        colour[j+6][temp4]=1;
                        colour[j+7][temp4]=3;
                        }
                    }
                    else{
                        temp4=temp4+3;
                        data[j][temp4]=(temp3+": "+temp5);
                        data[j+1][temp4]=(temp6);
                        data[j+2][temp4]=(temp7);
                        if(j>0)
                            colour[j-1][temp4]=3;
                        colour[j][temp4]=2;
                        colour[j+1][temp4]=2;
                        colour[j+2][temp4]=2;
                        colour[j+3][temp4]=3;
                        if(j>0)
                            colour[j-1][temp4-1]=3;
                        colour[j][temp4-1]=2;
                        colour[j+1][temp4-1]=2;
                        colour[j+2][temp4-1]=2;
                        colour[j+3][temp4-1]=3;
                        if(j>0)
                            colour[j-1][temp4+1]=3;
                        colour[j][temp4+1]=2;
                        colour[j+1][temp4+1]=2;
                        colour[j+2][temp4+1]=2;
                        colour[j+3][temp4+1]=3;
                    }
                }
                else if("".equals(data[j][temp4+3]) && temp4>4){
                    if(!("Lab".equals(temp8))){
                        temp4=temp4+3;
                        data[j][temp4]=(temp5);
                        data[j+1][temp4]=(temp6);
                        data[j+2][temp4]=(temp7);
                        if(j>0)
                            colour[j-1][temp4]=3;
                        colour[j][temp4]=1;
                        colour[j+1][temp4]=1;
                        colour[j+2][temp4]=1;
                        colour[j+3][temp4]=1;
                        if("".equals(data[j+4][temp4])){
                        colour[j+4][temp4]=1;
                        colour[j+5][temp4]=1;
                        colour[j+6][temp4]=1;
                        colour[j+7][temp4]=3;
                        }
                    }
                    else{
                        temp4=temp4+4;
                        data[j][temp4]=(temp3+": "+temp5);
                        data[j+1][temp4]=(temp6);
                        data[j+2][temp4]=(temp7);
                        if(j>0)
                            colour[j-1][temp4]=3;
                        colour[j][temp4]=2;
                        colour[j+1][temp4]=2;
                        colour[j+2][temp4]=2;
                        colour[j+3][temp4]=3;
                        if(j>0)
                            colour[j-1][temp4-1]=3;
                        colour[j][temp4-1]=2;
                        colour[j+1][temp4-1]=2;
                        colour[j+2][temp4-1]=2;
                        colour[j+3][temp4-1]=3;
                        if(j>0)
                            colour[j-1][temp4+1]=3;
                        colour[j][temp4+1]=2;
                        colour[j+1][temp4+1]=2;
                        colour[j+2][temp4+1]=2;
                        colour[j+3][temp4+1]=3;
                    }
                }
                else{
                    System.out.println("problem at "+i);
                }
            }
        }
    }
    JTable jt=new JTable(data,column); 
    TableColumn td;
        for(int j=0; j<11; j++){
            td=jt.getColumnModel().getColumn(j);
            int[] tem=new int[LEN_SEC*20];
            for(int i=0; i<(LEN_SEC*20); i++)
                tem[i]=colour[i][j];
            td.setCellRenderer(new ColorCellRenderer(tem,(LEN_SEC*20)));   
        }
    jt.setBounds(30,40,10000,1000); 
    jt.setRowHeight(20);
    jt.setShowHorizontalLines(false);
    jt.setShowVerticalLines(false);
    JScrollPane sp=new JScrollPane(jt);
                f.add(sp);
                f.setSize(Integer.MAX_VALUE,Integer.MAX_VALUE);
                f.setVisible(true);
		cont_roomRoutine = f_roomRoutine.getContentPane();
		cont_roomRoutine.setLayout(null);
		f_roomRoutine.setBounds(200,0,1000,700);
		f_roomRoutine.setVisible(true);
		cont_roomRoutine.setBackground(pink);
		f_roomRoutine.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		verify_room.setBounds(150,500,150,40);
		verify_room.setCursor(cur_view);
		export_room.setBounds(400,500,150,40);
		export_room.setCursor(cur_view);
		back_room.setBounds(600,500,150,40);
		back_room.setCursor(cur_view);
		verify_room.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		export_room.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		back_room.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		cont_roomRoutine.add(verify_room);
		cont_roomRoutine.add(export_room);
		cont_roomRoutine.add(back_room);
		
		//event within an event: back button event for the page after generation of routine as per room:
		back_room.addActionListener(new ActionListener(){
				//@override
                                @Override
				public void actionPerformed(ActionEvent event)
				{
					back_roomAction(event);
				}
			});
		//action event ends here.
		
		//verify room mouse event:
		verify_room.addMouseListener(new MouseListener(){
			//@override
                        @Override
			public void mouseEntered(MouseEvent e)
			{
				verify_roomMouseEntered(e);
			}
                        @Override
			public void mouseExited(MouseEvent e)
			{
				verify_roomMouseExited(e);
			}
                        @Override
			public void mousePressed(MouseEvent e)
			{
				
			}
                        @Override
			public void mouseClicked(MouseEvent e)
			{
				
			}
                        @Override
			public void mouseReleased(MouseEvent e)
			{
				
			}
		});
		//mouse event adding ends here.
		
		//export_room button mouse event:
		export_room.addMouseListener(new MouseListener(){
			//@override
                        @Override
			public void mouseEntered(MouseEvent e)
			{
				export_roomMouseEntered(e);
			}
                        @Override
			public void mouseExited(MouseEvent e)
			{
				export_roomMouseExited(e);
			}
                        @Override
			public void mousePressed(MouseEvent e)
			{
				
			}
                        @Override
			public void mouseClicked(MouseEvent e)
			{
                            try {
                                export_roomMouseClicked(e);
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(Page2.class.getName()).log(Level.SEVERE, null, ex);
                            }
			}
                        @Override
			public void mouseReleased(MouseEvent e)
			{
				
			}
		});
		//export room mouse event adding ends here.
		
		//back room mouse event:
		back_room.addMouseListener(new MouseListener(){
			//@override
                        @Override
			public void mouseEntered(MouseEvent e)
			{
				back_roomMouseEntered(e);
			}
                        @Override
			public void mouseExited(MouseEvent e)
			{
				back_roomMouseExited(e);
			}
                        @Override
			public void mousePressed(MouseEvent e)
			{
				
			}
                        @Override
			public void mouseClicked(MouseEvent e)
			{
				
			}
                        @Override
			public void mouseReleased(MouseEvent e)
			{
				
			}
		});
		//back button mouse event adding ends here.
		
	}
	
	
	public void generateBtn_sectionAction(ActionEvent event)
	{
		Container cont_sectionRoutine ;
		
		f_section.setVisible(false);
    sec_selected=cb_sec.getSelectedItem().toString();
    
    System.out.println(sec_selected);
    JFrame f=new JFrame();   
    int LEN_SEC=mgr.sections.size();
    String data[][]=new String[(LEN_SEC*20)+4][11];  
    String column[]={"DAY","YEAR","SEC","1","2","3","4","BREAK","5","6","7"};
    String days[]={"Tue","Wed","Thu","Fri","Sat"};
    int colour[][]=new int[(LEN_SEC*20)+4][11];
    for(int i=0; i<20*LEN_SEC; i=i+4){
        data[i][0]=days[i/(LEN_SEC*4)];
        data[i][1]=Integer.toString(mgr.sections.get((i/4)%LEN_SEC).getYear());
        data[i][2]=mgr.sections.get((i/4)%LEN_SEC).getLabSection();
        data[i][3]="";
        data[i][4]="";
        data[i][5]="";
        data[i][6]="";
        data[i][7]="";
        data[i][8]="";
        data[i][9]="";
        data[i][10]="";
    }
    int l=mgr.sections.size();
    int id=0;
    String temps[]=sec_selected.split(" ");
   // if((mgr.sections.get(id).getYear()+" "+mgr.sections.get(id).getSection()+" "+mgr.sections.get(id).getLabSection())==sec_selected)
   //     System.out.println("in here "+temps[0]+" "+temps[1]+" "+temps[2]);
    //System.out.println(temps[0]+" "+temps[1]+" "+temps[2]);
    for(int i=0; i<l; i++){
        if(temps[0].equals(Integer.toString(mgr.sections.get(i).getYear())) && temps[1].equals(mgr.sections.get(i).getSection()) && temps[2].equals(mgr.sections.get(i).getLabSection())){
          //  System.out.println("in here "+temps[0]+" "+temps[1]+" "+temps[2]);
            id=mgr.sections.get(i).getId();
    }
    }
    sid=id;
    System.out.println((mgr.sections.get(id).getYear()+" "+mgr.sections.get(id).getSection()+" "+mgr.sections.get(id).getLabSection()));
    int len=mgr.logicMgr.sectionwise[id].size();
    for(int i=0; i<len; i++){
        String temp1=mgr.logicMgr.sectionwise[id].get(i).getTimeslot().getDay();
        String temp2=Integer.toString(mgr.logicMgr.sectionwise[id].get(i).getSection().getYear());
        String temp3=mgr.logicMgr.sectionwise[id].get(i).getSection().getLabSection();
        int temp4=mgr.logicMgr.sectionwise[id].get(i).getTimeslot().getSlot();
        //int temp=temp4;
        String temp5=mgr.logicMgr.sectionwise[id].get(i).getCourse().getCode();
        String temp6=mgr.logicMgr.sectionwise[id].get(i).getInstructor().getName();
         String temp7=mgr.logicMgr.sectionwise[id].get(i).getRoom().getResources();
         String temp8=mgr.logicMgr.sectionwise[id].get(i).getCourse().getCourseType();
        for(int j=0; j<20*LEN_SEC; j=j+4){
            if((temp1.equals(data[j][0]) )&& (temp2.equals(data[j][1])) && (temp3.equals(data[j][2]))){
                if("".equals(data[j][temp4+2]) && temp4<5){
                    if(!("Lab".equals(temp8))){
                        temp4=temp4+2;
                        data[j][temp4]=(temp5);
                        data[j+1][temp4]=(temp6);
                        data[j+2][temp4]=(temp7);
                        if(j>0)
                            colour[j-1][temp4]=3;
                        colour[j][temp4]=1;
                        colour[j+1][temp4]=1;
                        colour[j+2][temp4]=1;
                        colour[j+3][temp4]=1;
                        if("".equals(data[j+4][temp4])){
                        colour[j+4][temp4]=1;
                        colour[j+5][temp4]=1;
                        colour[j+6][temp4]=1;
                        colour[j+7][temp4]=3;
                        }
                    }
                    else{
                        temp4=temp4+3;
                        data[j][temp4]=(temp3+": "+temp5);
                        data[j+1][temp4]=(temp6);
                        data[j+2][temp4]=(temp7);
                        if(j>0)
                            colour[j-1][temp4]=3;
                        colour[j][temp4]=2;
                        colour[j+1][temp4]=2;
                        colour[j+2][temp4]=2;
                        colour[j+3][temp4]=3;
                        if(j>0)
                            colour[j-1][temp4-1]=3;
                        colour[j][temp4-1]=2;
                        colour[j+1][temp4-1]=2;
                        colour[j+2][temp4-1]=2;
                        colour[j+3][temp4-1]=3;
                        if(j>0)
                            colour[j-1][temp4+1]=3;
                        colour[j][temp4+1]=2;
                        colour[j+1][temp4+1]=2;
                        colour[j+2][temp4+1]=2;
                        colour[j+3][temp4+1]=3;
                    }
                }
                else if("".equals(data[j][temp4+3]) && temp4>4){
                    if(!("Lab".equals(temp8))){
                        temp4=temp4+3;
                        data[j][temp4]=(temp5);
                        data[j+1][temp4]=(temp6);
                        data[j+2][temp4]=(temp7);
                        if(j>0)
                            colour[j-1][temp4]=3;
                        colour[j][temp4]=1;
                        colour[j+1][temp4]=1;
                        colour[j+2][temp4]=1;
                        colour[j+3][temp4]=1;
                        if("".equals(data[j+4][temp4])){
                        colour[j+4][temp4]=1;
                        colour[j+5][temp4]=1;
                        colour[j+6][temp4]=1;
                        colour[j+7][temp4]=3;
                        }
                    }
                    else{
                        temp4=temp4+4;
                        data[j][temp4]=(temp3+": "+temp5);
                        data[j+1][temp4]=(temp6);
                        data[j+2][temp4]=(temp7);
                        if(j>0)
                            colour[j-1][temp4]=3;
                        colour[j][temp4]=2;
                        colour[j+1][temp4]=2;
                        colour[j+2][temp4]=2;
                        colour[j+3][temp4]=3;
                        if(j>0)
                            colour[j-1][temp4-1]=3;
                        colour[j][temp4-1]=2;
                        colour[j+1][temp4-1]=2;
                        colour[j+2][temp4-1]=2;
                        colour[j+3][temp4-1]=3;
                        if(j>0)
                            colour[j-1][temp4+1]=3;
                        colour[j][temp4+1]=2;
                        colour[j+1][temp4+1]=2;
                        colour[j+2][temp4+1]=2;
                        colour[j+3][temp4+1]=3;
                    }
                }
                else{
                    System.out.println("problem at "+i);
                }
            }
        }
    }
    JTable jt=new JTable(data,column); 
    TableColumn td;
        for(int j=0; j<11; j++){
            td=jt.getColumnModel().getColumn(j);
            int[] tem=new int[LEN_SEC*20];
            for(int i=0; i<(LEN_SEC*20); i++)
                tem[i]=colour[i][j];
            td.setCellRenderer(new ColorCellRenderer(tem,(LEN_SEC*20)));   
        }
    jt.setBounds(30,40,10000,1000); 
    jt.setRowHeight(20);
    jt.setShowHorizontalLines(false);
    jt.setShowVerticalLines(false);
		
		cont_sectionRoutine = f_sectionRoutine.getContentPane();
		cont_sectionRoutine.setLayout(null);
		f_sectionRoutine.setBounds(200,0,1000,700);
		f_sectionRoutine.setVisible(true);
		cont_sectionRoutine.setBackground(pink);
		f_sectionRoutine.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		verify_section.setBounds(150,500,150,40);
		verify_section.setCursor(cur_view);
		export_section.setBounds(400,500,150,40);
		export_section.setCursor(cur_view);
		back_section.setBounds(600,500,150,40);
		back_section.setCursor(cur_view);
		verify_section.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		export_section.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		back_section.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		JScrollPane sp=new JScrollPane(jt);
                f.add(sp);
                f.setSize(Integer.MAX_VALUE,Integer.MAX_VALUE);
                f.setVisible(true);
		cont_sectionRoutine.add(verify_section);
		cont_sectionRoutine.add(export_section);
		cont_sectionRoutine.add(back_section);
		
		//event within an event: back button event for the page after generation of routine as per section:
		back_section.addActionListener(new ActionListener(){
				//@override
                                @Override
				public void actionPerformed(ActionEvent event)
				{
					back_sectionAction(event);
				}
			});
		//action event ends here.
		
		//verify section mouse event:
		verify_section.addMouseListener(new MouseListener(){
			//@override
                        @Override
			public void mouseEntered(MouseEvent e)
			{
				verify_sectionMouseEntered(e);
			}
                        @Override
			public void mouseExited(MouseEvent e)
			{
				verify_sectionMouseExited(e);
			}
                        @Override
			public void mousePressed(MouseEvent e)
			{
				
			}
                        @Override
			public void mouseClicked(MouseEvent e)
			{
				
			}
                        @Override
			public void mouseReleased(MouseEvent e)
			{
				
			}
		});
		//mouse event adding ends here.
		
		//export_section button mouse event:
		export_section.addMouseListener(new MouseListener(){
			//@override
                        @Override
			public void mouseEntered(MouseEvent e)
			{
				export_sectionMouseEntered(e);
			}
                        @Override
			public void mouseExited(MouseEvent e)
			{
				export_sectionMouseExited(e);
			}
                        @Override
			public void mousePressed(MouseEvent e)
			{
				
			}
                        @Override
			public void mouseClicked(MouseEvent e)
			{
                            try {
                                export_secMouseClicked(e);
                                        } catch (FileNotFoundException ex) {
                                Logger.getLogger(Page2.class.getName()).log(Level.SEVERE, null, ex);
                            }
			}
                        @Override
			public void mouseReleased(MouseEvent e)
			{
				
			}
		});
		//export section mouse event adding ends here.
		
		//back section mouse event:
		back_section.addMouseListener(new MouseListener(){
			//@override
                        @Override
			public void mouseEntered(MouseEvent e)
			{
				back_sectionMouseEntered(e);
			}
                        @Override
			public void mouseExited(MouseEvent e)
			{
				back_sectionMouseExited(e);
			}
                        @Override
			public void mousePressed(MouseEvent e)
			{
				
			}
                        @Override
			public void mouseClicked(MouseEvent e)
			{
				
			}
                        @Override
			public void mouseReleased(MouseEvent e)
			{
				
			}
		});
		//back button mouse event adding ends here.
		
	}
	//function declaration ends here.
	
	//function declaration for the back button after generation of routines
	public void back_entireAction(ActionEvent event)
	{
		f_entire.setVisible(true);
		f_entireRoutine.setVisible(false);
	}
	
	public void back_instAction(ActionEvent event)
	{
		f_inst.setVisible(true);
		f_instRoutine.setVisible(false);
	}
	
	public void back_roomAction(ActionEvent event)
	{
		f_room.setVisible(true);
		f_roomRoutine.setVisible(false);
	}
	
	public void back_sectionAction(ActionEvent event)
	{
		f_section.setVisible(true);
		f_sectionRoutine.setVisible(false);
	}
	//function declaration ends here.
	
	
		//function for mouse event functions declaration for the choosing page:
        @Override
		public void mouseEntered(MouseEvent e)
		{
			//int op = JOptionPane.showConfirmDialog(null , "mouse event");
			if(e.getSource() == button1)
			{
				button1.setBackground(Color.BLACK);
				button1.setForeground(Color.WHITE);
			}
			if(e.getSource() == button2)
			{

				button2.setBackground(Color.BLACK);
				button2.setForeground(Color.WHITE);
			}
			if(e.getSource() == button3)
			{
				
				button3.setBackground(Color.BLACK);
				button3.setForeground(Color.WHITE);
			}
			if(e.getSource() == button4)
			{
				button4.setBackground(Color.BLACK);
				button4.setForeground(Color.WHITE);
			}
		}
        @Override
		public void mouseExited(MouseEvent e)
		{
			if(e.getSource() == button1)
			{
				button1.setBackground(color);
				button1.setForeground(Color.BLACK);
			}
			if(e.getSource() == button2)
			{
				button2.setBackground(color);
				button2.setForeground(Color.BLACK);
			}
			if(e.getSource() == button3)
			{
				button3.setBackground(color);
				button3.setForeground(Color.BLACK);
			}
			if(e.getSource() == button4)
			{
				button4.setBackground(color);
				button4.setForeground(Color.BLACK);
			}
		}
        @Override
		public void mousePressed(MouseEvent e)
		{
			
		}
        @Override
		public void mouseClicked(MouseEvent e)
		{
			
		}
        @Override
		public void mouseReleased(MouseEvent e)
		{
			
		}
		//mouse event ends here.
		
		//function for mouse event for backBtn_entire starts here.
		public void backBtn_entireMouseEntered(MouseEvent e)
		{
			backBtn_entire.setBackground(Color.BLACK);
			backBtn_entire.setForeground(Color.WHITE);
		}
		public void backBtn_entireMouseExited(MouseEvent e)
		{
			backBtn_entire.setBackground(color);
			backBtn_entire.setForeground(Color.BLACK);
		}
		//function for mouse event for backBtn_entire ends here.
		
		//function for mouse event of generateBtn_entire starts here.
		public void generateBtn_entireMouseEntered(MouseEvent e)
		{
			generateBtn_entire.setBackground(Color.BLACK);
			generateBtn_entire.setForeground(Color.WHITE);
		}
		public void generateBtn_entireMouseExited(MouseEvent e)
		{
			generateBtn_entire.setBackground(color);
			generateBtn_entire.setForeground(Color.BLACK);
		}
		//function declaration for mouse event of generateBtn_entire ends here.
		
		//function for mouse event for backBtn_inst starts here.
		public void backBtn_instMouseEntered(MouseEvent e)
		{
			backBtn_inst.setBackground(Color.BLACK);
			backBtn_inst.setForeground(Color.WHITE);
		}
		public void backBtn_instMouseExited(MouseEvent e)
		{
			backBtn_inst.setBackground(color);
			backBtn_inst.setForeground(Color.BLACK);
		}
		//function for mouse event for backBtn_inst ends here.
		
		//function for mouse event of generateBtn_inst starts here.
		public void generateBtn_instMouseEntered(MouseEvent e)
		{
			generateBtn_inst.setBackground(Color.BLACK);
			generateBtn_inst.setForeground(Color.WHITE);
		}
		public void generateBtn_instMouseExited(MouseEvent e)
		{
			generateBtn_inst.setBackground(color);
			generateBtn_inst.setForeground(Color.BLACK);
		}
		//function declaration for mouse event of generateBtn_inst ends here.
		
		//function for mouse event for backBtn_room starts here.
		public void backBtn_roomMouseEntered(MouseEvent e)
		{
			backBtn_room.setBackground(Color.BLACK);
			backBtn_room.setForeground(Color.WHITE);
		}
		public void backBtn_roomMouseExited(MouseEvent e)
		{
			backBtn_room.setBackground(color);
			backBtn_room.setForeground(Color.BLACK);
		}
		//function for mouse event for backBtn_room ends here.
		
		//function for mouse event of generateBtn_room starts here.
		public void generateBtn_roomMouseEntered(MouseEvent e)
		{
			generateBtn_room.setBackground(Color.BLACK);
			generateBtn_room.setForeground(Color.WHITE);
		}
		public void generateBtn_roomMouseExited(MouseEvent e)
		{
			generateBtn_room.setBackground(color);
			generateBtn_room.setForeground(Color.BLACK);
		}
		//function declaration for mouse event of generateBtn_room ends here.
		
		//function for mouse event for backBtn_section starts here.
		public void backBtn_sectionMouseEntered(MouseEvent e)
		{
			backBtn_section.setBackground(Color.BLACK);
			backBtn_section.setForeground(Color.WHITE);
		}
		public void backBtn_sectionMouseExited(MouseEvent e)
		{
			backBtn_section.setBackground(color);
			backBtn_section.setForeground(Color.BLACK);
		}
		//function for mouse event for backBtn_section ends here.
		
		//function for mouse event of generateBtn_section starts here.
		public void generateBtn_sectionMouseEntered(MouseEvent e)
		{
			generateBtn_section.setBackground(Color.BLACK);
			generateBtn_section.setForeground(Color.WHITE);
		}
		public void generateBtn_sectionMouseExited(MouseEvent e)
		{
			generateBtn_section.setBackground(color);
			generateBtn_section.setForeground(Color.BLACK);
		}
		//function declaration for mouse event of generateBtn_room ends here.
		
		//function for mouse event for verify button of the entire routine page:
		public void verify_entireMouseEntered(MouseEvent e)
		{
			verify_entire.setBackground(Color.BLACK);
			verify_entire.setForeground(Color.WHITE);
		}
		public void verify_entireMouseExited(MouseEvent e)
		{
			verify_entire.setBackground(color);
			verify_entire.setForeground(Color.BLACK);
		}
		//function for mouse event function ends here.
		
		//function for mouse event for export button of the entire routine page:
		public void export_entireMouseEntered(MouseEvent e)
		{        
                        
			export_entire.setBackground(Color.BLACK);
			export_entire.setForeground(Color.WHITE);
		}
		public void export_entireMouseExited(MouseEvent e)
		{
			export_entire.setBackground(color);
			export_entire.setForeground(Color.BLACK);
		}
		//function for mouse event function ends here.
		
		//function for mouse event for back button of the entire routine page:
		public void back_entireMouseEntered(MouseEvent e)
		{
			back_entire.setBackground(Color.BLACK);
			back_entire.setForeground(Color.WHITE);
		}
		public void back_entireMouseExited(MouseEvent e)
		{
			back_entire.setBackground(color);
			back_entire.setForeground(Color.BLACK);
		}
		//function for mouse event function ends here.
		
		//function for mouse event for verify button of the routine as per instructor page:
		public void verify_instMouseEntered(MouseEvent e)
		{
			verify_inst.setBackground(Color.BLACK);
			verify_inst.setForeground(Color.WHITE);
		}
		public void verify_instMouseExited(MouseEvent e)
		{
			verify_inst.setBackground(color);
			verify_inst.setForeground(Color.BLACK);
		}
		//function for mouse event function ends here.
		
		//function for mouse event for export button of the routine as per instructor  page:
		public void export_instMouseEntered(MouseEvent e)
		{
			export_inst.setBackground(Color.BLACK);
			export_inst.setForeground(Color.WHITE);
		}
		public void export_instMouseExited(MouseEvent e)
		{
			export_inst.setBackground(color);
			export_inst.setForeground(Color.BLACK);
		}
		//function for mouse event function ends here.
		
		//function for mouse event for back button of the routine as per instructor page:
		public void back_instMouseEntered(MouseEvent e)
		{
			back_inst.setBackground(Color.BLACK);
			back_inst.setForeground(Color.WHITE);
		}
		public void back_instMouseExited(MouseEvent e)
		{
			back_inst.setBackground(color);
			back_inst.setForeground(Color.BLACK);
		}
		//function for mouse event function ends here.
		
		//function for mouse event for verify button of the routine as per room page:
		public void verify_roomMouseEntered(MouseEvent e)
		{
			verify_room.setBackground(Color.BLACK);
			verify_room.setForeground(Color.WHITE);
		}
		public void verify_roomMouseExited(MouseEvent e)
		{
			verify_room.setBackground(color);
			verify_room.setForeground(Color.BLACK);
		}
		//function for mouse event function ends here.
		
		//function for mouse event for export button of the routine as per room  page:
		public void export_roomMouseEntered(MouseEvent e)
		{
			export_room.setBackground(Color.BLACK);
			export_room.setForeground(Color.WHITE);
		}
		public void export_roomMouseExited(MouseEvent e)
		{
			export_room.setBackground(color);
			export_room.setForeground(Color.BLACK);
		}
		//function for mouse event function ends here.
		
		//function for mouse event for back button of the routine as per room page:
		public void back_roomMouseEntered(MouseEvent e)
		{
			back_room.setBackground(Color.BLACK);
			back_room.setForeground(Color.WHITE);
		}
		public void back_roomMouseExited(MouseEvent e)
		{
			back_room.setBackground(color);
			back_room.setForeground(Color.BLACK);
		}
		//function for mouse event function ends here.
		
		//function for mouse event for verify button of the routine as per section page:
		public void verify_sectionMouseEntered(MouseEvent e)
		{
			verify_section.setBackground(Color.BLACK);
			verify_section.setForeground(Color.WHITE);
		}
		public void verify_sectionMouseExited(MouseEvent e)
		{
			verify_section.setBackground(color);
			verify_section.setForeground(Color.BLACK);
		}
		//function for mouse event function ends here.
		
		//function for mouse event for export button of the routine as per section  page:
		public void export_sectionMouseEntered(MouseEvent e)
		{
			export_section.setBackground(Color.BLACK);
			export_section.setForeground(Color.WHITE);
		}
		public void export_sectionMouseExited(MouseEvent e)
		{
			export_section.setBackground(color);
			export_section.setForeground(Color.BLACK);
		}
		//function for mouse event function ends here.
		
		//function for mouse event for back button of the routine as per section page:
		public void back_sectionMouseEntered(MouseEvent e)
		{
			back_section.setBackground(Color.BLACK);
			back_section.setForeground(Color.WHITE);
		}
		public void back_sectionMouseExited(MouseEvent e)
		{
			back_section.setBackground(color);
			back_section.setForeground(Color.BLACK);
		}
                public void export_entireMouseClicked(MouseEvent e)throws FileNotFoundException{
                     JFileChooser fc = new JFileChooser();
                     fc.showSaveDialog(f_entire);
                     File f=fc.getSelectedFile();
                     if(f!=null){
                     System.out.println(f.getPath());
            try (PrintWriter writer = new PrintWriter(f.getPath()+".csv")) {
                int len=mgr.timetable.length;
                for(int i=0; i<len; i++)
                    writer.println(mgr.timetable[i].getTimeslot().getDay()+","+mgr.timetable[i].getTimeslot().getSlot()+","+mgr.timetable[i].getTimeslot().getStart()+","+mgr.timetable[i].getTimeslot().getEnd()+","+mgr.timetable[i].getSection().getYear()+","+mgr.timetable[i].getTimeslot().getDay()+","+mgr.timetable[i].getSection().getSection()+","+mgr.timetable[i].getSection().getLabSection()+","+mgr.timetable[i].getCourse().getCode()+","+mgr.timetable[i].getCourse().getName()+","+mgr.timetable[i].getCourse().getCourseType()+","+mgr.timetable[i].getInstructor().getName()+","+mgr.timetable[i].getCourse().getResource());
            }
                }
                }
                  public void export_instMouseClicked(MouseEvent e) throws FileNotFoundException{
                     JFileChooser fc = new JFileChooser();
                     fc.showSaveDialog(f_inst);
                     File f=fc.getSelectedFile();
                     System.out.println(f.getPath());
            try (PrintWriter writer = new PrintWriter(f.getPath()+".csv")) {
                int len=mgr.logicMgr.instructorwise[iid].size();
                for(int i=0; i<len; i++)
                    writer.println(mgr.logicMgr.instructorwise[iid].get(i).getTimeslot().getDay()+","+mgr.logicMgr.instructorwise[iid].get(i).getTimeslot().getSlot()+","+mgr.logicMgr.instructorwise[iid].get(i).getTimeslot().getStart()+","+mgr.logicMgr.instructorwise[iid].get(i).getTimeslot().getEnd()+","+mgr.logicMgr.instructorwise[iid].get(i).getSection().getYear()+","+mgr.logicMgr.instructorwise[iid].get(i).getTimeslot().getDay()+","+mgr.logicMgr.instructorwise[iid].get(i).getSection().getSection()+","+mgr.logicMgr.instructorwise[iid].get(i).getSection().getLabSection()+","+mgr.logicMgr.instructorwise[iid].get(i).getCourse().getCode()+","+mgr.logicMgr.instructorwise[iid].get(i).getCourse().getName()+","+mgr.logicMgr.instructorwise[iid].get(i).getCourse().getCourseType()+","+mgr.logicMgr.instructorwise[iid].get(i).getInstructor().getName()+","+mgr.logicMgr.instructorwise[iid].get(i).getCourse().getResource());
            }
                     
                }
            public void export_roomMouseClicked(MouseEvent e) throws FileNotFoundException{
                     JFileChooser fc = new JFileChooser();
                     fc.showSaveDialog(f_room);
                     File f=fc.getSelectedFile();
                     System.out.println(f.getPath());
            try (PrintWriter writer = new PrintWriter(f.getPath()+".csv")) {
                int len=mgr.logicMgr.roomwise[rid].size();
                for(int i=0; i<len; i++)
                    writer.println(mgr.logicMgr.roomwise[rid].get(i).getTimeslot().getDay()+","+mgr.logicMgr.roomwise[rid].get(i).getTimeslot().getSlot()+","+mgr.logicMgr.roomwise[rid].get(i).getTimeslot().getStart()+","+mgr.logicMgr.roomwise[rid].get(i).getTimeslot().getEnd()+","+mgr.logicMgr.roomwise[rid].get(i).getSection().getYear()+","+mgr.logicMgr.roomwise[rid].get(i).getTimeslot().getDay()+","+mgr.logicMgr.roomwise[rid].get(i).getSection().getSection()+","+mgr.logicMgr.roomwise[rid].get(i).getSection().getLabSection()+","+mgr.logicMgr.roomwise[rid].get(i).getCourse().getCode()+","+mgr.logicMgr.roomwise[rid].get(i).getCourse().getName()+","+mgr.logicMgr.roomwise[rid].get(i).getCourse().getCourseType()+","+mgr.logicMgr.roomwise[rid].get(i).getInstructor().getName()+","+mgr.logicMgr.roomwise[rid].get(i).getCourse().getResource());
            }
                     
                }
            public void export_secMouseClicked(MouseEvent e) throws FileNotFoundException{
                     JFileChooser fc = new JFileChooser();
                     fc.showSaveDialog(f_section);
                     File f=fc.getSelectedFile();
                     System.out.println(f.getPath());
            try (PrintWriter writer = new PrintWriter(f.getPath()+".csv")) {
                int len=mgr.logicMgr.sectionwise[sid].size();
                for(int i=0; i<len; i++)
                    writer.println(mgr.logicMgr.sectionwise[sid].get(i).getTimeslot().getDay()+","+mgr.logicMgr.sectionwise[sid].get(i).getTimeslot().getSlot()+","+mgr.logicMgr.sectionwise[sid].get(i).getTimeslot().getStart()+","+mgr.logicMgr.sectionwise[sid].get(i).getTimeslot().getEnd()+","+mgr.logicMgr.sectionwise[sid].get(i).getSection().getYear()+","+mgr.logicMgr.sectionwise[sid].get(i).getTimeslot().getDay()+","+mgr.logicMgr.sectionwise[sid].get(i).getSection().getSection()+","+mgr.logicMgr.sectionwise[sid].get(i).getSection().getLabSection()+","+mgr.logicMgr.sectionwise[sid].get(i).getCourse().getCode()+","+mgr.logicMgr.sectionwise[sid].get(i).getCourse().getName()+","+mgr.logicMgr.sectionwise[sid].get(i).getCourse().getCourseType()+","+mgr.logicMgr.sectionwise[sid].get(i).getInstructor().getName()+","+mgr.logicMgr.sectionwise[sid].get(i).getCourse().getResource());
            }
                     
                }

		//function for mouse event function ends here.
	
}
//colourrenderer
class ColorRowRenderer extends DefaultTableCellRenderer
{
   Color bkgndColor, fgndColor;
   int[] ar=new int[1000];  
   public ColorRowRenderer(Color bkgnd, Color foregnd) {
      super();
      bkgndColor = bkgnd;
      fgndColor = foregnd;
      for(int i=7; i<1000; i=i+8){
          ar[i]=1;
      }
   }
     
   public Component getTableCellRendererComponent
        (JTable table, Object value, boolean isSelected,
         boolean hasFocus, int row, int column)
   {
      Component cell = super.getTableCellRendererComponent
         (table, value, isSelected, hasFocus, row, column);
      setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
     // System.out.println(row+" "+column);
      if(ar[row]==1){
      cell.setBackground( fgndColor );
      cell.setForeground( bkgndColor );
      }
      else{
      cell.setBackground(Color.WHITE);
      cell.setForeground( Color.BLACK );   
      }
      return cell;
   }
}
//rowrendering

class ColorColumnRenderer extends DefaultTableCellRenderer
{
   Color bkgndColor, fgndColor;
     
   public ColorColumnRenderer(Color bkgnd, Color foregnd) {
      super();
      bkgndColor = bkgnd;
      fgndColor = foregnd;
   }
     
   public Component getTableCellRendererComponent
        (JTable table, Object value, boolean isSelected,
         boolean hasFocus, int row, int column)
   {
      Component cell = super.getTableCellRendererComponent
         (table, value, isSelected, hasFocus, row, column);
      //System.out.println(row+" "+column);
      cell.setBackground( fgndColor );
      cell.setForeground( bkgndColor );
      return cell;
   }
}
class ColorCellRenderer extends DefaultTableCellRenderer
{
   Color bkgndColor, fgndColor;
    Color rg[];
    int len;
   public ColorCellRenderer(int r[],int o) {
      super();
      len=o;
      rg=new Color[o];
     for(int i=0;i<len; i++){
         if(r[i]==0){
             rg[i]=Color.LIGHT_GRAY;
         }
         else if(r[i]==1){
             rg[i]=Color.CYAN;
         }
         else if(r[i]==2){
             rg[i]=Color.ORANGE;
         }
         else if(r[i]==3){
             rg[i]=Color.RED;
         }
     }
     
      }
     
   public Component getTableCellRendererComponent
        (JTable table, Object value, boolean isSelected,
         boolean hasFocus, int row, int column)
   {
      Component cell = super.getTableCellRendererComponent
         (table, value, isSelected, hasFocus, row, column);
      setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
     // System.out.println(row+" "+column);
      
      cell.setBackground( rg[row] );
      cell.setForeground( Color.BLACK);
      
      
      return cell;
   }
}

