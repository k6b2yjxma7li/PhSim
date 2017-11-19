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
	//
	public MainMenu() throws HeadlessException {
		this.setLayout(new BorderLayout());
		//
		this.setJMenuBar(menuBar);
		menuBar.fastSimButton.setEnabled(false);
		menuBar.slowSimButton.setEnabled(false);
		menuBar.stopSimButton.setEnabled(false);
		menuBar.normSimButton.setEnabled(false);
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
			} 
		});
		menuBar.slowSimButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menuBar.slowSimButton.setEnabled(false);
				menuBar.fastSimButton.setEnabled(true);
				menuBar.normSimButton.setEnabled(true);
			}
		});
		menuBar.fastSimButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menuBar.fastSimButton.setEnabled(false);
				menuBar.slowSimButton.setEnabled(true);
				menuBar.normSimButton.setEnabled(true);
			}
		});
		menuBar.normSimButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menuBar.fastSimButton.setEnabled(true);
				menuBar.slowSimButton.setEnabled(true);
				menuBar.normSimButton.setEnabled(false);
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