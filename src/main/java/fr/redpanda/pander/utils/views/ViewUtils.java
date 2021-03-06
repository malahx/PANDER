/**
 * 
 */
package fr.redpanda.pander.utils.views;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fr.redpanda.pander.utils.constant.Img;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class ViewUtils {

	/**
	 * Configure the jFrame and the jPanel
	 * 
	 * @param frame
	 *            a JFrame to configure
	 * @param panel
	 *            a JPanel to add to the frame
	 * 
	 */
	public static void configure(JFrame frame, JPanel panel) {
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(panel);
		ColorUtils.colorWhite(panel);
	}

	/**
	 * Configure the jFrame and the jPanel
	 * 
	 * @param frame
	 *            a JFrame to configure
	 * @param jPanel
	 *            a JPanel to add to the frame
	 * 
	 */
	public static void configure(JFrame frame) {
		int frameWidth = 1000;
		int frameHeight = 600;
		int maxFrameWidth = 1500;
		int maxFrameHeight = 900;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setMinimumSize(new Dimension(frameWidth, frameHeight));
		frame.setMaximumSize(new Dimension(maxFrameWidth, maxFrameHeight));
		ImageIcon icon = new ImageIcon(Img.APP_ICON);
		frame.setIconImage(icon.getImage());
		center(frame);
	}

	/**
	 * Center a frame
	 * 
	 * @param frame
	 */
	public static void center(JFrame frame) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = (int) screenSize.getWidth();
		int screenHeight = (int) screenSize.getHeight();
		int posWidth = (screenWidth - frame.getWidth()) / 2;
		int posHeight = (screenHeight - frame.getHeight()) / 2;
		frame.setBounds(posWidth, posHeight, frame.getWidth(), frame.getHeight());
	}

	/**
	 * Center a frame with the dimension of an other frame
	 * 
	 * @param mainFrame
	 * @param frame
	 */
	public static void center(JFrame mainFrame, JFrame frame) {
		int posWidth = mainFrame.getX() + (mainFrame.getWidth() - frame.getWidth()) / 2;
		int posHeight = mainFrame.getY() + (mainFrame.getHeight() - frame.getHeight()) / 2;
		frame.setBounds(posWidth, posHeight, frame.getWidth(), frame.getHeight());
	}

}
