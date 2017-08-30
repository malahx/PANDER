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
	 * 
	 */
	private PopupManager() {
	}
	
	public static void message(String title, String msg) {
		JOptionPane.showMessageDialog(null, msg, "PANDER : " + title, JOptionPane.INFORMATION_MESSAGE);
	}

}
