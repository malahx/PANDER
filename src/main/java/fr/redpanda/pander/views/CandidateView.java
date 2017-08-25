package fr.redpanda.pander.views;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

/**
 * 
 * @author Patrice SCHOCH
 *
 */
public class CandidateView extends MainView {

	private JPanel contentPane;
	private JTextField textCertificate1;
	private JTextField textCertificate2;
	private JTextField textBirthday;
	private JTextField textTransport;
	private JTable tableTechSkills;
	private JTable tableSoftSkills;

	
	
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
	 * @return the textCertificate1
	 */
	public JTextField getTextCertificate1() {
		return textCertificate1;
	}

	/**
	 * @param textCertificate1 the textCertificate1 to set
	 */
	public void setTextCertificate1(JTextField textCertificate1) {
		this.textCertificate1 = textCertificate1;
	}

	/**
	 * @return the textCertificate2
	 */
	public JTextField getTextCertificate2() {
		return textCertificate2;
	}

	/**
	 * @param textCertificate2 the textCertificate2 to set
	 */
	public void setTextCertificate2(JTextField textCertificate2) {
		this.textCertificate2 = textCertificate2;
	}

	/**
	 * @return the textBirthday
	 */
	public JTextField getTextBirthday() {
		return textBirthday;
	}

	/**
	 * @param textBirthday the textBirthday to set
	 */
	public void setTextBirthday(JTextField textBirthday) {
		this.textBirthday = textBirthday;
	}

	/**
	 * @return the textTransport
	 */
	public JTextField getTextTransport() {
		return textTransport;
	}

	/**
	 * @param textTransport the textTransport to set
	 */
	public void setTextTransport(JTextField textTransport) {
		this.textTransport = textTransport;
	}

	/**
	 * @return the tableTechSkills
	 */
	public JTable getTableTechSkills() {
		return tableTechSkills;
	}

	/**
	 * @param tableTechSkills the tableTechSkills to set
	 */
	public void setTableTechSkills(JTable tableTechSkills) {
		this.tableTechSkills = tableTechSkills;
	}

	/**
	 * @return the tableSoftSkills
	 */
	public JTable getTableSoftSkills() {
		return tableSoftSkills;
	}

	/**
	 * @param tableSoftSkills the tableSoftSkills to set
	 */
	public void setTableSoftSkills(JTable tableSoftSkills) {
		this.tableSoftSkills = tableSoftSkills;
	}

	/**
	 * Launch the application.
	 */
	
	

	/**
	 * Create the frame.
	 */
	public CandidateView() {

		super();
		super.pageName ="Candidate";
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0, 1.0, 0.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblCertificate1 = new JLabel("Diplôme 1");
		GridBagConstraints gbc_lblCertificate1 = new GridBagConstraints();
		gbc_lblCertificate1.anchor = GridBagConstraints.EAST;
		gbc_lblCertificate1.insets = new Insets(0, 0, 5, 5);
		gbc_lblCertificate1.gridx = 1;
		gbc_lblCertificate1.gridy = 1;
		contentPane.add(lblCertificate1, gbc_lblCertificate1);

		textCertificate1 = new JTextField();
		GridBagConstraints gbc_textCertificate1 = new GridBagConstraints();
		gbc_textCertificate1.gridwidth = 5;
		gbc_textCertificate1.insets = new Insets(0, 0, 5, 5);
		gbc_textCertificate1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCertificate1.gridx = 2;
		gbc_textCertificate1.gridy = 1;
		contentPane.add(textCertificate1, gbc_textCertificate1);
		textCertificate1.setColumns(10);

		JLabel lblCertificate2 = new JLabel("Diplôme 2");
		GridBagConstraints gbc_lblCertificate2 = new GridBagConstraints();
		gbc_lblCertificate2.anchor = GridBagConstraints.EAST;
		gbc_lblCertificate2.insets = new Insets(0, 0, 5, 5);
		gbc_lblCertificate2.gridx = 1;
		gbc_lblCertificate2.gridy = 2;
		contentPane.add(lblCertificate2, gbc_lblCertificate2);

		textCertificate2 = new JTextField();
		GridBagConstraints gbc_textCertificate2 = new GridBagConstraints();
		gbc_textCertificate2.gridwidth = 5;
		gbc_textCertificate2.insets = new Insets(0, 0, 5, 5);
		gbc_textCertificate2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCertificate2.gridx = 2;
		gbc_textCertificate2.gridy = 2;
		contentPane.add(textCertificate2, gbc_textCertificate2);
		textCertificate2.setColumns(10);

		JLabel lblBirthday = new JLabel("Date de naissance");
		GridBagConstraints gbc_lblBirthday = new GridBagConstraints();
		gbc_lblBirthday.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblBirthday.insets = new Insets(0, 0, 5, 5);
		gbc_lblBirthday.gridx = 1;
		gbc_lblBirthday.gridy = 3;
		contentPane.add(lblBirthday, gbc_lblBirthday);

		textBirthday = new JTextField();
		GridBagConstraints gbc_textBirthday = new GridBagConstraints();
		gbc_textBirthday.gridwidth = 2;
		gbc_textBirthday.insets = new Insets(0, 0, 5, 5);
		gbc_textBirthday.fill = GridBagConstraints.HORIZONTAL;
		gbc_textBirthday.gridx = 2;
		gbc_textBirthday.gridy = 3;
		contentPane.add(textBirthday, gbc_textBirthday);
		textBirthday.setColumns(10);

		JLabel lblTransport = new JLabel("Transport");
		GridBagConstraints gbc_lblTransport = new GridBagConstraints();
		gbc_lblTransport.anchor = GridBagConstraints.EAST;
		gbc_lblTransport.insets = new Insets(0, 0, 5, 5);
		gbc_lblTransport.gridx = 4;
		gbc_lblTransport.gridy = 3;
		contentPane.add(lblTransport, gbc_lblTransport);

		textTransport = new JTextField();
		GridBagConstraints gbc_textTransport = new GridBagConstraints();
		gbc_textTransport.gridwidth = 2;
		gbc_textTransport.insets = new Insets(0, 0, 5, 5);
		gbc_textTransport.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTransport.gridx = 5;
		gbc_textTransport.gridy = 3;
		contentPane.add(textTransport, gbc_textTransport);
		textTransport.setColumns(10);

		JLabel lblTechSkillsTitle = new JLabel("Compétences techniques");
		GridBagConstraints gbc_lblTechSkillsTitle = new GridBagConstraints();
		gbc_lblTechSkillsTitle.gridwidth = 2;
		gbc_lblTechSkillsTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblTechSkillsTitle.gridx = 1;
		gbc_lblTechSkillsTitle.gridy = 6;
		contentPane.add(lblTechSkillsTitle, gbc_lblTechSkillsTitle);

		JLabel lblSoftSkillsTitle = new JLabel("Soft Skills");
		GridBagConstraints gbc_lblSoftSkillsTitle = new GridBagConstraints();
		gbc_lblSoftSkillsTitle.gridwidth = 2;
		gbc_lblSoftSkillsTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblSoftSkillsTitle.gridx = 4;
		gbc_lblSoftSkillsTitle.gridy = 6;
		contentPane.add(lblSoftSkillsTitle, gbc_lblSoftSkillsTitle);

		JScrollPane scrollPaneTechSkills = new JScrollPane();
		scrollPaneTechSkills.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneTechSkills.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_scrollPaneTechSkills = new GridBagConstraints();
		gbc_scrollPaneTechSkills.gridheight = 4;
		gbc_scrollPaneTechSkills.gridwidth = 2;
		gbc_scrollPaneTechSkills.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPaneTechSkills.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneTechSkills.gridx = 1;
		gbc_scrollPaneTechSkills.gridy = 7;
		contentPane.add(scrollPaneTechSkills, gbc_scrollPaneTechSkills);

		tableTechSkills = new JTable();
		scrollPaneTechSkills.setViewportView(tableTechSkills);

		JScrollPane scrollPaneSoftSkills = new JScrollPane();
		scrollPaneSoftSkills.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneSoftSkills.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_scrollPaneSoftSkills = new GridBagConstraints();
		gbc_scrollPaneSoftSkills.gridheight = 4;
		gbc_scrollPaneSoftSkills.gridwidth = 2;
		gbc_scrollPaneSoftSkills.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPaneSoftSkills.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneSoftSkills.gridx = 4;
		gbc_scrollPaneSoftSkills.gridy = 7;
		contentPane.add(scrollPaneSoftSkills, gbc_scrollPaneSoftSkills);
		
		tableSoftSkills = new JTable();
		scrollPaneSoftSkills.setViewportView(tableSoftSkills);
	}

}
