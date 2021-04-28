package atsmanager;

import javax.swing.*;
import java.awt.*;


public class DisplayManager{
	private Page1 page;
	public void showPage1()
	{      
		page.setVisible(true);
		page.setTitle("HOME PAGE");
		page.setBounds(200,0,1000,700);
		page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
        

    public DisplayManager(ATSManager Mgr) {
        page=new Page1(Mgr);
       // System.out.println(Mgr.filenames[0]+" "+Mgr.filenames[1]+" "+Mgr.filenames[2]+" "+Mgr.filenames[3]+" "+Mgr.filenames[4]);
    }
}