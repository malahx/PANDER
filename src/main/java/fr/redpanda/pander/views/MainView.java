package fr.redpanda.pander.views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import fr.redpanda.pander.views.subviews.Footer;
import fr.redpanda.pander.views.subviews.Navbar;
import fr.redpanda.pander.views.subviews.Sidebar;
import fr.redpanda.pander.views.subviews.SidebarEditable;
import fr.redpanda.pander.views.subviews.SidebarPublic;

public abstract class MainView extends BaseView implements IMainView {
	
	private Navbar navbar;
	private Sidebar sidebar;
	private Footer footer;

	/**
	 * Create the frame.
	 */
	public MainView() {
		
		navbar = new Navbar();
		sidebar = isEditable() ? new SidebarEditable() : new SidebarPublic();
		footer = new Footer();
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JPanel pnlNavbar = navbar;
		GridBagConstraints gbc_pnlNavbar = new GridBagConstraints();
		gbc_pnlNavbar.gridwidth = 2;
		gbc_pnlNavbar.insets = new Insets(0, 0, 5, 5);
		gbc_pnlNavbar.fill = GridBagConstraints.BOTH;
		gbc_pnlNavbar.gridx = 0;
		gbc_pnlNavbar.gridy = 0;
		contentPane.add(pnlNavbar, gbc_pnlNavbar);

		JPanel pnlSidebar = sidebar;
		GridBagConstraints gbc_pnlSidebar = new GridBagConstraints();
		gbc_pnlSidebar.weightx = 300.0;
		gbc_pnlSidebar.insets = new Insets(0, 0, 0, 5);
		gbc_pnlSidebar.fill = GridBagConstraints.BOTH;
		gbc_pnlSidebar.gridx = 0;
		gbc_pnlSidebar.gridy = 1;
		contentPane.add(pnlSidebar, gbc_pnlSidebar);

		JPanel pnlContent = new JPanel();
		GridBagConstraints gbc_pnlContent = new GridBagConstraints();
		gbc_pnlContent.fill = GridBagConstraints.BOTH;
		gbc_pnlContent.gridx = 1;
		gbc_pnlContent.gridy = 1;
		contentPane.add(pnlContent, gbc_pnlContent);
		
	}

}
