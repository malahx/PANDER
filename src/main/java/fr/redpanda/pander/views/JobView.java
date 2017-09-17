/**
 * 
 */
package fr.redpanda.pander.views;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

import fr.redpanda.pander.entities.Job;
import fr.redpanda.pander.utils.views.ColorUtils;
import fr.redpanda.pander.views.base.MainView;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class JobView extends MainView {

	private JPanel pnlJobList;
	private JPanel pnlJobInfo;
	private JPanel pnlSkillList;
	private JLabel lblJobList;
	private JScrollPane scrPJobList;
	private JList<Job> lstJob;
	private JLabel lblName;
	private JTextField txtName;
	private JLabel lblContact;
	private JTextField txtContact;
	private JLabel lblLien;
	private JTextField txtLink;
	private JLabel lblInfos;
	private JTextArea txtInfos;
	private JLabel lblTechSkills;
	private JScrollPane scrPTechSkills;
	private JTable tblTechSkills;
	private JLabel lblSoftSkills;
	private JScrollPane scrPSoftSkills;
	private JPanel pnlSoftSkills;
	private JPanel pnlTechSkills;
	private JTable tblSoftSkills;
	private JPanel pnlButton;
	private JButton btnAdd;
	private JButton btnDelete;
	private JButton btnClear;
	private JPanel pnlSkills;

	/**
	 * @return the pnlJobList
	 */
	public JPanel getPnlJobList() {
		return pnlJobList;
	}

	/**
	 * @param pnlJobList
	 *            the pnlJobList to set
	 */
	public void setPnlJobList(JPanel pnlJobList) {
		this.pnlJobList = pnlJobList;
	}

	/**
	 * @return the pnlJobInfo
	 */
	public JPanel getPnlJobInfo() {
		return pnlJobInfo;
	}

	/**
	 * @param pnlJobInfo
	 *            the pnlJobInfo to set
	 */
	public void setPnlJobInfo(JPanel pnlJobInfo) {
		this.pnlJobInfo = pnlJobInfo;
	}

	/**
	 * @return the pnlSkillList
	 */
	public JPanel getPnlSkillList() {
		return pnlSkillList;
	}

	/**
	 * @param pnlSkillList
	 *            the pnlSkillList to set
	 */
	public void setPnlSkillList(JPanel pnlSkillList) {
		this.pnlSkillList = pnlSkillList;
	}

	/**
	 * @return the lblJobList
	 */
	public JLabel getLblJobList() {
		return lblJobList;
	}

	/**
	 * @param lblJobList
	 *            the lblJobList to set
	 */
	public void setLblJobList(JLabel lblJobList) {
		this.lblJobList = lblJobList;
	}

	/**
	 * @return the scrPJobList
	 */
	public JScrollPane getScrPJobList() {
		return scrPJobList;
	}

	/**
	 * @param scrPJobList
	 *            the scrPJobList to set
	 */
	public void setScrPJobList(JScrollPane scrPJobList) {
		this.scrPJobList = scrPJobList;
	}

	/**
	 * @return the lstJob
	 */
	public JList<Job> getLstJob() {
		return lstJob;
	}

	/**
	 * @param lstJob
	 *            the lstJob to set
	 */
	public void setLstJob(JList<Job> lstJob) {
		this.lstJob = lstJob;
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
	 * @return the txtName
	 */
	public JTextField getTxtName() {
		return txtName;
	}

	/**
	 * @param txtName
	 *            the txtName to set
	 */
	public void setTxtName(JTextField txtName) {
		this.txtName = txtName;
	}

	/**
	 * @return the lblContact
	 */
	public JLabel getLblContact() {
		return lblContact;
	}

	/**
	 * @param lblContact
	 *            the lblContact to set
	 */
	public void setLblContact(JLabel lblContact) {
		this.lblContact = lblContact;
	}

	/**
	 * @return the txtContact
	 */
	public JTextField getTxtContact() {
		return txtContact;
	}

	/**
	 * @param txtContact
	 *            the txtContact to set
	 */
	public void setTxtContact(JTextField txtContact) {
		this.txtContact = txtContact;
	}

	/**
	 * @return the lblLien
	 */
	public JLabel getLblLien() {
		return lblLien;
	}

	/**
	 * @param lblLien
	 *            the lblLien to set
	 */
	public void setLblLien(JLabel lblLien) {
		this.lblLien = lblLien;
	}

	/**
	 * @return the txtLink
	 */
	public JTextField getTxtLink() {
		return txtLink;
	}

	/**
	 * @param txtLink
	 *            the txtLink to set
	 */
	public void setTxtLink(JTextField txtLink) {
		this.txtLink = txtLink;
	}

	/**
	 * @return the lblInfos
	 */
	public JLabel getLblInfos() {
		return lblInfos;
	}

	/**
	 * @param lblInfos
	 *            the lblInfos to set
	 */
	public void setLblInfos(JLabel lblInfos) {
		this.lblInfos = lblInfos;
	}

	/**
	 * @return the txtInfos
	 */
	public JTextArea getTxtInfos() {
		return txtInfos;
	}

	/**
	 * @param txtInfos
	 *            the txtInfos to set
	 */
	public void setTxtInfos(JTextArea txtInfos) {
		this.txtInfos = txtInfos;
	}

	/**
	 * @return the lblTechSkills
	 */
	public JLabel getLblTechSkills() {
		return lblTechSkills;
	}

	/**
	 * @param lblTechSkills
	 *            the lblTechSkills to set
	 */
	public void setLblTechSkills(JLabel lblTechSkills) {
		this.lblTechSkills = lblTechSkills;
	}

	/**
	 * @return the scrPTechSkills
	 */
	public JScrollPane getScrPTechSkills() {
		return scrPTechSkills;
	}

	/**
	 * @param scrPTechSkills
	 *            the scrPTechSkills to set
	 */
	public void setScrPTechSkills(JScrollPane scrPTechSkills) {
		this.scrPTechSkills = scrPTechSkills;
	}

	/**
	 * @return the tblTechSkills
	 */
	public JTable getTblTechSkills() {
		return tblTechSkills;
	}

	/**
	 * @param tblTechSkills
	 *            the tblTechSkills to set
	 */
	public void setTblTechSkills(JTable tblTechSkills) {
		this.tblTechSkills = tblTechSkills;
	}

	/**
	 * @return the lblSoftSkills
	 */
	public JLabel getLblSoftSkills() {
		return lblSoftSkills;
	}

	/**
	 * @param lblSoftSkills
	 *            the lblSoftSkills to set
	 */
	public void setLblSoftSkills(JLabel lblSoftSkills) {
		this.lblSoftSkills = lblSoftSkills;
	}

	/**
	 * @return the scrPSoftSkills
	 */
	public JScrollPane getScrPSoftSkills() {
		return scrPSoftSkills;
	}

	/**
	 * @param scrPSoftSkills
	 *            the scrPSoftSkills to set
	 */
	public void setScrPSoftSkills(JScrollPane scrPSoftSkills) {
		this.scrPSoftSkills = scrPSoftSkills;
	}

	/**
	 * @return the pnlSoftSkills
	 */
	public JPanel getPnlSoftSkills() {
		return pnlSoftSkills;
	}

	/**
	 * @param pnlSoftSkills
	 *            the pnlSoftSkills to set
	 */
	public void setPnlSoftSkills(JPanel pnlSoftSkills) {
		this.pnlSoftSkills = pnlSoftSkills;
	}

	/**
	 * @return the pnlTechSkills
	 */
	public JPanel getPnlTechSkills() {
		return pnlTechSkills;
	}

	/**
	 * @param pnlTechSkills
	 *            the pnlTechSkills to set
	 */
	public void setPnlTechSkills(JPanel pnlTechSkills) {
		this.pnlTechSkills = pnlTechSkills;
	}

	/**
	 * @return the tblSoftSkills
	 */
	public JTable getTblSoftSkills() {
		return tblSoftSkills;
	}

	/**
	 * @param tblSoftSkills
	 *            the tblSoftSkills to set
	 */
	public void setTblSoftSkills(JTable tblSoftSkills) {
		this.tblSoftSkills = tblSoftSkills;
	}

	/**
	 * @return the pnlButton
	 */
	public JPanel getPnlButton() {
		return pnlButton;
	}

	/**
	 * @param pnlButton
	 *            the pnlButton to set
	 */
	public void setPnlButton(JPanel pnlButton) {
		this.pnlButton = pnlButton;
	}

	/**
	 * @return the btnAdd
	 */
	public JButton getBtnAdd() {
		return btnAdd;
	}

	/**
	 * @param btnAdd
	 *            the btnAdd to set
	 */
	public void setBtnAdd(JButton btnAdd) {
		this.btnAdd = btnAdd;
	}

	/**
	 * @return the btnDelete
	 */
	public JButton getBtnDelete() {
		return btnDelete;
	}

	/**
	 * @param btnDelete
	 *            the btnDelete to set
	 */
	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
	}

	/**
	 * @return the btnClear
	 */
	public JButton getBtnClear() {
		return btnClear;
	}

	/**
	 * @param btnClear
	 *            the btnClear to set
	 */
	public void setBtnClear(JButton btnClear) {
		this.btnClear = btnClear;
	}

	/**
	 * @return the pnlSkills
	 */
	public JPanel getPnlSkills() {
		return pnlSkills;
	}

	/**
	 * @param pnlSkills
	 *            the pnlSkills to set
	 */
	public void setPnlSkills(JPanel pnlSkills) {
		this.pnlSkills = pnlSkills;
	}

	/**
	 * The constructor
	 */
	public JobView() {

		super();
		super.pageName = "Poste";

		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 200, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0 };
		gbl_contentPane.rowWeights = new double[] { 1.0, 1.0, 0.0 };
		getPnlContent().setLayout(gbl_contentPane);

		pnlJobList = new JPanel();
		GridBagConstraints gbc_pnlJobList = new GridBagConstraints();
		gbc_pnlJobList.gridheight = 2;
		gbc_pnlJobList.insets = new Insets(0, 0, 5, 5);
		gbc_pnlJobList.fill = GridBagConstraints.BOTH;
		gbc_pnlJobList.gridx = 0;
		gbc_pnlJobList.gridy = 0;
		getPnlContent().add(pnlJobList, gbc_pnlJobList);
		GridBagLayout gbl_pnlJobList = new GridBagLayout();
		gbl_pnlJobList.columnWidths = new int[] { 200 };
		gbl_pnlJobList.rowHeights = new int[] { 0, 0 };
		gbl_pnlJobList.columnWeights = new double[] { 1.0 };
		gbl_pnlJobList.rowWeights = new double[] { 0.0, 1.0 };
		pnlJobList.setLayout(gbl_pnlJobList);

		lblJobList = new JLabel("Liste de Poste");
		lblJobList.setAlignmentY(0.0f);
		GridBagConstraints gbc_lblJobList = new GridBagConstraints();
		gbc_lblJobList.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblJobList.insets = new Insets(0, 0, 5, 0);
		gbc_lblJobList.gridx = 0;
		gbc_lblJobList.gridy = 0;
		pnlJobList.add(lblJobList, gbc_lblJobList);

		scrPJobList = new JScrollPane();
		scrPJobList.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrPJobList.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrPJobList = new GridBagConstraints();
		gbc_scrPJobList.fill = GridBagConstraints.BOTH;
		gbc_scrPJobList.anchor = GridBagConstraints.NORTHWEST;
		gbc_scrPJobList.gridx = 0;
		gbc_scrPJobList.gridy = 1;
		pnlJobList.add(scrPJobList, gbc_scrPJobList);

		lstJob = new JList<Job>();
		lstJob.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrPJobList.setViewportView(lstJob);

		pnlJobInfo = new JPanel();
		GridBagConstraints gbc_pnlJobInfo = new GridBagConstraints();
		gbc_pnlJobInfo.insets = new Insets(0, 0, 5, 0);
		gbc_pnlJobInfo.fill = GridBagConstraints.BOTH;
		gbc_pnlJobInfo.gridx = 1;
		gbc_pnlJobInfo.gridy = 0;
		getPnlContent().add(pnlJobInfo, gbc_pnlJobInfo);
		GridBagLayout gbl_pnlJobInfo = new GridBagLayout();
		gbl_pnlJobInfo.columnWidths = new int[] { 0, 0 };
		gbl_pnlJobInfo.rowHeights = new int[] { 0, 30, 0, 30, 0, 30, 0 };
		gbl_pnlJobInfo.columnWeights = new double[] { 0.0, 1.0 };
		gbl_pnlJobInfo.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0 };
		pnlJobInfo.setLayout(gbl_pnlJobInfo);

		lblName = new JLabel("Nom :");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 0;
		pnlJobInfo.add(lblName, gbc_lblName);

		txtName = new JTextField();
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
		GridBagConstraints gbc_txtLink = new GridBagConstraints();
		gbc_txtLink.insets = new Insets(0, 0, 5, 0);
		gbc_txtLink.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLink.gridx = 1;
		gbc_txtLink.gridy = 4;
		pnlJobInfo.add(txtLink, gbc_txtLink);
		txtLink.setColumns(10);

		lblInfos = new JLabel("Infos :");
		GridBagConstraints gbc_lblInfos = new GridBagConstraints();
		gbc_lblInfos.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblInfos.insets = new Insets(0, 0, 5, 5);
		gbc_lblInfos.gridx = 0;
		gbc_lblInfos.gridy = 6;
		pnlJobInfo.add(lblInfos, gbc_lblInfos);

		txtInfos = new JTextArea();
		txtInfos.setWrapStyleWord(true);
		txtInfos.setLineWrap(true);
		txtInfos.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		GridBagConstraints gbc_txtInfos = new GridBagConstraints();
		gbc_txtInfos.fill = GridBagConstraints.BOTH;
		gbc_txtInfos.ipady = 1;
		gbc_txtInfos.gridx = 1;
		gbc_txtInfos.gridy = 6;
		pnlJobInfo.add(txtInfos, gbc_txtInfos);

		pnlSkills = new JPanel();
		GridBagConstraints gbc_pnlSkills = new GridBagConstraints();
		gbc_pnlSkills.insets = new Insets(0, 0, 5, 0);
		gbc_pnlSkills.fill = GridBagConstraints.BOTH;
		gbc_pnlSkills.gridx = 1;
		gbc_pnlSkills.gridy = 1;
		getPnlContent().add(pnlSkills, gbc_pnlSkills);
		GridBagLayout gbl_pnlSkills = new GridBagLayout();
		gbl_pnlSkills.columnWidths = new int[] { 0, 0 };
		gbl_pnlSkills.rowHeights = new int[] { 0 };
		gbl_pnlSkills.columnWeights = new double[] { 0.5, 1 };
		gbl_pnlSkills.rowWeights = new double[] { 1.0 };
		pnlSkills.setLayout(gbl_pnlSkills);

		pnlSoftSkills = new JPanel();
		GridBagConstraints gbc_pnlSoftSkills = new GridBagConstraints();
		gbc_pnlSoftSkills.fill = GridBagConstraints.BOTH;
		gbc_pnlSoftSkills.insets = new Insets(0, 0, 0, 5);
		gbc_pnlSoftSkills.gridx = 1;
		gbc_pnlSoftSkills.gridy = 0;
		pnlSkills.add(pnlSoftSkills, gbc_pnlSoftSkills);
		GridBagLayout gbl_pnlSoftSkills = new GridBagLayout();
		gbl_pnlSoftSkills.columnWidths = new int[] { 0 };
		gbl_pnlSoftSkills.rowHeights = new int[] { 0 };
		gbl_pnlSoftSkills.columnWeights = new double[] { 1.0 };
		gbl_pnlSoftSkills.rowWeights = new double[] { 0.0, 1.0 };
		pnlSoftSkills.setLayout(gbl_pnlSoftSkills);

		lblSoftSkills = new JLabel("Qualités Humaines");
		GridBagConstraints gbc_lblSoftSkills = new GridBagConstraints();
		gbc_lblSoftSkills.anchor = GridBagConstraints.NORTH;
		gbc_lblSoftSkills.insets = new Insets(0, 0, 5, 0);
		gbc_lblSoftSkills.gridx = 0;
		gbc_lblSoftSkills.gridy = 0;
		pnlSoftSkills.add(lblSoftSkills, gbc_lblSoftSkills);

		scrPSoftSkills = new JScrollPane();
		GridBagConstraints gbc_scrPSoftSkills = new GridBagConstraints();
		gbc_scrPSoftSkills.fill = GridBagConstraints.BOTH;
		gbc_scrPSoftSkills.gridx = 0;
		gbc_scrPSoftSkills.gridy = 1;
		pnlSoftSkills.add(scrPSoftSkills, gbc_scrPSoftSkills);
		scrPSoftSkills.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrPSoftSkills.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		tblSoftSkills = new JTable();
		scrPSoftSkills.setViewportView(tblSoftSkills);

		pnlTechSkills = new JPanel();
		GridBagConstraints gbc_pnlTechSkills = new GridBagConstraints();
		gbc_pnlTechSkills.fill = GridBagConstraints.BOTH;
		gbc_pnlTechSkills.gridx = 0;
		gbc_pnlTechSkills.gridy = 0;
		pnlSkills.add(pnlTechSkills, gbc_pnlTechSkills);
		GridBagLayout gbl_pnlTechSkills = new GridBagLayout();
		gbl_pnlTechSkills.columnWidths = new int[] { 0 };
		gbl_pnlTechSkills.rowHeights = new int[] { 0 };
		gbl_pnlTechSkills.columnWeights = new double[] { 1.0 };
		gbl_pnlTechSkills.rowWeights = new double[] { 0.0, 1.0 };
		pnlTechSkills.setLayout(gbl_pnlTechSkills);

		lblTechSkills = new JLabel("Compétences Techniques");
		GridBagConstraints gbc_lblTechSkills = new GridBagConstraints();
		gbc_lblTechSkills.anchor = GridBagConstraints.NORTH;
		gbc_lblTechSkills.insets = new Insets(0, 0, 5, 0);
		gbc_lblTechSkills.gridx = 0;
		gbc_lblTechSkills.gridy = 0;
		pnlTechSkills.add(lblTechSkills, gbc_lblTechSkills);

		scrPTechSkills = new JScrollPane();
		GridBagConstraints gbc_scrPTechSkills = new GridBagConstraints();
		gbc_scrPTechSkills.fill = GridBagConstraints.BOTH;
		gbc_scrPTechSkills.gridx = 0;
		gbc_scrPTechSkills.gridy = 1;
		pnlTechSkills.add(scrPTechSkills, gbc_scrPTechSkills);
		scrPTechSkills.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrPTechSkills.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		tblTechSkills = new JTable();
		scrPTechSkills.setViewportView(tblTechSkills);

		btnDelete = new JButton("Supprimer");
		btnDelete.setEnabled(false);
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.fill = GridBagConstraints.BOTH;
		gbc_btnDelete.insets = new Insets(0, 0, 5, 5);
		gbc_btnDelete.gridx = 0;
		gbc_btnDelete.gridy = 2;
		getPnlContent().add(btnDelete, gbc_btnDelete);

		pnlButton = new JPanel();
		GridBagConstraints gbc_pnlButton = new GridBagConstraints();
		gbc_pnlButton.anchor = GridBagConstraints.EAST;
		gbc_pnlButton.insets = new Insets(0, 0, 5, 0);
		gbc_pnlButton.gridx = 1;
		gbc_pnlButton.gridy = 2;
		getPnlContent().add(pnlButton, gbc_pnlButton);
		pnlButton.setLayout(new BoxLayout(pnlButton, BoxLayout.X_AXIS));

		btnAdd = new JButton("Ajouter");
		btnAdd.setEnabled(false);
		pnlButton.add(btnAdd);

		btnClear = new JButton("Effacer les champs");
		pnlButton.add(btnClear);

		ColorUtils.colorLight(btnDelete);
		ColorUtils.colorLight(btnAdd);
		ColorUtils.colorLight(btnClear);
		ColorUtils.colorWhite(pnlButton);
		ColorUtils.colorWhite(pnlJobInfo);
		ColorUtils.colorWhite(pnlJobList);
		ColorUtils.colorWhite(pnlSkills);
		ColorUtils.colorWhite(pnlSoftSkills);
		ColorUtils.colorWhite(pnlTechSkills);

	}

}
