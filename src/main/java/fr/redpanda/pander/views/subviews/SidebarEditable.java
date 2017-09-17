package fr.redpanda.pander.views.subviews;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;

import fr.redpanda.pander.entities.Candidate;
import fr.redpanda.pander.entities.Company;
import fr.redpanda.pander.entities.User;
import fr.redpanda.pander.views.subviews.base.Sidebar;

/**
 * 
 * @author Patrice SCHOCH
 *
 */
public class SidebarEditable extends Sidebar {

	private static final long serialVersionUID = -7876599813851320634L;

	private JTextField txtDescription;
	private JTextField txtPostcode;
	private JTextField txtCity;
	private JTextField txtPhone;
	private JTextField txtMail;
	private JTextField txtAddress;
	private JTextField txtLink1;
	private JTextField txtLink2;
	private JTextField txtName1;
	private JTextField txtName2;

	/**
	 * @return the txtDescription
	 */
	public JTextField getTxtDescription() {
		return txtDescription;
	}

	/**
	 * @param txtDescription
	 *            the txtDescription to set
	 */
	public void setTxtDescription(JTextField txtDescription) {
		this.txtDescription = txtDescription;
	}

	/**
	 * @return the txtPostcode
	 */
	public JTextField getTxtPostcode() {
		return txtPostcode;
	}

	/**
	 * @param txtPostcode
	 *            the txtPostcode to set
	 */
	public void setTxtPostcode(JTextField txtPostcode) {
		this.txtPostcode = txtPostcode;
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
	 * @return the txtAddress
	 */
	public JTextField getTxtAddress() {
		return txtAddress;
	}

	/**
	 * @param txtAddress
	 *            the txtAddress to set
	 */
	public void setTxtAddress(JTextField txtAddress) {
		this.txtAddress = txtAddress;
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
	 * @return the txtName1
	 */
	public JTextField getTxtName1() {
		return txtName1;
	}

	/**
	 * @param txtName1
	 *            the txtName1 to set
	 */
	public void setTxtName1(JTextField txtName1) {
		this.txtName1 = txtName1;
	}

	/**
	 * @return the txtName2
	 */
	public JTextField getTxtName2() {
		return txtName2;
	}

	/**
	 * @param txtName2
	 *            the txtName2 to set
	 */
	public void setTxtName2(JTextField txtName2) {
		this.txtName2 = txtName2;
	}

	/**
	 * The Constructor
	 */
	public SidebarEditable() {
		super();

		txtName1 = new JTextField();
		GridBagConstraints gbc_txtNameOne = new GridBagConstraints();
		gbc_txtNameOne.gridwidth = 4;
		gbc_txtNameOne.insets = new Insets(5, 0, 5, 5);
		gbc_txtNameOne.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNameOne.gridx = 2;
		gbc_txtNameOne.gridy = 2;
		add(txtName1, gbc_txtNameOne);
		txtName1.setColumns(10);

		txtName2 = new JTextField();
		GridBagConstraints gbc_txtNameTwo = new GridBagConstraints();
		gbc_txtNameTwo.gridwidth = 4;
		gbc_txtNameTwo.insets = new Insets(0, 0, 5, 5);
		gbc_txtNameTwo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNameTwo.gridx = 2;
		gbc_txtNameTwo.gridy = 3;
		add(txtName2, gbc_txtNameTwo);
		txtName2.setColumns(10);

		txtDescription = new JTextField();
		GridBagConstraints gbc_txtDescriptionTitle = new GridBagConstraints();
		gbc_txtDescriptionTitle.gridwidth = 5;
		gbc_txtDescriptionTitle.insets = new Insets(0, 5, 5, 5);
		gbc_txtDescriptionTitle.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDescriptionTitle.gridx = 0;
		gbc_txtDescriptionTitle.gridy = 6;
		add(txtDescription, gbc_txtDescriptionTitle);
		txtDescription.setColumns(10);

		txtAddress = new JTextField();
		GridBagConstraints gbc_textAdress = new GridBagConstraints();
		gbc_textAdress.gridwidth = 4;
		gbc_textAdress.insets = new Insets(0, 0, 5, 5);
		gbc_textAdress.fill = GridBagConstraints.HORIZONTAL;
		gbc_textAdress.gridx = 1;
		gbc_textAdress.gridy = 9;
		add(txtAddress, gbc_textAdress);
		txtAddress.setColumns(10);

		txtPostcode = new JTextField();
		GridBagConstraints gbc_textCP = new GridBagConstraints();
		gbc_textCP.gridwidth = 4;
		gbc_textCP.insets = new Insets(0, 0, 5, 5);
		gbc_textCP.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCP.gridx = 1;
		gbc_textCP.gridy = 10;
		add(txtPostcode, gbc_textCP);
		txtPostcode.setColumns(10);

		txtCity = new JTextField();
		GridBagConstraints gbc_textCity = new GridBagConstraints();
		gbc_textCity.gridwidth = 4;
		gbc_textCity.insets = new Insets(0, 0, 5, 5);
		gbc_textCity.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCity.gridx = 1;
		gbc_textCity.gridy = 11;
		add(txtCity, gbc_textCity);
		txtCity.setColumns(10);

		txtPhone = new JTextField();
		GridBagConstraints gbc_textPhone = new GridBagConstraints();
		gbc_textPhone.gridwidth = 4;
		gbc_textPhone.insets = new Insets(0, 0, 5, 5);
		gbc_textPhone.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPhone.gridx = 1;
		gbc_textPhone.gridy = 12;
		add(txtPhone, gbc_textPhone);
		txtPhone.setColumns(10);

		txtMail = new JTextField();
		GridBagConstraints gbc_textMail = new GridBagConstraints();
		gbc_textMail.gridwidth = 4;
		gbc_textMail.insets = new Insets(0, 0, 5, 5);
		gbc_textMail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textMail.gridx = 1;
		gbc_textMail.gridy = 13;
		add(txtMail, gbc_textMail);
		txtMail.setColumns(10);

		txtLink1 = new JTextField();
		GridBagConstraints gbc_textLink1 = new GridBagConstraints();
		gbc_textLink1.gridwidth = 4;
		gbc_textLink1.insets = new Insets(0, 0, 5, 5);
		gbc_textLink1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textLink1.gridx = 1;
		gbc_textLink1.gridy = 16;
		add(txtLink1, gbc_textLink1);
		txtLink1.setColumns(10);

		txtLink2 = new JTextField();
		GridBagConstraints gbc_textLink2 = new GridBagConstraints();
		gbc_textLink2.gridwidth = 4;
		gbc_textLink2.insets = new Insets(0, 0, 5, 5);
		gbc_textLink2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textLink2.gridx = 1;
		gbc_textLink2.gridy = 17;
		add(txtLink2, gbc_textLink2);
		txtLink2.setColumns(10);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.views.subviews.Sidebar#initData(fr.redpanda.pander.
	 * entities.User)
	 */
	@Override
	protected void initUser(User user) {
		getTxtMail().setText(user.getEmail());
		getTxtAddress().setText(user.getAddress());
		getTxtCity().setText(user.getCity());
		getTxtDescription().setText(user.getDescription());
		getTxtPhone().setText(user.getPhone());
		getTxtPostcode().setText(user.getPostcode());
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
		getTxtLink1().setText(candidate.getLink1());
		getTxtLink2().setText(candidate.getLink2());
		getTxtName1().setText(candidate.getFirstname());
		getTxtName2().setText(candidate.getLastname());
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
		initUser(company);
		getTxtLink1().setText(company.getLink());
		getTxtLink2().setText(company.getContact());
		getTxtName1().setText(company.getName());
		getTxtName2().setText(company.getSiret());
	}

}
