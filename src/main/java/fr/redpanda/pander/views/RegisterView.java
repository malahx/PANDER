/**
 * 
 */
package fr.redpanda.pander.views;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import fr.redpanda.pander.views.base.BaseView;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class RegisterView extends BaseView {

	private JPanel contentPane;
	private JButton btnRegister;
	private JButton btnCancel;
	private JLabel lblTittle;
	private JLabel lblName;
	private JLabel lblOtherName;
	private JLabel lblEmail;
	private JLabel lblPass;
	private JLabel lblPassVerify;
	private JLabel lblInfo;
	private JTextField textName1;
	private JTextField textName2;
	private JTextField textEmail;
	private JPasswordField pwdPass;
	private JPasswordField pwdPassVerify;

	/**
	 * @return the contentPane
	 */
	public JPanel getContentPane() {
		return contentPane;
	}

	/**
	 * @param contentPane
	 *            the contentPane to set
	 */
	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}

	/**
	 * @return the btnRegister
	 */
	public JButton getBtnRegister() {
		return btnRegister;
	}

	/**
	 * @param btnRegister
	 *            the btnRegister to set
	 */
	public void setBtnRegister(JButton btnRegister) {
		this.btnRegister = btnRegister;
	}

	/**
	 * @return the btnCancel
	 */
	public JButton getBtnCancel() {
		return btnCancel;
	}

	/**
	 * @param btnCancel
	 *            the btnCancel to set
	 */
	public void setBtnCancel(JButton btnCancel) {
		this.btnCancel = btnCancel;
	}

	/**
	 * @return the lblTittle
	 */
	public JLabel getLblTittle() {
		return lblTittle;
	}

	/**
	 * @param lblTittle
	 *            the lblTittle to set
	 */
	public void setLblTittle(JLabel lblTittle) {
		this.lblTittle = lblTittle;
	}

	/**
	 * @return the lblName
	 */
	public JLabel getLblName() {
		return lblName;
	}

	/**
	 * @param lblName
	 *            the lblName to set
	 */
	public void setLblName(JLabel lblName) {
		this.lblName = lblName;
	}

	/**
	 * @return the lblOtherName
	 */
	public JLabel getLblOtherName() {
		return lblOtherName;
	}

	/**
	 * @param lblOtherName
	 *            the lblOtherName to set
	 */
	public void setLblOtherName(JLabel lblOtherName) {
		this.lblOtherName = lblOtherName;
	}

	/**
	 * @return the lblEmail
	 */
	public JLabel getLblEmail() {
		return lblEmail;
	}

	/**
	 * @param lblEmail
	 *            the lblEmail to set
	 */
	public void setLblEmail(JLabel lblEmail) {
		this.lblEmail = lblEmail;
	}

	/**
	 * @return the lblPass
	 */
	public JLabel getLblPass() {
		return lblPass;
	}

	/**
	 * @param lblPass
	 *            the lblPass to set
	 */
	public void setLblPass(JLabel lblPass) {
		this.lblPass = lblPass;
	}

	/**
	 * @return the lblPassVerify
	 */
	public JLabel getLblPassVerify() {
		return lblPassVerify;
	}

	/**
	 * @param lblPassVerify
	 *            the lblPassVerify to set
	 */
	public void setLblPassVerify(JLabel lblPassVerify) {
		this.lblPassVerify = lblPassVerify;
	}

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
	 * @return the textName1
	 */
	public JTextField getTextName1() {
		return textName1;
	}

	/**
	 * @param textName1
	 *            the textName1 to set
	 */
	public void setTextName1(JTextField textName1) {
		this.textName1 = textName1;
	}

	/**
	 * @return the textName2
	 */
	public JTextField getTextName2() {
		return textName2;
	}

	/**
	 * @param textName2
	 *            the textName2 to set
	 */
	public void setTextName2(JTextField textName2) {
		this.textName2 = textName2;
	}

	/**
	 * @return the textEmail
	 */
	public JTextField getTextEmail() {
		return textEmail;
	}

	/**
	 * @param textEmail
	 *            the textEmail to set
	 */
	public void setTextEmail(JTextField textEmail) {
		this.textEmail = textEmail;
	}

	/**
	 * @return the pwdPass
	 */
	public JPasswordField getPwdPass() {
		return pwdPass;
	}

	/**
	 * @param pwdPass
	 *            the pwdPass to set
	 */
	public void setPwdPass(JPasswordField pwdPass) {
		this.pwdPass = pwdPass;
	}

	/**
	 * @return the pwdPassVerify
	 */
	public JPasswordField getPwdPassVerify() {
		return pwdPassVerify;
	}

	/**
	 * @param pwdPassVerify
	 *            the pwdPassVerify to set
	 */
	public void setPwdPassVerify(JPasswordField pwdPassVerify) {
		this.pwdPassVerify = pwdPassVerify;
	}

	public boolean isSamePass() {
		return new String(getPwdPass().getPassword()).equals(new String(getPwdPassVerify().getPassword()));
	}
	
	/**
	 * Create the frame.
	 */
	public RegisterView() {
		pageName = "S'enregistrer";
		contentPane = new JPanel();
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		lblTittle = new JLabel("S'ENREGISTRER");
		lblTittle.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		GridBagConstraints gbc_lblTittle = new GridBagConstraints();
		gbc_lblTittle.gridwidth = 5;
		gbc_lblTittle.insets = new Insets(0, 0, 5, 0);
		gbc_lblTittle.gridx = 0;
		gbc_lblTittle.gridy = 2;
		contentPane.add(lblTittle, gbc_lblTittle);

		lblName = new JLabel("Nom 1");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 4;
		contentPane.add(lblName, gbc_lblName);

		textName1 = new JTextField();
		GridBagConstraints gbc_textName1 = new GridBagConstraints();
		gbc_textName1.gridwidth = 2;
		gbc_textName1.insets = new Insets(0, 0, 5, 5);
		gbc_textName1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textName1.gridx = 1;
		gbc_textName1.gridy = 4;
		contentPane.add(textName1, gbc_textName1);
		textName1.setColumns(10);

		lblOtherName = new JLabel("Nom 2");
		GridBagConstraints gbc_lblOtherName = new GridBagConstraints();
		gbc_lblOtherName.anchor = GridBagConstraints.EAST;
		gbc_lblOtherName.insets = new Insets(0, 0, 5, 5);
		gbc_lblOtherName.gridx = 0;
		gbc_lblOtherName.gridy = 5;
		contentPane.add(lblOtherName, gbc_lblOtherName);

		textName2 = new JTextField();
		GridBagConstraints gbc_textName2 = new GridBagConstraints();
		gbc_textName2.gridwidth = 2;
		gbc_textName2.insets = new Insets(0, 0, 5, 5);
		gbc_textName2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textName2.gridx = 1;
		gbc_textName2.gridy = 5;
		contentPane.add(textName2, gbc_textName2);
		textName2.setColumns(10);

		lblEmail = new JLabel("E-mail");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 6;
		contentPane.add(lblEmail, gbc_lblEmail);

		textEmail = new JTextField();
		GridBagConstraints gbc_textEmail = new GridBagConstraints();
		gbc_textEmail.gridwidth = 2;
		gbc_textEmail.insets = new Insets(0, 0, 5, 5);
		gbc_textEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textEmail.gridx = 1;
		gbc_textEmail.gridy = 6;
		contentPane.add(textEmail, gbc_textEmail);
		textEmail.setColumns(10);

		lblPass = new JLabel("Mot de passe");
		GridBagConstraints gbc_lblPass = new GridBagConstraints();
		gbc_lblPass.anchor = GridBagConstraints.EAST;
		gbc_lblPass.insets = new Insets(0, 0, 5, 5);
		gbc_lblPass.gridx = 0;
		gbc_lblPass.gridy = 7;
		contentPane.add(lblPass, gbc_lblPass);

		pwdPass = new JPasswordField();
		GridBagConstraints gbc_pwdPass = new GridBagConstraints();
		gbc_pwdPass.gridwidth = 2;
		gbc_pwdPass.insets = new Insets(0, 0, 5, 5);
		gbc_pwdPass.fill = GridBagConstraints.HORIZONTAL;
		gbc_pwdPass.gridx = 1;
		gbc_pwdPass.gridy = 7;
		contentPane.add(pwdPass, gbc_pwdPass);

		lblPassVerify = new JLabel("Confirmation MP");
		GridBagConstraints gbc_lblPassVerify = new GridBagConstraints();
		gbc_lblPassVerify.anchor = GridBagConstraints.EAST;
		gbc_lblPassVerify.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassVerify.gridx = 0;
		gbc_lblPassVerify.gridy = 8;
		contentPane.add(lblPassVerify, gbc_lblPassVerify);

		pwdPassVerify = new JPasswordField();
		GridBagConstraints gbc_pwdPassVerify = new GridBagConstraints();
		gbc_pwdPassVerify.gridwidth = 2;
		gbc_pwdPassVerify.insets = new Insets(0, 0, 5, 5);
		gbc_pwdPassVerify.fill = GridBagConstraints.HORIZONTAL;
		gbc_pwdPassVerify.gridx = 1;
		gbc_pwdPassVerify.gridy = 8;
		contentPane.add(pwdPassVerify, gbc_pwdPassVerify);

		lblInfo = new JLabel("Merci de compléter ces informations.");
		lblInfo.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		GridBagConstraints gbc_lblInfo = new GridBagConstraints();
		gbc_lblInfo.anchor = GridBagConstraints.WEST;
		gbc_lblInfo.gridwidth = 3;
		gbc_lblInfo.insets = new Insets(0, 0, 5, 0);
		gbc_lblInfo.gridx = 1;
		gbc_lblInfo.gridy = 9;
		contentPane.add(lblInfo, gbc_lblInfo);

		btnCancel = new JButton("Annuler");
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancel.gridx = 1;
		gbc_btnCancel.gridy = 11;
		contentPane.add(btnCancel, gbc_btnCancel);

		btnRegister = new JButton("S'enregistrer");
		btnRegister.setEnabled(false);
		GridBagConstraints gbc_btnRegister = new GridBagConstraints();
		gbc_btnRegister.insets = new Insets(0, 0, 5, 5);
		gbc_btnRegister.gridx = 2;
		gbc_btnRegister.gridy = 11;
		contentPane.add(btnRegister, gbc_btnRegister);
	}

}
