/**
 * @author rumcajs
 * @version 16.11.2017
 * Content pane settings
 */
package simVisual;

import java.awt.Color;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ContentPanel extends JPanel {
	int border = 100;
	public ContentPanel(int xDim, int yDim) {
		this.setVisible(true);
		if((xDim<border)&&(yDim<border)) {
			this.setSize(xDim-border, yDim-border);
		}else {
			this.setSize(xDim, yDim);
		}
		this.setBackground(Color.WHITE);
	}

}
