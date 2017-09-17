/**
 * 
 */
package fr.redpanda.pander.views.subviews.base;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.redpanda.pander.entities.Candidate;
import fr.redpanda.pander.entities.Company;
import fr.redpanda.pander.entities.User;
import fr.redpanda.pander.utils.constant.Img;
import fr.redpanda.pander.utils.constant.PanderColor;
import fr.redpanda.pander.utils.views.ViewUtils;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public abstract class Sidebar extends JPanel {

	private static final long serialVersionUID = -3102325959457435902L;

	protected JLabel lblPhoto;
	protected JLabel lblName1Title;
	protected JLabel lblName2Title;
	protected JLabel lblDescriptionTitle;
	protected JLabel lblCoordonateTitle;
	protected JLabel lblAddressTitle;
	protected JLabel lblPostcodeTitle;
	protected JLabel lblCityTitle;
	protected JLabel lblPhoneTitle;
	protected JLabel lblMailTitle;
	protected JLabel lblSocialLinks;
	protected JLabel lblLink1Title;
	protected JLabel lblLink2Title;
	protected JButton btnTelechargCV;
	protected JButton btnSeeCV;
	protected JLabel lblCurriculumVitae;

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
	 * @return the lblName1Title
	 */
	public JLabel getLblName1Title() {
		return lblName1Title;
	}

	/**
	 * @param lblName1Title
	 *            the lblName1Title to set
	 */
	public void setLblName1Title(JLabel lblName1Title) {
		this.lblName1Title = lblName1Title;
	}

	/**
	 * @return the lblName2Title
	 */
	public JLabel getLblName2Title() {
		return lblName2Title;
	}

	/**
	 * @param lblName2Title
	 *            the lblName2Title to set
	 */
	public void setLblName2Title(JLabel lblName2Title) {
		this.lblName2Title = lblName2Title;
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
	 * @return the lblAddressTitle
	 */
	public JLabel getLblAddressTitle() {
		return lblAddressTitle;
	}

	/**
	 * @param lblAddressTitle
	 *            the lblAddressTitle to set
	 */
	public void setLblAddressTitle(JLabel lblAddressTitle) {
		this.lblAddressTitle = lblAddressTitle;
	}

	/**
	 * @return the lblPostcodeTitle
	 */
	public JLabel getLblPostcodeTitle() {
		return lblPostcodeTitle;
	}

	/**
	 * @param lblPostcodeTitle
	 *            the lblPostcodeTitle to set
	 */
	public void setLblPostcodeTitle(JLabel lblPostcodeTitle) {
		this.lblPostcodeTitle = lblPostcodeTitle;
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
	 * @return the btnTelechargCV
	 */
	public JButton getBtnTelechargCV() {
		return btnTelechargCV;
	}

	/**
	 * @param btnTelechargCV
	 *            the btnTelechargCV to set
	 */
	public void setBtnTelechargCV(JButton btnTelechargCV) {
		this.btnTelechargCV = btnTelechargCV;
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
	 * Initialize the sidebar datas
	 * 
	 * @param user
	 *            the user to take datas
	 */
	protected abstract void initUser(User user);

	/**
	 * Initialize the sidebar datas
	 * 
	 * @param user
	 *            the user to take datas
	 */
	public void initCandidate(Candidate candidate) {
		initUser(candidate);
		getBtnSeeCV().setVisible(false);
		getBtnTelechargCV().setVisible(false);
		getLblCurriculumVitae().setVisible(false);
		getLblLink1Title().setText("Lien 1");
		getLblLink2Title().setText("Lien 2");
		getLblName1Title().setText("Prénom");
		getLblName2Title().setText("Nom");
	}

	/**
	 * Initialize the sidebar datas
	 * 
	 * @param user
	 *            the user to take datas
	 */
	public void initCompany(Company company) {
		initUser(company);
		getBtnSeeCV().setVisible(false);
		getBtnTelechargCV().setVisible(false);
		getLblCurriculumVitae().setVisible(false);
		getLblLink1Title().setText("Lien");
		getLblLink2Title().setText("Contact");
		getLblName1Title().setText("Nom");
		getLblName2Title().setText("SIRET");
	}

	/**
	 * The constructor
	 */
	protected Sidebar() {
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0 };
		gbl_contentPane.columnWeights = new double[] { 0, 0.0, 0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gbl_contentPane);

		JLabel lblPhoto = new JLabel();
		ImageIcon logoPhotoProfile = new ImageIcon(Img.PROFILE_LOGO);
		lblPhoto.setIcon(logoPhotoProfile);
		lblPhoto.setFont(new Font(PanderColor.FONT, Font.PLAIN, 36));
		GridBagConstraints gbc_lblPhoto = new GridBagConstraints();
		gbc_lblPhoto.anchor = GridBagConstraints.WEST;
		gbc_lblPhoto.gridheight = 3;
		gbc_lblPhoto.insets = new Insets(5, 5, 5, 5);
		gbc_lblPhoto.gridx = 0;
		gbc_lblPhoto.gridy = 2;
		add(lblPhoto, gbc_lblPhoto);

		lblName1Title = new JLabel("Name1");
		lblName1Title.setFont(new Font(PanderColor.FONT, Font.PLAIN, 11));
		GridBagConstraints gbc_lblNameOne = new GridBagConstraints();
		gbc_lblNameOne.anchor = GridBagConstraints.EAST;
		gbc_lblNameOne.gridwidth = 2;
		gbc_lblNameOne.insets = new Insets(5, 5, 5, 5);
		gbc_lblNameOne.gridx = 0;
		gbc_lblNameOne.gridy = 2;
		add(lblName1Title, gbc_lblNameOne);

		lblName2Title = new JLabel("Name2");
		lblName2Title.setFont(new Font(PanderColor.FONT, Font.PLAIN, 11));
		GridBagConstraints gbc_jlblNameTwo = new GridBagConstraints();
		gbc_jlblNameTwo.anchor = GridBagConstraints.EAST;
		gbc_jlblNameTwo.gridwidth = 2;
		gbc_jlblNameTwo.insets = new Insets(0, 5, 5, 5);
		gbc_jlblNameTwo.gridx = 0;
		gbc_jlblNameTwo.gridy = 3;
		add(lblName2Title, gbc_jlblNameTwo);

		lblDescriptionTitle = new JLabel("DESCRIPTION");
		lblDescriptionTitle.setFont(new Font(PanderColor.FONT, Font.BOLD, 13));
		GridBagConstraints gbc_lblDescriptionTitle = new GridBagConstraints();
		gbc_lblDescriptionTitle.gridwidth = 2;
		gbc_lblDescriptionTitle.insets = new Insets(0, 5, 5, 5);
		gbc_lblDescriptionTitle.gridx = 0;
		gbc_lblDescriptionTitle.gridy = 5;
		add(lblDescriptionTitle, gbc_lblDescriptionTitle);

		lblCoordonateTitle = new JLabel("COORDONNEES");
		lblCoordonateTitle.setFont(new Font(PanderColor.FONT, Font.BOLD, 13));
		GridBagConstraints gbc_lblCoordonateTittle = new GridBagConstraints();
		gbc_lblCoordonateTittle.gridwidth = 2;
		gbc_lblCoordonateTittle.insets = new Insets(0, 5, 5, 5);
		gbc_lblCoordonateTittle.gridx = 0;
		gbc_lblCoordonateTittle.gridy = 8;
		add(lblCoordonateTitle, gbc_lblCoordonateTittle);

		lblAddressTitle = new JLabel("Adresse");
		lblAddressTitle.setFont(new Font(PanderColor.FONT, Font.PLAIN, 11));
		GridBagConstraints gbc_lblAdressTitle = new GridBagConstraints();
		gbc_lblAdressTitle.anchor = GridBagConstraints.EAST;
		gbc_lblAdressTitle.insets = new Insets(0, 5, 5, 5);
		gbc_lblAdressTitle.gridx = 0;
		gbc_lblAdressTitle.gridy = 9;
		add(lblAddressTitle, gbc_lblAdressTitle);

		lblPostcodeTitle = new JLabel("Code Postal");
		lblPostcodeTitle.setFont(new Font(PanderColor.FONT, Font.PLAIN, 11));
		GridBagConstraints gbc_lblCpTitle = new GridBagConstraints();
		gbc_lblCpTitle.anchor = GridBagConstraints.EAST;
		gbc_lblCpTitle.insets = new Insets(0, 5, 5, 5);
		gbc_lblCpTitle.gridx = 0;
		gbc_lblCpTitle.gridy = 10;
		add(lblPostcodeTitle, gbc_lblCpTitle);

		lblCityTitle = new JLabel("Ville");
		lblCityTitle.setFont(new Font(PanderColor.FONT, Font.PLAIN, 11));
		GridBagConstraints gbc_lblCityTitle = new GridBagConstraints();
		gbc_lblCityTitle.anchor = GridBagConstraints.EAST;
		gbc_lblCityTitle.insets = new Insets(0, 5, 5, 5);
		gbc_lblCityTitle.gridx = 0;
		gbc_lblCityTitle.gridy = 11;
		add(lblCityTitle, gbc_lblCityTitle);

		lblPhoneTitle = new JLabel("Téléphone");
		lblPhoneTitle.setFont(new Font(PanderColor.FONT, Font.PLAIN, 11));
		GridBagConstraints gbc_lblPhoneTitle = new GridBagConstraints();
		gbc_lblPhoneTitle.anchor = GridBagConstraints.EAST;
		gbc_lblPhoneTitle.insets = new Insets(0, 5, 5, 5);
		gbc_lblPhoneTitle.gridx = 0;
		gbc_lblPhoneTitle.gridy = 12;
		add(lblPhoneTitle, gbc_lblPhoneTitle);

		lblMailTitle = new JLabel("E-Mail");
		lblMailTitle.setFont(new Font(PanderColor.FONT, Font.PLAIN, 11));
		GridBagConstraints gbc_lblMailTitle = new GridBagConstraints();
		gbc_lblMailTitle.anchor = GridBagConstraints.EAST;
		gbc_lblMailTitle.insets = new Insets(0, 5, 5, 5);
		gbc_lblMailTitle.gridx = 0;
		gbc_lblMailTitle.gridy = 13;
		add(lblMailTitle, gbc_lblMailTitle);

		lblSocialLinks = new JLabel("SOCIAL LINKS");
		lblSocialLinks.setFont(new Font(PanderColor.FONT, Font.BOLD, 13));
		GridBagConstraints gbc_lblSocialLinks = new GridBagConstraints();
		gbc_lblSocialLinks.gridwidth = 2;
		gbc_lblSocialLinks.insets = new Insets(0, 5, 5, 5);
		gbc_lblSocialLinks.gridx = 0;
		gbc_lblSocialLinks.gridy = 15;
		add(lblSocialLinks, gbc_lblSocialLinks);

		lblLink1Title = new JLabel("Link 1");
		lblLink1Title.setFont(new Font(PanderColor.FONT, Font.PLAIN, 11));
		GridBagConstraints gbc_lblLink1Title = new GridBagConstraints();
		gbc_lblLink1Title.anchor = GridBagConstraints.EAST;
		gbc_lblLink1Title.insets = new Insets(0, 5, 5, 5);
		gbc_lblLink1Title.gridx = 0;
		gbc_lblLink1Title.gridy = 16;
		add(lblLink1Title, gbc_lblLink1Title);

		lblLink2Title = new JLabel("Link 2 / Contact");
		lblLink2Title.setFont(new Font(PanderColor.FONT, Font.PLAIN, 11));
		GridBagConstraints gbc_lblLinkTitle = new GridBagConstraints();
		gbc_lblLinkTitle.anchor = GridBagConstraints.EAST;
		gbc_lblLinkTitle.insets = new Insets(0, 5, 5, 5);
		gbc_lblLinkTitle.gridx = 0;
		gbc_lblLinkTitle.gridy = 17;
		add(lblLink2Title, gbc_lblLinkTitle);

		lblCurriculumVitae = new JLabel("CURRICULUM VITAE");
		lblCurriculumVitae.setFont(new Font(PanderColor.FONT, Font.BOLD, 13));
		GridBagConstraints gbc_lblCurriculumVitae = new GridBagConstraints();
		gbc_lblCurriculumVitae.insets = new Insets(0, 5, 5, 5);
		gbc_lblCurriculumVitae.gridx = 0;
		gbc_lblCurriculumVitae.gridy = 19;
		add(lblCurriculumVitae, gbc_lblCurriculumVitae);

		btnTelechargCV = new JButton("Télécharger");
		btnTelechargCV.setFont(new Font(PanderColor.FONT, Font.PLAIN, 11));
		GridBagConstraints gbc_btnTelechargCV = new GridBagConstraints();
		gbc_btnTelechargCV.insets = new Insets(0, 5, 5, 5);
		gbc_btnTelechargCV.gridx = 0;
		gbc_btnTelechargCV.gridy = 20;
		add(btnTelechargCV, gbc_btnTelechargCV);

		btnSeeCV = new JButton("Voir");
		btnSeeCV.setFont(new Font(PanderColor.FONT, Font.PLAIN, 11));
		GridBagConstraints gbc_btnSeeCV = new GridBagConstraints();
		gbc_btnSeeCV.insets = new Insets(0, 5, 5, 0);
		gbc_btnSeeCV.gridx = 4;
		gbc_btnSeeCV.gridy = 20;
		add(btnSeeCV, gbc_btnSeeCV);

		JLabel label = new JLabel("");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 5, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 22;
		add(label, gbc_label);

		ViewUtils.colorGrey(this);

	}

}
