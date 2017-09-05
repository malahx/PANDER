/**
 * 
 */
package fr.redpanda.pander.views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import fr.redpanda.pander.utils.constant.Img;
import fr.redpanda.pander.views.base.MainView;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class HomeView extends MainView {

	private JLabel lblInfo;
	private JLabel lblText;
	private JLabel lblLogoMatching;
	private JLabel lblLogoimie;

	/**
	 * @return the lblInfo
	 */
	public JLabel getLblInfo() {
		return lblInfo;
	}

	/**
	 * @param lblInfo
	 *            the lblInfo to set
	 */
	public void setLblInfo(JLabel lblInfo) {
		this.lblInfo = lblInfo;
	}

	/**
	 * @return the lblText
	 */
	public JLabel getLblText() {
		return lblText;
	}

	/**
	 * @param lblText
	 *            the lblText to set
	 */
	public void setLblText(JLabel lblText) {
		this.lblText = lblText;
	}

	/**
	 * @return the lblLogoMatching
	 */
	public JLabel getLblLogoMatching() {
		return lblLogoMatching;
	}

	/**
	 * @param lblLogoMatching
	 *            the lblLogoMatching to set
	 */
	public void setLblLogoMatching(JLabel lblLogoMatching) {
		this.lblLogoMatching = lblLogoMatching;
	}

	/**
	 * @return the lblLogoimie
	 */
	public JLabel getLblLogoimie() {
		return lblLogoimie;
	}

	/**
	 * @param lblLogoimie
	 *            the lblLogoimie to set
	 */
	public void setLblLogoimie(JLabel lblLogoimie) {
		this.lblLogoimie = lblLogoimie;
	}

	/**
	 * Create the panel.
	 */
	public HomeView() {
		super();

		super.pageName = "Accueil";

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		getPnlContent().setLayout(gridBagLayout);

		lblInfo = new JLabel("Bienvenue sur PANDER");

		GridBagConstraints gbc_lblInfo = new GridBagConstraints();
		gbc_lblInfo.insets = new Insets(0, 0, 5, 0);
		gbc_lblInfo.gridx = 0;
		gbc_lblInfo.gridy = 0;
		getPnlContent().add(lblInfo, gbc_lblInfo);
		lblText = new JLabel("<html>Ce logiciel est un outil de matching qui va vous permettre de<br>"
				+ "valoriser votre profil et vos compétences en informatique<br>"
				+ "auprès des entreprises de la région.<br><br>"
				+ "Compléter votre profil et répondez à notre questionnaire afin<br>"
				+ "de pouvoir lancer le système de mise en relation.");
		GridBagConstraints gbc_lblText = new GridBagConstraints();
		gbc_lblText.anchor = GridBagConstraints.NORTH;
		gbc_lblText.insets = new Insets(0, 0, 5, 0);
		gbc_lblText.gridx = 0;
		gbc_lblText.gridy = 1;
		getPnlContent().add(lblText, gbc_lblText);

		JLabel lblLogoMatching = new JLabel();
		ImageIcon matchingIcon = new ImageIcon(Img.MATCHING2);
		lblLogoMatching.setIcon(matchingIcon);
		GridBagConstraints gbc_lblLogoMatching = new GridBagConstraints();
		gbc_lblLogoMatching.insets = new Insets(0, 0, 5, 0);
		gbc_lblLogoMatching.gridx = 0;
		gbc_lblLogoMatching.gridy = 2;
		getPnlContent().add(lblLogoMatching, gbc_lblLogoMatching);

		lblLogoimie = new JLabel("LogoIMIE");
		JLabel lblLogoImie = new JLabel();
		ImageIcon imieIcon = new ImageIcon(Img.LOGO_IMIE_S);
		lblLogoImie.setIcon(imieIcon);
		GridBagConstraints gbc_lblLogoImie = new GridBagConstraints();
		gbc_lblLogoImie.anchor = GridBagConstraints.EAST;
		gbc_lblLogoImie.gridx = 0;
		gbc_lblLogoImie.gridy = 3;
		getPnlContent().add(lblLogoImie, gbc_lblLogoImie);

	}

}
