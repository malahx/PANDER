/**
 * 
 */
package fr.redpanda.pander.controller;

import fr.redpanda.pander.database.UserDAO;
import fr.redpanda.pander.entities.Candidate;
import fr.redpanda.pander.entities.Company;
import fr.redpanda.pander.entities.User;
import fr.redpanda.pander.utils.observer.Action;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class AuthCtrl extends MainCtrl {

	private void login(String email, String password) {
		User loggedUser = UserDAO.getInstance().findBy(email, password);
		if (loggedUser != null) {
			setLoggedUser(loggedUser);
			if (loggedUser instanceof Candidate || loggedUser instanceof Company) {
				gotoProfile();
				return;
			}
			gotoAdmin();
		}
	}

	private void forgotPassword() {
	}

	private void registerCompany() {
	}

	private void registerCandidate() {
	}

	/**
	 * 
	 */
	public AuthCtrl() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.redpanda.pander.utils.observer.Observer#Update(fr.redpanda.pander.utils.
	 * observer.Action)
	 */
	@Override
	public void Update(Action action) {
		// TODO Auto-generated method stub
		switch (action) {
		case LOGIN:
			login("", "");
			break;

		case FORGOT_PASS:
			forgotPassword();
			break;

		case REGISTER_COMPANY:
			registerCompany();
			break;

		case REGISTER_CANDIDATE:
			registerCandidate();

		default:
			break;
		}
	}

}
