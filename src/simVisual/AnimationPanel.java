/**
 * @author rumcajs
 * @version 18.11.2017
 */
package simVisual;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class AnimationPanel extends JPanel implements ActionListener{
	int xSize = 640;
	int ySize = 480;
	double dT = 0.001;
	int wait = 1;
	int counter = 0;
	Timer timer = new Timer(wait, this);
	PhysicalBody ball = new PhysicalBody();//expected initialization in main class
	//default constructor
	public AnimationPanel() {
		dT = 0.001;
		counter = 0;
		wait = 1;
		xSize = 1;
		ySize = 1;
	}
	//main constructor
	public AnimationPanel(double timeStep, int waitTime, PhysicalBody point, int X, int Y) {
		dT = timeStep;
		wait = waitTime;
		ball = new PhysicalBody(point);//expected to be initialized in main class
		xSize = X;
		ySize = Y;
	}
	//setters
	public void setDTime(double timeStep) {
		dT = timeStep;
	}
	public void setWaiTime(int waitTime) {
		wait = waitTime;
	}
	public void setDim(int xS, int yS) {
		xSize = xS;
		ySize = yS;
	}
	//painter
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		g.fillOval((int)ball.getX(), (int)ball.getY(), 5, 5);
		timer.start();
	}
	public void clclt(PhysicalBody point, double Force, double angle) {
		point.calcPosition(dT);
		point.calcVel(dT);
		point.calcAcc(Force, angle);
		point.calcBoundaries(xSize, ySize);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		this.setVisible(true);
		clclt(ball, 0, 0);
		repaint();
		counter++;
	}
}