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
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainMenu extends JFrame {
	public JPanel mainPanel = new JPanel();
	public MenuBar menuBar = new MenuBar("EN");
	public AnimationPanel animation = new AnimationPanel();
	public PhysicalBody ball = new PhysicalBody(100, 100);
	public void mainSetter() {
		ball.reset();
		ball.setAy(9.80655/2);
		ball.setX(10);
		ball.setY(600);
		/*
		ball.setVx(20);
		ball.setVy(-50);
		*/
		ball.setVelVector(70, -60);
		animation.ball = ball;
	}
	//
	public MainMenu() throws HeadlessException {
		this.setLayout(new BorderLayout());
		//
		this.setJMenuBar(menuBar);
		menuBar.fastSimButton.setEnabled(false);
		menuBar.slowSimButton.setEnabled(false);
		menuBar.stopSimButton.setEnabled(false);
		menuBar.normSimButton.setEnabled(false);
		this.add(mainPanel);
		//
		menuBar.exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(DISPOSE_ON_CLOSE);
			}
		});
		menuBar.startSimButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menuBar.startSimButton.setEnabled(false);
				menuBar.fastSimButton.setEnabled(true);
				menuBar.slowSimButton.setEnabled(true);
				menuBar.stopSimButton.setEnabled(true);
				mainPanel.remove(animation);
				mainPanel.repaint();
				animation.timer.stop();
				animation.setSize(mainPanel.getWidth(),mainPanel.getHeight());
				mainPanel.add(animation);
				mainSetter();
				animation.timer.start();
				animation.repaint();
			}
		});
		menuBar.stopSimButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menuBar.startSimButton.setEnabled(true);
				menuBar.fastSimButton.setEnabled(false);
				menuBar.slowSimButton.setEnabled(false);
				menuBar.stopSimButton.setEnabled(false);
				menuBar.normSimButton.setEnabled(false);
				mainPanel.remove(animation);
				mainPanel.removeAll();
				mainPanel.repaint();
				animation.timer.stop();
				mainSetter();
			} 
		});
		menuBar.slowSimButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menuBar.slowSimButton.setEnabled(false);
				menuBar.fastSimButton.setEnabled(true);
				menuBar.normSimButton.setEnabled(true);
				animation.timer.setDelay(20);
			}
		});
		menuBar.fastSimButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menuBar.fastSimButton.setEnabled(false);
				menuBar.slowSimButton.setEnabled(true);
				menuBar.normSimButton.setEnabled(true);
				animation.timer.setDelay(5);
			}
		});
		menuBar.normSimButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menuBar.fastSimButton.setEnabled(true);
				menuBar.slowSimButton.setEnabled(true);
				menuBar.normSimButton.setEnabled(false);
				animation.timer.setDelay(10);
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