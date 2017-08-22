/**
 * 
 */
package fr.redpanda.pander.views;

import java.awt.GridBagLayout;
import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

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
	 * Create the panel.
	 */
	public HomeView() {
		super();
		
		super.pageName = "Accueil";
		
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
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
				+ "Compléter votre profil et répondez à notre questionnaires afin<br>de pouvoir lancer le système de mise en relation.");
		GridBagConstraints gbc_lblText = new GridBagConstraints();
		gbc_lblText.anchor = GridBagConstraints.NORTH;
		gbc_lblText.insets = new Insets(0, 0, 5, 0);
		gbc_lblText.gridx = 0;
		gbc_lblText.gridy = 1;
		getPnlContent().add(lblText, gbc_lblText);
		
		lblLogoMatching = new JLabel("Logo MATCHING");
		GridBagConstraints gbc_lblLogoMatching = new GridBagConstraints();
		gbc_lblLogoMatching.insets = new Insets(0, 0, 5, 0);
		gbc_lblLogoMatching.gridx = 0;
		gbc_lblLogoMatching.gridy = 2;
		getPnlContent().add(lblLogoMatching, gbc_lblLogoMatching);
		
		lblLogoimie = new JLabel("LogoIMIE");
		GridBagConstraints gbc_lblLogoimie = new GridBagConstraints();
		gbc_lblLogoimie.anchor = GridBagConstraints.EAST;
		gbc_lblLogoimie.gridx = 0;
		gbc_lblLogoimie.gridy = 3;
		getPnlContent().add(lblLogoimie, gbc_lblLogoimie);

	}

}
