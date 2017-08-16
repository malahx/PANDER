/**
 * 
 */
package fr.redpanda.pander.controller;

import fr.redpanda.pander.entities.User;
import fr.redpanda.pander.utils.observer.Observer;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public abstract class MainCtrl implements Observer {

	private static User loggedUser;
	private static MainCtrl mainCtrl;

	protected void gotoAuth() {
		setMainCtrl(new AuthCtrl());
	}

	protected void gotoMatching() {}

	protected void gotoProfile() {}
	
	protected void gotoAdmin() {}

	protected void exit() {}

	protected void logout() {}

	/**
	 * @return the loggedUser
	 */
	public static User getLoggedUser() {
		return loggedUser;
	}

	/**
	 * @param loggedUser
	 *            the loggedUser to set
	 */
	public static void setLoggedUser(User loggedUser) {
		MainCtrl.loggedUser = loggedUser;
	}

	/**
	 * @return the mainCtrl
	 */
	public static MainCtrl getMainCtrl() {
		return mainCtrl;
	}

	/**
	 * @param mainCtrl the mainCtrl to set
	 */
	public static void setMainCtrl(MainCtrl mainCtrl) {
		MainCtrl.mainCtrl = mainCtrl;
	}

	public MainCtrl() {
		// TODO Auto-generated constructor stub
	}

}
