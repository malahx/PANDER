/**
 * 
 */
package fr.redpanda.pander.utils;

import javax.swing.JOptionPane;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class PopupManager {

	/**
	 * The private constructor
	 */
	private PopupManager() {
	}

	/**
	 * Create a popup with a title and a message
	 * 
	 * @param title
	 * @param msg
	 */
	public static void message(String title, String msg) {
		JOptionPane.showMessageDialog(null, msg, "PANDER : " + title, JOptionPane.INFORMATION_MESSAGE);
	}

}
