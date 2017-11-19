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
public class AnimationPanel extends JPanel implements ActionListener {
	int step = 10;
	double dT = 0.001;
	int counter = 0;
	public PhysicalBody ball;
	//
	public int getCounter() {
		return counter;
	}
	//
	Timer timer = new Timer(step,this);
	//
	public void propCalc() {
		ball.calcVel(dT*counter);
		ball.calcPosition(dT*counter);
		ball.calcBoundaries(960, 600);
	}
	//
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		g.fillOval((int)ball.getX(), (int)ball.getY(), 20, 20);
		timer.start();
	}
	//
	@Override
	public void actionPerformed(ActionEvent e) {
		propCalc();
		repaint();
		counter++;
	}
}
