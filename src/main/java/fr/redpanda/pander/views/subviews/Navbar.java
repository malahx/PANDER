/**
 * 
 */
package fr.redpanda.pander.views.subviews;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class Navbar extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9170488463090549030L;

	private JLabel lblLogopander;
	private JLabel lblLogouser;
	private JPanel pnlNav;
	private JPanel pnlButton;
	private JPanel panel;
	private JLabel lblPander;
	private JLabel lblUser;

	/**
	 * @return the lblLogopander
	 */
	public JLabel getLblLogopander() {
		return lblLogopander;
	}

	/**
	 * @param lblLogopander
	 *            the lblLogopander to set
	 */
	public void setLblLogopander(JLabel lblLogopander) {
		this.lblLogopander = lblLogopander;
	}

	/**
	 * @return the lblLogouser
	 */
	public JLabel getLblLogouser() {
		return lblLogouser;
	}

	/**
	 * @param lblLogouser
	 *            the lblLogouser to set
	 */
	public void setLblLogouser(JLabel lblLogouser) {
		this.lblLogouser = lblLogouser;
	}

	/**
	 * @return the pnlNav
	 */
	public JPanel getPnlNav() {
		return pnlNav;
	}

	/**
	 * @param pnlNav
	 *            the pnlNav to set
	 */
	public void setPnlNav(JPanel pnlNav) {
		this.pnlNav = pnlNav;
	}

	/**
	 * @return the pnlButton
	 */
	public JPanel getPnlButton() {
		return pnlButton;
	}

	/**
	 * @param pnlButton
	 *            the pnlButton to set
	 */
	public void setPnlButton(JPanel pnlButton) {
		this.pnlButton = pnlButton;
	}

	/**
	 * @return the panel
	 */
	public JPanel getPanel() {
		return panel;
	}

	/**
	 * @param panel
	 *            the panel to set
	 */
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	/**
	 * @return the lblPander
	 */
	public JLabel getLblPander() {
		return lblPander;
	}

	/**
	 * @param lblPander
	 *            the lblPander to set
	 */
	public void setLblPander(JLabel lblPander) {
		this.lblPander = lblPander;
	}

	/**
	 * @return the lblUser
	 */
	public JLabel getLblUser() {
		return lblUser;
	}

	/**
	 * @param lblUser
	 *            the lblUser to set
	 */
	public void setLblUser(JLabel lblUser) {
		this.lblUser = lblUser;
	}

	/**
	 * Create the panel.
	 */
	public Navbar() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0 };
		setLayout(gridBagLayout);

		lblLogopander = new JLabel("logoPander");
		GridBagConstraints gbc_lblLogopander = new GridBagConstraints();
		gbc_lblLogopander.fill = GridBagConstraints.VERTICAL;
		gbc_lblLogopander.insets = new Insets(0, 0, 0, 5);
		gbc_lblLogopander.gridx = 0;
		gbc_lblLogopander.gridy = 0;
		add(lblLogopander, gbc_lblLogopander);

		pnlNav = new JPanel();
		GridBagConstraints gbc_pnlNav = new GridBagConstraints();
		gbc_pnlNav.insets = new Insets(0, 0, 0, 5);
		gbc_pnlNav.fill = GridBagConstraints.BOTH;
		gbc_pnlNav.gridx = 1;
		gbc_pnlNav.gridy = 0;
		add(pnlNav, gbc_pnlNav);
		GridBagLayout gbl_pnlNav = new GridBagLayout();
		gbl_pnlNav.columnWidths = new int[] { 0, 0 };
		gbl_pnlNav.rowHeights = new int[] { 0, 0 };
		gbl_pnlNav.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_pnlNav.rowWeights = new double[] { 1.0, 0.0 };
		pnlNav.setLayout(gbl_pnlNav);

		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		pnlNav.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0 };
		gbl_panel.rowHeights = new int[] { 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 0.0 };
		gbl_panel.rowWeights = new double[] { 0.0 };
		panel.setLayout(gbl_panel);

		lblPander = new JLabel("PANDER");
		lblPander.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblPander = new GridBagConstraints();
		gbc_lblPander.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblPander.insets = new Insets(0, 0, 0, 5);
		gbc_lblPander.gridx = 0;
		gbc_lblPander.gridy = 0;
		panel.add(lblPander, gbc_lblPander);

		lblUser = new JLabel("User");
		lblUser.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblUser = new GridBagConstraints();
		gbc_lblUser.insets = new Insets(0, 0, 0, 5);
		gbc_lblUser.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblUser.gridx = 1;
		gbc_lblUser.gridy = 0;
		panel.add(lblUser, gbc_lblUser);

		pnlButton = new JPanel();
		GridBagConstraints gbc_pnlButton = new GridBagConstraints();
		gbc_pnlButton.insets = new Insets(0, 0, 5, 0);
		gbc_pnlButton.fill = GridBagConstraints.BOTH;
		gbc_pnlButton.gridx = 0;
		gbc_pnlButton.gridy = 1;
		pnlNav.add(pnlButton, gbc_pnlButton);
		pnlButton.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JToggleButton tglbtnHome = new JToggleButton("Accueil");
		pnlButton.add(tglbtnHome);

		JToggleButton tglbtnProfile = new JToggleButton("Profile");
		pnlButton.add(tglbtnProfile);

		JToggleButton tglbtnMatching = new JToggleButton("Matching");
		pnlButton.add(tglbtnMatching);

		lblLogouser = new JLabel("LogoUser");
		GridBagConstraints gbc_lblLogouser = new GridBagConstraints();
		gbc_lblLogouser.fill = GridBagConstraints.VERTICAL;
		gbc_lblLogouser.gridx = 2;
		gbc_lblLogouser.gridy = 0;
		add(lblLogouser, gbc_lblLogouser);

	}

}
