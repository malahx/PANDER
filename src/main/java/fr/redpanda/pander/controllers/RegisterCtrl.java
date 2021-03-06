/**
 * 
 */
package fr.redpanda.pander.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.event.DocumentEvent;

import fr.redpanda.pander.controllers.base.BaseCtrl;
import fr.redpanda.pander.databases.CandidateDAO;
import fr.redpanda.pander.databases.CompanyDAO;
import fr.redpanda.pander.databases.UserDAO;
import fr.redpanda.pander.entities.Candidate;
import fr.redpanda.pander.entities.Company;
import fr.redpanda.pander.entities.User;
import fr.redpanda.pander.utils.PopupManager;
import fr.redpanda.pander.utils.StringManager;
import fr.redpanda.pander.utils.views.ViewUtils;
import fr.redpanda.pander.views.RegisterView;
import fr.redpanda.pander.views.models.DocListener;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class RegisterCtrl extends BaseCtrl {

	private JFrame mainFrame;
	private User user;

	/**
	 * The constructor
	 * 
	 * @param frame
	 * 
	 */
	public RegisterCtrl(JFrame mainFrame, User user) {
		super();
		super.view = new RegisterView();
		this.mainFrame = mainFrame;
		this.user = user;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.controllers.base.BaseCtrl#initView()
	 */
	@Override
	public void initView() {
		super.initView();
		mainFrame.setEnabled(false);
		frame.setBounds(0, 0, 400, 250);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setAlwaysOnTop(true);
		ViewUtils.center(mainFrame, frame);
		RegisterView view = (RegisterView) this.view;

		boolean isCandidate = user instanceof Candidate;

		view.getLblName().setText(isCandidate ? "Prénom" : "Nom");
		view.getLblOtherName().setText(isCandidate ? "Nom" : "SIRET");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.controllers.base.BaseCtrl#initEvent()
	 */
	@Override
	public void initEvent() {
		super.initEvent();

		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				close();
			}
		});

		RegisterView view = (RegisterView) this.view;

		DocListener refresh = new DocListener() {

			@Override
			public void update(DocumentEvent e) {
				refresh(view);
			}
		};

		view.getTextName1().getDocument().addDocumentListener(refresh);
		view.getTextName2().getDocument().addDocumentListener(refresh);
		view.getTextEmail().getDocument().addDocumentListener(refresh);
		view.getPwdPass().getDocument().addDocumentListener(refresh);
		view.getPwdPassVerify().getDocument().addDocumentListener(refresh);

		view.getBtnRegister().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				register(view);
			}
		});

		view.getBtnCancel().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
	}

	/**
	 * The register action
	 * 
	 * @param view
	 */
	protected void register(RegisterView view) {
		if (!StringManager.isEmail(view.getTextEmail().getText())) {
			PopupManager.message("Echec d'enregistrement", "Votre email n'est pas valide.");
			return;
		}
		if (UserDAO.getInstance().isExists(view.getTextEmail().getText())) {
			PopupManager.message("Echec d'enregistrement", "Cet email est déjà utilisé.");
			return;
		}
		if (user instanceof Candidate) {
			Candidate candidate = (Candidate) user;
			candidate.setFirstname(view.getTextName1().getText());
			candidate.setLastname(view.getTextName2().getText());
			candidate.setEmail(view.getTextEmail().getText());
			candidate.setPassword(new String(view.getPwdPass().getPassword()));
			CandidateDAO.getInstance().insert(candidate);
		} else if (user instanceof Company) {
			if (CompanyDAO.getInstance().isExists(view.getTextName2().getText())) {
				PopupManager.message("Echec d'enregistrement", "Ce numéro SIRET est déjà utilisé.");
				return;
			}
			Company company = (Company) user;
			company.setName(view.getTextName1().getText());
			company.setSiret(view.getTextName2().getText());
			company.setEmail(view.getTextEmail().getText());
			company.setPassword(new String(view.getPwdPass().getPassword()));
			CompanyDAO.getInstance().insert(company);
		}
		close();
	}

	/**
	 * The close action
	 */
	protected void close() {
		frame.dispose();
		mainFrame.setEnabled(true);
	}

	/**
	 * Refresh the btnRegister and the lblInfo
	 * 
	 * @param view
	 *            the view
	 * @return if the btnRegister is enabled
	 */
	protected boolean refresh(RegisterView view) {
		boolean result = false;
		boolean isValidEmail = StringManager.isEmail(view.getTextEmail().getText());
		if (view.getTextName1().getText().equals("") || view.getTextName2().getText().equals("")
				|| view.getTextEmail().getText().equals("") || new String(view.getPwdPass().getPassword()).equals("")
				|| !view.isSamePass() || !isValidEmail) {
			view.getBtnRegister().setEnabled(false);
		} else {
			view.getBtnRegister().setEnabled(true);
			result = true;
		}
		if (!new String(view.getPwdPass().getPassword()).equals(new String(view.getPwdPassVerify().getPassword()))) {
			view.getLblInfo().setText("Le mot de passe ne correspond pas.");
		} else if (!isValidEmail) {
			view.getLblInfo().setText("Votre email n'est pas valide.");
		} else {
			view.getLblInfo().setText("Merci de compléter ces informations.");
		}
		return result;
	}
}
