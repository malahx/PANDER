package fr.redpanda.pander.views.subviews;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import fr.redpanda.pander.entities.User;

/**
 * 
 * @author Patrice SCHOCH
 *
 */
public class SidebarEditable extends Sidebar {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7876599813851320634L;

	private JTextField txtDescriptionTitle;
	private JTextField txtCP;
	private JTextField txtCity;
	private JTextField txtPhone;
	private JTextField txtMail;
	private JTextField txtAdress;
	private JTextField txtLink1;
	private JTextField txtLink2;
	private JTextField txtNameOne;
	private JTextField txtNameTwo;
	private JLabel lblPhoto;
	private JLabel lblNameOne;
	private JLabel jlblNameTwo;
	private JLabel lblDescriptionTitle;
	private JLabel lblCoordonateTittle;
	private JLabel lblAdressTitle;
	private JLabel lblCpTitle;
	private JLabel lblCityTitle;
	private JLabel lblPhoneTitle;
	private JLabel lblMailTitle;
	private JLabel lblSocialLinks;
	private JLabel lblLink1Title;
	private JLabel lblLink2Title;
	private JLabel lblCurriculumVitae;
	private JButton btnSeeCV;

	/**
	 * @return the txtDescriptionTitle
	 */
	public JTextField getTxtDescriptionTitle() {
		return txtDescriptionTitle;
	}

	/**
	 * @param txtDescriptionTitle
	 *            the txtDescriptionTitle to set
	 */
	public void setTxtDescriptionTitle(JTextField txtDescriptionTitle) {
		this.txtDescriptionTitle = txtDescriptionTitle;
	}

	/**
	 * @return the txtCP
	 */
	public JTextField getTxtCP() {
		return txtCP;
	}

	/**
	 * @param txtCP
	 *            the txtCP to set
	 */
	public void setTxtCP(JTextField txtCP) {
		this.txtCP = txtCP;
	}

	/**
	 * @return the txtCity
	 */
	public JTextField getTxtCity() {
		return txtCity;
	}

	/**
	 * @param txtCity
	 *            the txtCity to set
	 */
	public void setTxtCity(JTextField txtCity) {
		this.txtCity = txtCity;
	}

	/**
	 * @return the txtPhone
	 */
	public JTextField getTxtPhone() {
		return txtPhone;
	}

	/**
	 * @param txtPhone
	 *            the txtPhone to set
	 */
	public void setTxtPhone(JTextField txtPhone) {
		this.txtPhone = txtPhone;
	}

	/**
	 * @return the txtMail
	 */
	public JTextField getTxtMail() {
		return txtMail;
	}

	/**
	 * @param txtMail
	 *            the txtMail to set
	 */
	public void setTxtMail(JTextField txtMail) {
		this.txtMail = txtMail;
	}

	/**
	 * @return the txtAdress
	 */
	public JTextField getTxtAdress() {
		return txtAdress;
	}

	/**
	 * @param txtAdress
	 *            the txtAdress to set
	 */
	public void setTxtAdress(JTextField txtAdress) {
		this.txtAdress = txtAdress;
	}

	/**
	 * @return the txtLink1
	 */
	public JTextField getTxtLink1() {
		return txtLink1;
	}

	/**
	 * @param txtLink1
	 *            the txtLink1 to set
	 */
	public void setTxtLink1(JTextField txtLink1) {
		this.txtLink1 = txtLink1;
	}

	/**
	 * @return the txtLink2
	 */
	public JTextField getTxtLink2() {
		return txtLink2;
	}

	/**
	 * @param txtLink2
	 *            the txtLink2 to set
	 */
	public void setTxtLink2(JTextField txtLink2) {
		this.txtLink2 = txtLink2;
	}

	/**
	 * @return the txtNameOne
	 */
	public JTextField getTxtNameOne() {
		return txtNameOne;
	}

	/**
	 * @param txtNameOne
	 *            the txtNameOne to set
	 */
	public void setTxtNameOne(JTextField txtNameOne) {
		this.txtNameOne = txtNameOne;
	}

	/**
	 * @return the txtNameTwo
	 */
	public JTextField getTxtNameTwo() {
		return txtNameTwo;
	}

	/**
	 * @param txtNameTwo
	 *            the txtNameTwo to set
	 */
	public void setTxtNameTwo(JTextField txtNameTwo) {
		this.txtNameTwo = txtNameTwo;
	}

	/**
	 * @return the lblPhoto
	 */
	public JLabel getLblPhoto() {
		return lblPhoto;
	}

	/**
	 * @param lblPhoto
	 *            the lblPhoto to set
	 */
	public void setLblPhoto(JLabel lblPhoto) {
		this.lblPhoto = lblPhoto;
	}

	/**
	 * @return the lblNameOne
	 */
	public JLabel getLblNameOne() {
		return lblNameOne;
	}

	/**
	 * @param lblNameOne
	 *            the lblNameOne to set
	 */
	public void setLblNameOne(JLabel lblNameOne) {
		this.lblNameOne = lblNameOne;
	}

	/**
	 * @return the jlblNameTwo
	 */
	public JLabel getJlblNameTwo() {
		return jlblNameTwo;
	}

	/**
	 * @param jlblNameTwo
	 *            the jlblNameTwo to set
	 */
	public void setJlblNameTwo(JLabel jlblNameTwo) {
		this.jlblNameTwo = jlblNameTwo;
	}

	/**
	 * @return the lblDescriptionTitle
	 */
	public JLabel getLblDescriptionTitle() {
		return lblDescriptionTitle;
	}

	/**
	 * @param lblDescriptionTitle
	 *            the lblDescriptionTitle to set
	 */
	public void setLblDescriptionTitle(JLabel lblDescriptionTitle) {
		this.lblDescriptionTitle = lblDescriptionTitle;
	}

	/**
	 * @return the lblCoordonateTittle
	 */
	public JLabel getLblCoordonateTittle() {
		return lblCoordonateTittle;
	}

	/**
	 * @param lblCoordonateTittle
	 *            the lblCoordonateTittle to set
	 */
	public void setLblCoordonateTittle(JLabel lblCoordonateTittle) {
		this.lblCoordonateTittle = lblCoordonateTittle;
	}

	/**
	 * @return the lblAdressTitle
	 */
	public JLabel getLblAdressTitle() {
		return lblAdressTitle;
	}

	/**
	 * @param lblAdressTitle
	 *            the lblAdressTitle to set
	 */
	public void setLblAdressTitle(JLabel lblAdressTitle) {
		this.lblAdressTitle = lblAdressTitle;
	}

	/**
	 * @return the lblCpTitle
	 */
	public JLabel getLblCpTitle() {
		return lblCpTitle;
	}

	/**
	 * @param lblCpTitle
	 *            the lblCpTitle to set
	 */
	public void setLblCpTitle(JLabel lblCpTitle) {
		this.lblCpTitle = lblCpTitle;
	}

	/**
	 * @return the lblCityTitle
	 */
	public JLabel getLblCityTitle() {
		return lblCityTitle;
	}

	/**
	 * @param lblCityTitle
	 *            the lblCityTitle to set
	 */
	public void setLblCityTitle(JLabel lblCityTitle) {
		this.lblCityTitle = lblCityTitle;
	}

	/**
	 * @return the lblPhoneTitle
	 */
	public JLabel getLblPhoneTitle() {
		return lblPhoneTitle;
	}

	/**
	 * @param lblPhoneTitle
	 *            the lblPhoneTitle to set
	 */
	public void setLblPhoneTitle(JLabel lblPhoneTitle) {
		this.lblPhoneTitle = lblPhoneTitle;
	}

	/**
	 * @return the lblMailTitle
	 */
	public JLabel getLblMailTitle() {
		return lblMailTitle;
	}

	/**
	 * @param lblMailTitle
	 *            the lblMailTitle to set
	 */
	public void setLblMailTitle(JLabel lblMailTitle) {
		this.lblMailTitle = lblMailTitle;
	}

	/**
	 * @return the lblSocialLinks
	 */
	public JLabel getLblSocialLinks() {
		return lblSocialLinks;
	}

	/**
	 * @param lblSocialLinks
	 *            the lblSocialLinks to set
	 */
	public void setLblSocialLinks(JLabel lblSocialLinks) {
		this.lblSocialLinks = lblSocialLinks;
	}

	/**
	 * @return the lblLink1Title
	 */
	public JLabel getLblLink1Title() {
		return lblLink1Title;
	}

	/**
	 * @param lblLink1Title
	 *            the lblLink1Title to set
	 */
	public void setLblLink1Title(JLabel lblLink1Title) {
		this.lblLink1Title = lblLink1Title;
	}

	/**
	 * @return the lblLink2Title
	 */
	public JLabel getLblLink2Title() {
		return lblLink2Title;
	}

	/**
	 * @param lblLink2Title
	 *            the lblLink2Title to set
	 */
	public void setLblLink2Title(JLabel lblLink2Title) {
		this.lblLink2Title = lblLink2Title;
	}

	/**
	 * @return the lblCurriculumVitae
	 */
	public JLabel getLblCurriculumVitae() {
		return lblCurriculumVitae;
	}

	/**
	 * @param lblCurriculumVitae
	 *            the lblCurriculumVitae to set
	 */
	public void setLblCurriculumVitae(JLabel lblCurriculumVitae) {
		this.lblCurriculumVitae = lblCurriculumVitae;
	}

	/**
	 * @return the btnSeeCV
	 */
	public JButton getBtnSeeCV() {
		return btnSeeCV;
	}

	/**
	 * @param btnSeeCV
	 *            the btnSeeCV to set
	 */
	public void setBtnSeeCV(JButton btnSeeCV) {
		this.btnSeeCV = btnSeeCV;
	}

	/**
	 * Create the frame.
	 */
	public SidebarEditable() {
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gbl_contentPane);

		lblPhoto = new JLabel("PHOTO");
		GridBagConstraints gbc_lblPhoto = new GridBagConstraints();
		gbc_lblPhoto.gridheight = 3;
		gbc_lblPhoto.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhoto.gridx = 0;
		gbc_lblPhoto.gridy = 2;
		add(lblPhoto, gbc_lblPhoto);

		lblNameOne = new JLabel("Name1");
		lblNameOne.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		GridBagConstraints gbc_lblNameOne = new GridBagConstraints();
		gbc_lblNameOne.anchor = GridBagConstraints.EAST;
		gbc_lblNameOne.gridwidth = 2;
		gbc_lblNameOne.insets = new Insets(0, 0, 5, 5);
		gbc_lblNameOne.gridx = 1;
		gbc_lblNameOne.gridy = 2;
		add(lblNameOne, gbc_lblNameOne);

		txtNameOne = new JTextField();
		GridBagConstraints gbc_txtNameOne = new GridBagConstraints();
		gbc_txtNameOne.gridwidth = 2;
		gbc_txtNameOne.insets = new Insets(0, 0, 5, 0);
		gbc_txtNameOne.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNameOne.gridx = 3;
		gbc_txtNameOne.gridy = 2;
		add(txtNameOne, gbc_txtNameOne);
		txtNameOne.setColumns(10);

		jlblNameTwo = new JLabel("Name2");
		jlblNameTwo.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		GridBagConstraints gbc_jlblNameTwo = new GridBagConstraints();
		gbc_jlblNameTwo.anchor = GridBagConstraints.EAST;
		gbc_jlblNameTwo.gridwidth = 2;
		gbc_jlblNameTwo.insets = new Insets(0, 0, 5, 5);
		gbc_jlblNameTwo.gridx = 1;
		gbc_jlblNameTwo.gridy = 3;
		add(jlblNameTwo, gbc_jlblNameTwo);

		txtNameTwo = new JTextField();
		GridBagConstraints gbc_txtNameTwo = new GridBagConstraints();
		gbc_txtNameTwo.gridwidth = 2;
		gbc_txtNameTwo.insets = new Insets(0, 0, 5, 0);
		gbc_txtNameTwo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNameTwo.gridx = 3;
		gbc_txtNameTwo.gridy = 3;
		add(txtNameTwo, gbc_txtNameTwo);
		txtNameTwo.setColumns(10);

		lblDescriptionTitle = new JLabel("DESCRIPTION");
		lblDescriptionTitle.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GridBagConstraints gbc_lblDescriptionTitle = new GridBagConstraints();
		gbc_lblDescriptionTitle.gridwidth = 2;
		gbc_lblDescriptionTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescriptionTitle.gridx = 0;
		gbc_lblDescriptionTitle.gridy = 5;
		add(lblDescriptionTitle, gbc_lblDescriptionTitle);

		txtDescriptionTitle = new JTextField();
		GridBagConstraints gbc_txtDescriptionTitle = new GridBagConstraints();
		gbc_txtDescriptionTitle.gridwidth = 5;
		gbc_txtDescriptionTitle.insets = new Insets(0, 0, 5, 0);
		gbc_txtDescriptionTitle.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDescriptionTitle.gridx = 0;
		gbc_txtDescriptionTitle.gridy = 6;
		add(txtDescriptionTitle, gbc_txtDescriptionTitle);
		txtDescriptionTitle.setColumns(10);

		lblCoordonateTittle = new JLabel("COORDONNEES");
		lblCoordonateTittle.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GridBagConstraints gbc_lblCoordonateTittle = new GridBagConstraints();
		gbc_lblCoordonateTittle.gridwidth = 2;
		gbc_lblCoordonateTittle.insets = new Insets(0, 0, 5, 5);
		gbc_lblCoordonateTittle.gridx = 0;
		gbc_lblCoordonateTittle.gridy = 8;
		add(lblCoordonateTittle, gbc_lblCoordonateTittle);

		lblAdressTitle = new JLabel("Adresse ");
		lblAdressTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		GridBagConstraints gbc_lblAdressTitle = new GridBagConstraints();
		gbc_lblAdressTitle.anchor = GridBagConstraints.EAST;
		gbc_lblAdressTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdressTitle.gridx = 0;
		gbc_lblAdressTitle.gridy = 9;
		add(lblAdressTitle, gbc_lblAdressTitle);

		txtAdress = new JTextField();
		GridBagConstraints gbc_textAdress = new GridBagConstraints();
		gbc_textAdress.gridwidth = 4;
		gbc_textAdress.insets = new Insets(0, 0, 5, 0);
		gbc_textAdress.fill = GridBagConstraints.HORIZONTAL;
		gbc_textAdress.gridx = 1;
		gbc_textAdress.gridy = 9;
		add(txtAdress, gbc_textAdress);
		txtAdress.setColumns(10);

		lblCpTitle = new JLabel("Code Postal");
		lblCpTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		GridBagConstraints gbc_lblCpTitle = new GridBagConstraints();
		gbc_lblCpTitle.anchor = GridBagConstraints.EAST;
		gbc_lblCpTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblCpTitle.gridx = 0;
		gbc_lblCpTitle.gridy = 10;
		add(lblCpTitle, gbc_lblCpTitle);

		txtCP = new JTextField();
		GridBagConstraints gbc_textCP = new GridBagConstraints();
		gbc_textCP.gridwidth = 4;
		gbc_textCP.insets = new Insets(0, 0, 5, 0);
		gbc_textCP.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCP.gridx = 1;
		gbc_textCP.gridy = 10;
		add(txtCP, gbc_textCP);
		txtCP.setColumns(10);

		lblCityTitle = new JLabel("Ville");
		lblCityTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		GridBagConstraints gbc_lblCityTitle = new GridBagConstraints();
		gbc_lblCityTitle.anchor = GridBagConstraints.EAST;
		gbc_lblCityTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblCityTitle.gridx = 0;
		gbc_lblCityTitle.gridy = 11;
		add(lblCityTitle, gbc_lblCityTitle);

		txtCity = new JTextField();
		GridBagConstraints gbc_textCity = new GridBagConstraints();
		gbc_textCity.gridwidth = 4;
		gbc_textCity.insets = new Insets(0, 0, 5, 0);
		gbc_textCity.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCity.gridx = 1;
		gbc_textCity.gridy = 11;
		add(txtCity, gbc_textCity);
		txtCity.setColumns(10);

		lblPhoneTitle = new JLabel("Téléphone");
		lblPhoneTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		GridBagConstraints gbc_lblPhoneTitle = new GridBagConstraints();
		gbc_lblPhoneTitle.anchor = GridBagConstraints.EAST;
		gbc_lblPhoneTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhoneTitle.gridx = 0;
		gbc_lblPhoneTitle.gridy = 12;
		add(lblPhoneTitle, gbc_lblPhoneTitle);

		txtPhone = new JTextField();
		GridBagConstraints gbc_textPhone = new GridBagConstraints();
		gbc_textPhone.gridwidth = 4;
		gbc_textPhone.insets = new Insets(0, 0, 5, 0);
		gbc_textPhone.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPhone.gridx = 1;
		gbc_textPhone.gridy = 12;
		add(txtPhone, gbc_textPhone);
		txtPhone.setColumns(10);

		lblMailTitle = new JLabel("E-Mail");
		lblMailTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		GridBagConstraints gbc_lblMailTitle = new GridBagConstraints();
		gbc_lblMailTitle.anchor = GridBagConstraints.EAST;
		gbc_lblMailTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblMailTitle.gridx = 0;
		gbc_lblMailTitle.gridy = 13;
		add(lblMailTitle, gbc_lblMailTitle);

		txtMail = new JTextField();
		GridBagConstraints gbc_textMail = new GridBagConstraints();
		gbc_textMail.gridwidth = 4;
		gbc_textMail.insets = new Insets(0, 0, 5, 0);
		gbc_textMail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textMail.gridx = 1;
		gbc_textMail.gridy = 13;
		add(txtMail, gbc_textMail);
		txtMail.setColumns(10);

		lblSocialLinks = new JLabel("SOCIAL LINKS");
		lblSocialLinks.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GridBagConstraints gbc_lblSocialLinks = new GridBagConstraints();
		gbc_lblSocialLinks.gridwidth = 2;
		gbc_lblSocialLinks.insets = new Insets(0, 0, 5, 5);
		gbc_lblSocialLinks.gridx = 0;
		gbc_lblSocialLinks.gridy = 15;
		add(lblSocialLinks, gbc_lblSocialLinks);

		lblLink1Title = new JLabel("Link 1");
		lblLink1Title.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		GridBagConstraints gbc_lblLink1Title = new GridBagConstraints();
		gbc_lblLink1Title.anchor = GridBagConstraints.EAST;
		gbc_lblLink1Title.insets = new Insets(0, 0, 5, 5);
		gbc_lblLink1Title.gridx = 0;
		gbc_lblLink1Title.gridy = 16;
		add(lblLink1Title, gbc_lblLink1Title);

		txtLink1 = new JTextField();
		GridBagConstraints gbc_textLink1 = new GridBagConstraints();
		gbc_textLink1.gridwidth = 4;
		gbc_textLink1.insets = new Insets(0, 0, 5, 0);
		gbc_textLink1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textLink1.gridx = 1;
		gbc_textLink1.gridy = 16;
		add(txtLink1, gbc_textLink1);
		txtLink1.setColumns(10);

		lblLink2Title = new JLabel("Link 2 / Contact");
		lblLink2Title.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		GridBagConstraints gbc_lblLinkTitle = new GridBagConstraints();
		gbc_lblLinkTitle.anchor = GridBagConstraints.EAST;
		gbc_lblLinkTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblLinkTitle.gridx = 0;
		gbc_lblLinkTitle.gridy = 17;
		add(lblLink2Title, gbc_lblLinkTitle);

		txtLink2 = new JTextField();
		GridBagConstraints gbc_textLink2 = new GridBagConstraints();
		gbc_textLink2.gridwidth = 4;
		gbc_textLink2.insets = new Insets(0, 0, 5, 0);
		gbc_textLink2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textLink2.gridx = 1;
		gbc_textLink2.gridy = 17;
		add(txtLink2, gbc_textLink2);
		txtLink2.setColumns(10);

		lblCurriculumVitae = new JLabel("CURRICULUM VITAE");
		lblCurriculumVitae.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GridBagConstraints gbc_lblCurriculumVitae = new GridBagConstraints();
		gbc_lblCurriculumVitae.insets = new Insets(0, 0, 5, 5);
		gbc_lblCurriculumVitae.gridx = 0;
		gbc_lblCurriculumVitae.gridy = 19;
		add(lblCurriculumVitae, gbc_lblCurriculumVitae);

		btnTelechargCV = new JButton("Télécharger");
		btnTelechargCV.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		GridBagConstraints gbc_btnTelechargCV = new GridBagConstraints();
		gbc_btnTelechargCV.insets = new Insets(0, 0, 5, 5);
		gbc_btnTelechargCV.gridx = 0;
		gbc_btnTelechargCV.gridy = 20;
		add(btnTelechargCV, gbc_btnTelechargCV);

		btnSeeCV = new JButton("Voir");
		btnSeeCV.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		GridBagConstraints gbc_btnSeeCV = new GridBagConstraints();
		gbc_btnSeeCV.insets = new Insets(0, 0, 5, 0);
		gbc_btnSeeCV.gridx = 4;
		gbc_btnSeeCV.gridy = 20;
		add(btnSeeCV, gbc_btnSeeCV);

		JLabel label = new JLabel("");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 22;
		add(label, gbc_label);
	}

	/* (non-Javadoc)
	 * @see fr.redpanda.pander.views.subviews.Sidebar#initData(fr.redpanda.pander.entities.User)
	 */
	@Override
	public void initData(User user) {
		getTxtAdress().setText(user.getAddress());
		getTxtCity().setText(user.getCity());
		getTxtDescriptionTitle().setText(user.getDescription());
		getTxtPhone().setText(user.getPhone());
		getTxtCP().setText(user.getPostcode());
	}

}
