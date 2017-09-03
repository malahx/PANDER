/**
 * 
 */
package fr.redpanda.pander.views;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

import fr.redpanda.pander.utils.constant.Img;
import fr.redpanda.pander.utils.views.ViewUtils;
import fr.redpanda.pander.views.base.MainView;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class MatchingView extends MainView {

	private JScrollPane scrPMatching;
	private JTable tblMatching;
	private JButton btnMatching;

	/**
	 * @return the scrPMatching
	 */
	public JScrollPane getScrPMatching() {
		return scrPMatching;
	}

	/**
	 * @param scrPMatching
	 *            the scrPMatching to set
	 */
	public void setScrPMatching(JScrollPane scrPMatching) {
		this.scrPMatching = scrPMatching;
	}

	/**
	 * @return the tblMatching
	 */
	public JTable getTblMatching() {
		return tblMatching;
	}

	/**
	 * @param tblMatching
	 *            the tblMatching to set
	 */
	public void setTblMatching(JTable tblMatching) {
		this.tblMatching = tblMatching;
	}

	/**
	 * @return the btnMatching
	 */
	public JButton getBtnMatching() {
		return btnMatching;
	}

	/**
	 * @param btnMatching
	 *            the btnMatching to set
	 */
	public void setBtnMatching(JButton btnMatching) {
		this.btnMatching = btnMatching;
	}

	/**
	 * Create the frame.
	 */
	public MatchingView() {
		super();

		super.pageName = "Matching";

		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		getPnlContent().setLayout(gbl_contentPane);

		scrPMatching = new JScrollPane();
		scrPMatching.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrPMatching.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		getPnlContent().add(scrPMatching, gbc_scrollPane);

		tblMatching = new JTable();
		scrPMatching.setViewportView(tblMatching);

		// Programme d'origine pour le boutton de lancement :
		// btnMatching = new JButton("Matching");
		// GridBagConstraints gbc_btnMatching = new GridBagConstraints();
		// gbc_btnMatching.gridx = 0;
		// gbc_btnMatching.gridy = 1;
		// getPnlContent().add(btnMatching, gbc_btnMatching);

		// Test d'insertion du gif anim� : (V�rification fonctionnement impossible - pas
		// acc�s � la vue)
		btnMatching = new JButton();
		ImageIcon matchingIconButton = new ImageIcon(Img.ANIM_BTN);
		btnMatching.setIcon(matchingIconButton);
		btnMatching.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		GridBagConstraints gbc_btnMatching = new GridBagConstraints();
		gbc_btnMatching.gridx = 0;
		gbc_btnMatching.gridy = 1;
		getPnlContent().add(btnMatching, gbc_btnMatching);
		
		ViewUtils.colorWhite(btnMatching);

	}

}
