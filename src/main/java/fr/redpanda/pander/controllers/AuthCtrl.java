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
import fr.redpanda.pander.databases.CompanyDAO;
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
import fr.redpanda.pander.utils.views.ViewUtils;
import fr.redpanda.pander.views.AuthView;
import fr.redpanda.pander.views.RegisterView;
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
			if (loggedUser instanceof Candidate) {
				ViewsManager.getInstance().next(new HomeCtrl(frame));
				CandidateDAO.getInstance().getSkills((Candidate) loggedUser);
			} else if (loggedUser instanceof Company) {
				ViewsManager.getInstance().next(new HomeCtrl(frame));
				Company company = (Company) loggedUser;
				JobDAO.getInstance().get(company);
				for (Job job : company.getJobs()) {
					JobDAO.getInstance().getSkills(job);
				}
			} else if (loggedUser instanceof Admin) {
				ViewsManager.getInstance().next(new AdminCtrl(frame));
			}
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

		view.getContentPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "login");
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

	private void refreshValidate() {
		AuthView view = (AuthView) this.view;
		view.getBtnValidate()
				.setEnabled(view.getTxtLogin().getText().length() > 0 && view.getTxtPassword().getPassword().length > 0
						? true
						: false);
	}

	private void initRegistration(User user) {
		JFrame registerFrame = new JFrame();
		registerFrame.setBounds(0, 0, 400, 250);
		ViewUtils.center(frame, registerFrame);
		RegisterView registerView = new RegisterView();
		registerView.loadView(registerFrame);

		if (user instanceof Candidate) {
			registerView.getLblName().setText("Prénom");
			registerView.getLblOtherName().setText("Nom");
		} else if (user instanceof Company) {
			registerView.getLblName().setText("Nom");
			registerView.getLblOtherName().setText("SIRET");
		}

		DocListener btnEnabler = new DocListener() {

			@Override
			public void update(DocumentEvent e) {
				if (registerView.getTextName1().getText().equals("") || registerView.getTextName2().getText().equals("")
						|| registerView.getTextEmail().getText().equals("")
						|| new String(registerView.getPwdPass().getPassword()).equals("")
						|| !registerView.isSamePass()) {
					registerView.getBtnRegister().setEnabled(false);
				} else {
					registerView.getBtnRegister().setEnabled(true);
				}
			}
		};

		DocListener passInfo = new DocListener() {

			@Override
			public void update(DocumentEvent e) {
				if (!new String(registerView.getPwdPass().getPassword())
						.equals(new String(registerView.getPwdPassVerify().getPassword()))) {
					registerView.getLblInfo().setText("Le mot de passe ne correspond pas.");
				} else {
					registerView.getLblInfo().setText("Merci de compléter ces informations.");
				}
			}
		};

		registerView.getTextName1().getDocument().addDocumentListener(btnEnabler);
		registerView.getTextName2().getDocument().addDocumentListener(btnEnabler);
		registerView.getTextEmail().getDocument().addDocumentListener(btnEnabler);
		registerView.getPwdPass().getDocument().addDocumentListener(btnEnabler);
		registerView.getPwdPassVerify().getDocument().addDocumentListener(btnEnabler);

		registerView.getPwdPass().getDocument().addDocumentListener(passInfo);
		registerView.getPwdPassVerify().getDocument().addDocumentListener(passInfo);

		registerView.getBtnRegister().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (user instanceof Candidate) {
					Candidate candidate = (Candidate) user;
					candidate.setFirstname(registerView.getTextName1().getText());
					candidate.setLastname(registerView.getTextName2().getText());
					candidate.setEmail(registerView.getTextEmail().getText());
					candidate.setPassword(registerView.getTextEmail().getText());
					CandidateDAO.getInstance().insert(candidate);
				} else if (user instanceof Company) {
					Company company = (Company) user;
					company.setName(registerView.getTextName1().getText());
					company.setSiret(registerView.getTextName2().getText());
					company.setEmail(registerView.getTextEmail().getText());
					company.setPassword(registerView.getTextEmail().getText());
					CompanyDAO.getInstance().insert(company);
				}
				registerFrame.dispose();
			}
		});

		registerView.getBtnCancel().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				registerFrame.dispose();
			}
		});

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registerFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
