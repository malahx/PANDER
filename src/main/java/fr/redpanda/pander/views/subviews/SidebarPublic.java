package fr.redpanda.pander.views.subviews;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;

import fr.redpanda.pander.entities.Candidate;
import fr.redpanda.pander.entities.Company;
import fr.redpanda.pander.entities.User;
import fr.redpanda.pander.utils.constant.PanderColor;
import fr.redpanda.pander.views.subviews.base.Sidebar;

/**
 * 
 * @author Patrice SCHOCH
 *
 */
public class SidebarPublic extends Sidebar {

	private static final long serialVersionUID = -5654665579388722049L;

	private JLabel lblPhoto;
	private JLabel lblName1;
	private JLabel lblName2;
	private JLabel lblDescriptionTitle;
	private JLabel lblPresentation;
	private JLabel lblCoordonateTitle;
	private JLabel lblAddress;
	private JLabel lblCp;
	private JLabel lblCity;
	private JLabel lblPhone;
	private JLabel lblMail;
	private JLabel lblAddress;
	private JLabel lblLink1;
	private JLabel lblLink2;
	private JLabel lblName1;
	private JLabel lblName2;

	/**
	 * @return the lblDescription
	 */
	public JLabel getLblDescription() {
		return lblDescription;
	}

	/**
	 * @param lblDescription
	 *            the lblDescription to set
	 */
	public void setLblDescription(JLabel lblDescription) {
		this.lblDescription = lblDescription;
	}

	/**
	 * @return the lblPostcode
	 */
	public JLabel getLblPostcode() {
		return lblPostcode;
	}

	/**
	 * @param lblPostcode
	 *            the lblPostcode to set
	 */
	public void setLblPostcode(JLabel lblPostcode) {
		this.lblPostcode = lblPostcode;
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
	 * @return the lblAddress
	 */
	public JLabel getLblAddress() {
		return lblAddress;
	}

	/**
	 * @param lblAddress
	 *            the lblAddress to set
	 */
	public void setLblAddress(JLabel lblAddress) {
		this.lblAddress = lblAddress;
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
	 * The Constructor
	 */
	public SidebarPublic() {

		initLayout();

		lblPhoto = new JLabel();
		ImageIcon logoPhotoProfile = new ImageIcon(Img.PROFILE_LOGO);
		lblPhoto.setIcon(logoPhotoProfile);
		GridBagConstraints gbc_lblPhoto = new GridBagConstraints();
		gbc_lblPhoto.anchor = GridBagConstraints.WEST;
		gbc_lblPhoto.gridheight = 4;
		gbc_lblPhoto.insets = new Insets(5, 5, 5, 5);
		gbc_lblPhoto.gridx = 1;
		gbc_lblPhoto.gridy = 1;
		add(lblPhoto, gbc_lblPhoto);

		lblName1 = new JLabel("Name 1");
		GridBagConstraints gbc_lblName1 = new GridBagConstraints();
		gbc_lblName1.gridwidth = 2;
		gbc_lblName1.insets = new Insets(5, 0, 5, 5);
		gbc_lblName1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblName1.gridx = 2;
		gbc_lblName1.gridy = 2;
		add(lblName1, gbc_lblName1);

		lblName2 = new JLabel();
		GridBagConstraints gbc_lblName2 = new GridBagConstraints();
		gbc_lblName2.gridwidth = 2;
		gbc_lblName2.insets = new Insets(0, 0, 5, 5);
		gbc_lblName2.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblName2.gridx = 2;
		gbc_lblName2.gridy = 3;
		add(lblName2, gbc_lblName2);

		lblDescription = new JLabel();
		lblDescription.setFont(new Font(PanderColor.FONT, Font.BOLD, 14));
		GridBagConstraints gbc_lblDescription = new GridBagConstraints();
		gbc_lblDescription.gridwidth = 5;
		gbc_lblDescription.insets = new Insets(0, 5, 5, 5);
		gbc_lblDescription.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblDescription.gridx = 0;
		gbc_lblDescription.gridy = 6;
		add(lblDescription, gbc_lblDescription);

		lblAddress = new JLabel();
		GridBagConstraints gbc_textAddress = new GridBagConstraints();
		gbc_textAddress.gridwidth = 4;
		gbc_textAddress.insets = new Insets(0, 0, 5, 5);
		gbc_textAddress.fill = GridBagConstraints.HORIZONTAL;
		gbc_textAddress.gridx = 1;
		gbc_textAddress.gridy = 9;
		add(lblAddress, gbc_textAddress);

		lblPostcode = new JLabel();
		GridBagConstraints gbc_textPostcode = new GridBagConstraints();
		gbc_textPostcode.gridwidth = 4;
		gbc_textPostcode.insets = new Insets(0, 0, 5, 5);
		gbc_textPostcode.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPostcode.gridx = 1;
		gbc_textPostcode.gridy = 10;
		add(lblPostcode, gbc_textPostcode);

		lblCity = new JLabel();
		GridBagConstraints gbc_textCity = new GridBagConstraints();
		gbc_textCity.gridwidth = 4;
		gbc_textCity.insets = new Insets(0, 0, 5, 5);
		gbc_textCity.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCity.gridx = 1;
		gbc_textCity.gridy = 11;
		add(lblCity, gbc_textCity);

		lblPhone = new JLabel();
		GridBagConstraints gbc_textPhone = new GridBagConstraints();
		gbc_textPhone.gridwidth = 4;
		gbc_textPhone.insets = new Insets(0, 0, 5, 5);
		gbc_textPhone.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPhone.gridx = 1;
		gbc_textPhone.gridy = 12;
		add(lblPhone, gbc_textPhone);

		lblMail = new JLabel();
		GridBagConstraints gbc_textMail = new GridBagConstraints();
		gbc_textMail.gridwidth = 4;
		gbc_textMail.insets = new Insets(0, 0, 5, 5);
		gbc_textMail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textMail.gridx = 1;
		gbc_textMail.gridy = 13;
		add(lblMail, gbc_textMail);

		lblLink1 = new JLabel();
		GridBagConstraints gbc_textLink1 = new GridBagConstraints();
		gbc_textLink1.gridwidth = 4;
		gbc_textLink1.insets = new Insets(0, 0, 5, 5);
		gbc_textLink1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textLink1.gridx = 1;
		gbc_textLink1.gridy = 16;
		add(lblLink1, gbc_textLink1);

		lblLink2 = new JLabel();
		GridBagConstraints gbc_textLink2 = new GridBagConstraints();
		gbc_textLink2.gridwidth = 4;
		gbc_textLink2.insets = new Insets(0, 0, 5, 0);
		gbc_textLink2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textLink2.gridx = 1;
		gbc_textLink2.gridy = 17;
		add(lblLink2, gbc_textLink2);

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
		getLblDescription().setText(user.getDescription());
		getLblPhone().setText(user.getPhone());
		getLblPostcode().setText(user.getPostcode());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.views.subviews.Sidebar#initData(fr.redpanda.pander.
	 * entities.User)
	 */
	@Override
	public void initCandidate(Candidate candidate) {
		super.initCandidate(candidate);
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
		super.initCompany(company);
		getLblLink1().setText(company.getLink());
		getLblLink2().setText(company.getContact());
		getLblName1().setText(company.getName());
		getLblName2().setText(company.getSiret());
	}

}
