/**
 * 
 */
package fr.redpanda.pander.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.JList;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTable;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class CompanyView extends JFrame {

	private JPanel contentPane;
	private JPanel pnlJobList;
	private JPanel pnlJobInfo;
	private JPanel pnlSkillList;
	private JLabel lblJobList;
	private JScrollPane scrPJobList;
	private JList lstJob;
	private JLabel lblName;
	private JTextField txtName;
	private JLabel lblContact;
	private JTextField txtContact;
	private JLabel lblLien;
	private JTextField txtLink;
	private JLabel lblInfos;
	private JTextArea txtrInfos;
	private JLabel lblTechSkills;
	private JScrollPane scrPTechSkills;
	private JTable tblTechSkills;
	private JLabel lblSoftSkills;
	private JScrollPane scrPSoftSkills;
	private JPanel pnlSoftSkills;
	private JPanel pnlTechSkills;
	private JTable tblSoftSkills;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CompanyView frame = new CompanyView();
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
	public CompanyView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 1.0 };
		gbl_contentPane.rowWeights = new double[] { 0.0 };
		contentPane.setLayout(gbl_contentPane);

		pnlJobList = new JPanel();
		GridBagConstraints gbc_pnlJobList = new GridBagConstraints();
		gbc_pnlJobList.insets = new Insets(0, 0, 5, 5);
		gbc_pnlJobList.fill = GridBagConstraints.BOTH;
		gbc_pnlJobList.gridx = 0;
		gbc_pnlJobList.gridy = 0;
		contentPane.add(pnlJobList, gbc_pnlJobList);
		pnlJobList.setLayout(new BoxLayout(pnlJobList, BoxLayout.Y_AXIS));

		lblJobList = new JLabel("Liste de Poste");
		pnlJobList.add(lblJobList);

		scrPJobList = new JScrollPane();
		scrPJobList.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrPJobList.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pnlJobList.add(scrPJobList);

		lstJob = new JList();
		scrPJobList.setViewportView(lstJob);

		pnlJobInfo = new JPanel();
		GridBagConstraints gbc_pnlJobInfo = new GridBagConstraints();
		gbc_pnlJobInfo.insets = new Insets(0, 0, 5, 5);
		gbc_pnlJobInfo.fill = GridBagConstraints.BOTH;
		gbc_pnlJobInfo.gridx = 1;
		gbc_pnlJobInfo.gridy = 0;
		contentPane.add(pnlJobInfo, gbc_pnlJobInfo);
		GridBagLayout gbl_pnlJobInfo = new GridBagLayout();
		gbl_pnlJobInfo.columnWidths = new int[] { 0, 0 };
		gbl_pnlJobInfo.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_pnlJobInfo.columnWeights = new double[] { 0.0, 1.0 };
		gbl_pnlJobInfo.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		pnlJobInfo.setLayout(gbl_pnlJobInfo);

		lblName = new JLabel("Nom :");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.WEST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 0;
		pnlJobInfo.add(lblName, gbc_lblName);

		txtName = new JTextField();
		txtName.setText("Name");
		GridBagConstraints gbc_txtName = new GridBagConstraints();
		gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtName.insets = new Insets(0, 0, 5, 0);
		gbc_txtName.gridx = 1;
		gbc_txtName.gridy = 0;
		pnlJobInfo.add(txtName, gbc_txtName);
		txtName.setColumns(10);

		lblContact = new JLabel("Contact :");
		GridBagConstraints gbc_lblContact = new GridBagConstraints();
		gbc_lblContact.anchor = GridBagConstraints.EAST;
		gbc_lblContact.insets = new Insets(0, 0, 5, 5);
		gbc_lblContact.gridx = 0;
		gbc_lblContact.gridy = 2;
		pnlJobInfo.add(lblContact, gbc_lblContact);

		txtContact = new JTextField();
		txtContact.setText("Contact");
		GridBagConstraints gbc_txtContact = new GridBagConstraints();
		gbc_txtContact.insets = new Insets(0, 0, 5, 0);
		gbc_txtContact.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtContact.gridx = 1;
		gbc_txtContact.gridy = 2;
		pnlJobInfo.add(txtContact, gbc_txtContact);
		txtContact.setColumns(10);

		lblLien = new JLabel("Lien :");
		GridBagConstraints gbc_lblLien = new GridBagConstraints();
		gbc_lblLien.anchor = GridBagConstraints.EAST;
		gbc_lblLien.insets = new Insets(0, 0, 5, 5);
		gbc_lblLien.gridx = 0;
		gbc_lblLien.gridy = 4;
		pnlJobInfo.add(lblLien, gbc_lblLien);

		txtLink = new JTextField();
		txtLink.setText("Link");
		GridBagConstraints gbc_txtLink = new GridBagConstraints();
		gbc_txtLink.insets = new Insets(0, 0, 5, 0);
		gbc_txtLink.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLink.gridx = 1;
		gbc_txtLink.gridy = 4;
		pnlJobInfo.add(txtLink, gbc_txtLink);
		txtLink.setColumns(10);

		lblInfos = new JLabel("Infos :");
		GridBagConstraints gbc_lblInfos = new GridBagConstraints();
		gbc_lblInfos.insets = new Insets(0, 0, 0, 5);
		gbc_lblInfos.gridx = 0;
		gbc_lblInfos.gridy = 6;
		pnlJobInfo.add(lblInfos, gbc_lblInfos);

		txtrInfos = new JTextArea();
		txtrInfos.setText("Infos");
		GridBagConstraints gbc_txtrInfos = new GridBagConstraints();
		gbc_txtrInfos.fill = GridBagConstraints.BOTH;
		gbc_txtrInfos.gridx = 1;
		gbc_txtrInfos.gridy = 6;
		pnlJobInfo.add(txtrInfos, gbc_txtrInfos);

		pnlSkillList = new JPanel();
		GridBagConstraints gbc_pnlSkillList = new GridBagConstraints();
		gbc_pnlSkillList.insets = new Insets(0, 0, 5, 0);
		gbc_pnlSkillList.fill = GridBagConstraints.VERTICAL;
		gbc_pnlSkillList.gridx = 2;
		gbc_pnlSkillList.gridy = 0;
		contentPane.add(pnlSkillList, gbc_pnlSkillList);
		GridBagLayout gbl_pnlSkillList = new GridBagLayout();
		gbl_pnlSkillList.columnWidths = new int[] { 0 };
		gbl_pnlSkillList.rowHeights = new int[] { 0, 0, 0 };
		gbl_pnlSkillList.columnWeights = new double[] { 1.0 };
		gbl_pnlSkillList.rowWeights = new double[] { 1.0, 0.0, 1.0 };
		pnlSkillList.setLayout(gbl_pnlSkillList);

		pnlSoftSkills = new JPanel();
		GridBagConstraints gbc_pnlSoftSkills = new GridBagConstraints();
		gbc_pnlSoftSkills.fill = GridBagConstraints.VERTICAL;
		gbc_pnlSoftSkills.insets = new Insets(0, 0, 5, 0);
		gbc_pnlSoftSkills.gridx = 0;
		gbc_pnlSoftSkills.gridy = 0;
		pnlSkillList.add(pnlSoftSkills, gbc_pnlSoftSkills);
		GridBagLayout gbl_pnlSoftSkills = new GridBagLayout();
		gbl_pnlSoftSkills.columnWidths = new int[] { 0 };
		gbl_pnlSoftSkills.rowHeights = new int[] { 0, 0 };
		gbl_pnlSoftSkills.columnWeights = new double[] { 1.0 };
		gbl_pnlSoftSkills.rowWeights = new double[] { 0.0, 1.0 };
		pnlSoftSkills.setLayout(gbl_pnlSoftSkills);

		lblSoftSkills = new JLabel("Soft Skills");
		GridBagConstraints gbc_lblSoftSkills = new GridBagConstraints();
		gbc_lblSoftSkills.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblSoftSkills.insets = new Insets(0, 0, 5, 0);
		gbc_lblSoftSkills.gridx = 0;
		gbc_lblSoftSkills.gridy = 0;
		pnlSoftSkills.add(lblSoftSkills, gbc_lblSoftSkills);

		scrPSoftSkills = new JScrollPane();
		GridBagConstraints gbc_scrPSoftSkills = new GridBagConstraints();
		gbc_scrPSoftSkills.fill = GridBagConstraints.VERTICAL;
		gbc_scrPSoftSkills.gridx = 0;
		gbc_scrPSoftSkills.gridy = 1;
		pnlSoftSkills.add(scrPSoftSkills, gbc_scrPSoftSkills);
		scrPSoftSkills.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrPSoftSkills.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		tblSoftSkills = new JTable();
		scrPSoftSkills.setViewportView(tblSoftSkills);

		pnlTechSkills = new JPanel();
		GridBagConstraints gbc_pnlTechSkills = new GridBagConstraints();
		gbc_pnlTechSkills.gridx = 0;
		gbc_pnlTechSkills.gridy = 2;
		pnlSkillList.add(pnlTechSkills, gbc_pnlTechSkills);
		GridBagLayout gbl_pnlTechSkills = new GridBagLayout();
		gbl_pnlTechSkills.columnWidths = new int[] { 0 };
		gbl_pnlTechSkills.rowHeights = new int[] { 0, 0 };
		gbl_pnlTechSkills.columnWeights = new double[] { 1.0 };
		gbl_pnlTechSkills.rowWeights = new double[] { 0.0, 1.0 };
		pnlTechSkills.setLayout(gbl_pnlTechSkills);

		lblTechSkills = new JLabel("Compétences Techniques");
		GridBagConstraints gbc_lblTechSkills = new GridBagConstraints();
		gbc_lblTechSkills.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblTechSkills.insets = new Insets(0, 0, 5, 0);
		gbc_lblTechSkills.gridx = 0;
		gbc_lblTechSkills.gridy = 0;
		pnlTechSkills.add(lblTechSkills, gbc_lblTechSkills);

		scrPTechSkills = new JScrollPane();
		GridBagConstraints gbc_scrPTechSkills = new GridBagConstraints();
		gbc_scrPTechSkills.fill = GridBagConstraints.VERTICAL;
		gbc_scrPTechSkills.gridx = 0;
		gbc_scrPTechSkills.gridy = 1;
		pnlTechSkills.add(scrPTechSkills, gbc_scrPTechSkills);
		scrPTechSkills.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrPTechSkills.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		tblTechSkills = new JTable();
		scrPTechSkills.setViewportView(tblTechSkills);
	}

}
