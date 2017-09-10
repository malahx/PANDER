/**
 * 
 */
package fr.redpanda.pander.views.subviews;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

import fr.redpanda.pander.utils.constant.Img;
import fr.redpanda.pander.utils.views.ViewUtils;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class Navbar extends JPanel {

	private static final long serialVersionUID = -9170488463090549030L;

	private JToggleButton tglbtnProfile;
	private JToggleButton tglbtnHome;
	private JToggleButton tglbtnMatching;
	private JToggleButton tglbtnJob;
	private JToggleButton tglbtnPublicProfile;
	private JLabel lblLogopander;
	private JLabel lblLogouser;
	private JLabel lblPander;
	private JLabel lblUser;

	/**
	 * @return the tglbtnProfile
	 */
	public JToggleButton getTglbtnProfile() {
		return tglbtnProfile;
	}

	/**
	 * @param tglbtnProfile
	 *            the tglbtnProfile to set
	 */
	public void setTglbtnProfile(JToggleButton tglbtnProfile) {
		this.tglbtnProfile = tglbtnProfile;
	}

	/**
	 * @return the tglbtnHome
	 */
	public JToggleButton getTglbtnHome() {
		return tglbtnHome;
	}

	/**
	 * @param tglbtnHome
	 *            the tglbtnHome to set
	 */
	public void setTglbtnHome(JToggleButton tglbtnHome) {
		this.tglbtnHome = tglbtnHome;
	}

	/**
	 * @return the tglbtnMatching
	 */
	public JToggleButton getTglbtnMatching() {
		return tglbtnMatching;
	}

	/**
	 * @param tglbtnMatching
	 *            the tglbtnMatching to set
	 */
	public void setTglbtnMatching(JToggleButton tglbtnMatching) {
		this.tglbtnMatching = tglbtnMatching;
	}

	/**
	 * @return the tglbtnPublicProfile
	 */
	public JToggleButton getTglbtnPublicProfile() {
		return tglbtnPublicProfile;
	}

	/**
	 * @param tglbtnPublicProfile
	 *            the tglbtnPublicProfile to set
	 */
	public void setTglbtnPublicProfile(JToggleButton tglbtnPublicProfile) {
		this.tglbtnPublicProfile = tglbtnPublicProfile;
	}

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
	 * @return the tglbtnJob
	 */
	public JToggleButton getTglbtnJob() {
		return tglbtnJob;
	}

	/**
	 * @param tglbtnJob
	 *            the tglbtnJob to set
	 */
	public void setTglbtnJob(JToggleButton tglbtnJob) {
		this.tglbtnJob = tglbtnJob;
	}

	/**
	 * Create the panel.
	 */
	public Navbar() {

		ViewUtils.colorWhite(this);

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0 };
		setLayout(gridBagLayout);

		JLabel lblLogopander = new JLabel();
		ImageIcon panderlogo = new ImageIcon(Img.LOGO_S);
		lblLogopander.setIcon(panderlogo);
		GridBagConstraints gbc_lblLogopander = new GridBagConstraints();
		gbc_lblLogopander.fill = GridBagConstraints.VERTICAL;
		gbc_lblLogopander.insets = new Insets(0, 0, 0, 5);
		gbc_lblLogopander.gridx = 0;
		gbc_lblLogopander.gridy = 0;
		add(lblLogopander, gbc_lblLogopander);

		JPanel pnlNav = new JPanel();
		GridBagConstraints gbc_pnlNav = new GridBagConstraints();
		gbc_pnlNav.insets = new Insets(0, 0, 0, 5);
		gbc_pnlNav.fill = GridBagConstraints.BOTH;
		gbc_pnlNav.gridx = 1;
		gbc_pnlNav.gridy = 0;
		add(pnlNav, gbc_pnlNav);
		GridBagLayout gbl_pnlNav = new GridBagLayout();
		gbl_pnlNav.columnWidths = new int[] { 0 };
		gbl_pnlNav.rowHeights = new int[] { 0 };
		gbl_pnlNav.columnWeights = new double[] { 1.0 };
		gbl_pnlNav.rowWeights = new double[] { 1.0 };
		pnlNav.setLayout(gbl_pnlNav);

		JPanel pnlHeader = new JPanel();
		GridBagConstraints gbc_pnlHeader = new GridBagConstraints();
		gbc_pnlHeader.insets = new Insets(0, 0, 5, 0);
		gbc_pnlHeader.fill = GridBagConstraints.WEST;
		gbc_pnlHeader.gridx = 0;
		gbc_pnlHeader.gridy = 0;
		pnlNav.add(pnlHeader, gbc_pnlHeader);
		GridBagLayout gbl_pnlHeader = new GridBagLayout();
		gbl_pnlHeader.columnWidths = new int[] { 50, 0 };
		gbl_pnlHeader.rowHeights = new int[] { 0 };
		gbl_pnlHeader.columnWeights = new double[] { 1.0, 0.0 };
		gbl_pnlHeader.rowWeights = new double[] { 0.0 };
		pnlHeader.setLayout(gbl_pnlHeader);

		JLabel lblPander = new JLabel();
		ImageIcon panderName = new ImageIcon(Img.TITLE_S);
		lblPander.setIcon(panderName);
		GridBagConstraints gbc_lblPander = new GridBagConstraints();
		gbc_lblPander.anchor = GridBagConstraints.WEST;
		gbc_lblPander.insets = new Insets(0, 0, 0, 0);
		gbc_lblPander.gridx = 0;
		gbc_lblPander.gridy = 0;
		pnlHeader.add(lblPander, gbc_lblPander);

		JLabel lblBanner = new JLabel();
		ImageIcon bandImage = new ImageIcon(Img.BANNER);
		lblBanner.setIcon(bandImage);
		GridBagConstraints gbc_lblBanner = new GridBagConstraints();
		gbc_lblBanner.anchor = GridBagConstraints.WEST;
		gbc_lblBanner.insets = new Insets(0, 60, 0, 5);
		gbc_lblBanner.gridx = 0;
		gbc_lblBanner.gridy = 0;
		pnlHeader.add(lblBanner, gbc_lblBanner);

		// JLabel pnlHeader = new JLabel();
		// ImageIcon bandImage = new ImageIcon(Img.BANNER);
		// pnlHeader.setIcon(bandImage);
		// GridBagConstraints gbc_pnlHeader = new GridBagConstraints();
		// gbc_pnlHeader.insets = new Insets(0, 0, 5, 0);
		// gbc_pnlHeader.fill = GridBagConstraints.WEST;
		// gbc_pnlHeader.gridx = 0;
		// gbc_pnlHeader.gridy = 0;
		// pnlNav.add(pnlHeader, gbc_pnlHeader);
		// GridBagLayout gbl_pnlHeader = new GridBagLayout();
		// gbl_pnlHeader.columnWidths = new int[] { 0, 0 };
		// gbl_pnlHeader.rowHeights = new int[] { 0 };
		// gbl_pnlHeader.columnWeights = new double[] { 1.0, 0.0 };
		// gbl_pnlHeader.rowWeights = new double[] { 0.0 };
		// pnlHeader.setLayout(gbl_pnlHeader);
		//
		// JLabel lblPander = new JLabel();
		// ImageIcon panderName = new ImageIcon(Img.TITLE_S);
		// lblPander.setIcon(panderName);
		// GridBagConstraints gbc_lblPander = new GridBagConstraints();
		// gbc_lblPander.anchor = GridBagConstraints.NORTHWEST;
		// gbc_lblPander.insets = new Insets(0, 0, 0, 5);
		// gbc_lblPander.gridx = 0;
		// gbc_lblPander.gridy = 0;
		// pnlHeader.add(lblPander, gbc_lblPander);

		// JLabel lblBanner = new JLabel();
		// ImageIcon bandImage = new ImageIcon(Img.BANNER);
		// lblBanner.setIcon(bandImage);
		// GridBagConstraints gbc_lblBanner = new GridBagConstraints();
		// gbc_lblBanner.anchor = GridBagConstraints.NORTHWEST;
		// gbc_lblBanner.insets = new Insets(0, 0, 0, 5);
		// gbc_lblBanner.gridx = 1;
		// gbc_lblBanner.gridy = 0;
		// pnlHeader.add(lblBanner, gbc_lblBanner);
		//
		// JLabel lblPander = new JLabel();
		// ImageIcon panderName = new ImageIcon(Img.TITLE_S);
		// lblPander.setIcon(panderName);
		// GridBagConstraints gbc_lblPander = new GridBagConstraints();
		// gbc_lblPander.anchor = GridBagConstraints.NORTHEAST;
		// gbc_lblPander.insets = new Insets(0, 0, 0, 5);
		// gbc_lblPander.gridx = 0;
		// gbc_lblPander.gridy = 0;
		// pnlHeader.add(lblPander, gbc_lblPander);

		lblUser = new JLabel("User");
		lblUser.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblUser = new GridBagConstraints();
		gbc_lblUser.insets = new Insets(0, 0, 0, 5);
		gbc_lblUser.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblUser.gridx = 1;
		gbc_lblUser.gridy = 0;
		pnlHeader.add(lblUser, gbc_lblUser);
		lblUser.setVisible(false);

		JPanel pnlButton = new JPanel();
		GridBagConstraints gbc_pnlButton = new GridBagConstraints();
		gbc_pnlButton.insets = new Insets(0, 0, 5, 0);
		gbc_pnlButton.fill = GridBagConstraints.BOTH;
		gbc_pnlButton.gridx = 0;
		gbc_pnlButton.gridy = 1;
		pnlNav.add(pnlButton, gbc_pnlButton);
		pnlButton.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		tglbtnHome = new JToggleButton("Accueil");
		pnlButton.add(tglbtnHome);

		tglbtnProfile = new JToggleButton("Profile");
		pnlButton.add(tglbtnProfile);

		tglbtnJob = new JToggleButton("Poste");
		tglbtnJob.setVisible(false);
		pnlButton.add(tglbtnJob);

		tglbtnMatching = new JToggleButton("Matching");
		pnlButton.add(tglbtnMatching);

		tglbtnPublicProfile = new JToggleButton("PublicProfile");
		tglbtnPublicProfile.setVisible(false);
		pnlButton.add(tglbtnPublicProfile);

		lblLogouser = new JLabel();
		ImageIcon logoUser = new ImageIcon(Img.HOME_CANDIDATE);
		lblLogouser.setIcon(logoUser);
		GridBagConstraints gbc_lblLogouser = new GridBagConstraints();
		gbc_lblLogouser.fill = GridBagConstraints.VERTICAL;
		gbc_lblLogouser.gridx = 2;
		gbc_lblLogouser.gridy = 0;
		add(lblLogouser, gbc_lblLogouser);

		ViewUtils.colorWhite(pnlButton);
		ViewUtils.colorWhite(pnlHeader);
		ViewUtils.colorWhite(pnlNav);
		ViewUtils.colorWhite(tglbtnHome);
		ViewUtils.colorWhite(tglbtnMatching);
		ViewUtils.colorWhite(tglbtnProfile);
		ViewUtils.colorWhite(tglbtnJob);

	}

}
