/**
 * 
 */
package fr.redpanda.pander.utils.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class ViewUtils {

	private static final Color GREY_LIGHT = new Color(207, 207, 207);
	private static final Color GREY = new Color(158, 158, 158);
	private static final Color LIGHT = new Color(255, 192, 70);
	private static final Color NORMAL = new Color(255, 143, 0);
	private static final Color DARK = new Color(197, 96, 0);
	private static final Color WHITE = new Color(255, 255, 255);

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
		colorWhite(panel);
	}

	/**
	 * Configure the color of the component
	 * 
	 * @param component
	 *            a JComponent to configure
	 * 
	 */
	public static void colorDark(JComponent component) {
		component.setBackground(DARK);
	}

	/**
	 * Configure the color of the component
	 * 
	 * @param component
	 *            a JComponent to configure
	 * 
	 */
	public static void colorNormal(JComponent component) {
		component.setBackground(NORMAL);
	}

	/**
	 * Configure the color of the component
	 * 
	 * @param component
	 *            a JPanel to configure
	 * 
	 */
	public static void colorLight(JComponent component) {
		component.setBackground(LIGHT);
	}

	/**
	 * Configure the color of the component
	 * 
	 * @param component
	 *            a JComponent to configure
	 * 
	 */
	public static void colorGrey(JComponent component) {
		component.setBackground(GREY);
	}

	/**
	 * Configure the color of the component
	 * 
	 * @param component
	 *            a JComponent to configure
	 * 
	 */
	public static void colorGreyLight(JComponent component) {
		component.setBackground(GREY_LIGHT);
	}

	/**
	 * Configure the color of the component
	 * 
	 * @param component
	 *            a JComponent to configure
	 * 
	 */
	public static void colorWhite(JComponent component) {
		component.setBackground(WHITE);
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
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setMinimumSize(new Dimension(frameWidth, frameHeight));
		frame.setMaximumSize(new Dimension(maxFrameWidth, maxFrameHeight));
		center(frame);
	}

	public static void center(JFrame frame) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = (int) screenSize.getWidth();
		int screenHeight = (int) screenSize.getHeight();
		int posWidth = (screenWidth - frame.getWidth()) / 2;
		int posHeight = (screenHeight - frame.getHeight()) / 2;
		frame.setBounds(posWidth, posHeight, frame.getWidth(), frame.getHeight());
	}

	public static void center(JFrame mainFrame, JFrame frame) {
		int posWidth = mainFrame.getX() + (mainFrame.getWidth() - frame.getWidth()) / 2;
		int posHeight = mainFrame.getY() + (mainFrame.getHeight() - frame.getHeight()) / 2;
		frame.setBounds(posWidth, posHeight, frame.getWidth(), frame.getHeight());
	}

}
