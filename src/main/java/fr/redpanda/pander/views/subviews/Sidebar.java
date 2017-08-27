/**
 * 
 */
package fr.redpanda.pander.views.subviews;

import javax.swing.JButton;
import javax.swing.JPanel;

import fr.redpanda.pander.entities.Candidate;
import fr.redpanda.pander.entities.Company;
import fr.redpanda.pander.entities.User;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public abstract class Sidebar extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3102325959457435902L;

	JButton btnTelechargCV;

	/**
	 * @return the btnTelechargCV
	 */
	public JButton getBtnTelechargCV() {
		return btnTelechargCV;
	}

	/**
	 * @param btnTelechargCV
	 *            the btnTelechargCV to set
	 */
	public void setBtnTelechargCV(JButton btnTelechargCV) {
		this.btnTelechargCV = btnTelechargCV;
	}
	
	/**
	 * Initialize the sidebar datas
	 * @param user the user to take datas
	 */
	protected abstract void initUser(User user);
	
	/**
	 * Initialize the sidebar datas
	 * @param user the user to take datas
	 */
	public abstract void initCandidate(Candidate candidate);
	
	/**
	 * Initialize the sidebar datas
	 * @param user the user to take datas
	 */
	public abstract void initCompany(Company company);

}
