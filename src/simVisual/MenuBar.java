/**
 * @author rumcajs
 * @version 16.11.2017
 * Menu bar class
 */
package simVisual;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class MenuBar extends JMenuBar {
	//MENUS
	public JMenu mainMenu;
	public JMenu simMenu;
	//Main menu
	public JMenuItem exitButton;
	//Simulation
	public JMenuItem startSimButton;
	public JMenuItem stopSimButton;
	public JMenuItem slowSimButton;
	public JMenuItem fastSimButton;
	//
	public MenuBar(String lang) {//EN - English, PL - Polish
		switch(lang) {
			case "EN":
			{
				mainMenu = new JMenu("File");
				simMenu = new JMenu("Simulation");
				//Main menu
				exitButton = new JMenuItem("Exit");
				//Simulation
				startSimButton = new JMenuItem("Start");
				stopSimButton = new JMenuItem("Stop");
				slowSimButton = new JMenuItem("Half speed");
				fastSimButton = new JMenuItem("Double speed");
				break;
			}
			case "PL":
			{
				mainMenu = new JMenu("Plik");
				simMenu = new JMenu("Symulacja");
				//Main menu
				exitButton = new JMenuItem("Wyjście");
				//Simulation
				startSimButton = new JMenuItem("Start");
				stopSimButton = new JMenuItem("Stop");
				slowSimButton = new JMenuItem("Połowa prędkości");
				fastSimButton = new JMenuItem("Dwukrotna prędkość");
				break;
			}
		}
		add(mainMenu);
		add(simMenu);
		//Main
		mainMenu.add(exitButton);
		//Simulation
		simMenu.add(startSimButton);
		simMenu.add(stopSimButton);
		simMenu.add(slowSimButton);
		simMenu.add(fastSimButton);
	}
}