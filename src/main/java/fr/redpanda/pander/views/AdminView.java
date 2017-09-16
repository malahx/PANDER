/**
 * 
 */
package fr.redpanda.pander.views;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import fr.redpanda.pander.views.base.BaseView;
import fr.redpanda.pander.views.models.AdminTableModel;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class AdminView extends BaseView {

	private JLabel lblTitle;
	private JLabel lblCopyright;
	private JButton btnExit;
	private JToggleButton tglbtnUsers;
	private JToggleButton tglbtnSkills;
	private JLabel lblSubtitle;
	private JPanel pnlCopyright;
	private JLabel lblInfo;
	private JPanel pnlButton;
	private JButton btnBtn1;
	private JButton btnDelete;
	private JTextField txtSkill;
	private AdminTableModel userTableModel;
	private JScrollPane scrlTable;
	private JTable tblTable;

	/**
	 * @return the lblTitle
	 */
	public JLabel getLblTitle() {
		return lblTitle;
	}

	/**
	 * @param lblTitle
	 *            the lblTitle to set
	 */
	public void setLblTitle(JLabel lblTitle) {
		this.lblTitle = lblTitle;
	}

	/**
	 * @return the lblCopyright
	 */
	public JLabel getLblCopyright() {
		return lblCopyright;
	}

	/**
	 * @param lblCopyright
	 *            the lblCopyright to set
	 */
	public void setLblCopyright(JLabel lblCopyright) {
		this.lblCopyright = lblCopyright;
	}

	/**
	 * @return the btnExit
	 */
	public JButton getBtnExit() {
		return btnExit;
	}

	/**
	 * @param btnExit
	 *            the btnExit to set
	 */
	public void setBtnExit(JButton btnExit) {
		this.btnExit = btnExit;
	}

	/**
	 * @return the tglbtnUsers
	 */
	public JToggleButton getTglbtnUsers() {
		return tglbtnUsers;
	}

	/**
	 * @param tglbtnUsers
	 *            the tglbtnUsers to set
	 */
	public void setTglbtnUsers(JToggleButton tglbtnUsers) {
		this.tglbtnUsers = tglbtnUsers;
	}

	/**
	 * @return the tglbtnSkills
	 */
	public JToggleButton getTglbtnSkills() {
		return tglbtnSkills;
	}

	/**
	 * @param tglbtnSkills
	 *            the tglbtnSkills to set
	 */
	public void setTglbtnSkills(JToggleButton tglbtnSkills) {
		this.tglbtnSkills = tglbtnSkills;
	}

	/**
	 * @return the lblSubtitle
	 */
	public JLabel getLblSubtitle() {
		return lblSubtitle;
	}

	/**
	 * @param lblSubtitle
	 *            the lblSubtitle to set
	 */
	public void setLblSubtitle(JLabel lblSubtitle) {
		this.lblSubtitle = lblSubtitle;
	}

	/**
	 * @return the scrlTable
	 */
	public JScrollPane getScrlTable() {
		return scrlTable;
	}

	/**
	 * @param scrlTable
	 *            the scrlTable to set
	 */
	public void setScrlTable(JScrollPane scrlTable) {
		this.scrlTable = scrlTable;
	}

	/**
	 * @return the tblTable
	 */
	public JTable getTblTable() {
		return tblTable;
	}

	/**
	 * @param tblTable
	 *            the tblTable to set
	 */
	public void setTblTable(JTable tblTable) {
		this.tblTable = tblTable;
	}

	/**
	 * @return the pnlCopyright
	 */
	public JPanel getPnlCopyright() {
		return pnlCopyright;
	}

	/**
	 * @param pnlCopyright
	 *            the pnlCopyright to set
	 */
	public void setPnlCopyright(JPanel pnlCopyright) {
		this.pnlCopyright = pnlCopyright;
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
	 * @return the btnBtn1
	 */
	public JButton getBtnBtn1() {
		return btnBtn1;
	}

	/**
	 * @param btnBtn1
	 *            the btnBtn1 to set
	 */
	public void setBtnBtn1(JButton btnBtn1) {
		this.btnBtn1 = btnBtn1;
	}

	/**
	 * @return the btnBtn2
	 */
	public JButton getBtnBtn2() {
		return btnDelete;
	}

	/**
	 * @param btnBtn2
	 *            the btnBtn2 to set
	 */
	public void setBtnBtn2(JButton btnBtn2) {
		this.btnDelete = btnBtn2;
	}

	/**
	 * @return the txtSkill
	 */
	public JTextField getTxtSkill() {
		return txtSkill;
	}

	/**
	 * @param txtSkill
	 *            the txtSkill to set
	 */
	public void setTxtSkill(JTextField txtSkill) {
		this.txtSkill = txtSkill;
	}

	/**
	 * @return the userTableModel
	 */
	public AdminTableModel getUserTableModel() {
		return userTableModel;
	}

	/**
	 * @param userTableModel
	 *            the userTableModel to set
	 */
	public void setUserTableModel(AdminTableModel userTableModel) {
		this.userTableModel = userTableModel;
	}

	/**
	 * The constructor
	 */
	public AdminView() {
		super();
		super.pageName = "Administrateur";
		super.contentPane = new JPanel();

		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0 };
		gbl_contentPane.rowWeights = new double[] { 0.0, 1.0, 0.0 };
		getContentPane().setLayout(gbl_contentPane);

		JPanel pnlHeader = new JPanel();
		GridBagConstraints gbc_pnlHeader = new GridBagConstraints();
		gbc_pnlHeader.fill = GridBagConstraints.BOTH;
		gbc_pnlHeader.insets = new Insets(0, 0, 5, 0);
		gbc_pnlHeader.gridx = 0;
		gbc_pnlHeader.gridy = 0;
		getContentPane().add(pnlHeader, gbc_pnlHeader);
		GridBagLayout gbl_pnlHeader = new GridBagLayout();
		gbl_pnlHeader.columnWidths = new int[] { 0, 0, 0 };
		gbl_pnlHeader.rowHeights = new int[] { 0 };
		gbl_pnlHeader.columnWeights = new double[] { 1.0, 0.0, 0.0 };
		gbl_pnlHeader.rowWeights = new double[] { 0.0 };
		pnlHeader.setLayout(gbl_pnlHeader);

		lblTitle = new JLabel("Administrateur");
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.fill = GridBagConstraints.BOTH;
		gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitle.gridx = 0;
		gbc_lblTitle.gridy = 0;
		pnlHeader.add(lblTitle, gbc_lblTitle);

		tglbtnUsers = new JToggleButton("Utilisateurs");
		GridBagConstraints gbc_tglbtnUsers = new GridBagConstraints();
		gbc_tglbtnUsers.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnUsers.gridx = 1;
		gbc_tglbtnUsers.gridy = 0;
		pnlHeader.add(tglbtnUsers, gbc_tglbtnUsers);

		tglbtnSkills = new JToggleButton("Compétences");
		GridBagConstraints gbc_tglbtnSkills = new GridBagConstraints();
		gbc_tglbtnSkills.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnSkills.gridx = 2;
		gbc_tglbtnSkills.gridy = 0;
		pnlHeader.add(tglbtnSkills, gbc_tglbtnSkills);

		JPanel pnlContent = new JPanel();
		GridBagConstraints gbc_pnlContent = new GridBagConstraints();
		gbc_pnlContent.fill = GridBagConstraints.BOTH;
		gbc_pnlContent.insets = new Insets(0, 0, 5, 0);
		gbc_pnlContent.gridx = 0;
		gbc_pnlContent.gridy = 1;
		getContentPane().add(pnlContent, gbc_pnlContent);

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 30, 0, 0, 30 };
		gridBagLayout.rowHeights = new int[] { 30, 0, 0, 0, 30 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		pnlContent.setLayout(gridBagLayout);

		lblSubtitle = new JLabel("TITLE");
		lblSubtitle.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblSubtitle = new GridBagConstraints();
		gbc_lblSubtitle.gridwidth = 2;
		gbc_lblSubtitle.anchor = GridBagConstraints.WEST;
		gbc_lblSubtitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblSubtitle.gridx = 1;
		gbc_lblSubtitle.gridy = 1;
		pnlContent.add(lblSubtitle, gbc_lblSubtitle);

		scrlTable = new JScrollPane();
		scrlTable.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrlTable.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_scrlTable = new GridBagConstraints();
		gbc_scrlTable.gridwidth = 2;
		gbc_scrlTable.insets = new Insets(0, 0, 5, 5);
		gbc_scrlTable.fill = GridBagConstraints.BOTH;
		gbc_scrlTable.gridx = 1;
		gbc_scrlTable.gridy = 2;
		pnlContent.add(scrlTable, gbc_scrlTable);

		tblTable = new JTable();
		tblTable.setFillsViewportHeight(true);
		scrlTable.setViewportView(tblTable);

		pnlCopyright = new JPanel();
		FlowLayout fl_pnlCopyright = (FlowLayout) pnlCopyright.getLayout();
		fl_pnlCopyright.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_pnlCopyright = new GridBagConstraints();
		gbc_pnlCopyright.anchor = GridBagConstraints.EAST;
		gbc_pnlCopyright.insets = new Insets(0, 0, 0, 5);
		gbc_pnlCopyright.fill = GridBagConstraints.VERTICAL;
		gbc_pnlCopyright.gridx = 1;
		gbc_pnlCopyright.gridy = 3;
		pnlContent.add(pnlCopyright, gbc_pnlCopyright);

		lblInfo = new JLabel("Infos");
		pnlCopyright.add(lblInfo);

		pnlButton = new JPanel();
		GridBagConstraints gbc_pnlButton = new GridBagConstraints();
		gbc_pnlButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_pnlButton.insets = new Insets(0, 0, 0, 5);
		gbc_pnlButton.gridx = 2;
		gbc_pnlButton.gridy = 3;
		pnlContent.add(pnlButton, gbc_pnlButton);
		GridBagLayout gbl_pnlButton = new GridBagLayout();
		gbl_pnlButton.columnWidths = new int[] { 0, 0, 0 };
		gbl_pnlButton.rowHeights = new int[] { 0 };
		gbl_pnlButton.columnWeights = new double[] { 1.0, 0.0, 0.0 };
		gbl_pnlButton.rowWeights = new double[] { 0.0 };
		pnlButton.setLayout(gbl_pnlButton);

		txtSkill = new JTextField();
		GridBagConstraints gbc_txtSkill = new GridBagConstraints();
		gbc_txtSkill.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSkill.insets = new Insets(0, 0, 0, 5);
		gbc_txtSkill.gridx = 0;
		gbc_txtSkill.gridy = 0;
		pnlButton.add(txtSkill, gbc_txtSkill);
		txtSkill.setHorizontalAlignment(SwingConstants.CENTER);
		txtSkill.setColumns(10);

		btnBtn1 = new JButton("BUTTON 1");
		btnBtn1.setEnabled(false);
		GridBagConstraints gbc_btnBtn1 = new GridBagConstraints();
		gbc_btnBtn1.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnBtn1.insets = new Insets(0, 0, 0, 5);
		gbc_btnBtn1.gridx = 1;
		gbc_btnBtn1.gridy = 0;
		pnlButton.add(btnBtn1, gbc_btnBtn1);

		btnDelete = new JButton("Supprimer");
		btnDelete.setEnabled(false);
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnDelete.gridx = 2;
		gbc_btnDelete.gridy = 0;
		pnlButton.add(btnDelete, gbc_btnDelete);

		JPanel pnlFooter = new JPanel();
		GridBagConstraints gbc_pnlFooter = new GridBagConstraints();
		gbc_pnlFooter.fill = GridBagConstraints.BOTH;
		gbc_pnlFooter.gridx = 0;
		gbc_pnlFooter.gridy = 2;
		getContentPane().add(pnlFooter, gbc_pnlFooter);
		GridBagLayout gbl_pnlFooter = new GridBagLayout();
		gbl_pnlFooter.columnWidths = new int[] { 0, 0 };
		gbl_pnlFooter.rowHeights = new int[] { 0 };
		gbl_pnlFooter.columnWeights = new double[] { 1.0, 0.0 };
		gbl_pnlFooter.rowWeights = new double[] { 0.0 };
		pnlFooter.setLayout(gbl_pnlFooter);

		lblCopyright = new JLabel("PANDER");
		GridBagConstraints gbc_lblCopyright = new GridBagConstraints();
		gbc_lblCopyright.fill = GridBagConstraints.BOTH;
		gbc_lblCopyright.insets = new Insets(0, 0, 0, 5);
		gbc_lblCopyright.gridx = 0;
		gbc_lblCopyright.gridy = 0;
		pnlFooter.add(lblCopyright, gbc_lblCopyright);

		btnExit = new JButton("Quitter");
		GridBagConstraints gbc_btnExit = new GridBagConstraints();
		gbc_btnExit.fill = GridBagConstraints.BOTH;
		gbc_btnExit.gridx = 1;
		gbc_btnExit.gridy = 0;
		pnlFooter.add(btnExit, gbc_btnExit);

	}

	/**
	 * Update the datas of the table model
	 * 
	 * @param title
	 * @param datas
	 */
	@SuppressWarnings("unchecked")
	public void updateDatas(String[] title, List<?> datas) {
		userTableModel = new AdminTableModel(title, (List<Object>) datas);
		tblTable.setModel(userTableModel);
		tblTable.addNotify();

	}
}
