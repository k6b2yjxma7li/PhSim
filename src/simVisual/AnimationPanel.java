/**
 * @author rumcajs
 * @version 18.11.2017
 */
package simVisual;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

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
	public AnimationPanel() throws FileNotFoundException {
	}
	//
	Timer tm = new Timer(step,this);
	//
	public void propCalc() {
		ball.calcPosition(dT);
		ball.calcBoundaries(980, 640);
	}
	//
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		g.fillOval((int)ball.getX(), (int)ball.getY(), 5, 5);
		tm.start();
	}
	//
	@Override
	public void actionPerformed(ActionEvent e) {
		propCalc();
		repaint();
		counter++;
	}
}
