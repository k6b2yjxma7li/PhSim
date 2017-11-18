/**
 * @author rumcajs
 * @version 16.11.2017
 * Main window class
 */
package simVisual;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MainMenu extends JFrame {
	public MenuBar menuBar = new MenuBar("EN");
	//public ContentPanel mainPanel;
	public AnimationPanel animation = new AnimationPanel();
	public PhysicalBody ball = new PhysicalBody();
	public void parameterSet(int X, int Y, double xV, double yV, double Rad, double F, double angl) {
		ball.setRad(Rad);
		ball.setVx(xV);
		ball.setVy(yV);
		ball.setX(X);
		ball.setY(Y);
		ball.setAx(0);
		ball.setAy(9.80655);
	}
	//
	public MainMenu() throws HeadlessException {
		this.setLayout(new BorderLayout());
		//
		//mainPanel = new ContentPanel(this.getWidth(), this.getHeight());
		this.setJMenuBar(menuBar);
		this.add(animation);
		//this.add(mainPanel, BorderLayout.CENTER);
		//mainPanel.setVisible(true);
		//mainPanel.add(animation);
		menuBar.fastSimButton.setEnabled(false);
		menuBar.slowSimButton.setEnabled(false);
		menuBar.stopSimButton.setEnabled(false);
		menuBar.exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(DISPOSE_ON_CLOSE);
			}
		});
		menuBar.startSimButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				parameterSet(300, 500, 1.0, 1.0, 5.0, 0, 0);
				animation = new AnimationPanel();
				animation.timer.stop();
				//mainPanel.remove(animation);
				//mainPanel.repaint();
				animation.timer.start();
				animation.repaint();
				menuBar.startSimButton.setEnabled(false);
				menuBar.fastSimButton.setEnabled(true);
				menuBar.slowSimButton.setEnabled(true);
				menuBar.stopSimButton.setEnabled(true);
			}
		});
		menuBar.stopSimButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menuBar.startSimButton.setEnabled(true);
				menuBar.fastSimButton.setEnabled(false);
				menuBar.slowSimButton.setEnabled(false);
				menuBar.stopSimButton.setEnabled(false);
				animation.timer.stop();
				//mainPanel.repaint();
				animation.repaint();
			} 
		});
		menuBar.slowSimButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menuBar.slowSimButton.setEnabled(false);
				menuBar.fastSimButton.setEnabled(true);
			}
		});
		menuBar.fastSimButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menuBar.fastSimButton.setEnabled(false);
				menuBar.slowSimButton.setEnabled(true);
			}
		});
	}
	public static void main(String[] args) {
		MainMenu menu = new MainMenu();
		menu.setVisible(true);
		menu.setVisible(true);
		menu.setSize(960, 640);
		menu.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}