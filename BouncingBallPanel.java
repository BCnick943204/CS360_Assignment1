//Nick Passantino
//CS360 Assignment 1
// Professor Serce
// 01/23/2019
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.event.*;
import java.util.Random;
import javax.swing.JPanel;

public class BouncingBallPanel extends JPanel implements MouseListener {

    private ArrayList<BallGUIComponent> balls = new ArrayList<BallGUIComponent>();

    public BouncingBallPanel(){
	this.addMouseListener(this); //add a MouseListener to allow the class to
	                             //detect when the mouse clicks

    }

    //Draw the balls
    public void paint(Graphics g) {
	super.paint(g);
	BallGUIComponent ball;
	for(int i=0; i<balls.size(); i++){
	    ball = balls.get(i);
	    //set the color of the ball
	    g.setColor(ball.getColor());
	    //draw the ball
	    g.fillOval(ball.getX(), ball.getY(),ball.getDiameter(), ball.getDiameter());
	    }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    //Spawn a ball if the mouse clicks on the panel
    @Override
    public void mousePressed(MouseEvent e) {
	Random random = new Random();
	//the range given to Random.nextInt will produce balls between 10-50 in size
	BallGUIComponent ball = new BallGUIComponent((random.nextInt(41)+10), this, e.getX(), e.getY());
	balls.add(ball);
	System.out.println("Creating Ball at (" + e.getX() + "," +e.getY() + ")");
	ball.start();

    }
    @Override
    public void mouseReleased(MouseEvent e) {

    }
    

}
