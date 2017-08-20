/**
 * 
 */
package fr.redpanda.pander.utils.views;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class ViewUtils {

	/**
	 * Configure the jFrame and the jPanel
	 * @param frame a JFrame to configure
	 * @param panel a JPanel to add to the frame
	 * 
	 */
	public static void configure(JFrame frame, JPanel panel) {
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(panel);
	}
	
	/**
	 * Configure the jFrame and the jPanel
	 * @param frame a JFrame to configure
	 * @param jPanel a JPanel to add to the frame
	 * 
	 */
	public static void configure(JFrame frame) {
		int frameWidth = 800;
		int frameHeight = 600;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = (int) screenSize.getWidth();
		int screenHeight = (int) screenSize.getHeight();
		int posWidth = (screenWidth - frameWidth) / 2;
		int posHeight = (screenHeight - frameHeight) / 2;
		
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setBounds(posWidth, posHeight, frameWidth, frameHeight);
	}

}
