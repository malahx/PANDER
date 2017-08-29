/**
 * 
 */
package fr.redpanda.pander.views.subviews;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.redpanda.pander.utils.views.ViewUtils;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class Footer extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8490956596546449622L;

	private JLabel lblCopyright;
	private JButton btnLogout;
	private JButton btnExit;

	/**
	 * @return the lblCopyright
	 */
	public JLabel getLblCopyright() {
		return lblCopyright;
	}

	/**
	 * @param lblCopyright
	 *            the lblCopyright to set
	 */
	public void setLblCopyright(JLabel lblCopyright) {
		this.lblCopyright = lblCopyright;
	}

	/**
	 * @return the btnLogout
	 */
	public JButton getBtnLogout() {
		return btnLogout;
	}

	/**
	 * @param btnLogout
	 *            the btnLogout to set
	 */
	public void setBtnLogout(JButton btnLogout) {
		this.btnLogout = btnLogout;
	}

	/**
	 * @return the btnExit
	 */
	public JButton getBtnExit() {
		return btnExit;
	}

	/**
	 * @param btnExit
	 *            the btnExit to set
	 */
	public void setBtnExit(JButton btnExit) {
		this.btnExit = btnExit;
	}

	/**
	 * Create the panel.
	 */
	public Footer() {

		ViewUtils.colorGrey(this);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 0.0 };
		gridBagLayout.rowWeights = new double[] { 0.0 };
		setLayout(gridBagLayout);

		lblCopyright = new JLabel("PANDER Copyright (c) RedPanda 2017");
		GridBagConstraints gbc_lblCopyright = new GridBagConstraints();
		gbc_lblCopyright.anchor = GridBagConstraints.WEST;
		gbc_lblCopyright.gridx = 0;
		gbc_lblCopyright.gridy = 0;
		add(lblCopyright, gbc_lblCopyright);

		btnLogout = new JButton("Déconnexion");
		GridBagConstraints gbc_btnLogout = new GridBagConstraints();
		gbc_btnLogout.anchor = GridBagConstraints.EAST;
		gbc_btnLogout.insets = new Insets(0, 0, 0, 5);
		gbc_btnLogout.gridx = 1;
		gbc_btnLogout.gridy = 0;
		add(btnLogout, gbc_btnLogout);

		btnExit = new JButton("Quitter");
		GridBagConstraints gbc_btnExit = new GridBagConstraints();
		gbc_btnExit.anchor = GridBagConstraints.EAST;
		gbc_btnLogout.insets = new Insets(0, 0, 5, 0);
		gbc_btnExit.gridx = 2;
		gbc_btnExit.gridy = 0;
		add(btnExit, gbc_btnExit);

	}

}
