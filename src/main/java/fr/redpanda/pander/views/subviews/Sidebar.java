/**
 * 
 */
package fr.redpanda.pander.views.subviews;

import javax.swing.JPanel;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public abstract class Sidebar {
	
	protected JPanel contentPane;
	
	/**
	 * @return the contentPane
	 */
	public JPanel getContentPane() {
		return contentPane;
	}

	/**
	 * @param contentPane
	 *            the contentPane to set
	 */
	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}
	
}
