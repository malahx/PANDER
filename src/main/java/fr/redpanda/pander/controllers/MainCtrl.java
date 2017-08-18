/**
 * 
 */
package fr.redpanda.pander.controllers;

import javax.swing.JFrame;

import fr.redpanda.pander.entities.User;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public abstract class MainCtrl {

	protected JFrame frame;
	private static User loggedUser;

	protected void gotoAuth() {
		new AuthCtrl(frame);
	}

	protected void gotoMatching() {
		//new MatchingCtrl(frame);
	}

	protected void gotoProfile() {
		new HomeCtrl(frame);
	}
	
	protected void gotoAdmin() {
		new AdminCtrl(frame);
	}

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

	public MainCtrl() {
		// TODO Auto-generated constructor stub
	}

}
