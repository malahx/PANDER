/**
 * 
 */
package fr.redpanda.pander.views.subviews;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public abstract class Sidebar extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3102325959457435902L;

	JButton btnTelechargCV;

	/**
	 * @return the btnTelechargCV
	 */
	public JButton getBtnTelechargCV() {
		return btnTelechargCV;
	}

	/**
	 * @param btnTelechargCV
	 *            the btnTelechargCV to set
	 */
	public void setBtnTelechargCV(JButton btnTelechargCV) {
		this.btnTelechargCV = btnTelechargCV;
	}

}
