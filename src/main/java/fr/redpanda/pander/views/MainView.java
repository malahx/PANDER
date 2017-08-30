package fr.redpanda.pander.views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import fr.redpanda.pander.utils.views.ViewUtils;
import fr.redpanda.pander.views.subviews.Footer;
import fr.redpanda.pander.views.subviews.Navbar;
import fr.redpanda.pander.views.subviews.Sidebar;
import fr.redpanda.pander.views.subviews.SidebarEditable;
import fr.redpanda.pander.views.subviews.SidebarPublic;

public abstract class MainView extends BaseView implements IMainView {

	private JPanel pnlContent;

	private Navbar navbar;
	private Sidebar sidebar;
	private Footer footer;

	/**
	 * @return the pnlContent
	 */
	public JPanel getPnlContent() {
		return pnlContent;
	}

	/**
	 * @param pnlContent
	 *            the pnlContent to set
	 */
	public void setPnlContent(JPanel pnlContent) {
		this.pnlContent = pnlContent;
		ViewUtils.colorWhite(pnlContent);
	}
	
	/**
	 * @return the navbar
	 */
	public Navbar getNavbar() {
		return navbar;
	}

	/**
	 * @param navbar
	 *            the navbar to set
	 */
	public void setNavbar(Navbar navbar) {
		this.navbar = navbar;
	}

	/**
	 * @return the sidebar
	 */
	public Sidebar getSidebar() {
		return sidebar;
	}

	/**
	 * @param sidebar
	 *            the sidebar to set
	 */
	public void setSidebar(Sidebar sidebar) {
		this.sidebar = sidebar;
	}

	/**
	 * @return the footer
	 */
	public Footer getFooter() {
		return footer;
	}

	/**
	 * @param footer
	 *            the footer to set
	 */
	public void setFooter(Footer footer) {
		this.footer = footer;
	}

	/**
	 * Create the frame.
	 */
	public MainView() {
		super.contentPane = new JPanel();

		navbar = new Navbar();
		sidebar = isEditable() ? new SidebarEditable() : new SidebarPublic();
		footer = new Footer();
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 300, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0 };
		gbl_contentPane.rowWeights = new double[] { 0.0, 1.0, 0.0 };
		contentPane.setLayout(gbl_contentPane);

		JPanel pnlNavbar = navbar;
		GridBagConstraints gbc_pnlNavbar = new GridBagConstraints();
		gbc_pnlNavbar.gridwidth = 2;
		gbc_pnlNavbar.insets = new Insets(0, 0, 5, 0);
		gbc_pnlNavbar.anchor = GridBagConstraints.WEST;
		gbc_pnlNavbar.fill = GridBagConstraints.HORIZONTAL;
		gbc_pnlNavbar.gridx = 0;
		gbc_pnlNavbar.gridy = 0;
		contentPane.add(pnlNavbar, gbc_pnlNavbar);

		JPanel pnlSidebar = sidebar;
		GridBagConstraints gbc_pnlSidebar = new GridBagConstraints();
		gbc_pnlSidebar.gridheight = 2;
		gbc_pnlSidebar.insets = new Insets(0, 0, 5, 5);
		gbc_pnlSidebar.anchor = GridBagConstraints.WEST;
		gbc_pnlSidebar.fill = GridBagConstraints.VERTICAL;
		gbc_pnlSidebar.gridx = 0;
		gbc_pnlSidebar.gridy = 1;
		contentPane.add(pnlSidebar, gbc_pnlSidebar);

		pnlContent = new JPanel();
		GridBagConstraints gbc_pnlContent = new GridBagConstraints();
		gbc_pnlContent.insets = new Insets(0, 0, 5, 0);
		gbc_pnlContent.fill = GridBagConstraints.BOTH;
		gbc_pnlContent.gridx = 1;
		gbc_pnlContent.gridy = 1;
		contentPane.add(pnlContent, gbc_pnlContent);

		JPanel pnlFooter = footer;
		GridBagConstraints gbc_pnlFooter = new GridBagConstraints();
		gbc_pnlFooter.insets = new Insets(0, 0, 0, 5);
		gbc_pnlFooter.anchor = GridBagConstraints.WEST;
		gbc_pnlFooter.fill = GridBagConstraints.HORIZONTAL;
		gbc_pnlFooter.gridx = 1;
		gbc_pnlFooter.gridy = 2;
		contentPane.add(pnlFooter, gbc_pnlFooter);
		
		ViewUtils.colorWhite(pnlContent);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.views.IMainView#isEditable()
	 */
	@Override
	public boolean isEditable() {
		return false;
	}

}
