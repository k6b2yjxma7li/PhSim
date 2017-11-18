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
	int xSize = 1;
	int ySize = 1;
	double dT = 0;
	int wait = 1;
	int counter = 0;
	Timer timer = new Timer(wait, this);
	PhysicalBody ball;//expected initialization in main class
	//default constructor
	public AnimationPanel() {
		dT = 0.001;
		counter = 0;
	}
	//main constructor
	public AnimationPanel(double timeStep, int waitTime, PhysicalBody point) {
		dT = timeStep;
		wait = waitTime;
		ball = new PhysicalBody(point);//expected to be initialized in main class
	}
	//setters
	void setDTime(double timeStep) {
		dT = timeStep;
	}
	void setWaiTime(int waitTime) {
		wait = waitTime;
	}
	//painter
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		g.fillOval((int)ball.getX(), (int)ball.getY(), 5, 5);
		timer.start();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		counter++;
	}
}