/**
 * 
 */
package fr.redpanda.pander.controllers;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import javax.swing.event.DocumentEvent;

import fr.redpanda.pander.controllers.base.BaseCtrl;
import fr.redpanda.pander.databases.CandidateDAO;
import fr.redpanda.pander.databases.JobDAO;
import fr.redpanda.pander.databases.UserDAO;
import fr.redpanda.pander.entities.Admin;
import fr.redpanda.pander.entities.Candidate;
import fr.redpanda.pander.entities.Company;
import fr.redpanda.pander.entities.Job;
import fr.redpanda.pander.entities.User;
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

	private RegisterCtrl registerCtrl;

	/**
	 * @return the registerCtrl
	 */
	public RegisterCtrl getRegisterCtrl() {
		return registerCtrl;
	}

	/**
	 * The function to login an user from his email and his password
	 * 
	 * @param email
	 * @param password
	 */
	private void login(String email, String password) {

		BaseEntity loggedUser = UserDAO.getInstance().get(email, password);
		if (loggedUser != null) {
			getViewDatas().put(TypeData.USER, loggedUser);
			if (loggedUser instanceof Candidate) {
				ViewsManager.getInstance().next(new HomeCtrl());
				CandidateDAO.getInstance().getSkills((Candidate) loggedUser);
			} else if (loggedUser instanceof Company) {
				ViewsManager.getInstance().next(new HomeCtrl());
				Company company = (Company) loggedUser;
				JobDAO.getInstance().get(company);
				for (Job job : company.getJobs()) {
					JobDAO.getInstance().getSkills(job);
				}
			} else if (loggedUser instanceof Admin) {
				ViewsManager.getInstance().next(new AdminCtrl());
			}
		} else {
			PopupManager.message("Authentification", "Identifiant ou mot de passe incorrect !");
		}

	}

	/**
	 * The constructor
	 */
	public AuthCtrl() {
		super();
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
				initRegistration(new Candidate());
			}
		});

		view.getBtnCompany().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				initRegistration(new Company());
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

		view.getContentPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "login");
		view.getContentPane().getActionMap().put("login", new AbstractAction() {

			private static final long serialVersionUID = 2923284308284198391L;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (view.getBtnValidate().isEnabled()) {
					view.getBtnValidate().doClick();
				}
			}
		});

	}

	/**
	 * The function to refresh if the button validate is enabled or disabled
	 */
	private void refreshValidate() {
		AuthView view = (AuthView) this.view;
		view.getBtnValidate()
				.setEnabled(view.getTxtLogin().getText().length() > 0 && view.getTxtPassword().getPassword().length > 0
						? true
						: false);
	}

	/**
	 * Initialize the registration for an user
	 * 
	 * @param user
	 */
	private void initRegistration(User user) {
		registerCtrl = new RegisterCtrl(frame, user);

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registerCtrl.loadController(new JFrame());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		// User loggeUser = new Company();
		// getViewDatas().put(TypeData.USER, loggeUser);
		// if (loggeUser instanceof Candidate || loggeUser instanceof Company) {
		// ViewsManager.getInstance().next(new HomeCtrl(frame));
		// return;
		// }
		// User loggeUser = new Candidate();
		// getViewDatas().put(TypeData.USER, loggeUser);
		// if (loggeUser instanceof Candidate || loggeUser instanceof Company) {
		// ViewsManager.getInstance().next(new HomeCtrl(frame));
		// return;
		// }
	}

}
