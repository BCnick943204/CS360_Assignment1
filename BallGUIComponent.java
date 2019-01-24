//Nick Passantino
//CS360 Assignment 1
// Professor Serce
// 01/23/2019
import java.util.Random;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.*;


public class BallGUIComponent extends Thread{

    private int diameter;
    private float x, y;
    private JPanel pnl;
    private Color color;
    private int xDirection, yDirection, velocityRange;

    BallGUIComponent(int diameter, JPanel pnl, int x, int y) {
	this.diameter = diameter;
	this.pnl = pnl;
	this.x = x - (diameter/2);
	this.y = y - (diameter/2);

	//initialize color

	Random random = new Random();
	float r, g, b, a;
	r = random.nextFloat();
	g = random.nextFloat();
	b = random.nextFloat();
	a = (random.nextFloat() *.5f) + .5f; //adjust the transparency
	color = new Color(r,g,b,a);
    }

    //Data retrieval methods
    public int getX(){
	return (int) x;
    }
    public int getY(){
	return (int) y;
    }
    public int getDiameter(){
	return diameter;
    }
    public Color getColor(){
	return color;
    }

    //update the velocity of the balls
    private void updateVelocity(){
	Random rand = new Random();
	velocityRange = 4;
	//the amount that will be added to each component for each
	//iteration of the timer
	xDirection = (rand.nextInt(2*velocityRange) - velocityRange) +1;
	yDirection = (rand.nextInt(2*velocityRange) - velocityRange) +1;
    }

    @Override
    public void run() {

	updateVelocity();
	
	while(true) {

	    x += xDirection;
	    y += yDirection;

	    //ball hits bottom of panel
	    if(x+diameter >= pnl.getWidth()) {
		updateVelocity();
		if(xDirection > 0){
		    xDirection *= -1;
		}

		//ball hits top of panel
	    } else if(x<= 0) {
		updateVelocity();
		if(xDirection < 0){
		    xDirection *= -1;
		}
		//ball hits right side of panel
	    } else if(y+diameter >= pnl.getHeight()){
		updateVelocity();

		if(yDirection > 0) {
		    yDirection *= -1;
		}
		//ball hits left side of panel
	    } else if(y <= 0) {
		updateVelocity();
		if(yDirection < 0) {
		    yDirection *= -1;
		}
	    }
	    
	    try{
		sleep(5);
	    } catch(InterruptedException i){
		System.out.println(i);
	    }
	}

    }


}
