package fr.redpanda.pander.views.subviews;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;

public class SidebarPublic extends Sidebar {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5654665579388722049L;

	/**
	 * Create the frame.
	 */
	public SidebarPublic() {
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gbl_contentPane);

		JLabel lblPhoto = new JLabel("PHOTO");
		GridBagConstraints gbc_lblPhoto = new GridBagConstraints();
		gbc_lblPhoto.gridheight = 4;
		gbc_lblPhoto.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhoto.gridx = 1;
		gbc_lblPhoto.gridy = 1;
		add(lblPhoto, gbc_lblPhoto);

		JLabel lblName1 = new JLabel("Name 1");
		GridBagConstraints gbc_lblName1 = new GridBagConstraints();
		gbc_lblName1.anchor = GridBagConstraints.WEST;
		gbc_lblName1.gridwidth = 5;
		gbc_lblName1.insets = new Insets(0, 0, 5, 5);
		gbc_lblName1.gridx = 2;
		gbc_lblName1.gridy = 2;
		add(lblName1, gbc_lblName1);

		JLabel lblName2 = new JLabel("Name 2");
		GridBagConstraints gbc_lblName2 = new GridBagConstraints();
		gbc_lblName2.anchor = GridBagConstraints.WEST;
		gbc_lblName2.gridwidth = 6;
		gbc_lblName2.insets = new Insets(0, 0, 5, 0);
		gbc_lblName2.gridx = 2;
		gbc_lblName2.gridy = 3;
		add(lblName2, gbc_lblName2);

		JLabel lblDescriptionTitle = new JLabel("DESCRIPTION");
		lblDescriptionTitle.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GridBagConstraints gbc_lblDescriptionTitle = new GridBagConstraints();
		gbc_lblDescriptionTitle.anchor = GridBagConstraints.WEST;
		gbc_lblDescriptionTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescriptionTitle.gridx = 1;
		gbc_lblDescriptionTitle.gridy = 5;
		add(lblDescriptionTitle, gbc_lblDescriptionTitle);

		JLabel lblPresentation = new JLabel("Présentation");
		GridBagConstraints gbc_lblPresentation = new GridBagConstraints();
		gbc_lblPresentation.gridwidth = 6;
		gbc_lblPresentation.anchor = GridBagConstraints.WEST;
		gbc_lblPresentation.insets = new Insets(0, 0, 5, 5);
		gbc_lblPresentation.gridx = 1;
		gbc_lblPresentation.gridy = 6;
		add(lblPresentation, gbc_lblPresentation);

		JLabel lblCoordonateTittle = new JLabel("COORDONNEES");
		lblCoordonateTittle.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GridBagConstraints gbc_lblCoordonateTittle = new GridBagConstraints();
		gbc_lblCoordonateTittle.anchor = GridBagConstraints.WEST;
		gbc_lblCoordonateTittle.insets = new Insets(0, 0, 5, 5);
		gbc_lblCoordonateTittle.gridx = 1;
		gbc_lblCoordonateTittle.gridy = 8;
		add(lblCoordonateTittle, gbc_lblCoordonateTittle);

		JLabel lblAdress = new JLabel("Adresse");
		GridBagConstraints gbc_lblAdress = new GridBagConstraints();
		gbc_lblAdress.anchor = GridBagConstraints.WEST;
		gbc_lblAdress.gridwidth = 6;
		gbc_lblAdress.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdress.gridx = 1;
		gbc_lblAdress.gridy = 9;
		add(lblAdress, gbc_lblAdress);

		JLabel lblCp = new JLabel("Code Postal");
		GridBagConstraints gbc_lblCp = new GridBagConstraints();
		gbc_lblCp.anchor = GridBagConstraints.WEST;
		gbc_lblCp.insets = new Insets(0, 0, 5, 5);
		gbc_lblCp.gridx = 1;
		gbc_lblCp.gridy = 10;
		add(lblCp, gbc_lblCp);

		JLabel lblCity = new JLabel("Ville");
		GridBagConstraints gbc_lblCity = new GridBagConstraints();
		gbc_lblCity.anchor = GridBagConstraints.WEST;
		gbc_lblCity.gridwidth = 5;
		gbc_lblCity.insets = new Insets(0, 0, 5, 5);
		gbc_lblCity.gridx = 2;
		gbc_lblCity.gridy = 10;
		add(lblCity, gbc_lblCity);

		JLabel lblPhoneTitle = new JLabel("Téléphone :");
		lblPhoneTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		GridBagConstraints gbc_lblPhoneTitle = new GridBagConstraints();
		gbc_lblPhoneTitle.anchor = GridBagConstraints.EAST;
		gbc_lblPhoneTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhoneTitle.gridx = 1;
		gbc_lblPhoneTitle.gridy = 12;
		add(lblPhoneTitle, gbc_lblPhoneTitle);

		JLabel lblPhone = new JLabel("Téléphone");
		GridBagConstraints gbc_lblPhone = new GridBagConstraints();
		gbc_lblPhone.anchor = GridBagConstraints.WEST;
		gbc_lblPhone.gridwidth = 5;
		gbc_lblPhone.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhone.gridx = 2;
		gbc_lblPhone.gridy = 12;
		add(lblPhone, gbc_lblPhone);

		JLabel lblMailTitle = new JLabel("E-Mail :");
		lblMailTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		GridBagConstraints gbc_lblMailTitle = new GridBagConstraints();
		gbc_lblMailTitle.anchor = GridBagConstraints.EAST;
		gbc_lblMailTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblMailTitle.gridx = 1;
		gbc_lblMailTitle.gridy = 13;
		add(lblMailTitle, gbc_lblMailTitle);

		JLabel lblMail = new JLabel("Mail");
		GridBagConstraints gbc_lblMail = new GridBagConstraints();
		gbc_lblMail.gridwidth = 5;
		gbc_lblMail.anchor = GridBagConstraints.WEST;
		gbc_lblMail.insets = new Insets(0, 0, 5, 5);
		gbc_lblMail.gridx = 2;
		gbc_lblMail.gridy = 13;
		add(lblMail, gbc_lblMail);

		JLabel lblSocialLinks = new JLabel("SOCIAL LINKS");
		lblSocialLinks.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GridBagConstraints gbc_lblSocialLinks = new GridBagConstraints();
		gbc_lblSocialLinks.anchor = GridBagConstraints.WEST;
		gbc_lblSocialLinks.insets = new Insets(0, 0, 5, 5);
		gbc_lblSocialLinks.gridx = 1;
		gbc_lblSocialLinks.gridy = 15;
		add(lblSocialLinks, gbc_lblSocialLinks);

		JLabel lblLink1Title = new JLabel("Link 1 :");
		lblLink1Title.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		GridBagConstraints gbc_lblLink1Title = new GridBagConstraints();
		gbc_lblLink1Title.anchor = GridBagConstraints.EAST;
		gbc_lblLink1Title.insets = new Insets(0, 0, 5, 5);
		gbc_lblLink1Title.gridx = 1;
		gbc_lblLink1Title.gridy = 16;
		add(lblLink1Title, gbc_lblLink1Title);

		JLabel lblLink1 = new JLabel("Lien 1");
		GridBagConstraints gbc_lblLink1 = new GridBagConstraints();
		gbc_lblLink1.anchor = GridBagConstraints.WEST;
		gbc_lblLink1.gridwidth = 5;
		gbc_lblLink1.insets = new Insets(0, 0, 5, 5);
		gbc_lblLink1.gridx = 2;
		gbc_lblLink1.gridy = 16;
		add(lblLink1, gbc_lblLink1);

		JLabel lblLinkTitle = new JLabel("Link 2 / Contact :");
		lblLinkTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		GridBagConstraints gbc_lblLinkTitle = new GridBagConstraints();
		gbc_lblLinkTitle.anchor = GridBagConstraints.EAST;
		gbc_lblLinkTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblLinkTitle.gridx = 1;
		gbc_lblLinkTitle.gridy = 17;
		add(lblLinkTitle, gbc_lblLinkTitle);

		JLabel lblLink2 = new JLabel("Lien 2");
		GridBagConstraints gbc_lblLink2 = new GridBagConstraints();
		gbc_lblLink2.anchor = GridBagConstraints.WEST;
		gbc_lblLink2.gridwidth = 5;
		gbc_lblLink2.insets = new Insets(0, 0, 5, 5);
		gbc_lblLink2.gridx = 2;
		gbc_lblLink2.gridy = 17;
		add(lblLink2, gbc_lblLink2);

		JLabel lblCurriculumVitae = new JLabel("CURRICULUM VITAE");
		lblCurriculumVitae.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GridBagConstraints gbc_lblCurriculumVitae = new GridBagConstraints();
		gbc_lblCurriculumVitae.insets = new Insets(0, 0, 5, 5);
		gbc_lblCurriculumVitae.gridx = 1;
		gbc_lblCurriculumVitae.gridy = 19;
		add(lblCurriculumVitae, gbc_lblCurriculumVitae);

		JButton btnTelechargCV = new JButton("Télécharger");
		btnTelechargCV.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		GridBagConstraints gbc_btnTelechargCV = new GridBagConstraints();
		gbc_btnTelechargCV.gridwidth = 6;
		gbc_btnTelechargCV.insets = new Insets(0, 0, 5, 5);
		gbc_btnTelechargCV.gridx = 1;
		gbc_btnTelechargCV.gridy = 21;
		add(btnTelechargCV, gbc_btnTelechargCV);

		JLabel label = new JLabel("");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 23;
		add(label, gbc_label);
	}

}
