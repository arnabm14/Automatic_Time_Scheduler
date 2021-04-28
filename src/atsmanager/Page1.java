package atsmanager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import java.util.*;
class Page1 extends JFrame implements ActionListener,MouseListener{
	
		
		//basic container
		Container c ;
		
		//Timer type object
		java.util.Timer timer = new java.util.Timer();
		
		//objects for the first window
		JLabel top = new JLabel("ACADAMIC TIME TABLE MANAGEMENT SYSTEM");
		JLabel head = new JLabel("please specify the files as mentioned");
		JLabel courseLabel = new JLabel("enter course file");
		JLabel sectionLabel = new JLabel("enter section file");
		JLabel instLabel = new JLabel("enter instructor file");
		JLabel roomLabel = new JLabel("enter room's file");
		JLabel timeLabel = new JLabel("enter timeslots file");
		
		Font f = new Font("Arial",Font.BOLD,20);
		Font f1 = new Font("Arial",Font.ITALIC,18);
		Font f2 = new Font("Arial",Font.ITALIC,20);
		
		Color color = new Color(240,240,240);
		
		
		JTextField course_tf = new JTextField();
		JTextField section_tf = new JTextField();
		JTextField inst_tf = new JTextField();
		JTextField room_tf = new JTextField();
		JTextField time_tf = new JTextField();
		
		JButton button = new JButton("Generate");
		JButton reset = new JButton("Reset");
		
		//object of the cursor
		Cursor cur = new Cursor(Cursor.HAND_CURSOR);
		
		Color backColor = new Color(255,153,204);
		
		//objects for the action event:
		Cursor cur1 = new Cursor(Cursor.WAIT_CURSOR);
		JFrame frame1 = new JFrame("HOME PAGE");
		ATSManager mgr;
                JFrame frame2;
                private Page2 page_2;
                //run()
                
		//constructor:
                public Page1(){}
		public Page1(ATSManager Mgr){
			mgr=Mgr;
                        page_2=new Page2(Mgr);
                        //System.out.println(Mgr.filenames[0]+" "+Mgr.filenames[1]+" "+Mgr.filenames[2]+" "+Mgr.filenames[3]+" "+Mgr.filenames[4]);
			c = this.getContentPane();
			c.setLayout(null);
			c.setBackground(backColor);
			top.setBounds(50,0,700,50);
			top.setFont(f);
			head.setBounds(150,70,500,50);
			head.setFont(f1);
			
			courseLabel.setBounds(150,100,150,100);
			sectionLabel.setBounds(150,150,150,100);
			instLabel.setBounds(150,200,150,100);
			roomLabel.setBounds(150,250,150,100);
			timeLabel.setBounds(150,300,150,100);
			
			course_tf.setBounds(300,130,100,30);
			section_tf.setBounds(300,180,100,30);
			inst_tf.setBounds(300,230,100,30);
			room_tf.setBounds(300,280,100,30);
			time_tf.setBounds(300,330,100,30);
			
			course_tf.setText("courses.csv");
			section_tf.setText("sections.csv");
			inst_tf.setText("instructors.csv");
			room_tf.setText("rooms.csv");
			time_tf.setText("timeslots.csv");
			
			
			//generate button
			button.setBounds(300,400,100,30);
			button.setCursor(cur);
			button.addActionListener(this);
			
			//mouse event for the buttons:
			button.addMouseListener(this);
			//mouse entered event for button ends here.
			
			button.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
			
			
			//reset button
			reset.setBounds(150,400,100,30);
			reset.setCursor(cur);
			reset.addActionListener(this);
			
			//mouse event for the reset buttons:
			reset.addMouseListener(this);
			//mouse event for reset button ends here
			
			reset.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
			
			c.add(top);
			c.add(head);
			c.add(courseLabel);
			c.add(sectionLabel);
			c.add(instLabel);
			c.add(roomLabel);
			c.add(timeLabel);
			c.add(course_tf);
			
			c.add(course_tf);
			c.add(section_tf);
			c.add(inst_tf);
			c.add(room_tf);
			c.add(time_tf);
			
			c.add(button);
			c.add(reset);
                        
		}
		
		//action event for button:
                @Override
		public void actionPerformed(ActionEvent event)
		{
			Container cont1;
			
			if(event.getSource() == button){
				
				//fetching text from the text fields:
				mgr.filenames[0]=course_tf.getText();
                                mgr.filenames[1]=room_tf.getText();
                                mgr.filenames[2]=section_tf.getText();
                                mgr.filenames[3]=inst_tf.getText();
                                mgr.filenames[4]=time_tf.getText();
                                mgr.dataMgr=new DataManager(mgr);
                                mgr.logicMgr=new LogicManager(mgr);
                               int len= mgr.timetable.length;
                               for(int i=0; i<len; i++){
                                   System.out.println(i+" "+mgr.timetable[i].getString());
                               }
                               // System.out.println(mgr.filenames[0]+" "+mgr.filenames[1]+" "+mgr.filenames[2]+" "+mgr.filenames[3]+" "+mgr.filenames[4]);
				//if(course_name == "courses.csv" && inst_name == "instructors.csv" && room_name == "rooms.csv" && section_name == "sections.csv" && time == "timeslots.csv")
				//{	
					//message box:
					int op = JOptionPane.showConfirmDialog(null , "are you sure you want to continue?");
					if(op == 0)
					{
                                                frame2 = new JFrame("HOME PAGE");
						timer.schedule(new RemindTask(), 5000);
					
						this.setVisible(false);
						Cursor cur1 = new Cursor(Cursor.WAIT_CURSOR);
						
						frame2.setBounds(200,0,1000,700);
						frame2.setVisible(true);
						frame2.setCursor(cur1);
						frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
						cont1= frame2.getContentPane();
						cont1.setBackground(backColor);
						cont1.setLayout(null);
						JLabel label1 = new JLabel("validating files..please wait");
						label1.setBounds(250,250,800,100);
						label1.setFont(f2);
						cont1.add(label1);
				
					}
				//}
				//else{
				//	JOptionPane.showMessageDialog(null, "incorrect specifications");
				//}
			}
			
			
			if(event.getSource() == reset)
			{
				course_tf.setText(null);
				section_tf.setText(null);
				inst_tf.setText(null);
				room_tf.setText(null);
				time_tf.setText(null);
			}
			//action event for the buttons ends here.
			
		}
		
		
		//mouse event starts here
                @Override
		public void mouseEntered(MouseEvent me)
		{
			if(me.getSource() == button){
			button.setBackground(Color.BLACK);
			button.setForeground(Color.WHITE);
			}
			
			if(me.getSource() == reset){
			reset.setBackground(Color.BLACK);
			reset.setForeground(Color.WHITE);
			}
		}
                @Override
		public void mouseExited(MouseEvent me)
		{
			if(me.getSource() == button){
			button.setBackground(color);
			button.setForeground(Color.BLACK);
			}
			
			if(me.getSource() == reset){
			reset.setBackground(color);
			reset.setForeground(Color.BLACK);
			}
		}
                @Override
		public void mouseClicked(MouseEvent me)
		{
			
		}
                @Override
		public void mouseReleased(MouseEvent me)
		{
			
		}
                @Override
		public void mousePressed(MouseEvent me)
		{
			
		}
		//mouse events end here
		
		
		//inner class within action event, for timer task
		class RemindTask extends TimerTask{
                        @Override
			public void run(){
                            frame2.dispose();
                            mgr.flag=1;
                            page_2.setVisible(true);
                            page_2.setTitle("HOME PAGE");
                            page_2.setBounds(200,0,1000,700);
                            page_2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		}
		//inner class ends here.
	
}

