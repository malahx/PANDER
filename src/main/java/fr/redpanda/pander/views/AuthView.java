package fr.redpanda.pander.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AuthView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AuthView frame = new AuthView();
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
	public AuthView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {0, 0};
		gbl_contentPane.rowHeights = new int[] {0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblLogoImie = new JLabel("Logo IMIE");
		GridBagConstraints gbc_lblLogoImie = new GridBagConstraints();
		gbc_lblLogoImie.anchor = GridBagConstraints.WEST;
		gbc_lblLogoImie.insets = new Insets(0, 0, 5, 5);
		gbc_lblLogoImie.gridx = 0;
		gbc_lblLogoImie.gridy = 0;
		contentPane.add(lblLogoImie, gbc_lblLogoImie);
		
		JLabel lblPander = new JLabel("PANDER");
		lblPander.setFont(new Font("Lucida Grande", Font.BOLD, 35));
		GridBagConstraints gbc_lblPander = new GridBagConstraints();
		gbc_lblPander.insets = new Insets(0, 0, 5, 0);
		gbc_lblPander.gridx = 1;
		gbc_lblPander.gridy = 0;
		contentPane.add(lblPander, gbc_lblPander);
		
		JLabel lblLogo = new JLabel("LOGO");
		lblLogo.setFont(new Font("Lucida Grande", Font.PLAIN, 36));
		GridBagConstraints gbc_lblLogo = new GridBagConstraints();
		gbc_lblLogo.insets = new Insets(0, 0, 0, 5);
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
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[] {0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, 1.0};
		panel.setLayout(gbl_panel);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblSidentifier = new JLabel("S'IDENTIFIER :");
		lblSidentifier.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		GridBagConstraints gbc_lblSidentifier = new GridBagConstraints();
		gbc_lblSidentifier.insets = new Insets(0, 0, 5, 5);
		gbc_lblSidentifier.gridx = 0;
		gbc_lblSidentifier.gridy = 0;
		panel_1.add(lblSidentifier, gbc_lblSidentifier);
		
		JLabel lblIdentifiant = new JLabel("Identifiant");
		GridBagConstraints gbc_lblIdentifiant = new GridBagConstraints();
		gbc_lblIdentifiant.insets = new Insets(0, 0, 5, 5);
		gbc_lblIdentifiant.gridx = 0;
		gbc_lblIdentifiant.gridy = 2;
		panel_1.add(lblIdentifiant, gbc_lblIdentifiant);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 2;
		panel_1.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe");
		GridBagConstraints gbc_lblMotDePasse = new GridBagConstraints();
		gbc_lblMotDePasse.insets = new Insets(0, 0, 5, 5);
		gbc_lblMotDePasse.gridx = 0;
		gbc_lblMotDePasse.gridy = 4;
		panel_1.add(lblMotDePasse, gbc_lblMotDePasse);
		
		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 0, 5, 0);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 2;
		gbc_passwordField.gridy = 4;
		panel_1.add(passwordField, gbc_passwordField);
		
		JButton btnMotDePasse = new JButton("Mot de passe oublié ?");
		btnMotDePasse.setFont(new Font("Lucida Grande", Font.ITALIC, 10));
		btnMotDePasse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnMotDePasse = new GridBagConstraints();
		gbc_btnMotDePasse.anchor = GridBagConstraints.WEST;
		gbc_btnMotDePasse.insets = new Insets(0, 0, 5, 0);
		gbc_btnMotDePasse.gridx = 2;
		gbc_btnMotDePasse.gridy = 5;
		panel_1.add(btnMotDePasse, gbc_btnMotDePasse);
		
		JButton btnValider = new JButton("VALIDER");
		btnValider.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GridBagConstraints gbc_btnValider = new GridBagConstraints();
		gbc_btnValider.anchor = GridBagConstraints.EAST;
		gbc_btnValider.insets = new Insets(0, 0, 5, 0);
		gbc_btnValider.gridx = 2;
		gbc_btnValider.gridy = 6;
		panel_1.add(btnValider, gbc_btnValider);
		
		JLabel lblSenregistrer = new JLabel("S'ENREGISTRER :");
		lblSenregistrer.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		GridBagConstraints gbc_lblSenregistrer = new GridBagConstraints();
		gbc_lblSenregistrer.anchor = GridBagConstraints.WEST;
		gbc_lblSenregistrer.insets = new Insets(0, 0, 5, 0);
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
		gbl_panel_2.columnWidths = new int[] {0, 0, 0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 0, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 0;
		panel_2.add(panel_3, gbc_panel_3);
		
		JButton btnCandidat = new JButton("CANDIDAT");
		btnCandidat.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		panel_3.add(btnCandidat);
		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.gridwidth = 4;
		gbc_panel_4.insets = new Insets(0, 0, 0, 5);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 1;
		gbc_panel_4.gridy = 0;
		panel_2.add(panel_4, gbc_panel_4);
		
		JButton btnEntreprise = new JButton("ENTREPRISE");
		btnEntreprise.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		panel_4.add(btnEntreprise);
	}

}
