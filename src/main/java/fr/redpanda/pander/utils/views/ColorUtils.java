/**
 * 
 */
package fr.redpanda.pander.utils.views;

import javax.swing.JComponent;

import fr.redpanda.pander.utils.constant.PanderColor;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class ColorUtils {

	/**
	 * Configure the color of the component
	 * 
	 * @param component
	 *            a JComponent to configure
	 * 
	 */
	public static void colorNormal(JComponent component) {
		component.setBackground(PanderColor.NORMAL);
	}

	/**
	 * Configure the color of the component
	 * 
	 * @param component
	 *            a JComponent to configure
	 * 
	 */
	public static void colorDark(JComponent component) {
		component.setBackground(PanderColor.DARK);
	}

	/**
	 * Configure the color of the component
	 * 
	 * @param component
	 *            a JPanel to configure
	 * 
	 */
	public static void colorLight(JComponent component) {
		component.setBackground(PanderColor.LIGHT);
	}

	/**
	 * Configure the color of the component
	 * 
	 * @param component
	 *            a JComponent to configure
	 * 
	 */
	public static void colorGrey(JComponent component) {
		component.setBackground(PanderColor.GREY);
	}

	/**
	 * Configure the color of the component
	 * 
	 * @param component
	 *            a JComponent to configure
	 * 
	 */
	public static void colorGreyLight(JComponent component) {
		component.setBackground(PanderColor.GREY_LIGHT);
	}

	/**
	 * Configure the color of the component
	 * 
	 * @param component
	 *            a JComponent to configure
	 * 
	 */
	public static void colorWhite(JComponent component) {
		component.setBackground(PanderColor.WHITE);
	}

	/**
	 * @param component
	 */
	public static void colorTextWhite(JComponent component) {
		component.setForeground(PanderColor.WHITE);
	}

}
