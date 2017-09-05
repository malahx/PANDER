package fr.redpanda.pander.views;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import fr.redpanda.pander.utils.constant.Img;
import fr.redpanda.pander.utils.views.ViewUtils;
import fr.redpanda.pander.views.base.BaseView;

/**
 * 
 * @author Patrice SCHOCH
 *
 */
public class AuthView extends BaseView {

	private JTextField txtLogin;
	private JPasswordField txtPassword;
	private JButton btnPassword;
	private JButton btnValidate;
	private JButton btnCandidate;
	private JButton btnCompany;

	/**
	 * @return the txtLogin
	 */
	public JTextField getTxtLogin() {
		return txtLogin;
	}

	/**
	 * @param txtLogin
	 *            the txtLogin to set
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
	 * @param txtPassword
	 *            the txtPassword to set
	 */
	public void setTxtPassword(JPasswordField txtPassword) {
		this.txtPassword = txtPassword;
	}

	/**
	 * @return the btnPassword
	 */
	public JButton getBtnPassword() {
		return btnPassword;
	}

	/**
	 * @param btnPassword
	 *            the btnPassword to set
	 */
	public void setBtnPassword(JButton btnPassword) {
		this.btnPassword = btnPassword;
	}

	/**
	 * @return the btnValidate
	 */
	public JButton getBtnValidate() {
		return btnValidate;
	}

	/**
	 * @param btnValidate
	 *            the btnValidate to set
	 */
	public void setBtnValidate(JButton btnValidate) {
		this.btnValidate = btnValidate;
	}

	/**
	 * @return the btnCandidate
	 */
	public JButton getBtnCandidate() {
		return btnCandidate;
	}

	/**
	 * @param btnCandidate
	 *            the btnCandidate to set
	 */
	public void setBtnCandidate(JButton btnCandidate) {
		this.btnCandidate = btnCandidate;
	}

	/**
	 * @return the btnCompany
	 */
	public JButton getBtnCompany() {
		return btnCompany;
	}

	/**
	 * @param btnCompany
	 *            the btnCompany to set
	 */
	public void setBtnCompany(JButton btnCompany) {
		this.btnCompany = btnCompany;
	}

	/**
	 * Create the frame.
	 */
	public AuthView() {
		super();
		pageName = "Authentification";
		contentPane = new JPanel();

		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0 };
		gbl_contentPane.rowWeights = new double[] { 0.0, 1.0 };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblLogoImie = new JLabel();
		ImageIcon imieIcon = new ImageIcon(Img.LOGO_IMIE);
		lblLogoImie.setIcon(imieIcon);
		GridBagConstraints gbc_lblLogoImie = new GridBagConstraints();
		gbc_lblLogoImie.anchor = GridBagConstraints.WEST;
		gbc_lblLogoImie.insets = new Insets(0, 0, 5, 5);
		gbc_lblLogoImie.gridx = 0;
		gbc_lblLogoImie.gridy = 0;
		contentPane.add(lblLogoImie, gbc_lblLogoImie);

		JLabel lblPander = new JLabel();
		ImageIcon titleIcon = new ImageIcon(Img.TITLE);
		lblPander.setIcon(titleIcon);
		lblPander.setFont(new Font("Lucida Grande", Font.BOLD, 35));
		GridBagConstraints gbc_lblPander = new GridBagConstraints();
		gbc_lblPander.insets = new Insets(0, 0, 5, 0);
		gbc_lblPander.gridx = 1;
		gbc_lblPander.gridy = 0;
		contentPane.add(lblPander, gbc_lblPander);

		JLabel lblLogo = new JLabel();
		ImageIcon logoIcon = new ImageIcon(Img.LOGO_PANDER1);
		lblLogo.setIcon(logoIcon);
		lblLogo.setFont(new Font("Lucida Grande", Font.PLAIN, 36));
		GridBagConstraints gbc_lblLogo = new GridBagConstraints();
		gbc_lblLogo.insets = new Insets(0, 50, 0, 5);
		gbc_lblLogo.gridx = 0;
		gbc_lblLogo.gridy = 1;
		contentPane.add(lblLogo, gbc_lblLogo);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, 1.0, 1.0 };
		panel.setLayout(gbl_panel);

		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JLabel lblSidentifier = new JLabel("S'IDENTIFIER :");
		lblSidentifier.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		GridBagConstraints gbc_lblSidentifier = new GridBagConstraints();
		gbc_lblSidentifier.insets = new Insets(0, 100, 5, 5);
		gbc_lblSidentifier.gridx = 0;
		gbc_lblSidentifier.gridy = 0;
		panel_1.add(lblSidentifier, gbc_lblSidentifier);

		JLabel lblIdentifiant = new JLabel("Identifiant");
		GridBagConstraints gbc_lblIdentifiant = new GridBagConstraints();
		gbc_lblIdentifiant.anchor = GridBagConstraints.EAST;
		gbc_lblIdentifiant.insets = new Insets(0, 0, 5, 5);
		gbc_lblIdentifiant.gridx = 0;
		gbc_lblIdentifiant.gridy = 2;
		panel_1.add(lblIdentifiant, gbc_lblIdentifiant);

		txtLogin = new JTextField();
		GridBagConstraints gbc_txtLogin = new GridBagConstraints();
		gbc_txtLogin.insets = new Insets(0, 0, 5, 50);
		gbc_txtLogin.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLogin.gridx = 2;
		gbc_txtLogin.gridy = 2;
		panel_1.add(txtLogin, gbc_txtLogin);
		txtLogin.setColumns(10);

		JLabel lblMotDePasse = new JLabel("Mot de passe");
		GridBagConstraints gbc_lblMotDePasse = new GridBagConstraints();
		gbc_lblMotDePasse.anchor = GridBagConstraints.EAST;
		gbc_lblMotDePasse.insets = new Insets(0, 0, 5, 5);
		gbc_lblMotDePasse.gridx = 0;
		gbc_lblMotDePasse.gridy = 4;
		panel_1.add(lblMotDePasse, gbc_lblMotDePasse);

		txtPassword = new JPasswordField();
		GridBagConstraints gbc_txtPassword = new GridBagConstraints();
		gbc_txtPassword.insets = new Insets(0, 0, 5, 50);
		gbc_txtPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPassword.gridx = 2;
		gbc_txtPassword.gridy = 4;
		panel_1.add(txtPassword, gbc_txtPassword);

		btnPassword = new JButton("Mot de passe oublié ?");
		btnPassword.setFont(new Font("Lucida Grande", Font.ITALIC, 10));
		btnPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnPassword = new GridBagConstraints();
		gbc_btnPassword.anchor = GridBagConstraints.WEST;
		gbc_btnPassword.insets = new Insets(0, 0, 5, 0);
		gbc_btnPassword.gridx = 2;
		gbc_btnPassword.gridy = 5;
		panel_1.add(btnPassword, gbc_btnPassword);

		btnValidate = new JButton("VALIDER");
		btnValidate.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GridBagConstraints gbc_btnValidate = new GridBagConstraints();
		gbc_btnValidate.anchor = GridBagConstraints.EAST;
		gbc_btnValidate.insets = new Insets(0, 0, 5, 50);
		gbc_btnValidate.gridx = 2;
		gbc_btnValidate.gridy = 6;
		panel_1.add(btnValidate, gbc_btnValidate);

		JLabel lblSenregistrer = new JLabel("S'ENREGISTRER :");
		lblSenregistrer.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		GridBagConstraints gbc_lblSenregistrer = new GridBagConstraints();
		gbc_lblSenregistrer.anchor = GridBagConstraints.WEST;
		gbc_lblSenregistrer.insets = new Insets(0, 100, 5, 0);
		gbc_lblSenregistrer.gridx = 0;
		gbc_lblSenregistrer.gridy = 1;
		panel.add(lblSenregistrer, gbc_lblSenregistrer);

		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 2;
		panel.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel_2.rowHeights = new int[] { 0, 0 };
		gbl_panel_2.columnWeights = new double[] { 1.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 100, 0, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 0;
		panel_2.add(panel_3, gbc_panel_3);

		btnCandidate = new JButton();
		ImageIcon registerCandidateIcon = new ImageIcon(Img.REGISTER_CANDIDATE);
		btnCandidate.setIcon(registerCandidateIcon);
		btnCandidate.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		btnCandidate.setBorder(BorderFactory.createEmptyBorder());
		panel_3.add(btnCandidate);

		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.gridwidth = 4;
		gbc_panel_4.insets = new Insets(0, 0, 0, 5);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 1;
		gbc_panel_4.gridy = 0;
		panel_2.add(panel_4, gbc_panel_4);

		btnCompany = new JButton();
		ImageIcon registerCompanyIcon = new ImageIcon(Img.REGISTER_COMPANY);
		btnCompany.setIcon(registerCompanyIcon);
		btnCompany.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		btnCompany.setBorder(BorderFactory.createEmptyBorder());
		panel_4.add(btnCompany);

		ViewUtils.colorWhite(panel_1);
		ViewUtils.colorWhite(panel_2);
		ViewUtils.colorWhite(panel_3);
		ViewUtils.colorWhite(panel_4);
		ViewUtils.colorWhite(panel);
		ViewUtils.colorWhite(btnCandidate);
		ViewUtils.colorWhite(btnCompany);
		ViewUtils.colorLight(btnValidate);
		ViewUtils.colorGreyLight(btnPassword);

	}

}
