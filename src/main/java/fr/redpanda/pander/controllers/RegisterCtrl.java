/**
 * 
 */
package fr.redpanda.pander.controllers;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.event.DocumentEvent;

import fr.redpanda.pander.controllers.base.BaseCtrl;
import fr.redpanda.pander.databases.CandidateDAO;
import fr.redpanda.pander.databases.CompanyDAO;
import fr.redpanda.pander.entities.Candidate;
import fr.redpanda.pander.entities.Company;
import fr.redpanda.pander.entities.User;
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
	 * @param frame
	 * 
	 */
	public RegisterCtrl(JFrame mainFrame, JFrame frame, User user) {
		super();
		super.frame = frame;
		super.view = new RegisterView();
		this.mainFrame = mainFrame;
		this.user = user;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loadController(frame);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.redpanda.pander.controllers.base.BaseCtrl#initView()
	 */
	@Override
	public void initView() {
		super.initView();
		frame.setBounds(0, 0, 400, 250);
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
		RegisterView view = (RegisterView) this.view;

		DocListener btnEnabler = new DocListener() {

			@Override
			public void update(DocumentEvent e) {
				refreshBtn(view);
			}
		};

		DocListener passInfo = new DocListener() {

			@Override
			public void update(DocumentEvent e) {
				passwordMessage(view);
			}
		};

		view.getTextName1().getDocument().addDocumentListener(btnEnabler);
		view.getTextName2().getDocument().addDocumentListener(btnEnabler);
		view.getTextEmail().getDocument().addDocumentListener(btnEnabler);
		view.getPwdPass().getDocument().addDocumentListener(btnEnabler);
		view.getPwdPassVerify().getDocument().addDocumentListener(btnEnabler);

		view.getPwdPass().getDocument().addDocumentListener(passInfo);
		view.getPwdPassVerify().getDocument().addDocumentListener(passInfo);

		view.getBtnRegister().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				register(view);
			}
		});

		view.getBtnCancel().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
	}

	/**
	 * @param view
	 */
	protected void register(RegisterView view) {
		if (user instanceof Candidate) {
			Candidate candidate = (Candidate) user;
			candidate.setFirstname(view.getTextName1().getText());
			candidate.setLastname(view.getTextName2().getText());
			candidate.setEmail(view.getTextEmail().getText());
			candidate.setPassword(view.getTextEmail().getText());
			CandidateDAO.getInstance().insert(candidate);
		} else if (user instanceof Company) {
			Company company = (Company) user;
			company.setName(view.getTextName1().getText());
			company.setSiret(view.getTextName2().getText());
			company.setEmail(view.getTextEmail().getText());
			company.setPassword(view.getTextEmail().getText());
			CompanyDAO.getInstance().insert(company);
		}
		frame.dispose();
	}

	/**
	 * @param view
	 */
	protected void passwordMessage(RegisterView view) {
		if (!new String(view.getPwdPass().getPassword()).equals(new String(view.getPwdPassVerify().getPassword()))) {
			view.getLblInfo().setText("Le mot de passe ne correspond pas.");
		} else {
			view.getLblInfo().setText("Merci de compléter ces informations.");
		}
	}

	/**
	 * @param view
	 */
	protected void refreshBtn(RegisterView view) {
		if (view.getTextName1().getText().equals("") || view.getTextName2().getText().equals("")
				|| view.getTextEmail().getText().equals("") || new String(view.getPwdPass().getPassword()).equals("")
				|| !view.isSamePass()) {
			view.getBtnRegister().setEnabled(false);
		} else {
			view.getBtnRegister().setEnabled(true);
		}
	}

}
