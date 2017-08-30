package fr.redpanda.pander.views.subviews;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;

import fr.redpanda.pander.entities.Candidate;
import fr.redpanda.pander.entities.Company;
import fr.redpanda.pander.entities.User;
import fr.redpanda.pander.utils.views.ViewUtils;

/**
 * 
 * @author Patrice SCHOCH
 *
 */
public class SidebarPublic extends Sidebar {

	private JLabel lblPhoto;
	private JLabel lblName1;
	private JLabel lblName2;
	private JLabel lblDescriptionTitle;
	private JLabel lblPresentation;
	private JLabel lblCoordonateTitle;
	private JLabel lblAddress;
	private JLabel lblCp;
	private JLabel lblCity;
	private JLabel lblPhoneTitle;
	private JLabel lblPhone;
	private JLabel lblMailTitle;
	private JLabel lblMail;
	private JLabel lblSocialLinks;
	private JLabel lblLink1Title;
	private JLabel lblLink1;
	private JLabel lblLink2Title;
	private JLabel lblLink2;
	private JLabel lblCurriculumVitae;

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
	 * @return the lblName1
	 */
	public JLabel getLblName1() {
		return lblName1;
	}

	/**
	 * @param lblName1
	 *            the lblName1 to set
	 */
	public void setLblName1(JLabel lblName1) {
		this.lblName1 = lblName1;
	}

	/**
	 * @return the lblName2
	 */
	public JLabel getLblName2() {
		return lblName2;
	}

	/**
	 * @param lblName2
	 *            the lblName2 to set
	 */
	public void setLblName2(JLabel lblName2) {
		this.lblName2 = lblName2;
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
	 * @return the lblPresentation
	 */
	public JLabel getLblPresentation() {
		return lblPresentation;
	}

	/**
	 * @param lblPresentation
	 *            the lblPresentation to set
	 */
	public void setLblPresentation(JLabel lblPresentation) {
		this.lblPresentation = lblPresentation;
	}

	/**
	 * @return the lblCoordonateTitle
	 */
	public JLabel getLblCoordonateTitle() {
		return lblCoordonateTitle;
	}

	/**
	 * @param lblCoordonateTitle
	 *            the lblCoordonateTitle to set
	 */
	public void setLblCoordonateTitle(JLabel lblCoordonateTitle) {
		this.lblCoordonateTitle = lblCoordonateTitle;
	}

	/**
	 * @return the lblAddress
	 */
	public JLabel getLblAddress() {
		return lblAddress;
	}

	/**
	 * @param lblAdress
	 *            the lblAdress to set
	 */
	public void setLblAddress(JLabel lblAddress) {
		this.lblAddress = lblAddress;
	}

	/**
	 * @return the lblCp
	 */
	public JLabel getLblCp() {
		return lblCp;
	}

	/**
	 * @param lblCp
	 *            the lblCp to set
	 */
	public void setLblCp(JLabel lblCp) {
		this.lblCp = lblCp;
	}

	/**
	 * @return the lblCity
	 */
	public JLabel getLblCity() {
		return lblCity;
	}

	/**
	 * @param lblCity
	 *            the lblCity to set
	 */
	public void setLblCity(JLabel lblCity) {
		this.lblCity = lblCity;
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
	 * @return the lblPhone
	 */
	public JLabel getLblPhone() {
		return lblPhone;
	}

	/**
	 * @param lblPhone
	 *            the lblPhone to set
	 */
	public void setLblPhone(JLabel lblPhone) {
		this.lblPhone = lblPhone;
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
	 * @return the lblMail
	 */
	public JLabel getLblMail() {
		return lblMail;
	}

	/**
	 * @param lblMail
	 *            the lblMail to set
	 */
	public void setLblMail(JLabel lblMail) {
		this.lblMail = lblMail;
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
	 * @return the lblLink1
	 */
	public JLabel getLblLink1() {
		return lblLink1;
	}

	/**
	 * @param lblLink1
	 *            the lblLink1 to set
	 */
	public void setLblLink1(JLabel lblLink1) {
		this.lblLink1 = lblLink1;
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
	 * @return the lblLink2
	 */
	public JLabel getLblLink2() {
		return lblLink2;
	}

	/**
	 * @param lblLink2
	 *            the lblLink2 to set
	 */
	public void setLblLink2(JLabel lblLink2) {
		this.lblLink2 = lblLink2;
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
	 * 
	 */
	private static final long serialVersionUID = -5654665579388722049L;

	/**
	 * Create the public sidebar.
	 */
	public SidebarPublic() {

		ViewUtils.colorGrey(this);
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gbl_contentPane);

		lblPhoto = new JLabel("PHOTO");
		GridBagConstraints gbc_lblPhoto = new GridBagConstraints();
		gbc_lblPhoto.gridheight = 4;
		gbc_lblPhoto.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhoto.gridx = 1;
		gbc_lblPhoto.gridy = 1;
		add(lblPhoto, gbc_lblPhoto);

		lblName1 = new JLabel("Name 1");
		GridBagConstraints gbc_lblName1 = new GridBagConstraints();
		gbc_lblName1.anchor = GridBagConstraints.WEST;
		gbc_lblName1.gridwidth = 5;
		gbc_lblName1.insets = new Insets(0, 0, 5, 5);
		gbc_lblName1.gridx = 2;
		gbc_lblName1.gridy = 2;
		add(lblName1, gbc_lblName1);

		lblName2 = new JLabel("Name 2");
		GridBagConstraints gbc_lblName2 = new GridBagConstraints();
		gbc_lblName2.anchor = GridBagConstraints.WEST;
		gbc_lblName2.gridwidth = 6;
		gbc_lblName2.insets = new Insets(0, 0, 5, 0);
		gbc_lblName2.gridx = 2;
		gbc_lblName2.gridy = 3;
		add(lblName2, gbc_lblName2);

		lblDescriptionTitle = new JLabel("DESCRIPTION");
		lblDescriptionTitle.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GridBagConstraints gbc_lblDescriptionTitle = new GridBagConstraints();
		gbc_lblDescriptionTitle.anchor = GridBagConstraints.WEST;
		gbc_lblDescriptionTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescriptionTitle.gridx = 1;
		gbc_lblDescriptionTitle.gridy = 5;
		add(lblDescriptionTitle, gbc_lblDescriptionTitle);

		lblPresentation = new JLabel("Présentation");
		GridBagConstraints gbc_lblPresentation = new GridBagConstraints();
		gbc_lblPresentation.gridwidth = 6;
		gbc_lblPresentation.anchor = GridBagConstraints.WEST;
		gbc_lblPresentation.insets = new Insets(0, 0, 5, 5);
		gbc_lblPresentation.gridx = 1;
		gbc_lblPresentation.gridy = 6;
		add(lblPresentation, gbc_lblPresentation);

		lblCoordonateTitle = new JLabel("COORDONNEES");
		lblCoordonateTitle.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GridBagConstraints gbc_lblCoordonateTittle = new GridBagConstraints();
		gbc_lblCoordonateTittle.anchor = GridBagConstraints.WEST;
		gbc_lblCoordonateTittle.insets = new Insets(0, 0, 5, 5);
		gbc_lblCoordonateTittle.gridx = 1;
		gbc_lblCoordonateTittle.gridy = 8;
		add(lblCoordonateTitle, gbc_lblCoordonateTittle);

		lblAddress = new JLabel("Adresse");
		GridBagConstraints gbc_lblAdress = new GridBagConstraints();
		gbc_lblAdress.anchor = GridBagConstraints.WEST;
		gbc_lblAdress.gridwidth = 6;
		gbc_lblAdress.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdress.gridx = 1;
		gbc_lblAdress.gridy = 9;
		add(lblAddress, gbc_lblAdress);

		lblCp = new JLabel("Code Postal");
		GridBagConstraints gbc_lblCp = new GridBagConstraints();
		gbc_lblCp.anchor = GridBagConstraints.WEST;
		gbc_lblCp.insets = new Insets(0, 0, 5, 5);
		gbc_lblCp.gridx = 1;
		gbc_lblCp.gridy = 10;
		add(lblCp, gbc_lblCp);

		lblCity = new JLabel("Ville");
		GridBagConstraints gbc_lblCity = new GridBagConstraints();
		gbc_lblCity.anchor = GridBagConstraints.WEST;
		gbc_lblCity.gridwidth = 5;
		gbc_lblCity.insets = new Insets(0, 0, 5, 5);
		gbc_lblCity.gridx = 2;
		gbc_lblCity.gridy = 10;
		add(lblCity, gbc_lblCity);

		lblPhoneTitle = new JLabel("Téléphone :");
		lblPhoneTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		GridBagConstraints gbc_lblPhoneTitle = new GridBagConstraints();
		gbc_lblPhoneTitle.anchor = GridBagConstraints.EAST;
		gbc_lblPhoneTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhoneTitle.gridx = 1;
		gbc_lblPhoneTitle.gridy = 12;
		add(lblPhoneTitle, gbc_lblPhoneTitle);

		lblPhone = new JLabel("Téléphone");
		GridBagConstraints gbc_lblPhone = new GridBagConstraints();
		gbc_lblPhone.anchor = GridBagConstraints.WEST;
		gbc_lblPhone.gridwidth = 5;
		gbc_lblPhone.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhone.gridx = 2;
		gbc_lblPhone.gridy = 12;
		add(lblPhone, gbc_lblPhone);

		lblMailTitle = new JLabel("E-Mail :");
		lblMailTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		GridBagConstraints gbc_lblMailTitle = new GridBagConstraints();
		gbc_lblMailTitle.anchor = GridBagConstraints.EAST;
		gbc_lblMailTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblMailTitle.gridx = 1;
		gbc_lblMailTitle.gridy = 13;
		add(lblMailTitle, gbc_lblMailTitle);

		lblMail = new JLabel("Mail");
		GridBagConstraints gbc_lblMail = new GridBagConstraints();
		gbc_lblMail.gridwidth = 5;
		gbc_lblMail.anchor = GridBagConstraints.WEST;
		gbc_lblMail.insets = new Insets(0, 0, 5, 5);
		gbc_lblMail.gridx = 2;
		gbc_lblMail.gridy = 13;
		add(lblMail, gbc_lblMail);

		lblSocialLinks = new JLabel("SOCIAL LINKS");
		lblSocialLinks.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GridBagConstraints gbc_lblSocialLinks = new GridBagConstraints();
		gbc_lblSocialLinks.anchor = GridBagConstraints.WEST;
		gbc_lblSocialLinks.insets = new Insets(0, 0, 5, 5);
		gbc_lblSocialLinks.gridx = 1;
		gbc_lblSocialLinks.gridy = 15;
		add(lblSocialLinks, gbc_lblSocialLinks);

		lblLink1Title = new JLabel("Link 1 :");
		lblLink1Title.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		GridBagConstraints gbc_lblLink1Title = new GridBagConstraints();
		gbc_lblLink1Title.anchor = GridBagConstraints.EAST;
		gbc_lblLink1Title.insets = new Insets(0, 0, 5, 5);
		gbc_lblLink1Title.gridx = 1;
		gbc_lblLink1Title.gridy = 16;
		add(lblLink1Title, gbc_lblLink1Title);

		lblLink1 = new JLabel("Lien 1");
		GridBagConstraints gbc_lblLink1 = new GridBagConstraints();
		gbc_lblLink1.anchor = GridBagConstraints.WEST;
		gbc_lblLink1.gridwidth = 5;
		gbc_lblLink1.insets = new Insets(0, 0, 5, 5);
		gbc_lblLink1.gridx = 2;
		gbc_lblLink1.gridy = 16;
		add(lblLink1, gbc_lblLink1);

		lblLink2Title = new JLabel("Link 2 / Contact :");
		lblLink2Title.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		GridBagConstraints gbc_lblLinkTitle = new GridBagConstraints();
		gbc_lblLinkTitle.anchor = GridBagConstraints.EAST;
		gbc_lblLinkTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblLinkTitle.gridx = 1;
		gbc_lblLinkTitle.gridy = 17;
		add(lblLink2Title, gbc_lblLinkTitle);

		lblLink2 = new JLabel("Lien 2");
		GridBagConstraints gbc_lblLink2 = new GridBagConstraints();
		gbc_lblLink2.anchor = GridBagConstraints.WEST;
		gbc_lblLink2.gridwidth = 5;
		gbc_lblLink2.insets = new Insets(0, 0, 5, 5);
		gbc_lblLink2.gridx = 2;
		gbc_lblLink2.gridy = 17;
		add(lblLink2, gbc_lblLink2);

		lblCurriculumVitae = new JLabel("CURRICULUM VITAE");
		lblCurriculumVitae.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GridBagConstraints gbc_lblCurriculumVitae = new GridBagConstraints();
		gbc_lblCurriculumVitae.insets = new Insets(0, 0, 5, 5);
		gbc_lblCurriculumVitae.gridx = 1;
		gbc_lblCurriculumVitae.gridy = 19;
		add(lblCurriculumVitae, gbc_lblCurriculumVitae);

		btnTelechargCV = new JButton("Télécharger");
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.views.subviews.Sidebar#initData(fr.redpanda.pander.
	 * entities.User)
	 */
	@Override
	protected void initUser(User user) {
		getLblMail().setText(user.getEmail());
		getLblAddress().setText(user.getAddress());
		getLblCity().setText(user.getCity());
		getLblDescriptionTitle().setText(user.getDescription());
		getLblPhone().setText(user.getPhone());
		getLblCp().setText(user.getPostcode());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.views.subviews.Sidebar#initData(fr.redpanda.pander.
	 * entities.User)
	 */
	@Override
	public void initCandidate(Candidate candidate) {
		initUser(candidate);
		getLblLink1().setText(candidate.getLink1());
		getLblLink2().setText(candidate.getLink2());
		getLblName1().setText(candidate.getFirstname());
		getLblName2().setText(candidate.getLastname());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.views.subviews.Sidebar#initData(fr.redpanda.pander.
	 * entities.User)
	 */
	@Override
	public void initCompany(Company company) {
		initUser(company);
		getLblLink1().setText(company.getLink());
		getLblLink2().setText(company.getContact());
		getLblName1().setText(company.getName());
		getLblName2().setText(company.getSiret());
		getBtnTelechargCV().setVisible(false);
	}

}
