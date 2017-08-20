/**
 * 
 */
package fr.redpanda.pander.views;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class AuthView extends BaseView {
	
	private JLabel lblLoginPage;
	private JLabel lblLogin;
	private JLabel lblPassword;
	private JTextField txtLogin;
	private JPasswordField txtPassword;
	private JButton btnValidate;
	
	/**
	 * @return the lblLoginPage
	 */
	public JLabel getLblLoginPage() {
		return lblLoginPage;
	}

	/**
	 * @param lblLoginPage the lblLoginPage to set
	 */
	public void setLblLoginPage(JLabel lblLoginPage) {
		this.lblLoginPage = lblLoginPage;
	}

	/**
	 * @return the lblLogin
	 */
	public JLabel getLblLogin() {
		return lblLogin;
	}

	/**
	 * @param lblLogin the lblLogin to set
	 */
	public void setLblLogin(JLabel lblLogin) {
		this.lblLogin = lblLogin;
	}

	/**
	 * @return the lblPassword
	 */
	public JLabel getLblPassword() {
		return lblPassword;
	}

	/**
	 * @param lblPassword the lblPassword to set
	 */
	public void setLblPassword(JLabel lblPassword) {
		this.lblPassword = lblPassword;
	}

	/**
	 * @return the contentPane
	 */
	public JPanel getContentPane() {
		return contentPane;
	}

	/**
	 * @param contentPane the contentPane to set
	 */
	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}

	/**
	 * @return the txtLogin
	 */
	public JTextField getTxtLogin() {
		return txtLogin;
	}

	/**
	 * @param txtLogin the txtLogin to set
	 */
	public void setTxtLogin(JTextField txtLogin) {
		this.txtLogin = txtLogin;
	}

	/**
	 * @return the txtPassword
	 */
	public JPasswordField getTxtPassword() {
		return txtPassword;
	}

	/**
	 * @param txtPassword the txtPassword to set
	 */
	public void setTxtPassword(JPasswordField txtPassword) {
		this.txtPassword = txtPassword;
	}

	/**
	 * @return the btnValidate
	 */
	public JButton getBtnValidate() {
		return btnValidate;
	}

	/**
	 * @param btnValidate the btnValidate to set
	 */
	public void setBtnValidate(JButton btnValidate) {
		this.btnValidate = btnValidate;
	}
	
	/**
	 * Create the frame.
	 */
	public AuthView(JFrame frame) {
		super.pageName = "Login";
		super.contentPane = new JPanel();
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		lblLoginPage = new JLabel("Login Page");
		GridBagConstraints gbc_lblLoginPage = new GridBagConstraints();
		gbc_lblLoginPage.insets = new Insets(0, 0, 5, 0);
		gbc_lblLoginPage.gridx = 6;
		gbc_lblLoginPage.gridy = 2;
		getContentPane().add(lblLoginPage, gbc_lblLoginPage);
		
		lblLogin = new JLabel("Login");
		GridBagConstraints gbc_lblLogin = new GridBagConstraints();
		gbc_lblLogin.insets = new Insets(0, 0, 5, 5);
		gbc_lblLogin.gridx = 3;
		gbc_lblLogin.gridy = 5;
		getContentPane().add(lblLogin, gbc_lblLogin);
		
		txtLogin = new JTextField();
		GridBagConstraints gbc_txtLogin = new GridBagConstraints();
		gbc_txtLogin.insets = new Insets(0, 0, 5, 0);
		gbc_txtLogin.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLogin.gridx = 6;
		gbc_txtLogin.gridy = 5;
		getContentPane().add(txtLogin, gbc_txtLogin);
		txtLogin.setColumns(10);
		
		lblPassword = new JLabel("Password");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 3;
		gbc_lblPassword.gridy = 7;
		getContentPane().add(lblPassword, gbc_lblPassword);
		
		txtPassword = new JPasswordField();
		GridBagConstraints gbc_txtPassword = new GridBagConstraints();
		gbc_txtPassword.insets = new Insets(0, 0, 5, 0);
		gbc_txtPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPassword.gridx = 6;
		gbc_txtPassword.gridy = 7;
		getContentPane().add(txtPassword, gbc_txtPassword);
		
		btnValidate = new JButton("Validate");
		GridBagConstraints gbc_btnValidate = new GridBagConstraints();
		gbc_btnValidate.gridx = 6;
		gbc_btnValidate.gridy = 9;
		getContentPane().add(btnValidate, gbc_btnValidate);
	}

}
