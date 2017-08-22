/**
 * 
 */
package fr.redpanda.pander.views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class MatchingView extends MainView {

	private JPanel contentPane;
	private JScrollPane scrPMatching;
	private JTable tblMatching;
	private JButton btnMatching;

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
		gbl_contentPane.rowWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		scrPMatching = new JScrollPane();
		scrPMatching.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrPMatching.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		contentPane.add(scrPMatching, gbc_scrollPane);

		tblMatching = new JTable();
		scrPMatching.setViewportView(tblMatching);

		btnMatching = new JButton("Matching");
		GridBagConstraints gbc_btnMatching = new GridBagConstraints();
		gbc_btnMatching.gridx = 0;
		gbc_btnMatching.gridy = 1;
		contentPane.add(btnMatching, gbc_btnMatching);
	}

}
