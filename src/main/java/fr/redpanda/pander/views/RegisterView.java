package fr.redpanda.pander.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;

public class RegisterView extends JFrame {

	private JPanel contentPane;
	private JButton btnRegister;
	private JButton btnCancel;
	private JLabel lblTittle;
	private JLabel lblName;
	private JLabel lblOtherName;
	private JLabel lblEmail;
	private JLabel lblPass;
	private JLabel lblPassVerify;
	private JLabel lblNewLabel_6;
	private JTextField textName1;
	private JTextField textName2;
	private JTextField textEmail;
	private JPasswordField pwdPass;
	private JPasswordField pwdPassVerify;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterView frame = new RegisterView();
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
	public RegisterView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		
		lblNewLabel_6 = new JLabel("Merci de compléter ces informations.");
		lblNewLabel_6.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_6.gridwidth = 3;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 9;
		contentPane.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
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
