package fr.redpanda.pander.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class MainView extends JFrame {

	private JPanel contentPane;
	private JPanel pnlFooter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
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
	public MainView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {0, 0};
		gbl_contentPane.rowHeights = new int[] {0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel pnlNavbar = new JPanel();
		GridBagConstraints gbc_pnlNavbar = new GridBagConstraints();
		gbc_pnlNavbar.gridwidth = 2;
		gbc_pnlNavbar.insets = new Insets(0, 0, 5, 0);
		gbc_pnlNavbar.fill = GridBagConstraints.BOTH;
		gbc_pnlNavbar.gridx = 0;
		gbc_pnlNavbar.gridy = 0;
		contentPane.add(pnlNavbar, gbc_pnlNavbar);
		
		JPanel pnlSidebar = new JPanel();
		GridBagConstraints gbc_pnlSidebar = new GridBagConstraints();
		gbc_pnlSidebar.insets = new Insets(0, 0, 5, 5);
		gbc_pnlSidebar.fill = GridBagConstraints.BOTH;
		gbc_pnlSidebar.gridx = 0;
		gbc_pnlSidebar.gridy = 1;
		contentPane.add(pnlSidebar, gbc_pnlSidebar);
		
		JPanel pnlContent = new JPanel();
		GridBagConstraints gbc_pnlContent = new GridBagConstraints();
		gbc_pnlContent.insets = new Insets(0, 0, 5, 0);
		gbc_pnlContent.fill = GridBagConstraints.BOTH;
		gbc_pnlContent.gridx = 1;
		gbc_pnlContent.gridy = 1;
		contentPane.add(pnlContent, gbc_pnlContent);
		
		pnlFooter = new JPanel();
		GridBagConstraints gbc_pnlFooter = new GridBagConstraints();
		gbc_pnlFooter.gridwidth = 2;
		gbc_pnlFooter.insets = new Insets(0, 0, 0, 5);
		gbc_pnlFooter.fill = GridBagConstraints.BOTH;
		gbc_pnlFooter.gridx = 0;
		gbc_pnlFooter.gridy = 2;
		contentPane.add(pnlFooter, gbc_pnlFooter);
	}

}
