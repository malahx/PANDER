/**
 * 
 */
package fr.redpanda.pander.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.event.DocumentEvent;

import fr.redpanda.pander.database.UserDAO;
import fr.redpanda.pander.entities.Admin;
import fr.redpanda.pander.entities.Candidate;
import fr.redpanda.pander.entities.Company;
import fr.redpanda.pander.entities.base.BaseEntity;
import fr.redpanda.pander.managers.ViewsManager;
import fr.redpanda.pander.utils.PopupManager;
import fr.redpanda.pander.utils.constant.TypeData;
import fr.redpanda.pander.views.AuthView;
import fr.redpanda.pander.views.models.DocListener;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class AuthCtrl extends BaseCtrl {

	private void login(String email, String password) {

		BaseEntity loggedUser = UserDAO.getInstance().get(email, password);
		if (loggedUser != null) {
			getViewDatas().put(TypeData.USER, loggedUser);
			if (loggedUser instanceof Candidate || loggedUser instanceof Company) {
				ViewsManager.getInstance().next(new HomeCtrl(frame));
				return;
			} else if (loggedUser instanceof Admin) {
				ViewsManager.getInstance().next(new AdminCtrl(frame));
			}
			return;
		}

	}

	/**
	 * 
	 */
	public AuthCtrl(JFrame frame) {
		super.frame = frame;
		super.view = new AuthView();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.controllers.BaseCtrl#initView()
	 */
	@Override
	public void initView() {
		refreshValidate();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.controllers.BaseCtrl#initEvent()
	 */
	@Override
	public void initEvent() {
		AuthView view = (AuthView) this.view;
		view.getBtnValidate().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				login(view.getTxtLogin().getText(), new String(view.getTxtPassword().getPassword()));
			}
		});

		view.getBtnPassword().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PopupManager.message("Mot de passe perdu ?",
						"Merci de bien vouloir contacter\nl'administrateur de ce logiciel\nEmail : admin@pander.fr");
			}
		});

		view.getBtnCandidate().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ViewsManager.getInstance().next(new HomeCtrl(frame));

			}
		});

		view.getBtnCompany().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		view.getTxtLogin().getDocument().addDocumentListener(new DocListener() {

			@Override
			public void update(DocumentEvent e) {
				refreshValidate();
			}
		});

		view.getTxtPassword().getDocument().addDocumentListener(new DocListener() {

			@Override
			public void update(DocumentEvent e) {
				refreshValidate();
			}
		});

	}

	private void refreshValidate() {
		AuthView view = (AuthView) this.view;
		view.getBtnValidate()
				.setEnabled(view.getTxtLogin().getText().length() > 0 && view.getTxtPassword().getPassword().length > 0
						? true
						: false);
	}

}
