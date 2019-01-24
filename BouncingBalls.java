//Nick Passantino
//CS360 Assignment 1
// Professor Serce
// 01/23/2019

import java.awt.Dimension;
import java.awt.event.*;
import java.util.*;
import java.util.Random;
import javax.swing.JFrame;
import java.util.ArrayList;
import javax.swing.Timer;

public class BouncingBalls {

    private JFrame frm = new JFrame();
    private BouncingBallPanel pnl = new BouncingBallPanel();

    public BouncingBalls(){
	pnl.setPreferredSize(new Dimension(500, 500));
	frm.add(pnl);
	frm.setVisible(true);
	frm.pack();
	frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	//Set a timer to update the panel
	Timer timer = new Timer(1,new ActionListener(){ 
		@Override
		public void actionPerformed(ActionEvent a){
		    pnl.repaint();
		}
	    });

	timer.start();
	
    }

			
    
    
    public static void main(String[] args) {
	BouncingBalls bbs = new BouncingBalls();
    }
    
}
