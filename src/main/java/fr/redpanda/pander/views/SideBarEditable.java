package fr.redpanda.pander.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JTextField;

public class SideBarEditable extends JFrame {

	private JPanel contentPane;
	private JTextField txtDescriptionTitle;
	private JTextField textCP;
	private JTextField textCity;
	private JTextField textPhone;
	private JTextField textMail;
	private JTextField textAdress;
	private JTextField textLink1;
	private JTextField textLink2;
	private JTextField txtNameOne;
	private JTextField txtNameTwo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SideBarEditable frame = new SideBarEditable();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SideBarEditable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblPhoto = new JLabel("PHOTO");
		GridBagConstraints gbc_lblPhoto = new GridBagConstraints();
		gbc_lblPhoto.gridheight = 3;
		gbc_lblPhoto.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhoto.gridx = 0;
		gbc_lblPhoto.gridy = 2;
		contentPane.add(lblPhoto, gbc_lblPhoto);
		
		JLabel lblNameOne = new JLabel("Name1");
		lblNameOne.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		GridBagConstraints gbc_lblNameOne = new GridBagConstraints();
		gbc_lblNameOne.anchor = GridBagConstraints.EAST;
		gbc_lblNameOne.gridwidth = 2;
		gbc_lblNameOne.insets = new Insets(0, 0, 5, 5);
		gbc_lblNameOne.gridx = 1;
		gbc_lblNameOne.gridy = 2;
		contentPane.add(lblNameOne, gbc_lblNameOne);
		
		txtNameOne = new JTextField();
		GridBagConstraints gbc_txtNameOne = new GridBagConstraints();
		gbc_txtNameOne.gridwidth = 2;
		gbc_txtNameOne.insets = new Insets(0, 0, 5, 0);
		gbc_txtNameOne.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNameOne.gridx = 3;
		gbc_txtNameOne.gridy = 2;
		contentPane.add(txtNameOne, gbc_txtNameOne);
		txtNameOne.setColumns(10);
		
		JLabel jlblNameTwo = new JLabel("Name2");
		jlblNameTwo.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		GridBagConstraints gbc_jlblNameTwo = new GridBagConstraints();
		gbc_jlblNameTwo.anchor = GridBagConstraints.EAST;
		gbc_jlblNameTwo.gridwidth = 2;
		gbc_jlblNameTwo.insets = new Insets(0, 0, 5, 5);
		gbc_jlblNameTwo.gridx = 1;
		gbc_jlblNameTwo.gridy = 3;
		contentPane.add(jlblNameTwo, gbc_jlblNameTwo);
		
		txtNameTwo = new JTextField();
		GridBagConstraints gbc_txtNameTwo = new GridBagConstraints();
		gbc_txtNameTwo.gridwidth = 2;
		gbc_txtNameTwo.insets = new Insets(0, 0, 5, 0);
		gbc_txtNameTwo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNameTwo.gridx = 3;
		gbc_txtNameTwo.gridy = 3;
		contentPane.add(txtNameTwo, gbc_txtNameTwo);
		txtNameTwo.setColumns(10);
		
		JLabel lblDescriptionTitle = new JLabel("DESCRIPTION");
		lblDescriptionTitle.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GridBagConstraints gbc_lblDescriptionTitle = new GridBagConstraints();
		gbc_lblDescriptionTitle.gridwidth = 2;
		gbc_lblDescriptionTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescriptionTitle.gridx = 0;
		gbc_lblDescriptionTitle.gridy = 5;
		contentPane.add(lblDescriptionTitle, gbc_lblDescriptionTitle);
		
		txtDescriptionTitle = new JTextField();
		GridBagConstraints gbc_txtDescriptionTitle = new GridBagConstraints();
		gbc_txtDescriptionTitle.gridwidth = 5;
		gbc_txtDescriptionTitle.insets = new Insets(0, 0, 5, 0);
		gbc_txtDescriptionTitle.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDescriptionTitle.gridx = 0;
		gbc_txtDescriptionTitle.gridy = 6;
		contentPane.add(txtDescriptionTitle, gbc_txtDescriptionTitle);
		txtDescriptionTitle.setColumns(10);
		
		JLabel lblCoordonateTittle = new JLabel("COORDONNEES");
		lblCoordonateTittle.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GridBagConstraints gbc_lblCoordonateTittle = new GridBagConstraints();
		gbc_lblCoordonateTittle.gridwidth = 2;
		gbc_lblCoordonateTittle.insets = new Insets(0, 0, 5, 5);
		gbc_lblCoordonateTittle.gridx = 0;
		gbc_lblCoordonateTittle.gridy = 8;
		contentPane.add(lblCoordonateTittle, gbc_lblCoordonateTittle);
		
		JLabel lblAdressTitle = new JLabel("Adresse ");
		lblAdressTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		GridBagConstraints gbc_lblAdressTitle = new GridBagConstraints();
		gbc_lblAdressTitle.anchor = GridBagConstraints.EAST;
		gbc_lblAdressTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdressTitle.gridx = 0;
		gbc_lblAdressTitle.gridy = 9;
		contentPane.add(lblAdressTitle, gbc_lblAdressTitle);
		
		textAdress = new JTextField();
		GridBagConstraints gbc_textAdress = new GridBagConstraints();
		gbc_textAdress.gridwidth = 4;
		gbc_textAdress.insets = new Insets(0, 0, 5, 0);
		gbc_textAdress.fill = GridBagConstraints.HORIZONTAL;
		gbc_textAdress.gridx = 1;
		gbc_textAdress.gridy = 9;
		contentPane.add(textAdress, gbc_textAdress);
		textAdress.setColumns(10);
		
		JLabel lblCpTitle = new JLabel("Code Postal");
		lblCpTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		GridBagConstraints gbc_lblCpTitle = new GridBagConstraints();
		gbc_lblCpTitle.anchor = GridBagConstraints.EAST;
		gbc_lblCpTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblCpTitle.gridx = 0;
		gbc_lblCpTitle.gridy = 10;
		contentPane.add(lblCpTitle, gbc_lblCpTitle);
		
		textCP = new JTextField();
		GridBagConstraints gbc_textCP = new GridBagConstraints();
		gbc_textCP.gridwidth = 4;
		gbc_textCP.insets = new Insets(0, 0, 5, 0);
		gbc_textCP.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCP.gridx = 1;
		gbc_textCP.gridy = 10;
		contentPane.add(textCP, gbc_textCP);
		textCP.setColumns(10);
		
		JLabel lblCityTitle = new JLabel("Ville");
		lblCityTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		GridBagConstraints gbc_lblCityTitle = new GridBagConstraints();
		gbc_lblCityTitle.anchor = GridBagConstraints.EAST;
		gbc_lblCityTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblCityTitle.gridx = 0;
		gbc_lblCityTitle.gridy = 11;
		contentPane.add(lblCityTitle, gbc_lblCityTitle);
		
		textCity = new JTextField();
		GridBagConstraints gbc_textCity = new GridBagConstraints();
		gbc_textCity.gridwidth = 4;
		gbc_textCity.insets = new Insets(0, 0, 5, 0);
		gbc_textCity.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCity.gridx = 1;
		gbc_textCity.gridy = 11;
		contentPane.add(textCity, gbc_textCity);
		textCity.setColumns(10);
		
		JLabel lblPhoneTitle = new JLabel("Téléphone");
		lblPhoneTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		GridBagConstraints gbc_lblPhoneTitle = new GridBagConstraints();
		gbc_lblPhoneTitle.anchor = GridBagConstraints.EAST;
		gbc_lblPhoneTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhoneTitle.gridx = 0;
		gbc_lblPhoneTitle.gridy = 12;
		contentPane.add(lblPhoneTitle, gbc_lblPhoneTitle);
		
		textPhone = new JTextField();
		GridBagConstraints gbc_textPhone = new GridBagConstraints();
		gbc_textPhone.gridwidth = 4;
		gbc_textPhone.insets = new Insets(0, 0, 5, 0);
		gbc_textPhone.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPhone.gridx = 1;
		gbc_textPhone.gridy = 12;
		contentPane.add(textPhone, gbc_textPhone);
		textPhone.setColumns(10);
		
		JLabel lblMailTitle = new JLabel("E-Mail");
		lblMailTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		GridBagConstraints gbc_lblMailTitle = new GridBagConstraints();
		gbc_lblMailTitle.anchor = GridBagConstraints.EAST;
		gbc_lblMailTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblMailTitle.gridx = 0;
		gbc_lblMailTitle.gridy = 13;
		contentPane.add(lblMailTitle, gbc_lblMailTitle);
		
		textMail = new JTextField();
		GridBagConstraints gbc_textMail = new GridBagConstraints();
		gbc_textMail.gridwidth = 4;
		gbc_textMail.insets = new Insets(0, 0, 5, 0);
		gbc_textMail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textMail.gridx = 1;
		gbc_textMail.gridy = 13;
		contentPane.add(textMail, gbc_textMail);
		textMail.setColumns(10);
		
		JLabel lblSocialLinks = new JLabel("SOCIAL LINKS");
		lblSocialLinks.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GridBagConstraints gbc_lblSocialLinks = new GridBagConstraints();
		gbc_lblSocialLinks.gridwidth = 2;
		gbc_lblSocialLinks.insets = new Insets(0, 0, 5, 5);
		gbc_lblSocialLinks.gridx = 0;
		gbc_lblSocialLinks.gridy = 15;
		contentPane.add(lblSocialLinks, gbc_lblSocialLinks);
		
		JLabel lblLink1Title = new JLabel("Link 1");
		lblLink1Title.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		GridBagConstraints gbc_lblLink1Title = new GridBagConstraints();
		gbc_lblLink1Title.anchor = GridBagConstraints.EAST;
		gbc_lblLink1Title.insets = new Insets(0, 0, 5, 5);
		gbc_lblLink1Title.gridx = 0;
		gbc_lblLink1Title.gridy = 16;
		contentPane.add(lblLink1Title, gbc_lblLink1Title);
		
		textLink1 = new JTextField();
		GridBagConstraints gbc_textLink1 = new GridBagConstraints();
		gbc_textLink1.gridwidth = 4;
		gbc_textLink1.insets = new Insets(0, 0, 5, 0);
		gbc_textLink1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textLink1.gridx = 1;
		gbc_textLink1.gridy = 16;
		contentPane.add(textLink1, gbc_textLink1);
		textLink1.setColumns(10);
		
		JLabel lblLinkTitle = new JLabel("Link 2 / Contact");
		lblLinkTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		GridBagConstraints gbc_lblLinkTitle = new GridBagConstraints();
		gbc_lblLinkTitle.anchor = GridBagConstraints.EAST;
		gbc_lblLinkTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblLinkTitle.gridx = 0;
		gbc_lblLinkTitle.gridy = 17;
		contentPane.add(lblLinkTitle, gbc_lblLinkTitle);
		
		textLink2 = new JTextField();
		GridBagConstraints gbc_textLink2 = new GridBagConstraints();
		gbc_textLink2.gridwidth = 4;
		gbc_textLink2.insets = new Insets(0, 0, 5, 0);
		gbc_textLink2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textLink2.gridx = 1;
		gbc_textLink2.gridy = 17;
		contentPane.add(textLink2, gbc_textLink2);
		textLink2.setColumns(10);
		
		JLabel lblCurriculumVitae = new JLabel("CURRICULUM VITAE");
		lblCurriculumVitae.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GridBagConstraints gbc_lblCurriculumVitae = new GridBagConstraints();
		gbc_lblCurriculumVitae.insets = new Insets(0, 0, 5, 5);
		gbc_lblCurriculumVitae.gridx = 0;
		gbc_lblCurriculumVitae.gridy = 19;
		contentPane.add(lblCurriculumVitae, gbc_lblCurriculumVitae);
		
		JButton btnTelechargCV = new JButton("Télécharger");
		btnTelechargCV.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		GridBagConstraints gbc_btnTelechargCV = new GridBagConstraints();
		gbc_btnTelechargCV.insets = new Insets(0, 0, 5, 5);
		gbc_btnTelechargCV.gridx = 0;
		gbc_btnTelechargCV.gridy = 20;
		contentPane.add(btnTelechargCV, gbc_btnTelechargCV);
		
		JButton btnSeeCV = new JButton("Voir");
		btnSeeCV.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		GridBagConstraints gbc_btnSeeCV = new GridBagConstraints();
		gbc_btnSeeCV.insets = new Insets(0, 0, 5, 0);
		gbc_btnSeeCV.gridx = 4;
		gbc_btnSeeCV.gridy = 20;
		contentPane.add(btnSeeCV, gbc_btnSeeCV);
		
		JLabel label = new JLabel("");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 22;
		contentPane.add(label, gbc_label);
	}

}
