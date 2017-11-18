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
	public MenuBar menuBar = new MenuBar("PL");
	public ContentPanel mainPanel;
	public AnimationPanel animation = new AnimationPanel();
	//
	public MainMenu() throws HeadlessException {
		this.setLayout(new BorderLayout());
		//
		mainPanel = new ContentPanel(this.getWidth(), this.getHeight());
		this.setJMenuBar(menuBar);
		this.add(mainPanel, BorderLayout.CENTER);
		mainPanel.setVisible(true);
		menuBar.exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(DISPOSE_ON_CLOSE);
			}
		});
		menuBar.startSimButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		menuBar.stopSimButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			} 
		});
		menuBar.slowSimButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		menuBar.fastSimButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
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