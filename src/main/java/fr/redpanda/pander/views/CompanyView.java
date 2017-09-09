/**
 * 
 */
package fr.redpanda.pander.views;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import fr.redpanda.pander.views.base.ProfileView;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class CompanyView extends ProfileView {

	public CompanyView() {
		super();
		super.pageName = "Profile";

		JLabel lblCompanyView = new JLabel();
		ImageIcon puzzleCompany = new ImageIcon("resources/companyImageProfile.jpg");
		lblCompanyView.setIcon(puzzleCompany);
		lblCompanyView.setFont(new Font("Lucida Grande", Font.BOLD, 35));
		GridBagConstraints gbc_lblCompanyView = new GridBagConstraints();
		gbc_lblCompanyView.insets = new Insets(0, 0, 5, 0);
		gbc_lblCompanyView.gridx = 1;
		gbc_lblCompanyView.gridy = 0;
		getPnlContent().add(lblCompanyView, gbc_lblCompanyView);
	}
}
