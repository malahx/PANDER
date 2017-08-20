/**
 * 
 */
package fr.redpanda.pander.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import fr.redpanda.pander.database.UserDAO;
import fr.redpanda.pander.entities.Candidate;
import fr.redpanda.pander.entities.Company;
import fr.redpanda.pander.entities.User;
import fr.redpanda.pander.managers.ViewsManager;
import fr.redpanda.pander.utils.constant.TypeData;
import fr.redpanda.pander.views.AuthView;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class AuthCtrl extends BaseCtrl {

	private void login(String email, String password) {
		User loggedUser = UserDAO.getInstance().findBy(email, password);
		if (loggedUser != null) {
			System.out.println("logged");
			getViewDatas().put(TypeData.USER, loggedUser);
			if (loggedUser instanceof Candidate || loggedUser instanceof Company) {
				// ViewsManager.getInstance().next(new ProfileCtrl(frame));
				return;
			}
			ViewsManager.getInstance().next(new AdminCtrl(frame));
			return;
		}
		System.out.println("not logged");
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
	public AuthCtrl(JFrame frame) {
		super.frame = frame;
		super.view = new AuthView(this.frame);
	}

	@Override
	public void initEvent() {
		AuthView view = (AuthView) this.view;
		view.getBtnValidate().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				login(view.getTxtLogin().getText(), new String(view.getTxtPassword().getPassword()));
			}
		});

	}

}
